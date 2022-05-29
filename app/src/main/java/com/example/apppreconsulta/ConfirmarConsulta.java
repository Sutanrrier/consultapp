package com.example.apppreconsulta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConfirmarConsulta extends AppCompatActivity {

    TextView marker;
    Button confirmarConsulta;
    Spinner medicos;
    EditText confirmarCPF;
    CalendarView calendario;
    String calendar;


    FirebaseDatabase rootNode;
    DatabaseReference references;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_consulta);

        confirmarConsulta = findViewById(R.id.btnConfirmarConsulta);
        marker = findViewById(R.id.marker);
        medicos = findViewById(R.id.spnmedicos);
        confirmarCPF = findViewById(R.id.ConfirmCPF);
        calendario = findViewById(R.id.Calendario);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.medicos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        medicos.setAdapter(adapter);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String selectedDate = sdf.format(new Date(calendario.getDate()));
        calendar = selectedDate;

        String local = getIntent().getStringExtra("local");
        marker.setText(local);





        confirmarConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {isUser();}

        });

    }

    /*public void confirmou(){

       rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("consulta");


        String CPF = confirmarCPF.getText().toString();
        String nome =

        DataBaseConsulta helperclass = new DataBaseConsulta(CPF, nome, local, medico, data);
        reference.child(CPF).setValue(helperclass);

        Intent intent = new Intent(this, Consulta.class);
        startActivity(intent);
        Toast.makeText(ConfirmarConsulta.this, "Consulta Marcada", Toast.LENGTH_SHORT).show();
        finish();
    }*/

    private void isUser(){
        final String usuarioUsuario = confirmarCPF.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("usuario");

        Query checkUsuario = reference.orderByChild("usuario").equalTo(usuarioUsuario);
        checkUsuario.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String CPFDB = snapshot.child(usuarioUsuario).child("usuario").getValue(String.class);
                    String nomeDB = snapshot.child(usuarioUsuario).child("nome").getValue(String.class);
                    String nomeb = nomeDB;
                    rootNode = FirebaseDatabase.getInstance();
                    references = rootNode.getReference("consulta");


                    String CPF = confirmarCPF.getText().toString();
                    String nome = nomeb;
                    String local = marker.getText().toString();
                    String medico = medicos.getSelectedItem().toString();
                    String data = calendar;

                            DataBaseConsulta helperclass = new DataBaseConsulta(CPF, nome, local, medico, data);
                    references.child(CPF).setValue(helperclass);

                    Intent intent = new Intent(getApplicationContext(), Consulta.class);
                    startActivity(intent);
                    Toast.makeText(ConfirmarConsulta.this, "Consulta Marcada", Toast.LENGTH_SHORT).show();
                    finish();


                }else{
                    confirmarCPF.setError("CPF incorreto");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}