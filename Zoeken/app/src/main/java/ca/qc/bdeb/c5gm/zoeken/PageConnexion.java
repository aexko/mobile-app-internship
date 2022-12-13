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
import ca.qc.bdeb.c5gm.zoeken.POJO.CompteResult;
import ca.qc.bdeb.c5gm.zoeken.POJO.ConnectUtils;
import ca.qc.bdeb.c5gm.zoeken.POJO.LoginData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PageConnexion extends AppCompatActivity {

    private EditText emailConnexion, mdpConnexion;
    private Button btnConnexion, btnInscription;
    private MonApi client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_connexion);

        initialiserComposants();

        client = MonApiClient.getRetrofit().create(MonApi.class);

        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String contenuEmail = emailConnexion.getText().toString();
                String contenuMdp = mdpConnexion.getText().toString();
                connecter(contenuEmail, contenuMdp);
            }
        });
        btnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ouvrirPageInscription();
            }
        });
    }

    /**
     * Initialise les composants
     */
    private void initialiserComposants() {
        btnConnexion = (Button) findViewById(R.id.btn_connexion);
        btnInscription = (Button) findViewById(R.id.btn_inscription);
        emailConnexion = findViewById(R.id.et_connexion_email);
        mdpConnexion = findViewById(R.id.et_connexion_mdp);
    }

    /**
     * Permet la connexion d'un utilisateur au serveur distant
     *
     * @param email email entre de l'utilisateur
     * @param mdp   mdp entre de l'utilisateur
     */
    private void connecter(String email, String mdp) {
        LoginData loginData = new LoginData(email, mdp);
        client.connecter(loginData).enqueue(
                new Callback<CompteResult>() {
                    @Override
                    public void onResponse(Call<CompteResult> call, Response<CompteResult> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(PageConnexion.this, "Succès: Connexion de l'utilisateur", Toast.LENGTH_SHORT).show();
                            CompteResult json = response.body();
                            ConnectUtils.authId = json.getId();
                            ConnectUtils.authToken = json.getAccessToken();
                            ConnectUtils.typeCompte = json.getTypeCompte();
                            ouvrirDashboard();
                        }
                    }

                    @Override
                    public void onFailure(Call<CompteResult> call, Throwable t) {
                        Toast.makeText(PageConnexion.this, "Échec: Connexion de l'utilisateur", Toast.LENGTH_SHORT).show();
                    }

                }
        );
    }

    /**
     * Ouvre la page d'inscription
     */
    private void ouvrirPageInscription() {
        Intent intent = new Intent(PageConnexion.this, PageInscription.class);
        startActivity(intent);
    }

    /**
     * Ouvre le dashboard (MainActivity)
     */
    private void ouvrirDashboard() {
        Intent intent = new Intent(PageConnexion.this, MainActivity.class);
        startActivity(intent);
    }
}