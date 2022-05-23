package com.ale.proyecto_dropez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Descripciontres extends AppCompatActivity {

    ImageButton btnatrasElden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripciontres);

        btnatrasElden= (ImageButton) findViewById(R.id.btnatrasElden);

        btnatrasElden.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(Descripciontres.this,SistemaMeGusta.class);
                startActivity(i);

            }
        });
    }
}