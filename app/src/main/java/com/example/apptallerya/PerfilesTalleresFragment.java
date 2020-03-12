package com.example.apptallerya;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public class PerfilesTalleresFragment extends Fragment
    implements Response.Listener<JSONObject>,Response.ErrorListener{

        private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";

        private String mParam1;
        private String mParam2;

        private OnFragmentInteractionListener mListener;

    List<Taller> tallerList;
    RecyclerView recyclerView;

    ProgressDialog dialog;

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    public PerfilesTalleresFragment() {
    }


    public static PerfilesTalleresFragment newInstance(String param1, String param2) {
        PerfilesTalleresFragment fragment = new PerfilesTalleresFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista= inflater.inflate(R.layout.fragment_perfiles_talleres, container, false);

        recyclerView=(RecyclerView)vista.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        tallerList=new ArrayList<>();

         request= Volley.newRequestQueue(getContext());

        cargarWebService();
        return vista;

    }





    private void cargarWebService() {
        dialog= new ProgressDialog(getContext());
        dialog.setMessage("Consultando imágenes");
        dialog.show();

        String url="https://tallerya.000webhostapp.com//talleresperfiles.php";
        jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        request.add(jsonObjectRequest);
        //VolleySingleton.getIntanciaVolley(getContext()).addToRequestQueue(jsonObjectRequest);

    }


    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        Taller taller=null;

        JSONArray json=response.optJSONArray("taller");

        try {

            for (int i=0;i<json.length();i++){
                taller=new Taller();
                JSONObject jsonObject=null;
                jsonObject=json.getJSONObject(i);

                taller.setNombre_taller(jsonObject.optString("nombre_taller"));
                taller.setDireccion_taller(jsonObject.optString("direccion_taller"));
                taller.setEvaluacion_taller(Double.parseDouble(jsonObject.optString("evaluacion_taller")));
                taller.setImagen1_taller(jsonObject.optString("imagen1_taller"));
                tallerList.add(taller);
            }
            dialog.hide();
            Adapter adapter=new Adapter(tallerList);
            recyclerView.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "No se ha podido establecer conexión con el servidor" +
                    " "+response, Toast.LENGTH_LONG).show();
            dialog.hide();
        }
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



    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }


    }

