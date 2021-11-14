package com.example.hogarappv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Buscar extends AppCompatActivity {

    String nombre="", ciudad="",  zona="",localidad="",direccion="", construido="";
    TextInputEditText tie_ciudad_b, tie_zona_b, tie_localidad_b, tie_direccion_b, tie_construido_b;
    MaterialButton bt_buscar_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        tie_ciudad_b=findViewById(R.id.tie_ciudad_b);
        tie_zona_b=findViewById(R.id.tie_zona_b);
        tie_localidad_b=findViewById(R.id.tie_localidad_b);
        tie_direccion_b=findViewById(R.id.tie_direccion_b);
        tie_construido_b=findViewById(R.id.tie_construido_b);

        bt_buscar_b=findViewById(R.id.bt_buscar_b);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            nombre=bundle.getString("nombre");
        }

        bt_buscar_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ciudad=tie_ciudad_b.getText().toString();
                zona=tie_zona_b.getText().toString();
                localidad=tie_localidad_b.getText().toString();
                direccion=tie_direccion_b.getText().toString();
                construido=tie_construido_b.getText().toString();
                if(!ciudad.equals("")){
                    //Buscar los inmuebles disponibles
                    Log.i("info", "Buscar ciudad ok");
                    Intent intent = new Intent(Buscar.this, Comprar.class);
                    intent.putExtra("nombre", nombre);
                    intent.putExtra("ciudad", ciudad);
                    intent.putExtra("zona", zona);
                    intent.putExtra("localidad", localidad);
                    intent.putExtra("direccion", direccion);
                    intent.putExtra("construido", construido);
                    startActivity(intent);
                }else{
//                    Toast.makeText(this,"Por favor ingrese una ciudad", Toast.LENGTH_SHORT).show();
                    Log.i("info", "No hay ciudad seleccionada");
                }

            }
        });

    }
}