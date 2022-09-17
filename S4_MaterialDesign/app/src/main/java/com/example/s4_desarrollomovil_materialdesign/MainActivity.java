package com.example.s4_desarrollomovil_materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences; // Valores para toda la app
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializacion
        sharedPreferences = this.getSharedPreferences("SESIONES", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    public void login(View view) {
        String user, pass;
        Intent intent = new Intent(this, MainActivity.class);
        TextInputLayout loginEmail = (TextInputLayout) findViewById(R.id.editTextTextPersonName2);
        TextInputLayout loginPass = (TextInputLayout) findViewById(R.id.editTextTextPassword3);
        user = loginEmail.getEditText().getText().toString();
        pass = loginPass.getEditText().getText().toString();
        Log.d("USER", user + " - " + pass);

        if (!user.equals("mail@mail.com") && !pass.equals("1234")) {
            CharSequence text = "Usuario no reconocido";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
            return;
        }

        intent.putExtra("USER", user);
        startActivity(intent);
    }
}
