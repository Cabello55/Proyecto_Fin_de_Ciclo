package com.ale.proyecto_dropez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class SistemaMeGusta extends AppCompatActivity {

    ImageButton btnmas1;
    ImageButton btnmas2;
    ImageButton btnmas3;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_me_gusta);

        btnmas1= (ImageButton) findViewById(R.id.btnmas1);
        btnmas2= (ImageButton) findViewById(R.id.btnmas2);
        btnmas3= (ImageButton) findViewById(R.id.btnmas3);


        btnmas1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(SistemaMeGusta.this,Descripcion.class);
                startActivity(i);

            }
        });

        btnmas2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(SistemaMeGusta.this,Descripciondos.class);
                startActivity(i);

            }
        });

        btnmas3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(SistemaMeGusta.this,Descripciontres.class);
                startActivity(i);

            }
        });


        LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.animation_view);
        LottieAnimationView animationView2 = (LottieAnimationView) findViewById(R.id.animation_view2);
        LottieAnimationView animationView3 = (LottieAnimationView) findViewById(R.id.animation_view3);
        animationView.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                animationView.playAnimation();

            }

        });


    }
}