package com.taocontrol.mascotas_s5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.taocontrol.mascotas_s5.POJO.Mascota;
import com.taocontrol.mascotas_s5.adaptador.MascotaAdaptador;

import java.util.ArrayList;

public class Detalle_Raiting extends AppCompatActivity {

    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle__raiting);

        Toolbar miActionBar2 = (Toolbar) findViewById(R.id.miActionBar2);
        setSupportActionBar(miActionBar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm2 = new LinearLayoutManager(this);
        llm2.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm2);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public MascotaAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas (){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.mascota_01, "Katty",3));
        mascotas.add(new Mascota(R.drawable.mascota_02, "Doggy",2));
        mascotas.add(new Mascota(R.drawable.mascota_03, "Foxxy",1));
        mascotas.add(new Mascota(R.drawable.mascota_04, "Goatty",5));
        mascotas.add(new Mascota(R.drawable.mascota_05,"Jiraffy",4));
    }
}
