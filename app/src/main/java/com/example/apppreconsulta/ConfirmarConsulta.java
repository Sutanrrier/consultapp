package com.example.apppreconsulta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmarConsulta extends AppCompatActivity {

    TextView marker;
    Button confirmarConsulta;
    Spinner medicos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_consulta);

        confirmarConsulta = findViewById(R.id.btnConfirmarConsulta);
        marker = findViewById(R.id.marker);
        medicos = findViewById(R.id.spnmedicos);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.medicos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        medicos.setAdapter(adapter);

        String local = getIntent().getStringExtra("local");
        marker.setText(local);

        confirmarConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {confirmou(view);}

        });

    }

    public void confirmou(View v){
        Intent intent = new Intent(this, Consulta.class);
        startActivity(intent);
        Toast.makeText(ConfirmarConsulta.this, "Consulta Marcada", Toast.LENGTH_SHORT).show();
    }

}