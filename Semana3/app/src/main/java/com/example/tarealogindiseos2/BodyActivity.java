package com.example.tarealogindiseos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RatingBar;

import java.util.ArrayList;
import java.util.List;

public class BodyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);

        List<String> data = new ArrayList<>(); // ArrayList para cargar data
        data.add("uno");
        data.add("dos");
        data.add("tres");
        data.add("catorce");

        ListView listView = (ListView) findViewById(R.id.listado);

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                data);

        listView.setAdapter(itemsAdapter);

    }

    public void calificar(View view) {
        Intent intent = new Intent(this, TesterActivity.class);

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        String message = String.valueOf(ratingBar.getRating()); // Se captura el mensage del ratingBar
        intent.putExtra("MESSAGE", message); // Es el identificador del mensaje capturado

        startActivity(intent);
    }
}