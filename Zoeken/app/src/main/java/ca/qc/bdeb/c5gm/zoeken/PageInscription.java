package ca.qc.bdeb.c5gm.zoeken;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ca.qc.bdeb.c5gm.zoeken.Authentification.MonApi;
import ca.qc.bdeb.c5gm.zoeken.Authentification.MonApiClient;
import ca.qc.bdeb.c5gm.zoeken.POJO.ComptePOJO;
import ca.qc.bdeb.c5gm.zoeken.POJO.CreationCompteData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PageInscription extends AppCompatActivity {

    private EditText etPrenom, etNom, etEmail, etMdp, etMdpConfirmation;
    private Button btnInscription;

    private MonApi client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_inscription);

        etPrenom = findViewById(R.id.et_inscription_prenom);
        etNom = findViewById(R.id.et_inscription_nom);
        etEmail = findViewById(R.id.et_inscription_email);
        etMdp = findViewById(R.id.et_inscription_mdp);
        etMdpConfirmation = findViewById((R.id.et_inscription_confirmation_mdp));
        btnInscription = (Button) findViewById(R.id.btn_confirmer_inscription);

        client = MonApiClient.getRetrofit().create(MonApi.class);

        btnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String contenuPrenom = etPrenom.getText().toString().trim();
                String contenuNom = etNom.getText().toString().trim();
                String contenuEmail = etEmail.getText().toString().trim();
                String contenuMdp = etMdp.getText().toString().trim();
                String contenuMdpConformation = etMdpConfirmation.getText().toString().trim();
                inscrire(contenuNom, contenuPrenom, contenuEmail, contenuMdp, contenuMdpConformation);

            }
        });


    }

    private void inscrire(String contenuNom, String contenuPrenom, String contenuEmail, String contenuMdp, String contenuMdpConformation) {
        CreationCompteData creationCompteData = new CreationCompteData(contenuNom, contenuPrenom, contenuEmail, contenuMdp, contenuMdpConformation);
        client.creerCompte(creationCompteData).enqueue(
                new Callback<ComptePOJO>() {
                    @Override
                    public void onResponse(Call<ComptePOJO> call, Response<ComptePOJO> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(PageInscription.this, "Inscription réussie", Toast.LENGTH_SHORT).show();
                            ouvrirDashboard();
                        }
                    }

                    @Override
                    public void onFailure(Call<ComptePOJO> call, Throwable t) {
                        Toast.makeText(PageInscription.this, "Inscription non réussie", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    private void ouvrirDashboard() {
        Intent intent = new Intent(PageInscription.this, MainActivity.class);
        startActivity(intent);
    }
}