package com.example.apptallerya;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class PerfilesTalleresFragment extends Fragment  implements Adapter.OnItemClickListener{


    private OnFragmentInteractionListener mListener;

    ArrayList<Taller> tallerList;
    RecyclerView recyclerView;
    ProgressDialog dialog;

    Adapter adaptador;
    DatabaseReference reference;

    public PerfilesTalleresFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_perfiles_talleres, container, false);

        recyclerView = (RecyclerView) vista.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        tallerList = new ArrayList<Taller>();
        reference = FirebaseDatabase.getInstance().getReference("Talleres");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Taller t = dataSnapshot1.getValue(Taller.class);
                    tallerList.add(t);
                }
                adaptador = new Adapter(getContext(), tallerList);
                recyclerView.setAdapter(adaptador);
                adaptador.setOnItemClickListener(PerfilesTalleresFragment.this);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "Ops... Algo anda mal", Toast.LENGTH_SHORT).show();
            }
        });




        return vista;

    }





    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    //probando abrir otro fragment con el click
   @Override
    public void onItemClick(int position) {
       Toast.makeText(getContext(), "Taller seleccionado " + position, Toast.LENGTH_SHORT).show();

        //ver que puedo llamar en vez de tallerlist para obtener la posición del roll
        Taller clickeditem = tallerList.get(position);
        TalleresFragment f = TalleresFragment.newInstance(clickeditem.getNombre_taller(), clickeditem.getTelefono_taller(), clickeditem.getDireccion_taller(), clickeditem.getEvaluacion_taller(), clickeditem.getImg1_taller(), clickeditem.getImg2_taller(), clickeditem.getImg_logo());
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.drawer_layout, f).addToBackStack(null).commit();

    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }


}

