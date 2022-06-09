package com.example.practicat4semana12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.example.practicat4semana12.Dao.AnimeDao;
import com.example.practicat4semana12.database.AppDatabase;
import com.example.practicat4semana12.entites.Anime;
import com.example.practicat4semana12.servicio.AnimeService;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class SincronizarActivity extends AppCompatActivity {
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sincronizar);
        db=AppDatabase.getDatabase(getApplicationContext());
        AnimeDao dao = db.animeDao();
        List<Anime>animes = dao.getAll();
        Log.i("APP_VJ20202",new Gson().toJson(animes));
        //EditText edInformacion=findViewById(R.id.editInformacion);
        //edInformacion.setText(new Gson().toJson(animes));
    }
}