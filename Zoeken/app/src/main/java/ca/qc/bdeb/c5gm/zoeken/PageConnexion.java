package ca.qc.bdeb.c5gm.zoeken;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class PageConnexion extends AppCompatActivity {

    private EditText username, password;
    private Button btnConnexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_connexion);

        btnConnexion = (Button) findViewById(R.id.btn_connexion);


    }
}