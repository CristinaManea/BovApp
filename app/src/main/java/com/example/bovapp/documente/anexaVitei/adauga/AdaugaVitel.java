package com.example.bovapp.documente.anexaVitei.adauga;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bovapp.R;
import com.example.bovapp.remoteData.Models.AnimalResponse;
import com.example.bovapp.remoteData.RequestModel.AnimalRequest;
import com.example.bovapp.remoteData.RequestModel.HeightR;
import com.example.bovapp.remoteData.RequestModel.WeightR;
import com.example.bovapp.remoteData.RetrofitClientInstance;
import com.example.bovapp.remoteData.iAnimalsAPI;
import com.google.protobuf.Api;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdaugaVitel extends AppCompatActivity {

    //public static final String KEY_PARSE_VITEL = "key";

    EditText edtNrMatricol;
    EditText edtNume;
    EditText edtGreutate;
    Spinner spnSex;
    Spinner spnGestatie;
    Spinner spnEmbriotransfer;
    Spinner spnUsurintaFatare;
    Spinner spnAvort;
    Spinner spnFatareGemerala;
    Spinner spnCuloare;
    Button btnSalveaza;
    Button btnInformation;
    Button buttonapi;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;


    private io.reactivex.rxjava3.disposables.CompositeDisposable disposable = new CompositeDisposable();

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_vitel);
        getSupportActionBar().setTitle("Adaugă Vițel");

        edtNrMatricol = findViewById(R.id.edtNrMatricol);
        edtNume = findViewById(R.id.edtNume);
        edtGreutate = findViewById(R.id.edtGreutate);
        spnSex = findViewById(R.id.spnSex);
        spnGestatie = findViewById(R.id.spnGestatia);
        spnEmbriotransfer = findViewById(R.id.spnEmbriotransfer);
        spnUsurintaFatare = findViewById(R.id.spnUsurintaFatare);
        spnAvort = findViewById(R.id.spnAvort);
        spnFatareGemerala = findViewById(R.id.spnFatareGemerala);
        spnCuloare = findViewById(R.id.spnCuloare);
        btnInformation= findViewById((R.id.btnInformation));

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getApplicationContext(),R.array.sex,R.layout.support_simple_spinner_dropdown_item);
        spnSex.setAdapter(adapter1);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getApplicationContext(),R.array.gestatia,R.layout.support_simple_spinner_dropdown_item);
        spnGestatie.setAdapter(adapter2);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getApplicationContext(),R.array.embriotransfer,R.layout.support_simple_spinner_dropdown_item);
        spnEmbriotransfer.setAdapter(adapter3);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(getApplicationContext(),R.array.usurintaFatara,R.layout.support_simple_spinner_dropdown_item);
        spnUsurintaFatare.setAdapter(adapter4);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(getApplicationContext(),R.array.avort,R.layout.support_simple_spinner_dropdown_item);
        spnAvort.setAdapter(adapter5);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(getApplicationContext(),R.array.fatareGemerala,R.layout.support_simple_spinner_dropdown_item);
        spnFatareGemerala.setAdapter(adapter6);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(getApplicationContext(),R.array.culoare,R.layout.support_simple_spinner_dropdown_item);
        spnCuloare.setAdapter(adapter7);

        btnSalveaza = findViewById(R.id.btnSalvare);

        openHelper = new DatabaseHelper(this);

        buttonapi.setOnClickListener(v -> {

        });
        btnSalveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nrMatricol = edtNrMatricol.getText().toString();
                String nume = edtNume.getText().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss");
                String currentDateandTime = sdf.format(new Date());
                String greutate = edtGreutate.getText().toString();

                String tipSex = spnSex.getSelectedItem().toString();
                String tipGestatie = spnGestatie.getSelectedItem().toString();
                String tipEmbriotransfer = spnEmbriotransfer.getSelectedItem().toString();
                String tipUsurintaFatare = spnUsurintaFatare.getSelectedItem().toString();
                String tipAvort = spnAvort.getSelectedItem().toString();
                String tipFatareGemerala = spnFatareGemerala.getSelectedItem().toString();
                String tipCuloare = spnCuloare.getSelectedItem().toString();

                db = openHelper.getWritableDatabase();

                insertData(nrMatricol, nume, greutate, tipSex, tipGestatie, tipEmbriotransfer, tipUsurintaFatare,
                        tipAvort, tipFatareGemerala, tipCuloare);
                Toast.makeText(AdaugaVitel.this, "Vițel înregistrat!", Toast.LENGTH_SHORT).show();
                clearFiels();
            }
        });

        btnInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdaugaVitel.this, ApiACtivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }










    public void clearFiels() {
        edtNrMatricol.setText("");
        edtNume.setText("");
        edtGreutate.setText("");
    }

    public void insertData(String nrMatricol, String nume, String greutate, String sex, String gestatie,
                           String embriotransfer, String usurintaFatare, String avort, String fatareGemerala, String culoare)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseHelper.COL_2, nrMatricol);
        contentValues.put(DatabaseHelper.COL_3, nume);
        contentValues.put(DatabaseHelper.COL_4, dateFormat.format(date));
        contentValues.put(DatabaseHelper.COL_5, greutate);
        contentValues.put(DatabaseHelper.COL_6, sex);
        contentValues.put(DatabaseHelper.COL_7, gestatie);
        contentValues.put(DatabaseHelper.COL_8, embriotransfer);
        contentValues.put(DatabaseHelper.COL_9, usurintaFatare);
        contentValues.put(DatabaseHelper.COL_10, avort);
        contentValues.put(DatabaseHelper.COL_11, fatareGemerala);
        contentValues.put(DatabaseHelper.COL_12, culoare);

        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }

}
