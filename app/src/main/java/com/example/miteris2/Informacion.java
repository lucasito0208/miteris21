package com.example.miteris2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Informacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        Toolbar tool = findViewById(R.id.toolbar);
        setSupportActionBar(tool);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.info_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mapa_option:
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:41.6269323,-4.717817"));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
                return true;
            case R.id.web_option:
                String url = "formacion.miteris.com/";
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://"+url));
                startActivity(i);
                return true;
            case R.id.cerrar_option:
                Intent i2 = new Intent(Informacion.this,
                        Registro.class);
                i2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i2);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}