package com.example.apptallerya;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class SignUpActivity extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener{

    RequestQueue rq;
    JsonRequest jrq;
    EditText txtCorreo,txtPassword,txtNombre,txtDireccion,txtTelefono;
    Button btnRegistrar;
    Button btnInicio;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        View vista=inflater.inflate(R.layout.activity_sing_up,container,false);
        txtPassword=(EditText)vista.findViewById(R.id.txtPassword);
        txtCorreo=(EditText)vista.findViewById(R.id.txtCorreo);
        txtNombre=(EditText)vista.findViewById(R.id.txtNombre);
        txtTelefono=(EditText)vista.findViewById(R.id.txtTelefono);
        btnInicio=(Button)vista.findViewById(R.id.btnInicio);
        btnRegistrar=(Button)vista.findViewById(R.id.btnRegistrar);
        rq= Volley.newRequestQueue(getContext());


        btnInicio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                iniciar_sesion();
            }
        });


        btnRegistrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                registrar_usuario();
            }
        });


        // Inflate the layout for this fragment
        // return  inflater.inflate(R.layout.fragment_registrar, container, false);
        return vista;
    }


    @Override
    public void onErrorResponse(VolleyError error){
        Toast.makeText(getContext(),"No se puedo registrar el usuario "+error.toString()+txtNombre.getText().toString(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONObject response){
        Toast.makeText(getContext(),"Se registró correctamente el usuario "+txtNombre.getText().toString(),Toast.LENGTH_SHORT).show();
        limpiarCajas();
        Intent intencion = new Intent(getContext(), LoginFragment.class);
        startActivity(intencion);

    }


    void limpiarCajas(){
        txtCorreo.setText("");
        txtPassword.setText("");
        txtNombre.setText("");
        //     txtDireccion.setText("");
        txtTelefono.setText("");

    }


    void iniciar_sesion(){

        LoginFragment fr=new LoginFragment();
        //fr.setArguments(bn);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.escenario,fr)
                .addToBackStack(null)
                .commit();
    }

    void registrar_usuario(){
        String url="https://tallerya.000webhostapp.com//registrar.php?&correo_cliente="+txtCorreo.getText().toString()+"&password_cliente="+txtPassword.getText().toString()
                +"&nombre_cliente="+txtNombre.getText().toString()+"&telefono_cliente="+txtTelefono.getText().toString();

        jrq=new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        rq.add(jrq);
    }

}
