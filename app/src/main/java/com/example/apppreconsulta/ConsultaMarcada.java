package com.example.apppreconsulta;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ConsultaMarcada extends AppCompatActivity implements View.OnClickListener {

    TextView localMarcado;
    TextView medicoMarcado;
    TextView dataMarcada;
    TextView localmat,medicomat,datamat;
    TextView localcli,medicocli,datacli;
    TextView localodonto,medicoodonto,dataodonto;
    TextView localcaps,medicocaps,datacaps;
    String CPF;
    Button urgencia;
    Button maternidade;
    Button clinica;
    Button odonto;
    Button caps;



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
        clinica = findViewById(R.id.btnclinica);
        localcli = findViewById(R.id.localclinica);
        medicocli = findViewById(R.id.medicoclinica);
        datacli = findViewById(R.id.dataclinica);
        odonto = findViewById(R.id.btnodontologia);
        localodonto = findViewById(R.id.localodonto);
        medicoodonto = findViewById(R.id.medicoodonto);
        dataodonto = findViewById(R.id.dataodonto);
        caps = findViewById(R.id.btnCAPS);
        localcaps = findViewById(R.id.localcaps);
        medicocaps = findViewById(R.id.medicocaps);
        datacaps = findViewById(R.id.dataocaps);


        Intent intent = getIntent();
        CPF = intent.getStringExtra("usuario");

        urgencia.setOnClickListener(view -> acaourgencia());
        maternidade.setOnClickListener(view -> acaomaternidade());
        clinica.setOnClickListener(view -> acaoclinica());
        odonto.setOnClickListener(view -> acaoodonto());
        caps.setOnClickListener(view -> acaocaps());



    }

    private void acaocaps() {
        final String usuarioUsuario = CPF;

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("consulta_CAPS");

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String local = snapshot.child(usuarioUsuario).child("local").getValue(String.class);
                    String medico = snapshot.child(usuarioUsuario).child("medico").getValue(String.class);
                    String data = snapshot.child(usuarioUsuario).child("data").getValue(String.class);

                    localcaps.setText(local);
                    medicocaps.setText(medico);
                    datacaps.setText(data);


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void acaoodonto() {
        final String usuarioUsuario = CPF;

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("consulta_odontologia");

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String local = snapshot.child(usuarioUsuario).child("local").getValue(String.class);
                    String medico = snapshot.child(usuarioUsuario).child("medico").getValue(String.class);
                    String data = snapshot.child(usuarioUsuario).child("data").getValue(String.class);

                    localodonto.setText(local);
                    medicoodonto.setText(medico);
                    dataodonto.setText(data);


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
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
    public void acaoclinica(){
        final String usuarioUsuario = CPF;

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("consulta_clinica");

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String localmate = snapshot.child(usuarioUsuario).child("local").getValue(String.class);
                    String medicomate = snapshot.child(usuarioUsuario).child("medico").getValue(String.class);
                    String datamate = snapshot.child(usuarioUsuario).child("data").getValue(String.class);

                    localcli.setText(localmate);
                    medicocli.setText(medicomate);
                    datacli.setText(datamate);


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