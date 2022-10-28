package ca.qc.bdeb.c5gm.zoeken;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ModifierCompagnieActivity extends AppCompatActivity {

    EditText et_nom_compagnie, et_nom_contact, et_email, et_telephone, et_site_web,
            et_adresse, et_ville, et_code_postal, et_date_de_contact;

    String id_compagnie, nom_compagnie, nom_contact, email, telephone,
            site_web, adresse, ville, code_postal, date_contact;

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
        et_date_de_contact = findViewById(R.id.et_date_contact_m);

        mettreAJourDonneesAffichage();
    }



    public void mettreAJourDonneesAffichage() {
        if (getIntent().hasExtra("id_compagnie") && getIntent().hasExtra("nom_compagnie") && getIntent().hasExtra("nom_contact")) {
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
            et_nom_contact.setText(nom_compagnie);
            et_email.setText(nom_compagnie);
            et_telephone.setText(nom_compagnie);
            et_site_web.setText(nom_compagnie);
            et_adresse.setText(nom_compagnie);
            et_ville.setText(nom_compagnie);
            et_code_postal.setText(nom_compagnie);
            et_date_de_contact.setText(nom_compagnie);


        }
    }

}