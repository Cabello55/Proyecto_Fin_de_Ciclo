package com.ale.proyecto_dropez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Descripciondos extends AppCompatActivity {

    ImageButton btnatrasRed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripciondos);

        btnatrasRed= (ImageButton) findViewById(R.id.btnatrasRed);

        btnatrasRed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(Descripciondos.this,SistemaMeGusta.class);
                startActivity(i);

            }
        });
    }
}