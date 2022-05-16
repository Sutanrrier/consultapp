
//*** Trabalho feito por***
//    Matheus Felipe Magalhães Linhares
//            Matricula:201902327292
//    Victor Sabino Loyola Barros
//            Matricula:201902134834


package com.example.apppreconsulta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnEntrar;
    Button btnCadastrar;
    Button btnRedefinir;
    EditText edtUsuario;
    EditText edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEntrar = findViewById(R.id.btnEntrar);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnRedefinir = findViewById(R.id.btnRedefinir);
        edtUsuario = findViewById(R.id.edtUsuario);
        edtSenha = findViewById(R.id.edtSenha);

        btnEntrar.setOnClickListener(this);
        btnCadastrar.setOnClickListener(this);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUsuario(v);
            }
        });
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastroUsuario(v);
            }
        });
        btnRedefinir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { redefinirSenha(v); }
        });

    }

    private Boolean validarUsername(){
        String val = edtUsuario.getText().toString();

        if (val.isEmpty()){
            edtUsuario.setError("Não pode estar vazio");
            return false;
        }else{
            edtUsuario.setError(null);
            return true;
        }
    }

    private Boolean validarSenha(){
        String val = edtSenha.getText().toString();

        if (val.isEmpty()){
            edtSenha.setError("Não pode estar vazio");
            return false;
        }else{
            edtSenha.setError(null);
            return true;
        }
    }

    public void loginUsuario(View v){
        if (!validarUsername() | !validarSenha()){
            return;
        }else{
            isUser();
        }
    }

    private void isUser(){
        final String usuarioUsuario = edtUsuario.getText().toString().trim();
        final String usuarioSenha = edtSenha.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("usuario");

        Query checkUsuario = reference.orderByChild("usuario").equalTo(usuarioUsuario);

        checkUsuario.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()){
                    String senhaDB = snapshot.child(usuarioUsuario).child("senha").getValue(String.class);

                    if(senhaDB.equals(usuarioSenha)){
                        String nomeDB = snapshot.child(usuarioUsuario).child("nome").getValue(String.class);
                        String emailDB = snapshot.child(usuarioUsuario).child("email").getValue(String.class);
                        String telefoneDB = snapshot.child(usuarioUsuario).child("telefone").getValue(String.class);
                        String enderecoDB = snapshot.child(usuarioUsuario).child("endereco").getValue(String.class);
                        String usuarioDB = snapshot.child(usuarioUsuario).child("usuario").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext(),TelaEntrar.class);

                        intent.putExtra("nome", nomeDB);
                        intent.putExtra("email", emailDB);
                        intent.putExtra("telefone", telefoneDB);
                        intent.putExtra("endereco", enderecoDB);
                        intent.putExtra("usuario", usuarioDB);
                        intent.putExtra("senha", senhaDB);

                        startActivity(intent);
                        finish();
                    }else{
                        edtSenha.setError("Senha errada");
                    }
                }else{
                    edtUsuario.setError("Usuario não existe");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void cadastroUsuario(View v){
        Intent intent = new Intent(this,TelaFormulario.class);
        startActivity(intent);
    }
    public void redefinirSenha(View v){
        Intent intent = new Intent (this, RedefinirSenha.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }
}
