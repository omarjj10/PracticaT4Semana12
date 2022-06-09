package com.example.practicat4semana12.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.practicat4semana12.entites.Anime;

import java.util.List;

@Dao
public interface AnimeDao {
    @Query("SELECT * FROM animes")
    List<Anime> getAll();
    @Query("SELECT * FROM animes WHERE id=:id")
    Anime find (int id);
    @Insert
    void create(Anime anime );
}
