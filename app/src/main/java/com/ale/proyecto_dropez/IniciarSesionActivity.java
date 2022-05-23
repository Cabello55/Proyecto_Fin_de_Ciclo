package com.ale.proyecto_dropez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class IniciarSesionActivity extends AppCompatActivity {

    private EditText correo;
    private EditText contrasena;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        correo = findViewById(R.id.txtemail);
        contrasena = findViewById(R.id.contrasena);

        mAuth = FirebaseAuth.getInstance();

    }

    public void onStart(){
        super.onStart();
        //Chek if user is signed in (non-null) and update UI accordignly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void irIniciar (View view){

        mAuth.signInWithEmailAndPassword(correo.getText().toString(),contrasena.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(i);
                                Toast.makeText(getApplicationContext(), "Autenticación correcta", Toast.LENGTH_SHORT).show();
                            //updateUI(user);

                        }else{
                            Toast.makeText(getApplicationContext(), "Autenticación fallida", Toast.LENGTH_SHORT).show();
                            //uploadUI(null);
                        }

                    }
                });

    }
}