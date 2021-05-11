package com.example.bovapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bovapp.conectare.Login;
import com.example.bovapp.documente.Documente;
import com.example.bovapp.infoUtile.InformatiiUtile;
import com.example.bovapp.reminder.Reminder;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button butonInfo;
    Button butonRem;
    Button butonDoc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Meniul Principal");

        butonInfo = findViewById(R.id.butonInfo);
        butonRem = findViewById(R.id.butonRem);
        butonDoc = findViewById(R.id.butonDoc);

        butonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), InformatiiUtile.class));
            }
        });

        butonRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Reminder.class));
            }
        });

        butonDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Documente.class));
            }
        });
    }


    public void deconectare(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }
}
