package com.example.parcial2;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText edt_Usuario, edt_Contrasena;
    Button btnLogin;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //String usuarioguardar;


        sharedPreferences = getSharedPreferences("mis_preferencias", MODE_PRIVATE);

        String usuarioguardar = sharedPreferences.getString("usuario", null);

        if (usuarioguardar != null) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
            return;
        }

        setContentView(R.layout.activity_login);

        edt_Usuario = findViewById(R.id.edt_Usuario);
        edt_Contrasena = findViewById(R.id.edt_Contrasena);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String usuario = edt_Usuario.getText().toString().trim();
            String contrasena = edt_Contrasena.getText().toString().trim();

            if (usuario.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(this, "Completa ambos campos", Toast.LENGTH_SHORT).show();
            } else {

                sharedPreferences.edit().putString("usuario", usuario).apply();
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
        });
    }
}