package com.example.apppreconsulta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MarcarConsulta extends AppCompatActivity implements View.OnClickListener{

    Button btnMarcarUrgencia;
    Button btnMarcarMaternidade;
    Button btnMarcarClinica;
    Button btnMarcarDentista;
    Button btnMarcarCAPS;
    String CPF;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcar_consulta);

      btnMarcarUrgencia = findViewById(R.id.btnMarcarUrgencia);
      btnMarcarMaternidade = findViewById(R.id.btnMarcarMaternidade);
      btnMarcarClinica = findViewById(R.id.btnMarcarClinica);
      btnMarcarDentista = findViewById(R.id.btnMarcarDentista);
      btnMarcarCAPS = findViewById(R.id.btnMarcarCAPS);

      Intent intent = getIntent();
        String user_User = intent.getStringExtra("usuario");
        CPF = user_User;


      btnMarcarUrgencia.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              localizacao(v);
          }
      });
      /*btnMarcarMaternidade.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              localizacao(view);
          }
      });*/



    }
    public void localizacao(View v){
        Intent intent = new Intent(this, Localizacao.class);
        intent.putExtra("usuario", CPF);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {

    }
}