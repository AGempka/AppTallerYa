package com.example.apptallerya;

import androidx.annotation.NonNull;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends Fragment {

    //RequestQueue rq;
    //JsonRequest jrq;
    EditText txtCorreo,txtPassword,txtNombre,txtDireccion,txtTelefono;
    Button btnRegistrar;
    Button btnInicio;
    String nombre_cliente, correo_cliente, password_cliente, direccion_cliente, telefono_cliente;
    Cliente cliente;
    FirebaseAuth mAuth;
    DatabaseReference mDataBase;


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
        //rq= Volley.newRequestQueue(getContext());
        mAuth= FirebaseAuth.getInstance();
        mDataBase= FirebaseDatabase.getInstance().getReference();
        btnInicio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                iniciar_sesion();
            }
        });
        btnRegistrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                nombre_cliente = txtNombre.getText().toString();
                correo_cliente=txtCorreo.getText().toString();
                telefono_cliente=txtTelefono.getText().toString();
                password_cliente=txtPassword.getText().toString();

                if(!nombre_cliente.isEmpty()&&!correo_cliente.isEmpty()&&!telefono_cliente.isEmpty()&&!password_cliente.isEmpty()){
                    if (password_cliente.length()>=6){
                        registrar_usuario();

                    }else{
                        Toast.makeText(getContext(), "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(getContext(), "Debe completar los campos", Toast.LENGTH_SHORT).show();
                }

            }
        });


        // Inflate the layout for this fragment
        // return  inflater.inflate(R.layout.fragment_registrar, container, false);
        return vista;
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
       // String url="https://tallerya.000webhostapp.com//regisrar.php?&correo_cliente="+txtCorreo.getText().toString()+"&password_cliente="+txtPassword.getText().toString()
         //       +"&nombre_cliente="+txtNombre.getText().toString()+"&telefono_cliente="+txtTelefono.getText().toString();
        //jrq=new JsonObjectRequest(Request.Method.GET,url,null,this,this);
       // rq.add(jrq);

    mAuth.createUserWithEmailAndPassword(correo_cliente, password_cliente).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if(task.isSuccessful()){

                Map<String, Object> map = new HashMap<>();
                map.put("nombre_cliente", nombre_cliente);
                map.put("correo_cliente", correo_cliente);
                map.put("password_cliente", password_cliente);
                map.put("telefono_cliente", telefono_cliente);

                String id=mAuth.getCurrentUser().getUid();
                mDataBase.child("Clientes").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task2) {
                        if(task2.isSuccessful()){
                                iniciar_sesion();

                        }else{
                            Toast.makeText(getContext(), "No se pudieron crear los datos correctamente", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }else{
                               Toast.makeText(getContext(), "No se pudo registrar el usuario", Toast.LENGTH_SHORT).show();

            }

        }
    });

    }

    //PARA MANTENER SESIÓN


}
