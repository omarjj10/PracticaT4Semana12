package com.example.practicat4semana12.entites;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "animes")
public class Anime {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "nombre")
    public String nombre;
    @ColumnInfo(name="descripcion")
    public String descripcion;
    public String avatar;
    public Anime(){

    }

    public Anime(int id) {
        this.id = id;
    }

    public Anime(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Anime(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Anime(int id, String nombre, String descripcion, String avatar) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.avatar = avatar;
    }
}
