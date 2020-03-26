package com.test.pokedex.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.test.pokedex.R;

public class ActivityDetalles extends AppCompatActivity {
    private TextView pokemon_nombre;
    private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);


        manageIntent();

        initializeComponents();
        initializeListeners();
        initializeData();
    }
    private void manageIntent() {
        if(getIntent() != null){
            id = getIntent().getStringExtra("ID");
            //password = getIntent().getStringExtra("PASSWORD");
        }
    }
    private void initializeComponents() {
    pokemon_nombre = findViewById(R.id.nombre_pokemon);
    pokemon_nombre.setText(id);
    }

    private void initializeListeners() {
    }

    private void initializeData() {
    }




}
