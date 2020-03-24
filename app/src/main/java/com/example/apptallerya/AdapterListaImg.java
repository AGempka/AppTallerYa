package com.example.apptallerya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterListaImg extends RecyclerView.Adapter<AdapterListaImg.ViewHolder> {
    Context context;
    ArrayList<Taller> list;


    public AdapterListaImg(Context context, ArrayList<Taller> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public AdapterListaImg.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_imagenes,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListaImg.ViewHolder holder, int position) {
        Taller taller = list.get(position);
        holder.imagen_lista.setImageBitmap(taller.getImg2());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagen_lista;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen_lista=itemView.findViewById(R.id.imagen_lista);
        }
    }
}
