package com.example.apppreconsulta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Consulta extends AppCompatActivity {

    Button btnMarcarConsulta;
    Button btnConsultaMarcada;
    Button btnVoltarConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        btnConsultaMarcada = findViewById(R.id.btnConsultaMarcada);
        btnMarcarConsulta = findViewById(R.id.btnMarcarConsulta);
        btnVoltarConsulta = findViewById(R.id.btnVoltarConsulta);

        btnMarcarConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                telaMarcarConsulta(v);
            }
        });
        btnVoltarConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltarConsulta(v);
            }
        });


    }

    public void telaMarcarConsulta(View v){
        Intent intent = new Intent(this,MarcarConsulta.class);
        startActivity(intent);
    }
    public void voltarConsulta(View v){
        super.onBackPressed();
        finish();
    }
}