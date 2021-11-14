package com.example.hogarappv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Confirmar extends AppCompatActivity {

    String nombre="";
    MaterialButton bt_confirmado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            nombre=bundle.getString("nombre");
        }
        bt_confirmado=findViewById(R.id.bt_confirmado);

        bt_confirmado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("info", "Confirmacion para: " + nombre);
                Intent intent= new Intent(Confirmar.this, Buscar.class);
                startActivity(intent);
            }
        });
    }
}