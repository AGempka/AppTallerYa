package com.example.apptallerya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements  PerfilesTalleresFragment.OnFragmentInteractionListener {
    public static final String nombre_cliente="nombre_cliente";
    TextView txtBienvenido;
    Button btnTalleres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.escenario2, new PerfilesTalleresFragment()).commit();

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
