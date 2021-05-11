package com.example.bovapp.documente.anexaVitei.lista;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bovapp.R;
import com.example.bovapp.documente.anexaVitei.adauga.AdaugaVitel;
import com.example.bovapp.documente.anexaVitei.adauga.DatabaseHelper;
import com.example.bovapp.documente.anexaVitei.Vitel;

import java.util.ArrayList;

public class ListaVitei extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_vitei);
        getSupportActionBar().setTitle("Viței înregistrați");

        DatabaseHelper db = new DatabaseHelper(this);
        TextView tvLista = findViewById(R.id.tvLista);

        Cursor cursor = db.getAllData();
        StringBuilder stringBuilder = new StringBuilder();

        while(cursor.moveToNext()) {
            stringBuilder.append("Nr. Matricol: " + cursor.getInt(1) + "\n");
            stringBuilder.append("Nume: " + cursor.getString(2) + "\n");
            stringBuilder.append("Data nasterii: " + cursor.getString(3) + "\n");
            stringBuilder.append("Greutate: " + cursor.getInt(4) + "\n");
            stringBuilder.append("Sex: " + cursor.getString(5) + "\n");
            stringBuilder.append("Gestatia: " + cursor.getString(6) + "\n");
            stringBuilder.append("Embriotransfer: " + cursor.getString(7) + "\n");
            stringBuilder.append("Usurinta fatare: " + cursor.getString(8) + "\n");
            stringBuilder.append("Avort: " + cursor.getString(9) + "\n");
            stringBuilder.append("Fatare gemerala: " + cursor.getString(10) + "\n");
            stringBuilder.append("Culoare: " + cursor.getString(11) + "\n\n");
        }

        tvLista.setText(stringBuilder);
    }

}
