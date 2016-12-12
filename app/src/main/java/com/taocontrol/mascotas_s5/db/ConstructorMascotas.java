package com.taocontrol.mascotas_s5.db;

/**
 * Created by Juan Collivadino on 12/12/2016.
 */

import android.content.ContentValues;
import android.content.Context;

import com.taocontrol.mascotas_s5.POJO.Mascota;
import com.taocontrol.mascotas_s5.R;

import java.util.ArrayList;


public class ConstructorMascotas {

    private static final int RAITING = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        /*ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.jiraffy,"Jiraffy",0));
        mascotas.add(new Mascota(R.drawable.lambby,"Lambby",0));
        mascotas.add(new Mascota(R.drawable.lionny,"Lionny",0));
        mascotas.add(new Mascota(R.drawable.piggy,"Piggy",0));

        return mascotas;*/

        BaseDatos db = new BaseDatos(context);
        insertarCincoMascota(db);
        return db.obtenerTodosLasMascotas();
    }

    public void insertarCincoMascota(BaseDatos db){
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota_01);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Bunny");
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota_02);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Katty");
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota_03);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Doggy");
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota_04);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Foxxy");
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota_05);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Goatty");
        db.insertarMascota(contentValues);
    }

    public void darRaitingMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_RAITING_MASCOTA_RAITING, RAITING);
        db.insertarRaitingMascota(contentValues);
    }
    public int obtenerRaitingMascota (Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerRaitingMascota(mascota);
    }
}
