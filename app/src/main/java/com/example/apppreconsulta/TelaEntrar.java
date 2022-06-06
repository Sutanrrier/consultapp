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
    Button qrcode;
    String CPF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_entrar);

        informacoesNome = findViewById(R.id.txtNomeentrar);
        consulta = findViewById(R.id.btnConsulta);
        remedios = findViewById(R.id.btnRemedios);
        qrcode = findViewById(R.id.btnQRcode);

        Intent intent = getIntent();
        String user_nome = intent.getStringExtra("nome");
        CPF = intent.getStringExtra("usuario");
        informacoesNome.setText(user_nome.split(" ")[0]);

        //Trigger do botão Consulta
        consulta.setOnClickListener(this::consulta);

        //Trigger do botão Remedios
        remedios.setOnClickListener(this::remedios);

        //Trigger do botão QrCode
        qrcode.setOnClickListener(this::qrcode);
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

    //Tela de QrCode
    public void qrcode(View v){
        Intent intent = new Intent(this,TelaQrCode.class);
        intent.putExtra("usuario", CPF);
        startActivity(intent);
    }
}
