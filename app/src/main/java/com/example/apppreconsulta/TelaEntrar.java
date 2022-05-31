package com.example.apppreconsulta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaEntrar extends AppCompatActivity {

    //Variaveis
    TextView informacoesNome;
    Button consulta;
    Button remedios;
    String CPF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_entrar);

        informacoesNome = findViewById(R.id.txtNomeentrar);
        consulta = findViewById(R.id.btnConsulta);
        remedios = findViewById(R.id.btnRemedios);

        Intent intent = getIntent();
        String user_nome = intent.getStringExtra("nome");
        String user_User = intent.getStringExtra("usuario");
        CPF = user_User;
        informacoesNome.setText(user_nome.split(" ")[0]);

        //Trigger do botão Consulta
        consulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consulta(v);
            }
        });

        //Trigger do botão Remedios
        remedios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remedios(v);
            }
        });
    }

    //Tela de Marcar Consulta
    public void consulta(View v){
        Intent intent = new Intent(this,Consulta.class);
        intent.putExtra("usuario", CPF);
        startActivity(intent);
    }

    //Tela de Remedios
    public void remedios(View v){
        Intent intent = new Intent(this,telaRemedios.class);
        intent.putExtra("usuario", CPF);
        startActivity(intent);
    }
}
