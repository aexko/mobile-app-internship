package ca.qc.bdeb.c5gm.zoeken;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ca.qc.bdeb.c5gm.zoeken.Authentification.MonApi;
import ca.qc.bdeb.c5gm.zoeken.Authentification.MonApiClient;
import ca.qc.bdeb.c5gm.zoeken.POJO.CompteEtudiant;
import ca.qc.bdeb.c5gm.zoeken.POJO.LoginData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PageConnexion extends AppCompatActivity {

    private EditText username, password;
    private Button btnConnexion, btnInscription;
    private MonApi client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_connexion);

        btnConnexion = (Button) findViewById(R.id.btn_connexion);
        btnInscription = (Button) findViewById(R.id.btn_inscription);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        client = MonApiClient.getRetrofit().create(MonApi.class);
        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputUsername = username.getText().toString();
                String inputPassword = password.getText().toString();
                connecter(inputUsername, inputPassword);
            }
        });

        btnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ouvrirPageInscription();
            }
        });


    }


    private void connecter(String inputUsername, String inputPassword) {
        LoginData loginData = new LoginData(inputUsername, inputPassword);
        client.connecter(loginData).enqueue(
                new Callback<CompteEtudiant>() {
                    @Override
                    public void onResponse(Call<CompteEtudiant> call, Response<CompteEtudiant> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(PageConnexion.this, "Connexion réussie", Toast.LENGTH_SHORT).show();
                            ouvrirDashboard();
                        }
                    }

                    @Override
                    public void onFailure(Call<CompteEtudiant> call, Throwable t) {
                        Toast.makeText(PageConnexion.this, "Connexion invalide", Toast.LENGTH_SHORT).show();
                    }

                }
        );
    }

    private void ouvrirPageInscription() {
        Intent intent = new Intent(PageConnexion.this, PageInscription.class);
        startActivity(intent);
    }

    private void ouvrirDashboard() {
        Intent intent = new Intent(PageConnexion.this, MainActivity.class);
        startActivity(intent);
    }
}