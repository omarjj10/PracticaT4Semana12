package com.example.practicat4semana12.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.practicat4semana12.Dao.AnimeDao;
import com.example.practicat4semana12.entites.Anime;

@Database(entities = {Anime.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AnimeDao animeDao();
    public static AppDatabase getDatabase(Context context){
        return Room.databaseBuilder(context,AppDatabase.class, "com.example.practicat4semana12.database.animes_db")
                .allowMainThreadQueries()
                .build();
    }
}
