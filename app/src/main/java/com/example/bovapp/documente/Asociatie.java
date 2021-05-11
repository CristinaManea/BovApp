package com.example.bovapp.documente;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bovapp.R;
import com.example.bovapp.documente.anexaVitei.AnexaViteiActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class Asociatie extends AppCompatActivity {

    Button butonCerereA;
    Button butonAnexaMonte;
    Button butonAnexaVitei;
    Button butonAnexaIntIes;

    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asociatie);
        getSupportActionBar().setTitle("Asociația Aberdeen Angus");

        butonCerereA = findViewById(R.id.btnCerereA);
        butonAnexaMonte = findViewById(R.id.btnAnexaMonte);
        butonAnexaVitei = findViewById(R.id.btnAnexaVitei);
        butonAnexaIntIes = findViewById(R.id.btnAnexaIntIes);

        butonCerereA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                descarcaCerereA();
            }
        });

        butonAnexaMonte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                descarcaAnexaMonte();
            }
        });

        butonAnexaVitei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AnexaViteiActivity.class));
                //descarcaAnexaVitei();
            }
        });

        butonAnexaIntIes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                descarcaAnexaIntIes();
            }
        });
    }

    public void descarcaCerereA() {
        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("cerereTipA.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                downloadFileA(Asociatie.this, "CerereAsociatie", ".pdf", DIRECTORY_DOWNLOADS, url);

                Toast.makeText(Asociatie.this, "Descarcare cu succes!", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Asociatie.this, "Eroare la descarcare!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void downloadFileA(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);
        downloadManager.enqueue(request);
    }

    public void descarcaAnexaMonte() {
        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("ANEXA_Monte.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                downloadFileAnexaMonte(Asociatie.this, "ANEXA_Monte", ".pdf", DIRECTORY_DOWNLOADS, url);

                Toast.makeText(Asociatie.this, "Descarcare cu succes!", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Asociatie.this, "Eroare la descarcare!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void downloadFileAnexaMonte(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);
        downloadManager.enqueue(request);
    }

//    public void descarcaAnexaVitei() {
//        storageReference = firebaseStorage.getInstance().getReference();
//        ref = storageReference.child("ANEXA_Vitei.pdf");
//
//        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//                String url = uri.toString();
//                downloadFileAnexaVitei(Asociatie.this, "ANEXA_Vitei", ".pdf", DIRECTORY_DOWNLOADS, url);
//
//                Toast.makeText(Asociatie.this, "Descarcare cu succes!", Toast.LENGTH_SHORT).show();
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(Asociatie.this, "Eroare la descarcare!", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    public void downloadFileAnexaVitei(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {
//        DownloadManager downloadManager = (DownloadManager) context.getSystemService(context.DOWNLOAD_SERVICE);
//        Uri uri = Uri.parse(url);
//        DownloadManager.Request request = new DownloadManager.Request(uri);
//
//        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
//        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);
//        downloadManager.enqueue(request);
//    }

    public void descarcaAnexaIntIes() {
        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("ANEXA_Intrari_Iesiri.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                downloadFileAnexaIntIes(Asociatie.this, "ANEXA_Intrari_Iesiri", ".pdf", DIRECTORY_DOWNLOADS, url);

                Toast.makeText(Asociatie.this, "Descarcare cu succes!", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Asociatie.this, "Eroare la descarcare!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void downloadFileAnexaIntIes(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);
        downloadManager.enqueue(request);
    }
}
