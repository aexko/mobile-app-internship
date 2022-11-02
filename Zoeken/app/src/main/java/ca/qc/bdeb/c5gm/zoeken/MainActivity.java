package ca.qc.bdeb.c5gm.zoeken;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ZoekenDatabaseHelper bd;
    private ArrayList<String> id_compagnie, nom_compagnie, nom_contact, email, telephone,
            site_web, adresse, ville, code_postal, date_de_contact;
    private InterfaceAdapter adapteur;


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
//        getIntent().getStringArrayListExtra("tableauCompagnies");


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