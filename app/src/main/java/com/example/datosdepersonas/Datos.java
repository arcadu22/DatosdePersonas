package com.example.datosdepersonas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Datos extends AppCompatActivity {
     Button editarDatos;
     TextView nombre, fechadeNacimeinto,telefono,email,descripcionPersona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        editarDatos = findViewById(R.id.btnEditarDatos);
        nombre = findViewById(R.id.txtNombre);
        fechadeNacimeinto = findViewById(R.id.txtFechaNacimiento);
        telefono = findViewById(R.id.txtTelefono);
        email = findViewById(R.id.txtEmail);
        descripcionPersona= findViewById(R.id.txtDescripcio);

        Bundle bundleNombre=this.getIntent().getExtras();


        Bundle bundleFecha=this.getIntent().getExtras();
        Bundle bundleTelefono=this.getIntent().getExtras();
        Bundle bundleEmail=this.getIntent().getExtras();
        Bundle bundleDescripcion=this.getIntent().getExtras();

        String bNombre= bundleNombre.getString("nombre");
        String bFecha= bundleFecha.getString("fecha");
        String bTelefono= bundleTelefono.getString("telefono");
        String bEmail= bundleEmail.getString("email");
        String bDescripcion= bundleDescripcion.getString("descripcion");

        nombre.setText(bNombre);
        fechadeNacimeinto.setText(bFecha);
        telefono.setText(bTelefono);
        email.setText(bEmail);
        descripcionPersona.setText(bDescripcion);

        editarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}