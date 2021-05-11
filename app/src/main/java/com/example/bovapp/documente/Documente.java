package com.example.bovapp.documente;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.bovapp.R;

public class Documente extends AppCompatActivity {

    Button butonApia;
    Button butonAdociatie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documente);
        getSupportActionBar().setTitle("Documente");

        butonApia = findViewById(R.id.btnApia);
        butonAdociatie = findViewById(R.id.btnAsociatie);

        butonApia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Apia.class));
            }
        });

        butonAdociatie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Asociatie.class));
            }
        });
    }

}
