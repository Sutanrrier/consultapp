package com.example.apppreconsulta;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

public class ConfirmarConsulta extends AppCompatActivity implements ModalPopup.ExempleDialogListener {

    TextView marker;
    Button confirmarConsulta;
    Spinner medicos;
    EditText confirmarCPF;
    CalendarView calendario;
    String calendar;
    String CPFs;
    String i;
    String a;
    Integer b = 0;
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
        //calendar = sdf.format(new Date(calendario.getDate()));
        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String data = i2 + "/" + (i1+1) + "/" +i;
                calendar = data;
            }
        });
        Date minDate = new Date();
        calendario.setMinDate(minDate.getTime());

        String local = getIntent().getStringExtra("local");
        marker.setText(local);


        confirmarConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Estamarcado();
            }
        });

    }

    public void Estamarcado(){
        final String usuarioUsuario = CPFs;
        switch(i){
            case "urgencia": a = "consulta_urgencia";
            break;
            case "maternidade": a = "consulta_maternidade";
            break;
            case "clinica": a = "consulta_clinica";
            break;
            case "dentista": a = "consulta_odontologia";
            break;
            case "CAPS": a = "consulta_CAPS";
            break;
        }

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(a);

        Query checkConsulta = reference.orderByChild("cpf").equalTo(usuarioUsuario);
        checkConsulta.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(b == 1){
                    isUser();
                }else if(snapshot.exists()){
                    String medicoDB = snapshot.child(usuarioUsuario).child("medico").getValue(String.class);
                    String localDB = snapshot.child(usuarioUsuario).child("local").getValue(String.class);
                    String dataDB = snapshot.child(usuarioUsuario).child("nome").getValue(String.class);

                    Intent intent = new Intent(getApplicationContext(),ModalPopup.class);
                    intent.putExtra("local", localDB);
                    intent.putExtra("medico", medicoDB);
                    intent.putExtra("data", dataDB);
                    MostrarModal();
                }else{
                    isUser();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



    public void MostrarModal(){
        ModalPopup modalPopup = new ModalPopup();
        modalPopup.show(getSupportFragmentManager(),"Fragment");
    }

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

    @Override
    public void applyTexts(Integer liberacao) {
        b = liberacao;
    }
}