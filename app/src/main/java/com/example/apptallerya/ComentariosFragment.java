package com.example.apptallerya;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;


public class ComentariosFragment extends Fragment {


    private ImageButton btnComentar;
    private EditText aggComentarios;
    private RecyclerView recyclerComentarios;
    private String keyTaller, current_user_id, mkey;

    private DatabaseReference UsersRef, TallerRef;
    private FirebaseAuth mAuth;



    public ComentariosFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_comentarios, container, false);
        recyclerComentarios = (RecyclerView) vista.findViewById(R.id.recyclerComentarios);
        recyclerComentarios.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerComentarios.setLayoutManager(linearLayoutManager);


        mAuth = FirebaseAuth.getInstance();
        current_user_id = mAuth.getCurrentUser().getUid();
        btnComentar = (ImageButton) vista.findViewById(R.id.btnComentar);
        aggComentarios = (EditText) vista.findViewById(R.id.commentInput);

        String otraclave = getArguments().getString("keyTaller");

        UsersRef = FirebaseDatabase.getInstance().getReference("Clientes");
        TallerRef = FirebaseDatabase.getInstance().getReference("Talleres").child(otraclave).child("Comentarios");
        btnComentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsersRef.child(current_user_id).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            String nombre_cliente = dataSnapshot.child("nombre_cliente").getValue().toString();
                            ValidateComment(nombre_cliente);
                            aggComentarios.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


        return vista;
    }

    private void ValidateComment(String nombre_cliente) {
        String commentText = aggComentarios.getText().toString();
        if (TextUtils.isEmpty(commentText)) {
            Toast.makeText(getContext(), "Por favor, escriba un comentario para enviar", Toast.LENGTH_SHORT).show();

        } else {
            Calendar calForDate = Calendar.getInstance();
            SimpleDateFormat currentDate = new SimpleDateFormat("dd-MMMM-yyyy");
            final String saveCurrentDate = currentDate.format(calForDate.getTime());

            Calendar calForTime = Calendar.getInstance();
            SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm");
            final String saveCurrentTime = currentTime.format(calForTime.getTime());

            final  String RandomKey = current_user_id + saveCurrentDate + saveCurrentTime;

            HashMap commentsMap = new HashMap();
            commentsMap.put("uid", current_user_id);
            commentsMap.put("comentario", commentText);
            commentsMap.put("nombre_cliente", nombre_cliente);
            commentsMap.put("date", saveCurrentDate);
            commentsMap.put("time", saveCurrentTime);

            TallerRef.child(RandomKey).updateChildren(commentsMap).addOnCompleteListener(new OnCompleteListener() {
                @Override
                public void onComplete(@NonNull Task task) {
                    if (task.isSuccessful()){
                        Toast.makeText(getContext(), "Comentario enviado. ", Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(getContext(), "Error al enviar el comentario. Intente más tarde.", Toast.LENGTH_SHORT).show();


                    }
                }
            });

        }

    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Comentarios> options =
                new FirebaseRecyclerOptions.Builder<Comentarios>()
                .setQuery(TallerRef, Comentarios.class)
                .build();

        FirebaseRecyclerAdapter<Comentarios, CommentViewHolder> adapter
              = new FirebaseRecyclerAdapter<Comentarios, CommentViewHolder>(options) {
            @NonNull
            @Override
            public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.include_commentlayout, parent, false);
                CommentViewHolder commentViewHolder = new CommentViewHolder(vista);
                return commentViewHolder;
            }

            @Override
            protected void onBindViewHolder(@NonNull CommentViewHolder holder, int position, @NonNull Comentarios model) {
                holder.txtnombre_cliente.setText(model.getNombre_cliente());
                holder.txtComentario.setText(model.getComentario());
                holder.txtTime.setText(model.getTime());
                holder.txtFecha.setText(model.getDate());
            }
        };
            recyclerComentarios.setAdapter(adapter);

            adapter.startListening();

    }

    public static class CommentViewHolder extends RecyclerView.ViewHolder{
View mView;
TextView txtnombre_cliente, txtFecha, txtTime, txtComentario;


    public CommentViewHolder(@NonNull View itemView) {
        super(itemView);
        txtnombre_cliente= itemView.findViewById(R.id.txtnombre_cliente);
        txtFecha= itemView.findViewById(R.id.txtFecha);
        txtTime= itemView.findViewById(R.id.txtTime);
        txtComentario= itemView.findViewById(R.id.txtComentario);
    }

}

}
