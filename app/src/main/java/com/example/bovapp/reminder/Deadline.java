package com.example.bovapp.reminder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bovapp.R;

public class Deadline extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deadline);
        getSupportActionBar().setTitle("Termen limită");
    }
}
