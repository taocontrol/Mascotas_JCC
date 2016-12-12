package com.taocontrol.mascotas_s5.fragments;

/**
 * Created by Juan Collivadino on 12/12/2016.
 */

import com.taocontrol.mascotas_s5.POJO.Mascota;
import com.taocontrol.mascotas_s5.adaptador.MascotaAdaptador;

import java.util.ArrayList;


public interface IRecyclerViewFragmentView {

    public void generarLinerarLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdapatadorRV(MascotaAdaptador adaptador);


}
