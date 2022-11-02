package ca.qc.bdeb.c5gm.zoeken;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ModifierCompagnieActivity extends AppCompatActivity {

    EditText et_nom_compagnie, et_nom_contact, et_email, et_telephone, et_site_web,
            et_adresse, et_ville, et_code_postal, et_date_contact;

    String id_compagnie, nom_compagnie, nom_contact, email, telephone,
            site_web, adresse, ville, code_postal, date_contact;

    Button btn_modifier_compagnie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_compagnie);

        et_nom_compagnie = findViewById(R.id.et_nom_compagnie_m);
        et_nom_contact = findViewById(R.id.et_nom_contact_m);
        et_email = findViewById(R.id.et_email_m);
        et_telephone = findViewById(R.id.et_telephone_m);
        et_site_web = findViewById(R.id.et_site_web_m);
        et_adresse = findViewById(R.id.et_adresse_m);
        et_ville = findViewById(R.id.et_ville_m);
        et_code_postal = findViewById(R.id.et_code_postal_m);
        et_date_contact = findViewById(R.id.et_date_contact_m);
        btn_modifier_compagnie = findViewById(R.id.btn_modifier_compagnie);

        mettreAJourDonneesAffichage();
    }

    /**
     * GET et SET les données correspondantes (passées par InterfaceAdapter)
     * pour remplir les champs de la compagnie
     */
    public void mettreAJourDonneesAffichage() {
        id_compagnie = getIntent().getStringExtra("id_compagnie");
        nom_compagnie = getIntent().getStringExtra("nom_compagnie");
        nom_contact = getIntent().getStringExtra("nom_contact");
        email = getIntent().getStringExtra("email");
        telephone = getIntent().getStringExtra("telephone");
        site_web = getIntent().getStringExtra("site_web");
        adresse = getIntent().getStringExtra("adresse");
        ville = getIntent().getStringExtra("ville");
        code_postal = getIntent().getStringExtra("code_postal");
        date_contact = getIntent().getStringExtra("date_contact");

        et_nom_compagnie.setText(nom_compagnie);
        et_nom_contact.setText(nom_contact);
        et_email.setText(email);
        et_telephone.setText(telephone);
        et_site_web.setText(site_web);
        et_adresse.setText(adresse);
        et_ville.setText(ville);
        et_code_postal.setText(code_postal);
        et_date_contact.setText(date_contact);
    }

    /**
     * Pour mettre à jour la base de données SQLite
     * @param view
     */
    public void modifierCompagnie(View view) {
        ZoekenDatabaseHelper bd = new ZoekenDatabaseHelper(ModifierCompagnieActivity.this);
        bd.mettreAJourBd(
                id_compagnie,
                et_nom_compagnie.getText().toString().trim(),
                et_nom_contact.getText().toString().trim(),
                et_email.getText().toString().trim(),
                et_telephone.getText().toString().trim(),
                et_site_web.getText().toString().trim(),
                et_adresse.getText().toString().trim(),
                et_ville.getText().toString().trim(),
                et_code_postal.getText().toString().trim(),
                et_date_contact.getText().toString().trim());
        finish();
    }

    /**
     * Pour supprimer une compagnie
     * @param view
     */
    public void supprimerCompagnie(View view) {
        ouvrirDialogueConfirmation();
    }

    /**
     * Pour ouvrir une fenêtre pour confirmer la supression d'une compagnie
     */
    void ouvrirDialogueConfirmation() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Suppression de la compagnie « " + nom_compagnie + " » ");
        alertDialogBuilder.setMessage("Êtes-vous sûr(e) de vouloir supprimer la compagnie « " + nom_compagnie + " » ?");
        alertDialogBuilder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ZoekenDatabaseHelper bd = new ZoekenDatabaseHelper(ModifierCompagnieActivity.this);
                bd.supprimerCompagnie(id_compagnie);
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialogBuilder.create().show();
    }

}