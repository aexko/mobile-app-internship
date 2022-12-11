package ca.qc.bdeb.c5gm.zoeken;

import static ca.qc.bdeb.c5gm.zoeken.MainActivity.listeCompagnies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AjouterCompagnieActivity extends AppCompatActivity {

    private EditText et_nom_compagnie, et_nom_contact, et_email, et_telephone, et_site_web,
            et_adresse, et_ville, et_code_postal, et_date_contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_compagnie);

        et_nom_compagnie = findViewById(R.id.et_nom_compagnie);
        et_nom_contact = findViewById(R.id.et_nom_contact);
        et_email = findViewById(R.id.et_email);
        et_telephone = findViewById(R.id.et_telephone);
        et_site_web = findViewById(R.id.et_site_web);
        et_adresse = findViewById(R.id.et_adresse);
        et_ville = findViewById(R.id.et_ville);
        et_code_postal = findViewById(R.id.et_code_postal);
        et_date_contact = findViewById(R.id.et_date_contact);
    }

    /**
     * Ajoute une compagnie dans la base de données SQLite
     *
     * @param view Bouton lié dans l'interface
     */
    public void ajouterCompagnie(View view) {
        try {
            ajouterCompagnieDansArray();
            ajouterCompagnieDansBd();
            Toast.makeText(AjouterCompagnieActivity.this,
                    "Compagnie ajoutée avec succès!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        startActivity(new Intent(AjouterCompagnieActivity.this, MainActivity.class));
        finish();

    }

    private void ajouterCompagnieDansArray() {
        Compagnie nouvelleCompagnie = new Compagnie(et_nom_compagnie.getText().toString(),
                et_nom_contact.getText().toString(), et_email.getText().toString(),
                et_telephone.getText().toString(), et_site_web.getText().toString(),
                et_adresse.getText().toString(), et_ville.getText().toString(),
                et_code_postal.getText().toString(),
                et_date_contact.getText().toString());
        listeCompagnies.add(nouvelleCompagnie);

    }

    private void ajouterCompagnieDansBd() {
        ZoekenDatabaseHelper bd = new ZoekenDatabaseHelper(AjouterCompagnieActivity.this);
        bd.ajouterCompagnie(
                et_nom_compagnie.getText().toString().trim(),
                et_nom_contact.getText().toString().trim(), et_email.getText().toString().trim(),
                et_telephone.getText().toString().trim(), et_site_web.getText().toString().trim(),
                et_adresse.getText().toString().trim(), et_ville.getText().toString().trim(),
                et_code_postal.getText().toString().trim(),
                et_date_contact.getText().toString().trim());
    }
}