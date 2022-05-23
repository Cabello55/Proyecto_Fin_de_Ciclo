package com.ale.proyecto_dropez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Descripcion extends AppCompatActivity {

    ImageButton btnatras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);

        btnatras= (ImageButton) findViewById(R.id.btnatras);

        btnatras.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(Descripcion.this,SistemaMeGusta.class);
                startActivity(i);

            }
        });
    }
}