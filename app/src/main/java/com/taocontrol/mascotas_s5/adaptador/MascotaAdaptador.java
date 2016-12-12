package com.taocontrol.mascotas_s5.adaptador;

/**
 * Created by Juan Collivadino on 12/12/2016.
 */

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.taocontrol.mascotas_s5.POJO.Mascota;
import com.taocontrol.mascotas_s5.R;
import com.taocontrol.mascotas_s5.db.ConstructorMascotas;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    //Inflar el layout y lo pasara al viewholder para que obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewholder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewholder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewholder.tvNombre.setText(mascota.getNombre());
        mascotaViewholder.tvRaiting.setText(String.valueOf(mascota.getRaiting()));

        mascotaViewholder.btnRaiting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Toast.makeText(activity, "Diste Like a "+mascota.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darRaitingMascota(mascota);

                mascotaViewholder.tvRaiting.setText(String.valueOf(constructorMascotas.obtenerRaitingMascota(mascota)));

            }
        });
    }

    @Override
    //Cantidad de elementos qur contiene mi lista de contactps
    public int getItemCount() { //Cantidad de elementos que contiene mi lista de mascotas
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvRaiting;
        private ImageButton btnRaiting;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvRaiting = (TextView) itemView.findViewById(R.id.tvRaiting);
            btnRaiting = (ImageButton) itemView.findViewById(R.id.btnRaiting);
        }
    }
}

