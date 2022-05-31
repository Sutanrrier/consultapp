package com.example.apppreconsulta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Switch;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Localizacao extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;
    String CPF;
    String i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizacao);

        Intent intent = getIntent();
        String user_numero = intent.getStringExtra("string");
        String user_User = intent.getStringExtra("usuario");
        CPF = user_User;
        i = user_numero;

        SupportMapFragment mapFragment = (SupportMapFragment)  getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;


        switch(i){
            case "urgencia":
                LatLng Fortaleza = new LatLng(-3.788059, -38.530496);
                LatLng Albert = new LatLng(-3.767040, -38.532458);
                LatLng a = new LatLng(-3.795867, -38.554386);
                LatLng b = new LatLng(-3.779120, -38.572062);
                LatLng c = new LatLng(-3.728043, -38.516246);
                LatLng d = new LatLng(-3.761962, -38.572859);

                map.addMarker(new MarkerOptions().position(Albert).title("Hospital Infantil Albert Sabin" +
                        "\nRua Jorge Acurcio, 807 - Vila União, Fortaleza - CE, 60410-800"));
                map.addMarker(new MarkerOptions().position(a).title("UPA Itaperi" +
                        "\nR. Betel, sn - Dendê, Fortaleza - CE, 60714-315"));
                map.addMarker(new MarkerOptions().position(b).title("Frotinha Parangaba" +
                        "\nAv. Gen. Osório de Paiva, 1127 - Parangaba, Fortaleza - CE, 60720-015"));
                map.addMarker(new MarkerOptions().position(c).title("Pronto Socorro São Camilo" +
                        "\nR. Nogueira Acioli, 453 - Centro, Fortaleza - CE, 60160-280"));
                map.addMarker(new MarkerOptions().position(d).title("Hospital Infantil de Fortaleza" +
                        "Av. Lineu Machado, 155 - Jóquei Clube, Fortaleza - CE, 60020-181"));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Fortaleza, 12));
                break;

            case "maternidade":
                LatLng Fortaleza2 = new LatLng(-3.788059, -38.530496);
                LatLng a2 = new LatLng(-3.734890, -38.520186);
                LatLng b2 = new LatLng(-3.734213, -38.537729);
                LatLng c2 = new LatLng(-3.763481, -38.574368);
                LatLng d2 = new LatLng(-3.728043, -38.516246);
                LatLng e2 = new LatLng(-3.752945, -38.522511);

                map.addMarker(new MarkerOptions().position(a2).title("Hospital e Maternidade Eugênia Pinheiro" +
                        "\nAv. Heráclito Graça, 493-405 - Centro, Fortaleza - CE, 60140-060"));
                map.addMarker(new MarkerOptions().position(b2).title("Hospital e Maternidade José Martiniano de Alencar" +
                        "\nRua Princesa Isabel, 1526 - Centro, Fortaleza - CE, 60015-061"));
                map.addMarker(new MarkerOptions().position(c2).title("Dra. Zilda Arns Neumann (Hospital da Mulher de Fortaleza)" +
                        "\nR. George Rocha, 50 - Demócrito Rocha, Fortaleza - CE, 60520-100"));
                map.addMarker(new MarkerOptions().position(d2).title("Argentina Castelo Branco" +
                        "\nR. Maceió, 1350 - Henrique Jorge, Fortaleza - CE, 60525-540"));
                map.addMarker(new MarkerOptions().position(e2).title("Maternidade Antônio Prudente" +
                        "R. João Lôbo Filho, 140 - Fátima, Fortaleza - CE, 60040-140"));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Fortaleza2, 12));
                break;

        }

        /*LatLng Fortaleza = new LatLng(-3.788059, -38.530496);
        LatLng Albert = new LatLng(-3.767040, -38.532458);
        LatLng a = new LatLng(-3.795867, -38.554386);
        LatLng b = new LatLng(-3.779120, -38.572062);
        LatLng c = new LatLng(-3.728043, -38.516246);
        LatLng d = new LatLng(-3.761962, -38.572859);

        map.addMarker(new MarkerOptions().position(Albert).title("Hospital Infantil Albert Sabin" +
                "\nRua Jorge Acurcio, 807 - Vila União, Fortaleza - CE, 60410-800"));
        map.addMarker(new MarkerOptions().position(a).title("UPA Itaperi" +
                "\nR. Betel, sn - Dendê, Fortaleza - CE, 60714-315"));
        map.addMarker(new MarkerOptions().position(b).title("Frotinha Parangaba" +
                "\nAv. Gen. Osório de Paiva, 1127 - Parangaba, Fortaleza - CE, 60720-015"));
        map.addMarker(new MarkerOptions().position(c).title("Pronto Socorro São Camilo" +
                "\nR. Nogueira Acioli, 453 - Centro, Fortaleza - CE, 60160-280"));
        map.addMarker(new MarkerOptions().position(d).title("Hospital Infantil de Fortaleza" +
                "Av. Lineu Machado, 155 - Jóquei Clube, Fortaleza - CE, 60020-181"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(Fortaleza, 12));*/

        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String markertitle = marker.getTitle();

                Intent intent = new Intent(Localizacao.this, ConfirmarConsulta.class);
                intent.putExtra("local", markertitle);
                intent.putExtra("usuario", CPF);
                intent.putExtra("tipo", i);
                startActivity(intent);
                finish();

                return false;
            }
        });


    }


}