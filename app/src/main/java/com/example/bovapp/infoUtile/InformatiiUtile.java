package com.example.bovapp.infoUtile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bovapp.R;

public class InformatiiUtile extends AppCompatActivity {

    Button butonEchip, butonCom, butonFur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informatii_utile);
        getSupportActionBar().setTitle("Informații Utile");

        butonEchip = findViewById(R.id.butonEchip);
        butonCom = findViewById(R.id.butonCom);
        butonFur = findViewById(R.id.butonFur);
    }

    public void SchimbaFragmentul(View view) {
        Fragment fragment;

        if(view == findViewById(R.id.butonEchip)) {
            fragment = new EchipamenteFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentInfo, fragment);
            ft.commit();
        }
        if(view == findViewById(R.id.butonCom)) {
            fragment = new ComertFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentInfo, fragment);
            ft.commit();
        }
        if(view == findViewById(R.id.butonFur)) {
            fragment = new FurajeFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentInfo, fragment);
            ft.commit();
        }
    }
}
