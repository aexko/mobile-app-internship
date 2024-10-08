package ca.qc.bdeb.c5gm.zoeken;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.UUID;

import ca.qc.bdeb.c5gm.zoeken.Authentification.MonApi;
import ca.qc.bdeb.c5gm.zoeken.Authentification.MonApiClient;
import ca.qc.bdeb.c5gm.zoeken.POJO.ConnectUtils;
import ca.qc.bdeb.c5gm.zoeken.POJO.Entreprise;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// SOURCE: https://www.youtube.com/playlist?list=PLSrm9z4zp4mGK0g_0_jxYGgg3os9tqRUQ

public class ModifierEntreprise extends AppCompatActivity {

    public static int REQUEST_CALL = 1;

    private EditText et_nom_compagnie, et_nom_contact, et_email, et_telephone, et_site_web,
            et_adresse, et_ville, et_province, et_code_postal, et_date_contact;

    private String id_compagnie, nom_compagnie, nom_contact, email, telephone,
            site_web, adresse, ville, province, code_postal, date_contact;

    private UUID id_compagnie_uuid;

    private Button btnSupprimer, btnModifier;

    private MonApi client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_entreprise);

        initialiserComposants();

        btnSupprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ouvrirDialogueConfirmation();
            }
        });

        btnModifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modifierEntreprise();
            }
        });

        mettreAJourDonneesAffichage();

        client = MonApiClient.getRetrofit().create(MonApi.class);

    }

    private void initialiserComposants() {
        et_nom_compagnie = findViewById(R.id.et_nom_compagnie_m);
        et_nom_contact = findViewById(R.id.et_nom_contact_m);
        et_email = findViewById(R.id.et_email_m);
        et_telephone = findViewById(R.id.et_telephone_m);
        et_site_web = findViewById(R.id.et_site_web_m);
        et_adresse = findViewById(R.id.et_adresse_m);
        et_ville = findViewById(R.id.et_ville_m);
        et_province = findViewById(R.id.et_province_m);
        et_code_postal = findViewById(R.id.et_code_postal_m);
        et_date_contact = findViewById(R.id.et_date_contact_m);

        btnSupprimer = findViewById(R.id.btn_supprimer_compagnie);
        btnModifier = findViewById(R.id.btn_modifier_compagnie);
    }

    private void modifierEntreprise() {
        Entreprise entreprise = new Entreprise(id_compagnie_uuid, nom_compagnie, nom_contact, email, telephone, site_web, adresse, ville, province, code_postal, date_contact, false);
        client.modifierEntreprise(ConnectUtils.authToken, id_compagnie, entreprise).enqueue(new Callback<Entreprise>() {
            @Override
            public void onResponse(Call<Entreprise> call, Response<Entreprise> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(ModifierEntreprise.this, "Succès: Modification de l'entreprise", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<Entreprise> call, Throwable t) {
                Toast.makeText(ModifierEntreprise.this, "Échec: Modification de l'entreprise", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void supprimerEntreprise() {

        client.supprEntreprise(ConnectUtils.authToken, id_compagnie).enqueue(
                new Callback<Entreprise>() {
                    @Override
                    public void onResponse(Call<Entreprise> call, Response<Entreprise> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(ModifierEntreprise.this, "Succès: Suppression de l'entreprise", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<Entreprise> call, Throwable t) {
                        Toast.makeText(ModifierEntreprise.this, "Échec: suppression de l'entreprise", Toast.LENGTH_SHORT).show();
                    }
                }
        );


    }

    /**
     * GET et SET les données correspondantes (passées par InterfaceAdapterEtudiant)
     * pour remplir les champs
     */
    public void mettreAJourDonneesAffichage() {
        id_compagnie = getIntent().getStringExtra("id_compagnie");
        id_compagnie_uuid = UUID.fromString(id_compagnie);
        nom_compagnie = getIntent().getStringExtra("nom_compagnie");
        nom_contact = getIntent().getStringExtra("nom_contact");
        email = getIntent().getStringExtra("email");
        telephone = getIntent().getStringExtra("telephone");
        site_web = getIntent().getStringExtra("site_web");
        adresse = getIntent().getStringExtra("adresse");
        ville = getIntent().getStringExtra("ville");
        province = getIntent().getStringExtra("province");
        code_postal = getIntent().getStringExtra("code_postal");
        date_contact = getIntent().getStringExtra("date_contact");

        et_nom_compagnie.setText(nom_compagnie);
        et_nom_contact.setText(nom_contact);
        et_email.setText(email);
        et_telephone.setText(telephone);
        et_site_web.setText(site_web);
        et_adresse.setText(adresse);
        et_ville.setText(ville);
        et_province.setText(province);
        et_code_postal.setText(code_postal);
        et_date_contact.setText(date_contact);
    }

    /**
     * Pour mettre à jour la base de données SQLite
     *
     * @param view
     */
    public void modifierCompagnie(View view) {
        ZoekenDatabaseHelper bd = new ZoekenDatabaseHelper(ModifierEntreprise.this);
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
     * Pour ouvrir une fenêtre pour confirmer la supression d'une compagnie
     */
    void ouvrirDialogueConfirmation() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Suppression de la compagnie « " + nom_compagnie + " » ");
        alertDialogBuilder.setMessage("Êtes-vous sûr(e) de vouloir supprimer la compagnie « " +
                nom_compagnie + " » ?");
        alertDialogBuilder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ZoekenDatabaseHelper bd = new ZoekenDatabaseHelper
                        (ModifierEntreprise.this);
                bd.supprimerCompagnie(id_compagnie);
                supprimerEntreprise();
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

    /**
     * Permet d'aller sur le web
     * @source https://developer.android.com/guide/components/intents-common#Browser
     * @param view Bouton
     */
    public void allerVersSite(View view) {
        String entreeUtilisateur = et_site_web.getText().toString();
        String url;
        if (entreeUtilisateur.contains("https://www.") || entreeUtilisateur.contains
                ("http://www.")) {
            url = et_site_web.getText().toString();
            Log.d("urlW", "allerVersSite: " + entreeUtilisateur.contains("https://"));
        } else {
            url = "https://www." + et_site_web.getText().toString();
            Log.d("urlW", "allerVersSite: " + entreeUtilisateur.contains("https://"));

        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    /**
     * Permet d'appeler avec le numero
     * @source https://www.youtube.com/watch?v=UDwj5j4tBYg
     * @param view Bouton
     */
    public void appelerTelephone(View view) {
        String numero_telephone = et_telephone.getText().toString();
        if (numero_telephone.length() != 10) {
            Toast.makeText(this, "Numéro de téléphone dépasse 10 chiffres, " +
                            "veuillez rentrer un numéro de téléphone valide",
                    Toast.LENGTH_LONG).show();
        }
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +
                Uri.encode(numero_telephone)));
        intent.setData((Uri.parse("tel:" + numero_telephone)));
        if (numero_telephone.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(ModifierEntreprise.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(ModifierEntreprise.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            }
            startActivity(intent);
        } else {
            Toast.makeText(this, "Erreur, veuillez réessayer.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Permet d'envoyer un email
     * @source https://developer.android.com/guide/components/intents-common#ComposeEmail
     * @param view Bouton
     */
    public void envoyerEmail(View view) {
        String[] email = new String[1];
        email[0] = et_email.getText().toString();

        if (!Patterns.EMAIL_ADDRESS.matcher(email[0]).matches()) {
            Toast.makeText(this, "Erreur, adresse courriel non valide.",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Veuillez sélectionner une " +
                    "application pour envoyer votre courriel."));
        } else {
            Toast.makeText(this, "Erreur, aucune application disponible.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
