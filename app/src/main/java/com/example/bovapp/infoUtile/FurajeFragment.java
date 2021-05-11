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
public class FurajeFragment extends Fragment {

    public FurajeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_furaje, container, false);

        Button butonBalbona = (Button) view.findViewById(R.id.butonBalbona);
        butonBalbona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://babolna.ro/"));
                startActivity(siteIntent);
            }
        });

        Button butonEvialis = (Button) view.findViewById(R.id.butonEvialis);
        butonEvialis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://evialis.ro/"));
                startActivity(siteIntent);
            }
        });

        Button butonBiomin = (Button) view.findViewById(R.id.butonBiomin);
        butonBiomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.biomin.net/"));
                startActivity(siteIntent);
            }
        });

        Button butonBergophor = (Button) view.findViewById(R.id.butonBergophor);
        butonBergophor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bergophor.de/en/"));
                startActivity(siteIntent);
            }
        });

        return view;
    }
}
