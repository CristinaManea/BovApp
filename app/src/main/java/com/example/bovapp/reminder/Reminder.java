package com.example.bovapp.reminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.room.Room;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bovapp.R;
import com.example.bovapp.reminder.room.Monte;
import com.example.bovapp.reminder.room.MonteDB;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Reminder extends AppCompatActivity {

    public static final String CHANNEL_1_ID = "channel1";
    private NotificationManagerCompat notificationManager;
    public static final String DATE_FORMAT = "dd/MM/yyyy";

    EditText edtNrCrotala, edtVarsta, edtDataMonta;
    Button butonInregistrareData, butonDDL;
    MonteDB myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        getSupportActionBar().setTitle("Reminder");

        notificationManager = NotificationManagerCompat.from(this);

        edtNrCrotala = findViewById(R.id.nrCrotala);
        edtVarsta = findViewById(R.id.varsta);
        edtDataMonta = findViewById(R.id.dataMonta);
        butonInregistrareData = findViewById(R.id.butonInregistrareData);
        butonDDL = findViewById(R.id.butonDDL);

        setUpDB();

        butonInregistrareData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validareDate()) {
                    Monte monte = new Monte(edtNrCrotala.getText().toString(),
                            edtVarsta.getText().toString(),
                            getDateAfter263(edtDataMonta.getText().toString()) );

                    myDatabase.getIMonte().insert(monte);

                    sendOnChannel1();
                    clearField();
                    Toast.makeText(Reminder.this, "Dată înregistrată și reminder setat!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        butonDDL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Deadline.class));

            }
        });

    }

    public boolean validareDate() {
        if(edtNrCrotala.getText()==null||edtNrCrotala.getText().toString().trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Introduceți numărul crotalei!", Toast.LENGTH_LONG).show();
            return false;
        }
        if(edtVarsta.getText()==null||edtVarsta.getText().toString().trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Introduceți vârsta!", Toast.LENGTH_LONG).show();
            return false;
        }
        if(edtDataMonta.getText()==null||edtDataMonta.getText().toString().trim().isEmpty()||!validareFormatData(edtDataMonta.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Dată neintrodusă sau incorectă!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private boolean validareFormatData(String toString){
        SimpleDateFormat forma = new SimpleDateFormat(DATE_FORMAT, Locale.US);
        try {
            forma.parse(toString);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void sendOnChannel1() {
        String title = "Reminder setat pentru bovina cu numărul cotralei: " + edtNrCrotala.getText().toString();
        String text = "Vârsta: " + edtVarsta.getText().toString() + " luni | Data înregistrării: " + edtDataMonta.getText().toString();

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_add_alert_black_24dp)
                .setContentTitle(title)
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(100, notification);
    }

    private Date getDateAfter263(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = null;
        try {
            Date currentDate=sdf.parse(date);
            calendar = Calendar.getInstance();
            calendar.setTime(currentDate);
            calendar.add(Calendar.DATE, 263);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date newDate= calendar.getTime();
        return newDate;
    }

    private void setUpDB(){
        myDatabase = Room.databaseBuilder(Reminder.this , MonteDB.class , "MonteDB")
                .allowMainThreadQueries().build();
    }

    private void clearField() {
        edtNrCrotala.setText("");
        edtVarsta.setText("");
        edtDataMonta.setText("");
    }
}
