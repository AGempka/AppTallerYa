package com.example.apptallerya;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.TallerViewHolder> {
    Context context;

    ArrayList<Taller> taller;
    private OnItemClickListener miListener;

    public interface OnItemClickListener {
        void onItemClick(int position);  // este es el método del onclick de la interfase
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        miListener = listener;
    }

    public Adapter(Context c, ArrayList<Taller> t) {
        context = c;
        taller = t;
    }


    @Override
    public TallerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams);
        return new TallerViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull final TallerViewHolder holder, int position) {

        holder.txtNombreTaller.setText(taller.get(position).getNombre_taller());
        holder.txtDireccionTaller.setText(taller.get(position).getDireccion_taller());
        holder.textViewRating.setText(String.valueOf(taller.get(position).getEvaluacion_taller()));
        Picasso.get().load(taller.get(position).getImg_logo()).into(holder.img_logo);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (miListener != null){
                    int position = holder.getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        miListener.onItemClick(position);  // el método onclick de la interface
                    }
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return taller.size();
    }

    class TallerViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombreTaller, txtDireccionTaller, textViewRating;
        ImageView img_logo;

        public TallerViewHolder(View itemView) {
            super(itemView);
            txtNombreTaller = itemView.findViewById(R.id.txtNombreTaller);
            txtDireccionTaller = itemView.findViewById(R.id.txtDireccionTaller);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            img_logo = itemView.findViewById(R.id.img_logo);

        }

    }


    }


