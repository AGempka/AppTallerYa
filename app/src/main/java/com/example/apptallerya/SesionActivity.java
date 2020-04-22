package com.example.apptallerya;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.firebase.auth.FirebaseAuth;

public class SesionActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.escenario, new LoginFragment()).commit();

    }




}
