package com.example.apppreconsulta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;

public class MarcarConsulta extends AppCompatActivity implements View.OnClickListener{

    CheckBox CbFebre;
    CheckBox CbDorCabeca;
    CheckBox CbDiarreia;
    CheckBox CbAr;
    CheckBox CbTontura;
    EditText EdtFebre;
    Button btnEnviarMarcarConsulta;
    Button btnVoltarMarcarConsulta;
    TextView txtFebre;
    String febre2, dorcabeca2, diarreira2, ar2, tontura2, edtfebre2;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcar_consulta);

        CbFebre = findViewById(R.id.CbFebre);
        CbDorCabeca = findViewById(R.id.CbDorcabeca);
        CbDiarreia = findViewById(R.id.CbDiarreia);
        CbAr = findViewById(R.id.CbAr);
        CbTontura = findViewById(R.id.CbTontura);
        EdtFebre = findViewById(R.id.EdtFebre);
        btnEnviarMarcarConsulta = findViewById(R.id.btnEnviarMarcarConsulta);
        btnVoltarMarcarConsulta = findViewById(R.id.btnVoltarConsulta);
        txtFebre = findViewById(R.id.txtFebre);

        txtFebre.setVisibility(View.INVISIBLE);
        EdtFebre.setVisibility(View.INVISIBLE);

        CbFebre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CbFebre.isChecked()){
                    txtFebre.setVisibility(View.VISIBLE);
                    EdtFebre.setVisibility(View.VISIBLE);
                }
                else{
                    txtFebre.setVisibility(View.INVISIBLE);
                    EdtFebre.setVisibility(View.INVISIBLE);
                }


            }

        });

        btnEnviarMarcarConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("consulta");

                if (CbFebre.isChecked()){
                    febre2 = "Febre";
                }else{
                    febre2 = "";
                }
                if (CbDorCabeca.isChecked()){
                    dorcabeca2 = "Dor de cabeça";
                }else{
                    dorcabeca2 = "";
                }
                if (CbDiarreia.isChecked()){
                    diarreira2= "Diarreia";
                }else{
                    diarreira2 = "";
                }
                if (CbAr.isChecked()){
                    ar2 = "Falta de ar";
                }else{
                    ar2 = "";
                }
                if (CbTontura.isChecked()){
                    tontura2 = "Tontura";
                }else{
                    tontura2 = "";
                }


                String febre1 = febre2;
                String dorcabeca1 = dorcabeca2;
                String diarreia1 = diarreira2;
                String ar1 = ar2;
                String tontura1 = tontura2;
                String edtfebre1 = EdtFebre.getText().toString();


                Toast.makeText(MarcarConsulta.this, "Consulta Marcada", Toast.LENGTH_SHORT).show();
                DataBaseConsulta helperclass = new DataBaseConsulta (febre1, dorcabeca1, diarreia1, ar1, tontura1, edtfebre1);
                reference.child(edtfebre1).setValue(helperclass);

            }
        });



    }

    @Override
    public void onClick(View view) {

    }
}