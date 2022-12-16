package com.example.miteris21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Confirmacion extends AppCompatActivity {

    TextView textNombre, textApellido, textTelefono, textEmail, textOnline, textPresencial, textModalidad;
    Button fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        textNombre = findViewById(R.id.tv_nombre);
        textApellido = findViewById(R.id.tv_apellidos);
        textTelefono = findViewById(R.id.tv_tele);
        textEmail = findViewById(R.id.tv_email);
        textModalidad = findViewById(R.id.tv_modalidad);
        fin = findViewById(R.id.btnfin);

        Intent i = getIntent();
        String nombre = i.getStringExtra("nombre");
        String apellido = i.getStringExtra("apellido");
        String telefono = i.getStringExtra("telefono");
        String email = i.getStringExtra("email");

        textNombre.setText(nombre);
        textApellido.setText(apellido);
        textTelefono.setText(telefono);
        textEmail.setText(email);

        fin.setOnClickListener((view -> {
            Intent i2 = new Intent(this, MainActivity.class);
            startActivity(i2);
            finish();
        }));




    }
}