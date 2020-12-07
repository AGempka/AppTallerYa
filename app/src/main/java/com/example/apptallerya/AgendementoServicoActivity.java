package com.example.apptallerya;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import com.example.apptallerya.util.DialogProgress;
import com.example.apptallerya.util.Util;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AgendementoServicoActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {


    private EditText detallesdelvehiculo;
    private TextView editText_Nome;
    private TextView textView_NumeroContato;
    private CheckBox checkBox_WhatsApp;
    private TextView textView_Email;
    private CheckBox checkBox_ChaperiayPintura;
    private CheckBox checkBox_Mecanica;
    private CheckBox checkBox_Limpieza;
    private CheckBox checkBox_Lubricacion;
    private CheckBox checkBox_Inyeccion;
    private CheckBox checkBox_Electricidad;

    private CardView cardView_Agendar;

    private DatabaseReference UsersRef;



    private ArrayList<String> data = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendemento_servico);

        data = getIntent().getStringArrayListExtra("data");
      String  key = getIntent().getStringExtra("keyTaller");


        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        String uid = user.getUid();

        editText_Nome = (TextView)findViewById(R.id.AgendamentoServico_Nome);
        textView_NumeroContato = (TextView)findViewById(R.id.textView_AgendamentoServico_Numero);
        checkBox_WhatsApp = (CheckBox)findViewById(R.id.checkbox_AgendamentoServico_WhatsApp);
        textView_Email = (TextView)findViewById(R.id.AgendamentoServico_Correo);
        checkBox_ChaperiayPintura = (CheckBox)findViewById(R.id.checkbox_AgendamentoChaperia);
        checkBox_Mecanica= (CheckBox)findViewById(R.id.checkbox_AgendamentoMecanica);
        checkBox_Electricidad= (CheckBox)findViewById(R.id.checkbox_AgendamentoElectricidad);
        checkBox_Inyeccion=(CheckBox)findViewById(R.id.checkbox_AgendamentoInyeccion);
        checkBox_Limpieza=(CheckBox)findViewById(R.id.checkbox_AgendamentoLimpieza);
        checkBox_Lubricacion=(CheckBox)findViewById(R.id.checkbox_AgendamentoLubricacion);
        cardView_Agendar = (CardView)findViewById(R.id.cardView_AgendamentoServico_Agendar);
        detallesdelvehiculo = (EditText)findViewById(R.id.editText_detallesdelvehiculo);

        cardView_Agendar.setOnClickListener(this);


        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Clientes");
        ref.child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String nombre_cliente = dataSnapshot.child("nombre_cliente").getValue(String.class);
                String correo_cliente = dataSnapshot.child("correo_cliente").getValue(String.class);
                String telefono_cliente = dataSnapshot.child("telefono_cliente").getValue(String.class);

                editText_Nome.setText(nombre_cliente);
                textView_NumeroContato.setText(telefono_cliente);
                textView_Email.setText(correo_cliente);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Fallo en la lectura: " + databaseError.getCode());
            }
        });
    }


    //----------------------------------ACAO DE CLICK--------------------------------------------------

    @Override
    public void onClick(View view) {


        switch (view.getId()){


            case R.id.cardView_AgendamentoServico_Agendar:

                agendar();

                break;

        }

    }






    //----------------------------------OBTER NUMERO TELEFONE-------------------------------------------------
/*
    private void obterNumeroContato(){


        HintRequest hintRequest = new HintRequest.Builder()
                .setHintPickerConfig(new CredentialPickerConfig.Builder().setShowCancelButton(false).build())
                .setPhoneNumberIdentifierSupported(true)
                .build();


        PendingIntent intent = Auth.CredentialsApi.getHintPickerIntent(googleApiClient_Numero,hintRequest);


        try {

            startIntentSenderForResult(intent.getIntentSender(),122,null,0,0,0);

        } catch (IntentSender.SendIntentException e) {
            e.printStackTrace();
        }

    }
*/


    //----------------------------------OBTER NUMERO EMAIL-------------------------------------------------


  /*  private void obterEmail(){

    AccountManager accountManager = AccountManager.get(this);

        Account[] accounts = accountManager.getAccounts();


        for (Account account: accounts){

            String email = account.name; // email = jonejhgajhgf@gmail.com

            if(email.contains("@")){


                textView_Email.setText(email);
                break;

            }
        }

    }*/









    //----------------------------------METODOS OBTER NUMERO TELEFONE-------------------------------------------------

