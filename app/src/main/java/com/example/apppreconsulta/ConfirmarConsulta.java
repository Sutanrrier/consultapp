package com.example.apppreconsulta;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
    String CPFs;
    String i;
    Dialog popup;


    FirebaseDatabase rootNode;
    DatabaseReference references;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_consulta);

        confirmarConsulta = findViewById(R.id.btnConfirmarConsulta);
        marker = findViewById(R.id.marker);
        medicos = findViewById(R.id.spnmedicos);
        calendario = findViewById(R.id.Calendario);
        popup = new Dialog(this);

        Intent intent = getIntent();
        String user_tipo = intent.getStringExtra("tipo");
        String user_User = intent.getStringExtra("usuario");
        i = user_tipo;
        CPFs = user_User;

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.medicos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        medicos.setAdapter(adapter);

        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        calendar = sdf.format(new Date(calendario.getDate()));

        String local = getIntent().getStringExtra("local");
        marker.setText(local);





       confirmarConsulta.setOnClickListener(view -> isUser());

    }

    /*public void MostrarPopup(){
        TextView popupLocal;
        TextView popupMedico;
        TextView popupData;
        Button btnsim;
        Button btnnao;
        popup.setContentView(R.layout.popup);
        popupLocal = findViewById(R.id.popuplocal);
        popupMedico = findViewById(R.id.popupmedico);
        popupData = findViewById(R.id.popupdata);
        btnsim = findViewById(R.id.btnpopupsim);
        btnnao = findViewById(R.id.btnpopupnao);

        btnsim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
            popup.show();
            }

    public void confirmou(){

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
        final String usuarioUsuario = CPFs;

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("usuario");

        Query checkUsuario = reference.orderByChild("usuario").equalTo(usuarioUsuario);
        checkUsuario.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    snapshot.child(usuarioUsuario).child("usuario").getValue(String.class);
                    String nomeb = snapshot.child(usuarioUsuario).child("nome").getValue(String.class);
                    rootNode = FirebaseDatabase.getInstance();
                    switch (i) {
                        case "urgencia": references = rootNode.getReference("consulta_urgencia");
                        break;
                        case "maternidade": references = rootNode.getReference("consulta_maternidade");
                        break;
                        case "clinica": references = rootNode.getReference("consulta_clinica");
                        break;
                        case "dentista": references = rootNode.getReference("consulta_odontologia");
                        break;
                        case "CAPS": references = rootNode.getReference("consulta_CAPS");
                        break;
                    }

                    String CPF = CPFs;
                    String local = marker.getText().toString();
                    String medico = medicos.getSelectedItem().toString();
                    String data = calendar;

                            DataBaseConsulta helperclass = new DataBaseConsulta(CPF, nomeb, local, medico, data);
                    references.child(CPF).setValue(helperclass);

                    Intent intent = new Intent(getApplicationContext(), Consulta.class);
                    intent.putExtra("usuario", CPF);
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