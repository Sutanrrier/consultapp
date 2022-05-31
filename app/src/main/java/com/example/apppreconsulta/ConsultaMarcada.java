package com.example.apppreconsulta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ConsultaMarcada extends AppCompatActivity implements View.OnClickListener {

    TextView localMarcado;
    TextView medicoMarcado;
    TextView dataMarcada;
    TextView localmat,medicomat,datamat;
    String CPF;
    Button urgencia;
    Button maternidade;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_marcada);

        localMarcado = findViewById(R.id.localconsulta);
        medicoMarcado = findViewById(R.id.medicoconsulta);
        dataMarcada = findViewById(R.id.dataconsulta);
        urgencia = findViewById(R.id.btnurgencia);
        maternidade = findViewById(R.id.btnmaternidade);
        localmat = findViewById(R.id.localmaternidade);
        medicomat = findViewById(R.id.medicomaternidade);
        datamat = findViewById(R.id.datamaternidade);

        Intent intent = getIntent();
        String user_User = intent.getStringExtra("usuario");
        CPF = user_User;

        urgencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acaourgencia();
            }
        });
        maternidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {acaomaternidade();}
        });


    }

    public void acaourgencia(){
        final String usuarioUsuario = CPF;

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("consulta_urgencia");

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String local = snapshot.child(usuarioUsuario).child("local").getValue(String.class);
                    String medico = snapshot.child(usuarioUsuario).child("medico").getValue(String.class);
                    String data = snapshot.child(usuarioUsuario).child("data").getValue(String.class);

                    localMarcado.setText(local);
                    medicoMarcado.setText(medico);
                    dataMarcada.setText(data);


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    public void acaomaternidade(){
        final String usuarioUsuario = CPF;

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("consulta_maternidade");

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String localmate = snapshot.child(usuarioUsuario).child("local").getValue(String.class);
                    String medicomate = snapshot.child(usuarioUsuario).child("medico").getValue(String.class);
                    String datamate = snapshot.child(usuarioUsuario).child("data").getValue(String.class);

                    localmat.setText(localmate);
                    medicomat.setText(medicomate);
                    datamat.setText(datamate);


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    @Override
    public void onClick(View view) {

    }
}