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
        String user_User = intent.getStringExtra("usuario");
        CPF = user_User;

        btnMarcarConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                telaMarcarConsulta(v);
            }
        });
        btnConsultaMarcada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { telaConsultaMarcada(); }
        });

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