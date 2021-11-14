package com.example.hogarappv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Agendar extends AppCompatActivity {

    String nombre="", direccion="", descripcion="";
    MaterialButton bt_llamar_a, bt_agendar_a;
    TextInputEditText tie_descripcion_a, tie_cliente_a, tie_predio_a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar);

        bt_llamar_a=findViewById(R.id.bt_llamar_a);
        bt_agendar_a=findViewById(R.id.bt_agendar_a);
        tie_descripcion_a=findViewById(R.id.tie_descripcion_a);
        tie_cliente_a=findViewById(R.id.tie_cliente_a);
        tie_predio_a=findViewById(R.id.tie_predio_a);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            nombre=bundle.getString("nombre");
            direccion=bundle.getString("direccion");
        }

        tie_cliente_a.setText(nombre);
        tie_predio_a.setText("Su inmueble " + direccion);

        bt_llamar_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(this, "Llamar al numero", Toast.LENGTH_SHORT).show();
                Log.i("info", "Realizando llamada");
            }
        });

        bt_agendar_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //capturar la fecha
//                Toast.makeText(this, "Llamar al numero", Toast.LENGTH_SHORT).show();
                Log.i("info", "Registrando cita");
                Intent intent=new Intent(Agendar.this, Confirmar.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("direccion", direccion);
                startActivity(intent);
            }
        });

    }
}