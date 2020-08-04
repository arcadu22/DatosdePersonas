package com.example.datosdepersonas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button siguiente;
    TextInputEditText edtNombre,edtFecha, edtTelefono, edtEmail, edtDescripcion;
    private int anio, mes, dia, anioInicial, mesInicial, diaInicial;
    static final int DATE_ID = 0;
    Calendar C = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        siguiente = findViewById(R.id.btnSiguiente);
        edtNombre = findViewById(R.id.edtNombre);
        edtFecha = findViewById(R.id.edtFecha);
        edtTelefono = findViewById(R.id.edtTelefono);
        edtEmail = findViewById(R.id.edtEmail);
        edtDescripcion = findViewById(R.id.edtDescripcion);

        mesInicial = C.get(Calendar.MONTH);
        diaInicial = C.get(Calendar.DAY_OF_MONTH);
        anioInicial = C.get(Calendar.YEAR);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,Datos.class);

                Bundle bundleNombre = new Bundle();
                Bundle bundleFecha = new  Bundle();
                Bundle bundleTelefono = new Bundle();
                Bundle bundleEmail = new Bundle();
                Bundle bundleDescripcion = new Bundle();

                bundleNombre.putString("nombre",edtNombre.getText().toString());
                bundleFecha.putString("fecha",edtFecha.getText().toString());
                bundleTelefono.putString("tefono",edtTelefono.getText().toString());
                bundleEmail.putString("email",edtEmail.getText().toString());
                bundleDescripcion.putString("descripcion", edtDescripcion.getText().toString());

                intent.putExtras(bundleNombre);
                intent.putExtras(bundleFecha);
                intent.putExtras(bundleTelefono);
                intent.putExtras(bundleEmail);
                intent.putExtras(bundleDescripcion);

                startActivity(intent);
            }
        });

        edtFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DATE_ID);

            }
        });

    }
    private void colocar_fecha() {
        edtFecha.setText((mes + 1) + "-" + dia + "-" + anio+" ");
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    anio = year;
                    mes = monthOfYear;
                    dia = dayOfMonth;
                    colocar_fecha();
                }
            };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this, mDateSetListener, anioInicial, mesInicial, diaInicial);
        }

        return null;
    }
}