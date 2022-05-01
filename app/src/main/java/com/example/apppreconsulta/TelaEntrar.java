package com.example.apppreconsulta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaEntrar extends AppCompatActivity {

    TextView informacoesNome;
    //TextView informacoesEmail;
    //TextView informacoesTelefone;
    //TextView informacoesEndereco;
    Button consulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_entrar);

        informacoesNome = findViewById(R.id.txtNomeentrar);
        //informacoesEmail = findViewById(R.id.txtEmailentrar);
        //informacoesTelefone = findViewById(R.id.txtTelefoneentrar);
        //informacoesEndereco = findViewById(R.id.txtEnderecoentrar);
        consulta = findViewById(R.id.btnConsulta);

        Intent intent = getIntent();
        String user_nome = intent.getStringExtra("nome");
        //String user_email = intent.getStringExtra("email");
        //String user_telefone = intent.getStringExtra("telefone");
        //String user_endereco = intent.getStringExtra("endereco");


        informacoesNome.setText(user_nome);
        //informacoesEmail.setText(user_email);
        //informacoesTelefone.setText(user_telefone);
        //informacoesEndereco.setText(user_endereco);

        consulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consulta(v);
            }

        });
    }
    public void consulta(View v){
        Intent intent = new Intent(this,Consulta.class);
        startActivity(intent);
    }
}
