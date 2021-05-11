package com.example.bovapp.conectare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bovapp.MainActivity;
import com.example.bovapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {

    public static final String TAG = "TAG";
    EditText numePrenume, email, telefon, judet, parola;
    Button butonSignup;
    Button butonBack;
    ProgressBar progressBar;

    String userId;

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().setTitle("Înregistrare");

        numePrenume = findViewById(R.id.numePrenume);
        email = findViewById(R.id.email);
        telefon = findViewById(R.id.telefon);
        judet = findViewById(R.id.judet);
        parola = findViewById(R.id.parola);
        butonSignup = findViewById(R.id.butonSignUp);
        butonBack = findViewById(R.id.butonBack);
        progressBar = findViewById(R.id.progressBar);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        if(firebaseAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        butonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String emailValue = email.getText().toString().trim();
                String parolaValue = parola.getText().toString().trim();

                final String numePrenumeValue = numePrenume.getText().toString();
                final String telefonValue = telefon.getText().toString();
                final String judetValue = judet.getText().toString();

                if(TextUtils.isEmpty(emailValue)){
                    email.setError("E-mailul este necesar!");
                    return;
                }

                if(TextUtils.isEmpty(parolaValue)){
                    parola.setError("Parola este necesară!");
                    return;
                }

                if(parolaValue.length() <=6 ){
                    parola.setError("Parola trebuie să conțină minim 6 caractere!");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                firebaseAuth.createUserWithEmailAndPassword(emailValue, parolaValue).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Signup.this, "Utilizator înregistrat cu succes!", Toast.LENGTH_SHORT).show();
                            userId = firebaseAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = firebaseFirestore.collection("users").document(userId);
                            Map<String, Object> user = new HashMap<>();
                            user.put("numeComplet", numePrenumeValue);
                            user.put("email", emailValue);
                            user.put("telefon", telefonValue);
                            user.put("judet", judetValue);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "onSucces" + userId);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFail" +e.toString());
                                }
                            });
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else {
                            Toast.makeText(Signup.this, "Eroare la înregistrare!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        butonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
    }
}
