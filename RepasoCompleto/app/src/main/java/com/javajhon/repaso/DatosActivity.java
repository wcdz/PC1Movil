package com.javajhon.repaso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class DatosActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        /* Iniciar SharedPreferences */
        preferences = this.getSharedPreferences("SESIONES", Context.MODE_PRIVATE);
        editor = preferences.edit();

        TextView textView = findViewById(R.id.datos_texto);
        textView.setText(preferences.getString("NOMBRE","USER"));
    }
}