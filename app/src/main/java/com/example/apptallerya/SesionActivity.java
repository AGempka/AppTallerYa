package com.example.apptallerya;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class SesionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.escenario, new LoginFragment()).commit();

    }
}
