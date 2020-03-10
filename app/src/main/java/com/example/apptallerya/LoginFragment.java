package com.example.apptallerya;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class LoginFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener {
    RequestQueue rq;
    JsonRequest jrq;
    EditText txtCorreo, txtPassword;
    Button btnSesion, btnRegistrar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_login, container, false);
        txtCorreo = (EditText) vista.findViewById(R.id.txtCorreo);
        txtPassword = (EditText) vista.findViewById(R.id.txtPassword);

        btnSesion = (Button) vista.findViewById(R.id.btnLogin);
        btnRegistrar = (Button) vista.findViewById(R.id.btnRegistrar);
        rq = Volley.newRequestQueue(getContext());

        btnSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciar_sesion();
            }
        });


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar_usuario();
            }
        });


        // Inflate the layout for this fragment
        return vista;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(), "No se encontró el usuario " +error.toString()+ txtCorreo.getText().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getContext(), "Se encontró el usuario " + txtCorreo.getText().toString(), Toast.LENGTH_SHORT).show();
        Cliente cliente = new Cliente();
        JSONArray jsonArray = response.optJSONArray("datos");
        JSONObject jsonObject = null;

        try {
            jsonObject = jsonArray.getJSONObject(0);
            cliente.setNombre_cliente(jsonObject.optString("nombre_cliente"));
            cliente.setCorreo_cliente(jsonObject.optString("correo_cliente"));
            cliente.setPassword_cliente(jsonObject.optString("password_cliente"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Intent intencion = new Intent(getContext(), Main2Activity.class);
        startActivity(intencion);


    }


    void iniciar_sesion() {


        String url = "https://tallerya.000webhostapp.com//sesion.php?correo_cliente=" + txtCorreo.getText().toString() +
                "&password_cliente=" + txtPassword.getText().toString();
        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);


    }

    void registrar_usuario(){
        RegistrarFragment fr=new RegistrarFragment();
        //fr.setArguments(fr);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.escenario,fr)
                .addToBackStack(null)
                .commit();

    }



}