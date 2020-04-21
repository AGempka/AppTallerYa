package com.example.apptallerya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.apptallerya.LoginFragment.PREFERENCE_ESTADO_BUTTON_SESION;

public class MainActivity extends AppCompatActivity {
    Button ir_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (sesion()== false){
            Toast.makeText(getApplicationContext(),
                    "Seba es un crack", Toast.LENGTH_SHORT).show();
            Intent intencion = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intencion);
            finish();
        } else {
            ir_login = findViewById(R.id.ir_login);
            ir_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, SesionActivity.class));
                    finish();
                }
            });
        }
    }

    private boolean sesion() {
        SharedPreferences myPreferences = getSharedPreferences("PREFERENCE_ESTADO_BUTTON_SESION",MODE_PRIVATE);
        return myPreferences.getBoolean(PREFERENCE_ESTADO_BUTTON_SESION,false);

    }


}
