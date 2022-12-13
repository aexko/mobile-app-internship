package ca.qc.bdeb.c5gm.zoeken;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import ca.qc.bdeb.c5gm.zoeken.Authentification.MonApi;
import ca.qc.bdeb.c5gm.zoeken.Authentification.MonApiClient;
import ca.qc.bdeb.c5gm.zoeken.POJO.ComptePOJO;
import ca.qc.bdeb.c5gm.zoeken.POJO.ConnectUtils;
import ca.qc.bdeb.c5gm.zoeken.POJO.Entreprise;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ZoekenDatabaseHelper bd;
    private InterfaceAdapterEtudiant adapterEtudiant;
    private InterfaceAdapterProf adapterProf;
    private Button btnDeconnexion;
    private FloatingActionButton btnOuvrirAjouterEntreprise;

    private MonApi client;

    private List<ComptePOJO> listeEtudiants;
    private List<Entreprise> listeEntreprises;

    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialisationComposants();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        client = MonApiClient.getRetrofit().create(MonApi.class);

        btnDeconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deconnexion();
            }
        });

        if (ConnectUtils.typeCompte == ComptePOJO.TypeCompte.PROFESSEUR) {
            btnOuvrirAjouterEntreprise.hide();
            getListeEtudiants();
            initialiserSearchViewProfs();
        } else {
            getListeEntreprises();
            initialiserSearchViewEtudiants();
        }

        // Partie SQLite auquelle je n'ai pas vraiment travaillee
        bd = new ZoekenDatabaseHelper(MainActivity.this);
    }

    /**
     * Initialise les composants
     */
    private void initialisationComposants() {
        recyclerView = findViewById(R.id.recycler_view);
        btnDeconnexion = (Button) findViewById(R.id.btn_deconnexion);
        btnOuvrirAjouterEntreprise = (FloatingActionButton) findViewById(R.id.btn_ouvrir_ajouter_compagnie);
        searchView = findViewById(R.id.sv_rechercher);
    }

    /**
     * Initialise la recherche pour etudiants
     */
    private void initialiserSearchViewEtudiants() {
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                List<Entreprise> listeEntreprisesTrouvees = new ArrayList<Entreprise>();
                for (Entreprise entreprise : listeEntreprises) {
                    if (entreprise.getNom().toLowerCase().contains(s.toLowerCase(Locale.ROOT))) {
                        listeEntreprisesTrouvees.add(entreprise);
                    }
                }
                if (listeEntreprisesTrouvees.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Pas de entreprises trouvées", Toast.LENGTH_SHORT).show();
                }
                adapterEtudiant.initialiserListeRechercheEntreprises(listeEntreprisesTrouvees);
                return true;
            }
        });
    }

    /**
     * Initialise la recherche pour les profs
     */
    private void initialiserSearchViewProfs() {
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                List<ComptePOJO> listeEtudiantsTrouves = new ArrayList<ComptePOJO>();
                for (ComptePOJO etudiant : listeEtudiants) {
                    if (etudiant.getNom().toLowerCase().contains(s.toLowerCase(Locale.ROOT))) {
                        listeEtudiantsTrouves.add(etudiant);
                    }
                }
                if (listeEtudiantsTrouves.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Pas de d'étudiants trouvés", Toast.LENGTH_SHORT).show();
                }
                adapterProf.initialiserListeRechercheEtudiants(listeEtudiantsTrouves);
                return true;
            }
        });
    }

    /**
     * Permet de recuperer la liste des entreprises
     */
    private void getListeEntreprises() {
        client.getEtudiantConnecte(ConnectUtils.authToken).enqueue(
                new Callback<ComptePOJO>() {
                    @Override
                    public void onResponse(Call<ComptePOJO> call, Response<ComptePOJO> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Succès: Récupération des entreprises de l'étudiant", Toast.LENGTH_SHORT).show();
                            ComptePOJO comptePOJO = response.body();
                            if (comptePOJO != null) {
                                listeEntreprises = comptePOJO.getEntreprises();
                            }
                            adapterEtudiant = new InterfaceAdapterEtudiant(listeEntreprises, MainActivity.this);
                            recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
                            recyclerView.setAdapter(adapterEtudiant);
                        }
                    }

                    @Override
                    public void onFailure(Call<ComptePOJO> call, Throwable t) {

                    }
                });
    }

    /**
     * Permet de recuperer la liste des etudiants
     */
    private void getListeEtudiants() {
        client.getComptesEleves(ConnectUtils.authToken).enqueue(
                new Callback<List<ComptePOJO>>() {
                    @Override
                    public void onResponse(Call<List<ComptePOJO>> call, Response<List<ComptePOJO>> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Récupération de la liste des étudiants réussie", Toast.LENGTH_SHORT).show();
                            listeEtudiants = response.body();
                            adapterProf = new InterfaceAdapterProf(listeEtudiants, MainActivity.this);
                            recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
                            recyclerView.setAdapter(adapterProf);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<ComptePOJO>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Récupération de la liste des étudiants non réussie", Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }

    /**
     * Pour rafraîchir la page après une modification
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            recreate();
        }
    }

    /**
     * Permet la deconnexion le l'utilisateur
     */
    private void deconnexion() {
        client.deconnecter(ConnectUtils.authToken).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, "NON-OK", Toast.LENGTH_SHORT).show();
            }
        });
    }
}