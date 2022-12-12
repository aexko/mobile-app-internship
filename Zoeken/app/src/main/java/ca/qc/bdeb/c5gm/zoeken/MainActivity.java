package ca.qc.bdeb.c5gm.zoeken;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

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
//    private ArrayList<String> id_compagnie, nom_compagnie, nom_contact, email, telephone,
//            site_web, adresse, ville, code_postal, date_de_contact;

    private InterfaceAdapterEtudiant adapterEtudiant;
    private InterfaceAdapterProf adapterProf;

    private MonApi client;

    private Button btnDeconnexion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        btnDeconnexion = (Button) findViewById(R.id.btn_deconnexion);
        client = MonApiClient.getRetrofit().create(MonApi.class);

        btnDeconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deconnexion();
            }
        });

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        TextView tv_dashboard = (TextView) myToolbar.findViewById(R.id.tv_toolbar);

        if (ConnectUtils.typeCompte == ComptePOJO.TypeCompte.PROFESSEUR) {
            getListeEtudiants();
        } else {
            getListeEntreprises();
        }

        // MODIFIER
        bd = new ZoekenDatabaseHelper(MainActivity.this);
//        id_compagnie = new ArrayList<>();
//        nom_compagnie = new ArrayList<>();
//        nom_contact = new ArrayList<>();
//        email = new ArrayList<>();
//        telephone = new ArrayList<>();
//        site_web = new ArrayList<>();
//        adresse = new ArrayList<>();
//        ville = new ArrayList<>();
//        code_postal = new ArrayList<>();
//        date_de_contact = new ArrayList<>();

        sauvegarderCompagnies();
    }

    private void getListeEntreprises() {
        client.getEtudiantConnecte(ConnectUtils.authToken).enqueue(
                new Callback<ComptePOJO>() {
                    @Override
                    public void onResponse(Call<ComptePOJO> call, Response<ComptePOJO> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Succès: Récupération des entreprises de l'étudiant", Toast.LENGTH_SHORT).show();
                            ComptePOJO comptePOJO = response.body();
                            List<Entreprise> listeEntreprises = comptePOJO.getEntreprises();
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

    private void getListeEtudiants() {
        client.getComptesEleves(ConnectUtils.authToken).enqueue(
                new Callback<List<ComptePOJO>>() {
                    @Override
                    public void onResponse(Call<List<ComptePOJO>> call, Response<List<ComptePOJO>> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Récupération de la liste des étudiants réussie", Toast.LENGTH_SHORT).show();
                            List<ComptePOJO> listeEtudiants = response.body();

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

    // MODIFIER

    /**
     * Sauvegarde les compagnies dans la base de données SQLite
     */
    public void sauvegarderCompagnies() {

        Cursor curseur = bd.lireBd();
        if (curseur.getCount() != 0) {
            while (curseur.moveToNext()) {
//                id_compagnie.add(curseur.getString(0));
//                nom_compagnie.add(curseur.getString(1));
//                nom_contact.add(curseur.getString(2));
//                email.add(curseur.getString(3));
//                telephone.add(curseur.getString(4));
//                site_web.add(curseur.getString(5));
//                adresse.add(curseur.getString(6));
//                ville.add(curseur.getString(7));
//                code_postal.add(curseur.getString(8));
//                date_de_contact.add(curseur.getString(9));
            }
        } else {
            Toast.makeText(this, "Aucune compagnie à afficher", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * Pour ouvrir l'activité "MapsActivity" avec le bouton
     *
     * @param view
     */
    public void ouvrirMaps(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    /**
     * Pour ouvrir l'activité "AjouterCompagnie" avec le bouton
     *
     * @param view
     */
    public void ouvrirAjouterCompagnie(View view) {
        Intent intent = new Intent(this, AjouterEntreprise.class);
        startActivity(intent);
    }


    public void deconnexion() {
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