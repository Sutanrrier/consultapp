package com.example.apppreconsulta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class RedefinirSenha extends AppCompatActivity implements View.OnClickListener{

    EditText redefinirCPF;
    EditText redefinirSenha;
    EditText redefinirConfSenha;
    Button btnredefinirSenha;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redefinir_senha);

        redefinirCPF = findViewById(R.id.edtRedefinirCPF);
        redefinirSenha = findViewById(R.id.edtRedefinirSenha);
        redefinirConfSenha = findViewById(R.id.edtRedefinirConfSenha);
        btnredefinirSenha = findViewById(R.id.btnRedefinirSenha);

        btnredefinirSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redefinirASenha(v);
            }
        });

    }


    private Boolean validarUsername(){
        String val = redefinirCPF.getText().toString();

        if (val.isEmpty()){
            redefinirCPF.setError("Não pode estar vazio");
            return false;
        }else{
            redefinirCPF.setError(null);
            return true;
        }
    }

    public Boolean validarSenha(){
        String val = redefinirSenha.getText().toString();

        if (val.isEmpty()){
            redefinirSenha.setError("Não pode estar vazio");
            return false;
        }else{
            redefinirSenha.setError(null);
            return true;
        }
    }
    public Boolean validarSenhaconf(){
        String val = redefinirConfSenha.getText().toString();

        if (val.isEmpty()){
            redefinirConfSenha.setError("Não pode estar vazio");
            return false;
        }else{
            redefinirConfSenha.setError(null);
            return true;
        }
    }
    public void redefinirASenha(View v){
        if (!validarUsername() | !validarSenha() | !validarSenhaconf()){
            return;
        }else{
            isUser();
        }
    }

    private void isUser() {
        final String usuarioUsuario = redefinirCPF.getText().toString().trim();
        final String usuarioSenha = redefinirSenha.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("usuario");

        Query checkUsuario = reference.orderByChild("usuario").equalTo(usuarioUsuario);
        checkUsuario.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    redefinicao();
                }else{
                    redefinirCPF.setError("CPF não cadastrado");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    public void redefinicao(){
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("usuario");
        String userCPF = redefinirCPF.getText().toString();
        String Senha = redefinirSenha.getText().toString();
        HashMap hashMap = new HashMap();
        hashMap.put("senha", Senha);


        reference.child(userCPF).updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                Toast.makeText(RedefinirSenha.this, "Senha redefinida", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }


    @Override
    public void onClick(View view) {

    }
}
