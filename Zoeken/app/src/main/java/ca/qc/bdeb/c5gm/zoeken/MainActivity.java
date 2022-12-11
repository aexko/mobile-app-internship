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
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ZoekenDatabaseHelper bd;
//    private ArrayList<String> id_compagnie, nom_compagnie, nom_contact, email, telephone,
//            site_web, adresse, ville, code_postal, date_de_contact;
    private InterfaceAdapter adapteur;

    public static List<Compagnie> listeCompagnies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        bd = new ZoekenDatabaseHelper(MainActivity.this);
        listeCompagnies = new ArrayList<>();

        adapteur = new InterfaceAdapter();
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