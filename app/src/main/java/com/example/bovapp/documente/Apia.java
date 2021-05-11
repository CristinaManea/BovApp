package com.example.bovapp.documente;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bovapp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class Apia extends AppCompatActivity {

    Button butonCerere;
    Button butonPasaport;
    Button butonAdevMedic;
    Button butonAdevAsociatie;

    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apia);
        getSupportActionBar().setTitle("Agenția de Plăți și Intervenții în Agricultură");

        butonCerere = findViewById(R.id.btnCerere);
        butonPasaport = findViewById(R.id.btnPasaport);
        butonAdevMedic = findViewById(R.id.btnAdevMedic);
        butonAdevAsociatie = findViewById(R.id.btnAdevAsociatie);

        butonCerere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                descarcaCerere();
            }
        });

        butonPasaport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                descarcaPasaport();
            }
        });

        butonAdevMedic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                descarcaAdevMedic();
            }
        });

        butonAdevAsociatie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                descarcaAdevAAA();
            }
        });
    }

    public void descarcaCerere() {
        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("cerereTip.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                downloadFile(Apia.this, "CerereAPIA", ".pdf", DIRECTORY_DOWNLOADS, url);

                Toast.makeText(Apia.this, "Descarcare cu succes!", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Apia.this, "Eroare la descarcare!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void downloadFile(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);
        downloadManager.enqueue(request);
    }

    public void descarcaPasaport() {
        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("pasaport.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                downloadPasaport(Apia.this, "Pasaport", ".pdf", DIRECTORY_DOWNLOADS, url);

                Toast.makeText(Apia.this, "Descarcare cu succes!", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Apia.this, "Eroare la descarcare!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void downloadPasaport(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);
        downloadManager.enqueue(request);
    }

    public void descarcaAdevMedic() {
        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("AdeverintaMedicala.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                downloadAdevMedic(Apia.this, "AdeverintaMedicala", ".pdf", DIRECTORY_DOWNLOADS, url);

                Toast.makeText(Apia.this, "Descarcare cu succes!", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Apia.this, "Eroare la descarcare!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void downloadAdevMedic(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);
        downloadManager.enqueue(request);
    }

    public void descarcaAdevAAA() {
        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("AdeverintaAAA.pdf");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                downloadAdevAAA(Apia.this, "AdeverintaAsociatie", ".pdf", DIRECTORY_DOWNLOADS, url);

                Toast.makeText(Apia.this, "Descarcare cu succes!", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Apia.this, "Eroare la descarcare!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void downloadAdevAAA(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);
        downloadManager.enqueue(request);
    }
}
