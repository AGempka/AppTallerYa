package com.example.apptallerya;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginFragment extends Fragment  {
   // RequestQueue rq;
    //JsonRequest jrq;
    EditText txtCorreo, txtPassword;
    Button btnSesion, btnCrear, btnRecuperarContraseña;
    String correo_cliente, password_cliente;
    FirebaseAuth mAuth;



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View vista = inflater.inflate(R.layout.login_fragment, container, false);
        txtCorreo = (EditText) vista.findViewById(R.id.txtCorreo);
        txtPassword = (EditText) vista.findViewById(R.id.txtPassword);

        btnSesion = (Button) vista.findViewById(R.id.btnSesion);
        btnCrear = (Button) vista.findViewById(R.id.btnCrear);
        btnRecuperarContraseña=(Button)vista.findViewById(R.id.btnRecuperarContraseña);
       // rq = Volley.newRequestQueue(getContext());
        mAuth=FirebaseAuth.getInstance();
        btnSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correo_cliente=txtCorreo.getText().toString();
                password_cliente=txtPassword.getText().toString();
                if (!correo_cliente.isEmpty() && !correo_cliente.isEmpty()) {
                    iniciar_sesion();
                }else{
                    Toast.makeText(getContext(), "Debe completar los campos", Toast.LENGTH_SHORT).show();
                }



            }
        });


        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar_usuario();
            }
        });

        btnRecuperarContraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recuperar_contraseña();




            }
        });

        return vista;
    }

    private void recuperar_contraseña() {
        ResetPassword fr=new ResetPassword();
        //fr.setArguments(fr);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.escenario,fr)
                .addToBackStack(null)
                .commit();

    }



    void iniciar_sesion() {

       // String url = "https://tallerya.000webhostapp.com//sesion.php?correo_cliente=" + txtCorreo.getText().toString() +
       //         "&password_cliente=" + txtPassword.getText().toString();
        //jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
      //  rq.add(jrq);

mAuth.signInWithEmailAndPassword(correo_cliente, password_cliente).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()){
            startActivity(new Intent(getContext(), Main2Activity.class));
           // finish();
        }else{
            Toast.makeText(getContext(), "No se pudo iniciar sesión. Compruebe los datos.", Toast.LENGTH_SHORT).show();

        }

    }
});
    }

    void registrar_usuario(){
        SignUpActivity fr=new SignUpActivity();
        //fr.setArguments(fr);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.escenario,fr)
                .addToBackStack(null)
                .commit();

    }

}
