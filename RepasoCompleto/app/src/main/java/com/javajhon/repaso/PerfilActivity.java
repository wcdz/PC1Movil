package com.javajhon.repaso;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import com.javajhon.repaso.databinding.ActivityPerfilBinding;

public class PerfilActivity extends AppCompatActivity {

    private ActivityPerfilBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPerfilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /* Iniciar SharedPreferences */
        preferences = this.getSharedPreferences("SESIONES", Context.MODE_PRIVATE);
        editor = preferences.edit();

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(toolbar.getTitle());

        TextView datos = findViewById(R.id.perfil_datos);
        datos.setText(preferences.getString("NOMBRE", "USER") + " " + preferences.getString("APELLIDO", "USER"));




        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}