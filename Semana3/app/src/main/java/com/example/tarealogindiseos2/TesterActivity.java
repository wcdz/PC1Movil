package com.example.tarealogindiseos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TesterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tester);

        // Obtenemos el mensaje del body activity
        Intent intent = getIntent(); // Obtenemos el intento referenciado, no es necesario especificarlo, ya que solo se invoca 1 vez
        String msg = intent.getStringExtra("MESSAGE"); // se obtiene la data por el identificador MESSAGE
        TextView textView = findViewById(R.id.textView); // se busca el componente con el id
        textView.setText(msg); // Asignamos el valor que se obtuvo
    }

}
