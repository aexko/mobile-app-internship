package ca.qc.bdeb.c5gm.zoeken;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ZoekenDatabaseHelper bd;
    private ArrayList<String> id_compagnie, nom_compagnie, nom_contact, email, telephone,
            site_web, adresse, ville, code_postal, date_de_contact;
    private InterfaceAdapter adapteur;

    private ArrayList<Compagnie> listeCompagnies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        bd = new ZoekenDatabaseHelper(MainActivity.this);
        id_compagnie = new ArrayList<>();
        nom_compagnie = new ArrayList<>();
        nom_contact = new ArrayList<>();
        email = new ArrayList<>();
        telephone = new ArrayList<>();
        site_web = new ArrayList<>();
        adresse = new ArrayList<>();
        ville = new ArrayList<>();
        code_postal = new ArrayList<>();
        date_de_contact = new ArrayList<>();

        sauvegarderCompagnies();

        adapteur = new InterfaceAdapter(this, id_compagnie, nom_compagnie, nom_contact,
                email, telephone, site_web, adresse, ville, code_postal, date_de_contact,
                MainActivity.this);
        recyclerView.setAdapter(adapteur);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
     * Sauvegarde les compagnies dans la base de données SQLite
     */
    public void sauvegarderCompagnies() {

        Cursor curseur = bd.lireBd();
        if (curseur.getCount() != 0) {
            while (curseur.moveToNext()) {
                id_compagnie.add(curseur.getString(0));
                nom_compagnie.add(curseur.getString(1));
                nom_contact.add(curseur.getString(2));
                email.add(curseur.getString(3));
                telephone.add(curseur.getString(4));
                site_web.add(curseur.getString(5));
                adresse.add(curseur.getString(6));
                ville.add(curseur.getString(7));
                code_postal.add(curseur.getString(8));
                date_de_contact.add(curseur.getString(9));
            }
//            ajouterCompagnieDansListe(curseur);

        } else {
            Toast.makeText(this, "Aucune compagnie à afficher", Toast.LENGTH_SHORT).show();
        }
    }

//    private void ajouterCompagnieDansListe(Cursor curseur) {
//        if (curseur.getCount() != 0) {
//            while (curseur.moveToNext()) {
//                String strNomCompagnie = curseur.getString(1);
//                String strAdresse = curseur.getString(6);
//                String strVille = curseur.getString(7);
//                String strCodePostal = curseur.getString(8);
//                Compagnie nouvelleCompagnie = new Compagnie(strNomCompagnie, strAdresse, strVille, strCodePostal);
//                Log.d("ajoutCompagnie", "ajouterCompagnieDansListe: " + nouvelleCompagnie);
//                listeCompagnies.add(nouvelleCompagnie);
//
//            }
//        }
//    }

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
        Intent intent = new Intent(this, AjouterCompagnieActivity.class);
        startActivity(intent);
    }

    /**
     * Pour faire apparaître le toolbar avec le menu
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

}