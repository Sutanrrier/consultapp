package com.example.apppreconsulta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TelaFormulario extends AppCompatActivity  implements View.OnClickListener {

    Button btnSalvar;
    Button btnVoltar;
    EditText edtNome;
    EditText edtEmail;
    EditText edtTelefone;
    EditText edtEndereco;
    EditText edtUsuario;
    EditText edtSenha;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_formulario);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnVoltar = findViewById(R.id.btnVoltar);
        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtTelefone = findViewById(R.id.edtTelefone);
        edtEndereco = findViewById(R.id.edtEndereco);
        edtUsuario = findViewById(R.id.edtUsuario);
        edtSenha = findViewById(R.id.edtSenha);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("usuario");

                String nome = edtNome.getText().toString();
                String email = edtEmail.getText().toString();
                String telefone = edtTelefone.getText().toString();
                String endereco = edtEndereco.getText().toString();
                String usuario = edtUsuario.getText().toString();
                String senha = edtSenha.getText().toString();



                if (nome.isEmpty()) {
                    edtNome.setError("Obrigatório");
                    return;
                }
                if (email.isEmpty()) {
                    edtEmail.setError("Obrigatório");
                    return;
                }
                if (telefone.isEmpty()) {
                    edtTelefone.setError("Obrigatório");
                    return;
                }
                if (endereco.isEmpty()) {
                    edtEndereco.setError("Obrigatório");
                    return;
                }
                if (usuario.isEmpty()) {
                    edtUsuario.setError("Obrigatório");
                    return;
                }
                if (senha.isEmpty()) {
                    edtSenha.setError("Obrigatório");
                    return;
                }
                Toast.makeText(TelaFormulario.this, "Cadastro feito", Toast.LENGTH_SHORT).show();
                DatabaseHelper helperclass = new DatabaseHelper(nome, email, telefone, endereco, usuario, senha);
                reference.child(usuario).setValue(helperclass);

                btnVoltar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        onBackPressed(v);
                    }
                });
            }
        });
    }

    public void onBackPressed(View v) {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onClick(View view) {

    }
}


