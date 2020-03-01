package com.example.apptallerya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.TallerViewHolder>
{


    private List<Taller> tallerList;

    public Adapter( List<Taller> tallerList) {

        this.tallerList = tallerList;
    }


    @Override
    public TallerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
        RecyclerView.LayoutParams layoutParams=new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams);
        return new TallerViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull TallerViewHolder holder, int position) {
        Taller taller = tallerList.get(position);

        holder.txtNombreTaller.setText(taller.getNombre_taller());
        holder.txtDireccionTaller.setText(taller.getDireccion_taller());
        holder.textViewRating.setText(String.valueOf(taller.getEvaluacion_taller()));
    }


    @Override
    public int getItemCount() {
        return tallerList.size();
    }

     class TallerViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombreTaller, txtDireccionTaller, textViewRating;
        ImageView img1;

        public TallerViewHolder (View itemView){
            super(itemView);
        txtNombreTaller=itemView.findViewById(R.id.txtNombreTaller);
        txtDireccionTaller=itemView.findViewById(R.id.txtDireccionTaller);
        textViewRating=itemView.findViewById(R.id.textViewRating);
        img1=itemView.findViewById(R.id.img1);
        }
    }
}
