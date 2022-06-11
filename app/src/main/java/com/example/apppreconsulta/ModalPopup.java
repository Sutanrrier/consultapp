package com.example.apppreconsulta;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ModalPopup extends AppCompatDialogFragment {

    private TextView popuplocal, popupmedico, popupdata;
    String i;
    String a;
    private ExempleDialogListener listener;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        Intent intent = getActivity().getIntent();
        String CPFs = intent.getStringExtra("usuario");
        String tipo = intent.getStringExtra("tipo");
        i = tipo;

        switch (i) {
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

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String local = snapshot.child(CPFs).child("local").getValue(String.class);
                    String medico = snapshot.child(CPFs).child("medico").getValue(String.class);
                    String data = snapshot.child(CPFs).child("data").getValue(String.class);

                    popuplocal.setText(local);
                    popupmedico.setText(medico);
                    popupdata.setText(data);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.popup,null);
        builder.setView(view)
                .setTitle("Você já tem uma consulta marcada")
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       Integer liberacao = 1;
                       listener.applyTexts(liberacao);
                    }


        });
        popuplocal = view.findViewById(R.id.popuplocal);
        popupmedico = view.findViewById(R.id.popupmedico);
        popupdata = view.findViewById(R.id.popupdata);




        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    try {
        listener = (ExempleDialogListener) context;
    }catch (ClassCastException e){
        throw new ClassCastException(context.toString()+"Deve implementar");
    }

    }

    public interface ExempleDialogListener{
        void applyTexts(Integer liberacao);
    }
}