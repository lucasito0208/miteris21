package com.example.miteris21;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    EditText nombre, apellidos, telefono, email;
    RadioGroup radioG;
    RadioButton online, presencial;
    Button comprobar, atras;

    Intent intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = findViewById(R.id.editTextNombre);
        apellidos = findViewById(R.id.editTextApellidos);
        telefono = findViewById(R.id.editTextTelefono);
        email = findViewById(R.id.editTextEmail);
        radioG = findViewById(R.id.radio_group);
        online = findViewById(R.id.radio_online);
        presencial = findViewById(R.id.radio_presencial);
        comprobar = findViewById(R.id.botonRegistrar);
        atras = findViewById(R.id.botonAtras);
        //boolean campos = nombre.getText().toString().length() == 0 || apellidos.getText().toString().length() == 0 || telefono.getText().toString().length() == 0 || email.getText().toString().length() == 0;

            //if(!campos){
                //comprobar.setEnabled(true);
                comprobar.setOnClickListener(view -> {

                    intent2 = new Intent(getApplicationContext(), Confirmacion.class);

                    String nom = nombre.getText().toString();
                    String ape = apellidos.getText().toString();
                    String tel = telefono.getText().toString();
                    String ema = email.getText().toString();

                    intent2.putExtra("nombre", nom);
                    intent2.putExtra("apellidos", ape);
                    intent2.putExtra("telefono", tel);
                    intent2.putExtra("email", ema);

                    radioG.setOnCheckedChangeListener((radioG, intent2) -> {
                        if (intent2 == R.id.radio_online) {
                            Intent i = new Intent();
                            i.putExtra("online", "Has escogido modalidad presencial.");
                            startActivity(i);
                        } else if (intent2 == R.id.radio_presencial) {
                            Intent i = new Intent();
                            i.putExtra("presencial", "Has escogido modalidad presencial.");
                            startActivity(i);
                        }
                    });

                    startActivity(intent2);
                });
           // }else {
                //comprobar.setEnabled(false);
                Toast.makeText(this, "Faltan campos por rellenar!!!", Toast.LENGTH_SHORT).show();
            //}

        atras.setOnClickListener(view -> {
            intent2 = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent2);

        });
    }
}

//Aquí comento lo mismo pero utilizando textWatcher.
        /*
        boolean nombreCambiado = nombre.getText().toString().length() > 2;
        boolean apellidoCambiado = nombre.getText().toString().length() > 2;
        boolean telefonoCambiado = nombre.getText().toString().length() > 2;
        boolean emailCambiado = nombre.getText().toString().length() > 2;

        nombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(nombre.getText().toString().length() == 0) {
                    comprobar.setEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                comprobar.setEnabled(nombreCambiado && apellidoCambiado && telefonoCambiado && emailCambiado);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        apellidos.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(apellidos.getText().toString().length() == 0) {
                    comprobar.setEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                comprobar.setEnabled(nombreCambiado && apellidoCambiado && telefonoCambiado && emailCambiado);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        telefono.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(telefono.getText().toString().length() == 0) {
                    comprobar.setEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                comprobar.setEnabled(nombreCambiado && apellidoCambiado && telefonoCambiado && emailCambiado);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(email.getText().toString().length() == 0) {
                    comprobar.setEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                comprobar.setEnabled(nombreCambiado && apellidoCambiado && telefonoCambiado && emailCambiado);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        radioG.setOnCheckedChangeListener((radioG, intent2) -> {
            if (intent2 == R.id.radio_online) {
                Intent i = new Intent();
                i.putExtra("online", "Has escogido modalidad presencial.");
                startActivity(i);
            } else if (intent2 == R.id.radio_presencial) {
                Intent i = new Intent();
                i.putExtra("presencial", "Has escogido modalidad presencial.");
                startActivity(i);
            }
        });

        comprobar.setOnClickListener(view -> {

                    intent2 = new Intent(getApplicationContext(), Confirmacion.class);

                    String nom = nombre.getText().toString();
                    String ape = apellidos.getText().toString();
                    String tel = telefono.getText().toString();
                    String ema = email.getText().toString();

                    intent2.putExtra("nombre", nom);
                    intent2.putExtra("apellidos", ape);
                    intent2.putExtra("telefono", tel);
                    intent2.putExtra("email", ema);

        });


    }



         */
