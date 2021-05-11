package com.example.bovapp.documente.anexaVitei;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bovapp.R;
import com.example.bovapp.documente.anexaVitei.adauga.AdaugaVitel;
import com.example.bovapp.documente.anexaVitei.adauga.DatabaseHelper;
import com.example.bovapp.documente.anexaVitei.lista.ListaVitei;

import java.io.File;
import java.io.FileOutputStream;

public class AnexaViteiActivity extends AppCompatActivity {

    Button btnAdauga;
    Button btnLista;
    Button btnExport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anexa_vitei);
        getSupportActionBar().setTitle("Anexă Viței");

        btnAdauga = findViewById(R.id.btnAdauga);
        btnLista = findViewById(R.id.btnLista);
        btnExport = findViewById(R.id.btnExport);

        btnAdauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AdaugaVitel.class));
            }
        });

        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ListaVitei.class));
            }
        });

    }

    public void exportData(View view)
    {
        DatabaseHelper db = new DatabaseHelper(this);
        Cursor cursor = db.getAllData();
        StringBuilder data = new StringBuilder();
        data.append("Nr.Matricol,Nume,Nastere,Greutate,Sex,Gestatie,Embriotransfer,Usurinta,Avort,Fatare,Culoare");

        while(cursor.moveToNext()) {
            data.append("\n" + String.valueOf(cursor.getInt(1))+","+String.valueOf(cursor.getString(2))+","+
                    String.valueOf(cursor.getString(3))+","+
                    String.valueOf(cursor.getInt(4))+","+
                    String.valueOf(cursor.getString(5))+","+
                    String.valueOf(cursor.getString(6))+","+
                    String.valueOf(cursor.getString(7))+","+
                    String.valueOf(cursor.getString(8))+","+
                    String.valueOf(cursor.getString(9))+","+
                    String.valueOf(cursor.getString(10))+","+
                    String.valueOf(cursor.getString(11)));
        }

        try{
            FileOutputStream out = openFileOutput("data.csv", Context.MODE_PRIVATE);
            out.write((data.toString()).getBytes());
            out.close();

            Context context = getApplicationContext();
            File filelocation = new File(getFilesDir(), "data.csv");
            Uri path = FileProvider.getUriForFile(context, "com.example.bovapp.documente.anexaVitei.fileprovider", filelocation);

            Intent fileIntent = new Intent(Intent.ACTION_SEND);
            fileIntent.setType("text/csv");
            fileIntent.putExtra(Intent.EXTRA_SUBJECT, "Subiect");
            fileIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            fileIntent.putExtra(Intent.EXTRA_STREAM, path);
            startActivity(Intent.createChooser(fileIntent, "Send mail"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
