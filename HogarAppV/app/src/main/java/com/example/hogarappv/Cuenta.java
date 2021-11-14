package com.example.hogarappv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Cuenta extends AppCompatActivity {

    String nombre="", telefono="", email="", usuario="", clave="", reclave="";
    TextInputEditText tie_nombre_c, tie_telefono_c, tie_email_c, tie_usuario_c, tie_clave_c, tie_reclave_c;
    MaterialButton bt_crear_c;
    int estadoDatos=0, estadoClave=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta);

        tie_nombre_c=findViewById(R.id.tie_nombre_c);
        tie_telefono_c=findViewById(R.id.tie_telefono_c);
        tie_email_c=findViewById(R.id.tie_email_c);
        tie_clave_c=findViewById(R.id.tie_clave_l);
        tie_reclave_c=findViewById(R.id.tie_reclave_c);

        bt_crear_c=findViewById(R.id.bt_crear_c);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            usuario=bundle.getString("usuario");
            clave=bundle.getString("clave");
            tie_clave_c.setText(clave);
            nombre=bundle.getString("nombre");
        }


        bt_crear_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre=tie_nombre_c.getText().toString();
                telefono=tie_telefono_c.getText().toString();
                email=tie_email_c.getText().toString();
                reclave=tie_reclave_c.getText().toString();

                if(!nombre.equals("") && !telefono.equals("") && !email.equals("")){
                    estadoDatos=1;
                }
                if(clave.equals(reclave.toString())){
                    estadoClave=1;
                }
                if((estadoDatos==1)&&(estadoClave==1)){
//                    Toast.makeText(this, "Cuenta Creada", Toast.LENGTH_SHORT).show();
                    Log.i("info", "Cuenta creada");
                    Intent intent = new Intent(Cuenta.this, Buscar.class);
                    intent.putExtra("nombre", nombre);
                    startActivity(intent);
                }else{
//                    Toast.makeText(this, "Por favor llene todos los datos", Toast.LENGTH_SHORT).show();
                    Log.i("info", "Datos incompletos");
                }
            }
        });

    }
}