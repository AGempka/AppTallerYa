package com.example.apptallerya;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class ResetPassword extends Fragment {
     EditText txtCorreo;
     Button btnRecuperar;
    Button btnVolver;
    String correo_cliente;
    FirebaseAuth mAuth;
    ProgressDialog mDialog;

    public ResetPassword() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View vista = inflater.inflate(R.layout.fragment_reset_password, container, false);
        txtCorreo=(EditText)vista.findViewById(R.id.txtCorreoRecuperar);
        btnRecuperar=(Button)vista.findViewById(R.id.btnRecuperar);
        btnVolver=(Button)vista.findViewById(R.id.btnVolver);
        mAuth=FirebaseAuth.getInstance();
        mDialog= new ProgressDialog(getContext());
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginFragment fr=new LoginFragment();
                //fr.setArguments(bn);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.escenario,fr)
                        .addToBackStack(null)
                        .commit();
            }
        });
        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            correo_cliente=txtCorreo.getText().toString();
        if (!correo_cliente.isEmpty()){
            mDialog.setMessage("Espere un momento...");
            mDialog.setCanceledOnTouchOutside(false);
            mDialog.show();
            resetPassword();
            LoginFragment fr=new LoginFragment();
            //fr.setArguments(bn);
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.escenario,fr)
                    .addToBackStack(null)
                    .commit();
        }else {
            Toast.makeText(getContext(), "Debe ingresar el correo", Toast.LENGTH_SHORT).show();
        }

            }
        });



        return vista;
    }

    private void resetPassword() {
    mAuth.setLanguageCode("es");
    mAuth.sendPasswordResetEmail(correo_cliente).addOnCompleteListener(new OnCompleteListener<Void>() {
    @Override
    public void onComplete(@NonNull Task<Void> task) {
   if(task.isSuccessful()){
       Toast.makeText(getContext(), "Se ha enviado un correo para reestablecer la contraseña", Toast.LENGTH_SHORT).show();
   }   else{
       Toast.makeText(getContext(), "No se pudo enviar el correo para reestablecer la contraseña", Toast.LENGTH_SHORT).show();
   }

   mDialog.dismiss();
    }
});
    }
}
