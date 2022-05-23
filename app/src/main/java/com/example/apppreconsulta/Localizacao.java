package com.example.apppreconsulta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizacao);

        SupportMapFragment mapFragment = (SupportMapFragment)  getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;

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

        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String markertitle = marker.getTitle();

                Intent intent = new Intent(Localizacao.this, ConfirmarConsulta.class);
                intent.putExtra("local", markertitle);
                startActivity(intent);

                return false;
            }
        });


    }


}