package com.example.bovapp.infoUtile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bovapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EchipamenteFragment extends Fragment {

    public EchipamenteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view2 = inflater.inflate(R.layout.fragment_echipamente, container, false);

        Button butonRomvac = (Button) view2.findViewById(R.id.butonRomvac);
        butonRomvac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://romvac.ro/"));
                startActivity(siteIntent);
            }
        });

        Button butonFarmavet = (Button) view2.findViewById(R.id.butonFarmavet);
        butonFarmavet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.farmavet.ro/site/"));
                startActivity(siteIntent);
            }
        });

        Button butonAltius = (Button) view2.findViewById(R.id.butonAltius);
        butonAltius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://altius.ro/"));
                startActivity(siteIntent);
            }
        });

        Button butonBistrivet = (Button) view2.findViewById(R.id.butonBristrivet);
        butonBistrivet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bistrivet.eu/"));
                startActivity(siteIntent);
            }
        });

        Button butonKismetal = (Button) view2.findViewById(R.id.butonKismetal);
        butonKismetal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://kismetal.ro/"));
                startActivity(siteIntent);
            }
        });

        Button butonFerrobull = (Button) view2.findViewById(R.id.butonFerrobull);
        butonFerrobull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ferrobull.ro/"));
                startActivity(siteIntent);
            }
        });

        Button butonSuperFarmLand = (Button) view2.findViewById(R.id.butonSuperFarmLand);
        butonSuperFarmLand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.superfarmland.com/"));
                startActivity(siteIntent);
            }
        });

        Button butonDcmZootehnie = (Button) view2.findViewById(R.id.butonDcmZootehnie);
        butonDcmZootehnie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dcmzootehnie.ro/"));
                startActivity(siteIntent);
            }
        });

        Button butonBentleyFarm = (Button) view2.findViewById(R.id.butonBentleyFarm);
        butonBentleyFarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bentleyfarm.ro/"));
                startActivity(siteIntent);
            }
        });

        return view2;
    }
}
