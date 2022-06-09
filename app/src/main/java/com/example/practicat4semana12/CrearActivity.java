package com.example.practicat4semana12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.practicat4semana12.entites.Anime;
import com.example.practicat4semana12.factorie.RetroFactori;
import com.example.practicat4semana12.servicio.AnimeService;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CrearActivity extends AppCompatActivity {
    Anime animes = new Anime();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        Button btnCrear = findViewById(R.id.btnCrearAnime);
        EditText edNombre = findViewById(R.id.editNombre);
        EditText edDescripcion = findViewById(R.id.editDescripcion);
        EditText edImagen=findViewById(R.id.editImagen);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit= RetroFactori.build();
                AnimeService service = retrofit.create(AnimeService.class);
                animes.nombre=String.valueOf(edNombre.getText());
                animes.descripcion=String.valueOf(edDescripcion.getText());
                animes.avatar=String.valueOf(edImagen.getText());
                Call<Anime> call=service.create(animes);
                call.enqueue(new Callback<Anime>() {
                    @Override
                    public void onResponse(Call<Anime> call, Response<Anime> response) {
                        if(response.isSuccessful()){
                            Log.i("APP_VJ20202", new Gson().toJson(response.body()));
                        }
                    }

                    @Override
                    public void onFailure(Call<Anime> call, Throwable t) {
                        Log.e("APP_VJ20202","No nos podemos conectar al servicio web");
                    }
                });
            }
        });
    }
}