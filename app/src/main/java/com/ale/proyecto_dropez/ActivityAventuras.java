package com.ale.proyecto_dropez;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class ActivityAventuras extends AppCompatActivity {
    private ListView listView1;

    private ArrayList<String> aventuras;

    private StorageReference mStorageRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aventuras);

        listView1 = findViewById(R.id.listviewAventuras);
        aventuras = new ArrayList<>();

        //inicialización del objeto en firebase Storage
        mStorageRef = FirebaseStorage.getInstance().getReference();

        //traigo la referencia el bucket donde tengo guardado mis juegos en Jpg de Firebase
        StorageReference ref = mStorageRef.child("aventuras");

        //codigo para traer todos los títulos de los documentos
        ref.listAll().addOnSuccessListener(new  OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {
                for (StorageReference item : listResult.getItems()) {
                    aventuras.add(item.getName() + "");
                }

                //configuro el adaptador de la lista
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, aventuras);

                //muestro el adaptador en la vista
                listView1.setAdapter(adapter);

                //se activa al clickear
                listView1.setOnItemClickListener(( parent, view, position, id) -> {
                    final String titulo_aventuras_seleccionado = listView1.getItemAtPosition(position).toString();
                    //abrir nueva activity
                    Intent i = new Intent(getApplicationContext(),VisorPdfAventuras.class);
                    i.putExtra("aventuras",titulo_aventuras_seleccionado);
                    startActivity(i);
                });
            }


            //por si hay error al traer las cosas de la base de datos
        }).addOnFailureListener((e) -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(ActivityAventuras.this);
            builder1.setMessage("Ha ocurrido un error al cargar los juegos. Revisa tu coinexión a internet");
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    "ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();

                        }
                    });
            AlertDialog alert1 = builder1.create();
            alert1.show();


        });

    }
}
