package com.example.miteris2;

import static com.example.miteris2.Registro.online;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Confirmacion extends AppCompatActivity {

    TextView textNombre, textApellido, textTelefono, textEmail,textModalidad;
    Button atras, continuar;
    Intent i2;
    //Modalidad mod = new Modalidad();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        textNombre = findViewById(R.id.tv_nombre);
        textApellido = findViewById(R.id.tv_apellidos);
        textTelefono = findViewById(R.id.tv_tele);
        textEmail = findViewById(R.id.tv_email);
        textModalidad = findViewById(R.id.tv_modalidad);
        atras = findViewById(R.id.btnatras);
        continuar = findViewById(R.id.btncontinuar);


        Intent i = getIntent();
        String nombre = i.getStringExtra("nom");
        textNombre.setText(nombre);
        String apellido = i.getStringExtra("ape");
        textApellido.setText(apellido);
        String telefono = i.getStringExtra("tel");
        textTelefono.setText(telefono);
        String email = i.getStringExtra("em");
        textEmail.setText(email);

        if(online) {
            String modalidad = i.getStringExtra("online");
            textModalidad.setText(modalidad);
        } else {
            String modalidad = i.getStringExtra("presencial");
            textModalidad.setText(modalidad);
        }

        atras.setOnClickListener((view -> {
            i2 = new Intent(this, Registro.class);
            i2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i2);
        }));

        continuar.setOnClickListener((view -> {
            i2 = new Intent(this, Informacion.class);
            startActivity(i2);
        }));

    }
}