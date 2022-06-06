package com.example.apppreconsulta;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

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
        CPF = intent.getStringExtra("usuario");
        i = user_numero;

        SupportMapFragment mapFragment = (SupportMapFragment)  getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
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
                        "\nAv. Lineu Machado, 155 - Jóquei Clube, Fortaleza - CE, 60020-181"));
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
                        "\nR. João Lôbo Filho, 140 - Fátima, Fortaleza - CE, 60040-140"));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Fortaleza2, 12));
                break;

                case "clinica":
                LatLng Fortaleza3 = new LatLng(-3.788059, -38.530496);
                LatLng a3 = new LatLng( -3.766306, -38.574305);
                LatLng b3 = new LatLng( -3.776552, -38.563945 );
                LatLng c3 = new LatLng( -3.726582, -38.529248 );
                LatLng d3 = new LatLng( -3.722453, -38.528019 );
                LatLng e3 = new LatLng( -3.731197, -38.526562 );

                map.addMarker(new MarkerOptions().position(a3).title("Clínica SiM Unidade Jóquei" +
                        "\nAv. Senador Fernandes Távora, 84 - Loja 27 - Jóquei Clube, Fortaleza - CE, 60510-114"));
                map.addMarker(new MarkerOptions().position(b3).title("AME Clínica" +
                        "\nR. Eduardo Perdigão, 230 - Parangaba, Fortaleza - CE, 60720-110"));
                map.addMarker(new MarkerOptions().position(c3).title("Clínica Nova" +
                        "\nR. Guilherme Rocha, 326 - Centro, Fortaleza - CE, 60030-140"));
                map.addMarker(new MarkerOptions().position(d3).title("Clínica Santa Clara Centro" +
                        "\nRua Dr. João Moreira, 379 - Centro, Fortaleza - CE, 60030-000"));
                map.addMarker(new MarkerOptions().position(e3).title("Clínica Popular Centro Médico da Família" +
                        "\nRua Solon Pinheiro, 76 - Centro, Fortaleza - CE, 60050-040"));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Fortaleza3, 12));
                break;
            case "dentista":
                LatLng Fortaleza4 = new LatLng(-3.788059, -38.530496);
                LatLng a4 = new LatLng( -3.761411, -38.571784);
                LatLng b4 = new LatLng( -3.776552, -38.563945 );
                LatLng c4 = new LatLng( -3.726582, -38.529248 );
                LatLng d4 = new LatLng( -3.722453, -38.528019 );
                LatLng e4 = new LatLng( -3.750904, -38.558619 );

                map.addMarker(new MarkerOptions().position(a4).title("Consultório Dr Coelho" +
                        "\nAv. Carneiro de Mendonça, 1480 - Demócrito Rocha, Fortaleza - CE, 60440-160"));
                map.addMarker(new MarkerOptions().position(b4).title("Clínica Odontológica Dr.Marcos" +
                        "\nAv. Dr. Silas Munguba, 3388 - Serrinha, Fortaleza - CE, 60714-242"));
                map.addMarker(new MarkerOptions().position(c4).title("Clínica Nova" +
                        "\nR. Guilherme Rocha, 326 - Centro, Fortaleza - CE, 60030-140"));
                map.addMarker(new MarkerOptions().position(d4).title("Clínica Santa Clara Centro" +
                        "\nRua Dr. João Moreira, 379 - Centro, Fortaleza - CE, 60030-000"));
                map.addMarker(new MarkerOptions().position(e4).title("Cruz E Cardoso Odontologia" +
                        "\nRR. José Façanha, 855 - Rodolfo Teófilo, Fortaleza - CE, 60430-232"));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Fortaleza4, 12));
                break;
            case "CAPS":
                LatLng Fortaleza5 = new LatLng(-3.788059, -38.530496);
                LatLng a5 = new LatLng( -3.746124, -38.554626);
                LatLng b5 = new LatLng( -3.746600, -38.609080 );
                LatLng c5 = new LatLng( -3.794085, -38.602257);
                LatLng d5 = new LatLng( -3.835614, -38.491817 );
                LatLng e5 = new LatLng( -3.734108, -38.511689 );

                map.addMarker(new MarkerOptions().position(a5).title(" CAPS Ad III " +
                        "\nRua Frei Marcelino, 1191 - Rodolfo Teófilo, Fortaleza - CE, 60431-010"));
                map.addMarker(new MarkerOptions().position(b5).title("Caps II Jurema" +
                        "\nR. Estados Unidos, 1151 - Parque das Nacoes (Jurema), Caucaia - CE, 61642-140"));
                map.addMarker(new MarkerOptions().position(c5).title("CAPS V" +
                        "\nR. Bom Jesus, 940 - Bom Jardim, Fortaleza - CE, 60540-250"));
                map.addMarker(new MarkerOptions().position(d5).title("CAPS" +
                        "\nRua Carlota Rodrigues, 89 - Messejana, Fortaleza - CE, 60871-610"));
                map.addMarker(new MarkerOptions().position(e5).title("CAPS Geral II" +
                        "\nR. Pinto Madeira, 1550 - Aldeota, Fortaleza - CE, 60150-000"));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(Fortaleza5, 12));
                break;


        }

        map.setOnMarkerClickListener(marker -> {
            String markertitle = marker.getTitle();

            Intent intent = new Intent(Localizacao.this, ConfirmarConsulta.class);
            intent.putExtra("local", markertitle);
            intent.putExtra("usuario", CPF);
            intent.putExtra("tipo", i);
            startActivity(intent);
            finish();

            return false;
        });


    }


}