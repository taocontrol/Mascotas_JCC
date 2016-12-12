package com.taocontrol.mascotas_s5.fragments;

/**
 * Created by Juan Collivadino on 12/12/2016.
 */


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taocontrol.mascotas_s5.POJO.Mascota;
import com.taocontrol.mascotas_s5.R;
import com.taocontrol.mascotas_s5.adaptador.MascotaAdaptador_perfil;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas_perfil);

        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        //listaMascotas.setLayoutManager(llm);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(glm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return v;

    }

    public MascotaAdaptador_perfil adaptador;
    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador_perfil(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);

    }

    public void inicializarListaMascotas (){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.mascota_01,"Bunny",2));
        mascotas.add(new Mascota(R.drawable.mascota_02, "Katty",3));
        mascotas.add(new Mascota(R.drawable.mascota_03, "Doggy",5));
        mascotas.add(new Mascota(R.drawable.mascota_04, "Foxxy",1));
        mascotas.add(new Mascota(R.drawable.mascota_05, "Goatty",0));
        mascotas.add(new Mascota(R.drawable.mascota_06,"Jiraffy",5));
        mascotas.add(new Mascota(R.drawable.mascota_07,"Lambby",7));
        mascotas.add(new Mascota(R.drawable.mascota_08,"Lionny",1));
        mascotas.add(new Mascota(R.drawable.mascota_09, "Katty",3));
        mascotas.add(new Mascota(R.drawable.mascota_10, "Doggy",5));
        mascotas.add(new Mascota(R.drawable.mascota_11,"Bunny",2));
        mascotas.add(new Mascota(R.drawable.bone,"Mascotin",2));
        mascotas.add(new Mascota(R.drawable.bone,"Mascotin",5));
        mascotas.add(new Mascota(R.drawable.bone, "Mascotin",1));
        mascotas.add(new Mascota(R.drawable.bone,"Mascotin",1));
        mascotas.add(new Mascota(R.drawable.bone, "Mascotin",0));
        mascotas.add(new Mascota(R.drawable.bone,"Mascotin",7));
        mascotas.add(new Mascota(R.drawable.bone,"Mascotin",2));
    }
}