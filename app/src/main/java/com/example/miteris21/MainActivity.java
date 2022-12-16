package com.example.miteris21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button) findViewById(R.id.btn1);

        bt1.setOnClickListener(view ->  {

                Intent intent = new Intent(getApplicationContext(), Registro.class);
                startActivity(intent);

        });

    }

}