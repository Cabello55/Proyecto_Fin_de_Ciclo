package com.ale.proyecto_dropez;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;

    private Button login;
    private Button registrar;
    private Button cerrarSesion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        login = findViewById(R.id.btnlogin);
        registrar = findViewById(R.id.btnregistrer);
        cerrarSesion = findViewById(R.id.btncerrarsesion);

        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser()!=null){
            login.setVisibility(View.GONE);
            registrar.setVisibility(View.GONE);
            cerrarSesion.setVisibility(View.VISIBLE);
        }

    }

    public void irIniciar(View view){
        Intent i = new Intent(this,IniciarSesionActivity.class);
        startActivity(i);

    }

    public void irRegistrarse(View view){
        Intent i = new Intent(this,Registrarse.class);
        startActivity(i);
    }


    public void cerrarSesion(View view){
        auth.signOut();
        if(auth.getCurrentUser()==null){
            login.setVisibility(View.VISIBLE);
            registrar.setVisibility(View.VISIBLE);
            cerrarSesion.setVisibility(View.GONE);
        }
    }

    public void irPremiados(View view){

        if(auth.getCurrentUser()!=null){
            Intent i = new Intent(this,ActivityPremiados.class);
            startActivity(i);
        }else{
            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
            builder1.setMessage("Debes registrarte o iniciar sesión para acceder a los juegos premiados");
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    "Ok",
                    (dialog, id) -> {dialog.cancel();});
            AlertDialog alert11 = builder1.create();
            alert11.show();
        }

    }

    public void irAventuras(View view){
        if(auth.getCurrentUser()!=null){
            Intent i = new Intent(this,ActivityPremiados.class);
            startActivity(i);
        }else{
            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
            builder1.setMessage("Debes registrarte o iniciar sesión para acceder a los juegos de aventuras");
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    "Ok",
                    (dialog, id) -> {dialog.cancel();});
            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
    }

    public void irIndies(View view){
        if(auth.getCurrentUser()!=null){
            Intent i = new Intent(this,ActivityPremiados.class);
            startActivity(i);
        }else{
            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
            builder1.setMessage("Debes registrarte o iniciar sesión para acceder a los juegos indies");
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    "Ok",
                    (dialog, id) -> {dialog.cancel();});
            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
    }

    public void irRol(View view){
        if(auth.getCurrentUser()!=null){
            Intent i = new Intent(this,ActivityPremiados.class);
            startActivity(i);
        }else{
            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
            builder1.setMessage("Debes registrarte o iniciar sesión para acceder a los juegos de rol");
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    "Ok",
                    (dialog, id) -> {dialog.cancel();});
            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
    }

    public void irDeportivo(View view){
        if(auth.getCurrentUser()!=null){
            Intent i = new Intent(this,ActivityPremiados.class);
            startActivity(i);
        }else{
            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
            builder1.setMessage("Debes registrarte o iniciar sesión para acceder a los juegos deportivos");
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    "Ok",
                    (dialog, id) -> {dialog.cancel();});
            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
    }

}