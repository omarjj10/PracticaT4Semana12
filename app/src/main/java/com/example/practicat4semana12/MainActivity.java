package com.example.practicat4semana12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.practicat4semana12.Adaptador.AnimeAdapter;
import com.example.practicat4semana12.Dao.AnimeDao;
import com.example.practicat4semana12.database.AppDatabase;
import com.example.practicat4semana12.entites.Anime;
import com.example.practicat4semana12.factorie.RetroFactori;
import com.example.practicat4semana12.servicio.AnimeService;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    List<Anime>animes=new ArrayList<>();
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit= RetroFactori.build();
        AnimeService service = retrofit.create(AnimeService.class);
        Call<List<Anime>> call=service.GetAnime();
        call.enqueue(new Callback<List<Anime>>() {
            @Override
            public void onResponse(Call<List<Anime>> call, Response<List<Anime>> response) {
                //si hay conectividad
                if(!response.isSuccessful()){
                    Log.e("APP_VJ20202","Error de aplicacion");
                }else{
                    Log.i("APP_VJ20202","Respuesta correcta");
                    Log.i("APP_VJ20202",new Gson().toJson(response.body()));
                    animes=response.body();
                    //saveInDatabase(animes);
                    AnimeAdapter adapter = new AnimeAdapter(animes);
                }
            }
            @Override
            public void onFailure(Call<List<Anime>> call, Throwable t) {
                //no hay conectividad
                Log.e("APP_VJ20202","No hubo conectividad con el servicio web");
            }
        });
        Button btnCrear=findViewById(R.id.btnCrear);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),CrearActivity.class);
                startActivity(intent);
            }
        });
        Button btnMostrar=findViewById(R.id.btnMostrar);
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MostrarAnime.class);
                startActivity(intent);
            }
        });
        Button btnSincronizar=findViewById(R.id.btnSincronizar);
        btnSincronizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),SincronizarActivity.class);
                startActivity(intent);
            }
        });
    }
    private void saveInDatabase(List<Anime>animes){
        AnimeDao dao = db.animeDao();
        for(Anime anime:animes){
            dao.create(anime);
        }
    }
}