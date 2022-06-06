package com.example.apppreconsulta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Consulta extends AppCompatActivity {

    Button btnMarcarConsulta;
    Button btnConsultaMarcada;
    String CPF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        btnConsultaMarcada = findViewById(R.id.btnConsultaMarcada);
        btnMarcarConsulta = findViewById(R.id.btnMarcarConsulta);

        Intent intent = getIntent();
        CPF = intent.getStringExtra("usuario");

        btnMarcarConsulta.setOnClickListener(this::telaMarcarConsulta);
        btnConsultaMarcada.setOnClickListener(view -> telaConsultaMarcada());

    }

    public void telaMarcarConsulta(View v){
        Intent intent = new Intent(this,MarcarConsulta.class);
        intent.putExtra("usuario", CPF);
        startActivity(intent);
    }
    public void telaConsultaMarcada(){
        Intent intent = new Intent(this, ConsultaMarcada.class);
        intent.putExtra("usuario", CPF);
        startActivity(intent);
    }

}