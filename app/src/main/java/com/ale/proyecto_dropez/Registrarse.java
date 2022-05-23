package com.ale.proyecto_dropez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registrarse extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText correo;
    private EditText contrasena;
    private EditText contrasenaConfirmacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        mAuth = FirebaseAuth.getInstance();

        correo = findViewById(R.id.txtemail);
        contrasena = findViewById(R.id.contrasena);
        contrasenaConfirmacion = findViewById(R.id.contrasenaConfirmacion);
    }

    public void onStart(){
        super.onStart();
        //Chek if user is signed in (non-null) and update UI accordignly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void irRegistrarse(View view){

        if(contrasena.getText().toString().equals(contrasenaConfirmacion.getText().toString())){
            mAuth.createUserWithEmailAndPassword(correo.getText().toString(),contrasena.getText().toString())
                    .addOnCompleteListener (this,new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task){
                            if (task.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "Usuario creado", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(i);
                                //updateUI(user);

                            }else{
                                Toast.makeText(getApplicationContext(), "Authentication failed", Toast.LENGTH_SHORT).show();
                                //updateUI(null);
                            }
                        }
                    });
        }else{
            Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
        }

    }
}