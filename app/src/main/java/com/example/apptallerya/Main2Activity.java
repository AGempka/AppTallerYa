package com.example.apptallerya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

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
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, PerfilesTalleresFragment.OnFragmentInteractionListener {
    private DrawerLayout drawer;
    Adapter adapter;
    FirebaseAuth mAuth;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.drawer_layout, new PerfilesTalleresFragment()).commit();

          mAuth=FirebaseAuth.getInstance();


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_talleres, R.id.nav_agenda, R.id.nav_promo,R.id.nav_perfil,R.id.nav_nosotros)
                .setDrawerLayout(drawer)
                .build();

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
            case R.id.nav_sesion:
               cerrar_sesion();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //CERRANDO SESIÓN
    private void cerrar_sesion() {
    mAuth.signOut();
    startActivity(new Intent(Main2Activity.this, SesionActivity.class));
    finish();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_menu, menu);
        return true;
    }




}