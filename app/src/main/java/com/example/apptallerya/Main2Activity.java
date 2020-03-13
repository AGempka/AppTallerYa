package com.example.apptallerya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.ContentQueryMap;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, PerfilesTalleresFragment.OnFragmentInteractionListener {
    private DrawerLayout drawer;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.drawer_layout, new PerfilesTalleresFragment()).commit();




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
                        new RegistrarFragment()).commit();
                break;
            //case R.id.nav_nosotros:
            // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
            //       new MessageFragment()).commit();
            //break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }



}