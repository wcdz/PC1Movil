package com.javajhon.repaso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* Iniciar SharedPreferences */
        preferences = this.getSharedPreferences("SESIONES", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       switch (item.getItemId()){
           case R.id.menu_main_visitar:
               startActivity(new Intent(this, PerfilActivity.class));
               return true;
           case R.id.menu_main_ayuda:
               CharSequence msg = "Happy to help";
               Toast aviso = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
               aviso.show();
               return true;
           case R.id.menu_main_log:
               Log.d("MENSAJE DE LOG", "HOLA LOG");
               return true;
           default:
               return super.onOptionsItemSelected(item);
       }
    }

    public void enviarInfo(View view){
        TextInputLayout nombresForm = findViewById(R.id.main_nombre);
        String nombres = nombresForm.getEditText().getText().toString();
        TextInputLayout apellidosForm = findViewById(R.id.main_apellido);
        String apellidos = apellidosForm.getEditText().getText().toString();
        editor.putString("NOMBRE", nombres);
        editor.putString("APELLIDO", apellidos);
        editor.apply();
        startActivity(new Intent(this, DatosActivity.class));
    }
}