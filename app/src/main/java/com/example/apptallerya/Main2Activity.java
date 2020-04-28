package com.example.apptallerya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, PerfilesTalleresFragment.OnFragmentInteractionListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FirebaseAuth mAuth;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);


        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        // Carga de Fragment de talleres
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_main, new PerfilesTalleresFragment()).commit();

        // Establecimiento de evento onclick de menu
        navigationView.setNavigationItemSelectedListener(this);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (menuItem.getItemId() == R.id.nav_talleres) {
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_main, new PerfilesTalleresFragment()).commit();
        }
            if (menuItem.getItemId() == R.id.nav_agenda) {
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_main, new SignUpActivity()).commit();
            }
            if (menuItem.getItemId() == R.id.nav_promo) {
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_main, new  SignUpActivity()).commit();
            }
            if (menuItem.getItemId() == R.id.nav_perfil) {
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_main, new SignUpActivity()).commit();
            }
            if (menuItem.getItemId() == R.id.nav_nosotros) {
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_main, new SignUpActivity()).commit();
            }
        return false;
    }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
    public void onFragmentInteraction(Uri uri) {

    }
}