package com.ale.proyecto_dropez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class VisorPdf extends AppCompatActivity {
    public final static long ONE_MEGABYTE = 1024 * 1024*20;

    private String juegoNombre;
    private PDFView pdfView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_pdf);

        juegoNombre = getIntent().getStringExtra("premiados");

        pdfView = findViewById(R.id.pdfView);

        FirebaseStorage mFirebaseStorage = FirebaseStorage.getInstance();
        StorageReference mmFirebaseStorageRef = mFirebaseStorage.getReference().child("premiados");

        mmFirebaseStorageRef.child(juegoNombre).getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                pdfView.fromBytes(bytes).load();
            }

        }).addOnFailureListener((e) -> {
            Toast.makeText(VisorPdf.this,"download unsuccessful",Toast.LENGTH_LONG).show();
        });
    }
}