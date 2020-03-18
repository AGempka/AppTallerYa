package com.example.apptallerya;

import android.content.Context;
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

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.TallerViewHolder>
{

    Context context;

   List<Taller> tallerList;
   List<Taller> tallerListFull;
   private OnItemClickListener miListener;

    public Adapter( List<Taller> tallerList) {
        this.context = context;
        this.tallerList = tallerList;
        tallerListFull = new ArrayList<>(tallerList);
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
    public void onBindViewHolder(@NonNull final TallerViewHolder holder, int position) {
        Taller taller = tallerList.get(position);

        holder.txtNombreTaller.setText(taller.getNombre_taller());
        holder.txtDireccionTaller.setText(taller.getDireccion_taller());
        holder.textViewRating.setText(String.valueOf(taller.getEvaluacion_taller()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(miListener!=null){
                    int position = holder.getAdapterPosition();
                    if(position!=RecyclerView.NO_POSITION){
                        miListener.onItemClick(position); //método onclick del interface
                    }
                }
            }
        });

        if (tallerList.get(position).getImg1()!=null){
            holder.img1.setImageBitmap(tallerList.get(position).getImg1());
        }else{
            holder.img1.setImageResource(R.drawable.img_base);
        }


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

public interface OnItemClickListener{
void onItemClick(int position);
}

    public void setOnItemClickListener(OnItemClickListener listener){
        miListener = listener;
    }

//public void filtrar(ArrayList<Taller> filtrar){
  //      this.tallerList = filtrar;
    //    notifyDataSetChanged();

//}
}
