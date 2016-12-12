package com.taocontrol.mascotas_s5.db;

/**
 * Created by Juan Collivadino on 12/12/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.taocontrol.mascotas_s5.POJO.Mascota;

import java.util.ArrayList;



public class BaseDatos extends SQLiteOpenHelper{

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascotas = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + " ("+
                ConstantesBaseDatos.TABLE_MASCOTAS_ID +     " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO +   " INTEGER," +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT" + " )";

        String queryCrearTablaRaitingMascotas = "CREATE TABLE " + ConstantesBaseDatos.TABLE_RAITING_MASCOTA + " ("+
                ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID +          " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID_MASCOTA +  " INTEGER, " +
                ConstantesBaseDatos.TABLE_RAITING_MASCOTA_RAITING +     " INTEGER, " +
                "FOREIGN KEY ("+ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID_MASCOTA+") "+
                "REFERENCES "+ConstantesBaseDatos.TABLE_MASCOTAS +" ("+ConstantesBaseDatos.TABLE_MASCOTAS_ID+")" + ")";

        db.execSQL(queryCrearTablaMascotas);
        db.execSQL(queryCrearTablaRaitingMascotas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST "+ConstantesBaseDatos.TABLE_RAITING_MASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodosLasMascotas (){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS + " LIMIT 5";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setFoto(registros.getInt(1));
            mascotaActual.setNombre(registros.getString(2));

            //Recuperar raiting de cada mascota
            String queryLikes = "SELECT COUNT ("+ConstantesBaseDatos.TABLE_RAITING_MASCOTA_RAITING+") as raiting "+
                    " FROM " + ConstantesBaseDatos.TABLE_RAITING_MASCOTA+
                    " WHERE "+ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosRaiting = db.rawQuery(queryLikes, null);
            if (registrosRaiting.moveToNext()){
                mascotaActual.setRaiting(registrosRaiting.getInt(0));
            } else{
                mascotaActual.setRaiting(0);
            }

            mascotas.add(mascotaActual);

        }
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }

    public void insertarRaitingMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_RAITING_MASCOTA, null, contentValues);
        db.close();
    }

    public int obtenerRaitingMascota(Mascota mascota){
        int raiting = 0;
        String query = "SELECT COUNT ("+ConstantesBaseDatos.TABLE_RAITING_MASCOTA_RAITING+")"+
                " FROM "+ConstantesBaseDatos.TABLE_RAITING_MASCOTA +
                " WHERE "+ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID_MASCOTA +"="+mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        if (registros.moveToNext()){
            raiting = registros.getInt(0);
        }
        db.close();
        return raiting;
    }
}
