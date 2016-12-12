package com.taocontrol.mascotas_s5.POJO;

/**
 * Created by Juan Collivadino on 12/12/2016.
 */

public class Mascota {
    private int id; //Se va a generar automaticamente
    private int foto;
    private String nombre;
    private int raiting;


    public Mascota(int foto, String nombre, int raiting) {
        this.nombre = nombre;
        this.foto = foto;
        this.raiting = raiting;
    }
    public Mascota() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }
}
