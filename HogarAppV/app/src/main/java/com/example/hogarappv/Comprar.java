package com.example.hogarappv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Comprar extends AppCompatActivity {

    String nombre="", ciudad="", zona="", localidad="", direccion="",construido="",predio="";
    MaterialButton bt_comprar, bt_alquilar;
    TextInputEditText tie_predio_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar);

        tie_predio_c=findViewById(R.id.tie_predio_c);
        bt_comprar=findViewById(R.id.bt_comprar);
        bt_alquilar=findViewById(R.id.bt_alquilar);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            nombre=bundle.getString("nombre");
            ciudad=bundle.getString("ciudad");
            zona=bundle.getString("zona");
            localidad=bundle.getString("localidad");
            direccion=bundle.getString("direccion");
            construido=bundle.getString("construido");
            predio=ciudad + "|" + zona + "|" + localidad  + "|" + direccion + "|" + construido;
        }
        tie_predio_c.setText(predio);

        bt_comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checkbox para elegir el predio

                if(!ciudad.equals("")){
                    Log.i("info","Acordar cita");
                    Intent intent=new Intent(Comprar.this, Agendar.class);
                    intent.putExtra("nombre", nombre);
                    intent.putExtra("direccion", direccion);
                    startActivity(intent);
                }else{
                    Log.i("info", "No hay predio disponible");
                }
            }
        });

        bt_alquilar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checkbox para elegir el predio
                if(!ciudad.equals("")){
                    Log.i("info","Acordar cita");
                    Intent intent=new Intent(Comprar.this, Agendar.class);
                    intent.putExtra("nombre", nombre);
                    intent.putExtra("direccion", direccion);
                    startActivity(intent);
                }else{
                    Log.i("info", "No hay predio disponible");
                }

            }
        });
    }
}