package com.example.apptallerya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



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