/*

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 122) {


            if (resultCode == RESULT_OK) {

                Credential credential = data.getParcelableExtra(Credential.EXTRA_KEY);

                if (!credential.getId().isEmpty()) {

                    textView_NumeroContato.setText(credential.getId());

                } else {

                    Toast.makeText(getBaseContext(), "Escolha um numero de contato para poder continuar", Toast.LENGTH_LONG).show();

                }
            } else {

                dialogNumeroContato();

            }

        }

    }




*/
/*
    private void dialogNumeroContato(){


        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("Escolha Obrigatória")
                .setCancelable(false)
                .setMessage("Escolha um número de telefone para agendar um horário.")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        obterNumeroContato();
                    }
                })
                .setNegativeButton("Sair", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        finish();
                    }
                });


        builder.show();

    }

*/





    //----------------------------------AGENDAR NO FIREBASE-------------------------------------------------


    private void agendar(){

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        String uid = user.getUid();

        UsersRef = FirebaseDatabase.getInstance().getReference("Clientes");


        final boolean whatsApp = checkBox_WhatsApp.isChecked();
        final boolean chaperiaypintura = checkBox_ChaperiayPintura.isChecked();
        final boolean lubricacion = checkBox_Lubricacion.isChecked();
        final boolean limpieza = checkBox_Limpieza.isChecked();
        final boolean mecanica = checkBox_Mecanica.isChecked();
        final boolean electricidad = checkBox_Electricidad.isChecked();
        final boolean inyeccion = checkBox_Inyeccion.isChecked();



            if (!chaperiaypintura && !lubricacion && !limpieza && !mecanica && !electricidad && !inyeccion){

                Toast.makeText(getBaseContext(),"Debes de elegir al menos un servicio para agendar",Toast.LENGTH_LONG).show();

            }else{
                if (Util.statusInternet_MoWi(getBaseContext())){
                    UsersRef.child(uid).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                String nombre_cliente = dataSnapshot.child("nombre_cliente").getValue().toString();
                                String telefono_cliente = dataSnapshot.child("telefono_cliente").getValue().toString();
                                String correo_cliente = dataSnapshot.child("correo_cliente").getValue().toString();
                                agendarFirebase(nombre_cliente, telefono_cliente, correo_cliente, whatsApp, chaperiaypintura,lubricacion, limpieza,mecanica, electricidad, inyeccion);

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
            else{

                    Toast.makeText(getBaseContext(),"Error - Verifique su internet.",Toast.LENGTH_LONG).show();

                }
            }

        }





    private void agendarFirebase(String nombre_cliente,String telefono_cliente, String correo_cliente,  boolean whatsApp, boolean chaperiaypintura, boolean lubricacion, boolean limpieza, boolean mecanica, boolean electricidad, boolean inyeccion){

        Agendamiento agendamiento = new Agendamiento(nombre_cliente,telefono_cliente,correo_cliente, whatsApp, chaperiaypintura,lubricacion, limpieza, mecanica,electricidad, inyeccion);

        final DialogProgress dialogProgress = new DialogProgress();

        dialogProgress.show(getSupportFragmentManager(),"dialog");



        String  key = getIntent().getStringExtra("keyTaller");
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference reference = firebaseDatabase.getReference().child("Talleres").child(key).child("Calendario")
                .child("HorariosAgendados").child(data.get(2)).child("Mes").child(data.get(1))
                .child("Dia").child(data.get(0));


        reference.child(data.get(3)).setValue(agendamiento).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {


                if (task.isSuccessful()){


                    dialogProgress.dismiss();
                    Toast.makeText(getBaseContext(),"Solicitud de agendamiento enviada.",Toast.LENGTH_LONG).show();
                    finish();

                }else{

                    dialogProgress.dismiss();
                    Toast.makeText(getBaseContext(),"Fallo al Agendar",Toast.LENGTH_LONG).show();

                }



            }
        });

    }











    //----------------------------------METODOS GOOGLE --------------------------------------------------


    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

}
