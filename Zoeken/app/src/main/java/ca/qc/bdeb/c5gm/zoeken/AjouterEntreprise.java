package ca.qc.bdeb.c5gm.zoeken;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;

import ca.qc.bdeb.c5gm.zoeken.Authentification.MonApi;
import ca.qc.bdeb.c5gm.zoeken.Authentification.MonApiClient;
import ca.qc.bdeb.c5gm.zoeken.POJO.ConnectUtils;
import ca.qc.bdeb.c5gm.zoeken.POJO.Entreprise;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AjouterEntreprise extends AppCompatActivity {

    private EditText et_nom_entreprise, et_nom_contact, et_email, et_telephone, et_site_web,
            et_adresse, et_ville, et_province, et_code_postal, et_date_contact;

    private Button btnAjouterEntreprise;

    private MonApi client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_entreprise);

        initialisationComposants();

        client = MonApiClient.getRetrofit().create(MonApi.class);

        btnAjouterEntreprise = (Button) findViewById(R.id.btn_ajouter_compagnie);
        btnAjouterEntreprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String contenuNomEntreprise = et_nom_entreprise.getText().toString().trim();
                String contenuNomContact = et_nom_contact.getText().toString().trim();
                String contenuEmail = et_email.getText().toString().trim();
                String contenuTelephone = et_telephone.getText().toString().trim();
                String contenuSiteWeb = et_site_web.getText().toString().trim();
                String contenuAdresse = et_adresse.getText().toString().trim();
                String contenuVille = et_ville.getText().toString().trim();
                String contenuProvince = et_province.getText().toString().trim();
                String contenuCodePostal = et_code_postal.getText().toString().trim();
                String contenuDateContact = et_date_contact.getText().toString().trim();
                ajouterEntreprise(contenuNomEntreprise, contenuNomContact, contenuEmail, contenuTelephone, contenuSiteWeb, contenuAdresse, contenuVille, contenuProvince, contenuCodePostal, contenuDateContact);
            }
        });
    }

    /**
     * Initialise les composants
     */
    private void initialisationComposants() {
        et_nom_entreprise = findViewById(R.id.et_nom_compagnie);
        et_nom_contact = findViewById(R.id.et_nom_contact);
        et_email = findViewById(R.id.et_email);
        et_telephone = findViewById(R.id.et_telephone);
        et_site_web = findViewById(R.id.et_site_web);
        et_adresse = findViewById(R.id.et_adresse);
        et_ville = findViewById(R.id.et_ville);
        et_province = findViewById(R.id.et_province);
        et_code_postal = findViewById(R.id.et_code_postal);
        et_date_contact = findViewById(R.id.et_date_contact);
    }

    /**
     * Ajoute une entreprise dans le serveur
     *
     * @param contenuNomEntreprise nom entre de l'entreprise
     * @param contenuNomContact    contact entre de l'entreprise
     * @param contenuEmail         email entre de l'entreprise
     * @param contenuTelephone     telephone entre de l'entreprise
     * @param contenuSiteWeb       site web entre de l'entreprise
     * @param contenuAdresse       adresse entree de l'entreprise
     * @param contenuVille         ville entree de l'entreprise
     * @param contenuProvince      province entree de l'entreprise
     * @param contenuCodePostal    code postal de l'entreprise
     * @param contenuDateContact   date contact de l'entreprise
     */
    private void ajouterEntreprise(String contenuNomEntreprise, String contenuNomContact, String contenuEmail, String contenuTelephone, String contenuSiteWeb, String contenuAdresse, String contenuVille, String contenuProvince, String contenuCodePostal, String contenuDateContact) {
        Entreprise entreprise = new Entreprise(UUID.randomUUID(), contenuNomEntreprise, contenuNomContact, contenuEmail, contenuTelephone, contenuSiteWeb, contenuAdresse, contenuVille, contenuProvince, contenuCodePostal, contenuDateContact, false);
        client.creerEntreprise(ConnectUtils.authToken, entreprise).enqueue(new Callback<Entreprise>() {
            @Override
            public void onResponse(Call<Entreprise> call, Response<Entreprise> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(AjouterEntreprise.this, "Succès: Création d'entreprise", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());

                }
            }

            @Override
            public void onFailure(Call<Entreprise> call, Throwable t) {
                Toast.makeText(AjouterEntreprise.this, "Échec: Création d'entreprise", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Ajoute une compagnie dans SQLite
     */
    private void ajouterCompagnieDansBd() {
        ZoekenDatabaseHelper bd = new ZoekenDatabaseHelper(AjouterEntreprise.this);
        bd.ajouterCompagnie(et_nom_entreprise.getText().toString().trim(),
                et_nom_contact.getText().toString().trim(),
                et_email.getText().toString().trim(),
                et_telephone.getText().toString().trim(),
                et_site_web.getText().toString().trim(),
                et_adresse.getText().toString().trim(),
                et_ville.getText().toString().trim(),
                et_code_postal.getText().toString().trim(),
                et_date_contact.getText().toString().trim());
    }
}