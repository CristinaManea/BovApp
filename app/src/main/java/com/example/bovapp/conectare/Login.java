package com.example.bovapp.conectare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bovapp.MainActivity;
import com.example.bovapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText email, parola;
    Button butonLogin, butonSignup;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Conectare");

        email = findViewById(R.id.email);
        parola = findViewById(R.id.parola);
        butonLogin = findViewById(R.id.butonLogin);
        butonSignup = findViewById(R.id.butonSignup);

        firebaseAuth = FirebaseAuth.getInstance();

        butonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailValue = email.getText().toString().trim();
                String parolaValue = parola.getText().toString().trim();

                if(TextUtils.isEmpty(emailValue)){
                    email.setError("E-mailul este necesar!");
                    return;
                }

                if(TextUtils.isEmpty(parolaValue)){
                    parola.setError("Parola este necesară!");
                    return;
                }

                if(parolaValue.length() <= 6){
                    parola.setError("Parola trebuie să conțină minim 6 caractere!");
                    return;
                }
                firebaseAuth.signInWithEmailAndPassword(emailValue, parolaValue).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this, "Utilizator conectat cu succes!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else {
                            Toast.makeText(Login.this, "Eroare la conectare!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        butonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Signup.class));
            }
        });
    }
}
