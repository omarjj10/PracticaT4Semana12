package com.example.practicat4semana12.Adaptador;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.practicat4semana12.AnimeActivity;
import com.example.practicat4semana12.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicat4semana12.entites.Anime;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>{
    public static int codigo;
    List<Anime> animes;
    public AnimeAdapter(List<Anime> animes){
        this.animes=animes;
    }
    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anime,parent,false);
        return new AnimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder vh, int position) {
        View itemView = vh.itemView;
        Anime anime=animes.get(position);
        TextView tvId=itemView.findViewById(R.id.tvId);
        TextView tvNombre = itemView.findViewById(R.id.tvNombre);
        TextView tvDes = itemView.findViewById(R.id.tvDescripcion);
        ImageView ivAvatar = itemView.findViewById(R.id.ivAvatar);
        tvNombre.setText(anime.nombre);
        tvDes.setText(anime.descripcion);
        String id = String.valueOf(anime.id);
        tvId.setText(id);
        Picasso.get().load("https://i.ibb.co/1qh9DWm/fairy-tail.png").into(ivAvatar);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), AnimeActivity.class);
                String animeJSON=new Gson().toJson(anime);
                intent.putExtra("Anime",animeJSON);
                codigo=anime.id;
                itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    class AnimeViewHolder extends RecyclerView.ViewHolder{

        public AnimeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
