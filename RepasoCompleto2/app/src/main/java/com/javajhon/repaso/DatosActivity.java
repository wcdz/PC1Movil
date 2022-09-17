package com.javajhon.repaso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.javajhon.repaso.adaptadores.RecyclerDatosAdapter;

public class DatosActivity extends AppCompatActivity {

    /*Preferencias*/
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    /*Recycler-view*/
    RecyclerView lista;
    String[] signos, descrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        /* Iniciar SharedPreferences */
        preferences = this.getSharedPreferences("SESIONES", Context.MODE_PRIVATE);
        editor = preferences.edit();

        TextView textView = findViewById(R.id.datos_texto);
        textView.setText(preferences.getString("NOMBRE","USER"));

        /*Iniciar el recycler-view*/
        lista = findViewById(R.id.datos_lista);
        signos = getResources().getStringArray(R.array.signos);
        descrip = getResources().getStringArray(R.array.descripcion_signos);

        /*Vincular con el adaptador*/
        RecyclerDatosAdapter adapter = new RecyclerDatosAdapter(this,signos,descrip);
        lista.setAdapter(adapter);
        lista.setLayoutManager(new LinearLayoutManager(this));

    }
}