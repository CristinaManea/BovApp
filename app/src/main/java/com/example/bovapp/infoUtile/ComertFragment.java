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
public class ComertFragment extends Fragment {

    public ComertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view3 = inflater.inflate(R.layout.fragment_comert, container, false);

        Button butonKarpatenMeat = (Button) view3.findViewById(R.id.butonKarpatenMeat);
        butonKarpatenMeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://karpaten-meat.com/"));
                startActivity(siteIntent);
            }
        });

        Button butonDutchTrading = (Button) view3.findViewById(R.id.butonDutchTrading);
        butonDutchTrading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dutchtrading.ro/"));
                startActivity(siteIntent);
            }
        });

        Button butonAngusBucovina = (Button) view3.findViewById(R.id.butonAngusBucovina);
        butonAngusBucovina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://asociatia-angus.ro/"));
                startActivity(siteIntent);
            }
        });

        Button butonAvastar = (Button) view3.findViewById(R.id.butonAvastar);
        butonAvastar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.avastar.ro/"));
                startActivity(siteIntent);
            }
        });

        Button butonSamcom = (Button) view3.findViewById(R.id.butonSamcom);
        butonSamcom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.samcom.ro/"));
                startActivity(siteIntent);
            }
        });

        Button butonDutchTrading2 = (Button) view3.findViewById(R.id.butonDutchTrading2);
        butonDutchTrading2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dutchtrading.ro/"));
                startActivity(siteIntent);
            }
        });

        return view3;
    }
}
