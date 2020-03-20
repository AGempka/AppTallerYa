package com.example.apptallerya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    public static final String nombre_cliente="nombre_cliente";
    TextView txtBienvenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       // txtBienvenido=(TextView)findViewById(R.id.txtbienvenido);
        //String cliente=getIntent().getStringExtra("nombre_cliente");
        //txtBienvenido.setText("¡Bienvenido "+ cliente + "!");
    }
}

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_talleres:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PerfilesTalleresFragment()).commit();
                break;
            // case R.id.nav_agenda:
            //   getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
            //         new MessageFragment()).commit();
            //break;
            //case R.id.nav_promo:
            //  getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
            //        new MessageFragment()).commit();
            //break;
            case R.id.nav_perfil:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SignUpActivity()).commit();
                break;
            //case R.id.nav_nosotros:
            // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
            //       new MessageFragment()).commit();
            //break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    }