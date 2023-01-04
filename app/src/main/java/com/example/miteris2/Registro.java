package com.example.miteris2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Registro extends AppCompatActivity {

    EditText nombre, apellidos, telefono, email;
    Button comprobar, atras;
    AlertDialog.Builder builder;
    Spinner spinner;

    Intent intent;

    static boolean online = false;
    static boolean presencial = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);
        nombre = findViewById(R.id.editTextNombre);
        apellidos = findViewById(R.id.editTextApellidos);
        telefono = findViewById(R.id.editTextTelefono);
        email = findViewById(R.id.editTextEmail);
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editable.toString().contains("@") || !editable.toString().contains(".") || editable.toString().length() < 10)  {
                    email.setError("Email incorrecto");
                }
            }
        });
        comprobar = findViewById(R.id.botonRegistrar);
        atras = findViewById(R.id.botonAtras);
        spinner = findViewById(R.id.spin);
        String[] modalidad = {"online", "presencial"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, modalidad);

        spinner.setAdapter(adaptador);

        comprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                builder.setMessage("Quiéres guardar estos datos?")
                        .setCancelable(false)
                        .setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                intent = new Intent(Registro.this, Confirmacion.class);

                                String nom = nombre.getText().toString();
                                String ape = apellidos.getText().toString();
                                String tel = telefono.getText().toString();
                                String ema = email.getText().toString();

                                intent.putExtra("nom", nom);
                                intent.putExtra("ape", ape);
                                intent.putExtra("tel", tel);
                                intent.putExtra("em", ema);

                                mostrar(view);

                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("Estas seguro?");
                alert.show();

            }
        });

        atras.setOnClickListener((view -> {
            intent = new Intent(Registro.this, Onboarding.class);
            startActivity(intent);
        }));
    }

    public void mostrar(View view) {
        String selec = spinner.getSelectedItem().toString();
       // intent = new Intent(Registro.this, Confirmacion.class);

        if (selec.equals("online")) {
            String onli = "Ha seleccionado modalidad Online";
            intent.putExtra("online", onli);
            online = true;
        } else {
            String pres = "Ha seleccionado modalidad Presencial";
            intent.putExtra("presencial", pres);
            presencial = true;
        }
    }
}