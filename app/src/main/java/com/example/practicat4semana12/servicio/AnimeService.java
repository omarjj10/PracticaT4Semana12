package com.example.practicat4semana12.servicio;

import com.example.practicat4semana12.entites.Anime;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AnimeService {
    @GET("Anime")
    Call<List<Anime>> GetAnime();
    @GET("Anime/{id}")
    Call<Anime> findAnime(@Path("id") int a);
    @POST("Anime")
    Call<Anime>create(@Body Anime anime);
    @PUT("Anime/{id}")
    Call<Anime>update(@Path("id") int a,@Body Anime anime);
    @DELETE("Anime/{id}")
    Call<Anime>delete(@Path("id") int a);
}
