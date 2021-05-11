package com.example.bovapp.infoUtile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bovapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrimulFragment extends Fragment {

    public PrimulFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_primul, container, false);
    }
}
