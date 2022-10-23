package ca.qc.bdeb.c5gm.zoeken;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ouvrirMaps(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void ouvrirInscription(View view) {
        Intent intent = new Intent(this, InscriptionActivity.class);
        startActivity(intent);
    }

    public void ouvrirConnexion(View view) {
        Intent intent = new Intent(this, ConnexionActivity.class);
        startActivity(intent);
    }
}