package ca.qc.bdeb.c5gm.zoeken;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton btn_ajouter_compagnie;

    ZoekenDatabaseHelper bd;
    ArrayList<String> id_compagnie, nom_compagnie, nom_contact, email, telephone,
            site_web, adresse, ville, code_postal, date_de_contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        btn_ajouter_compagnie = findViewById(R.id.btn_ouvrir_ajouter_compagnie);

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

    }

    public void sauvegarderCompagnies() {
        Cursor curseur = bd.lireBD();
        if (curseur.getCount()!=0) {
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
        } else {
            Toast.makeText(this, "Aucune compagnie à afficher", Toast.LENGTH_SHORT).show();
        }
    }

    public void ouvrirMaps(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void ouvrirAjouterCompagnie(View view) {
        Intent intent = new Intent(this, AjouterCompagnieActivity.class);
        startActivity(intent);
    }

}