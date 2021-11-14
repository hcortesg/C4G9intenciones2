package com.example.hogarappv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    String usuario="", clave="", nombre="Yona Aufa", claveR="1234", usuarioR="yona";
    TextInputEditText tie_usuario_l, tie_clave_l;
    MaterialButton bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_login=findViewById(R.id.bt_login);
        tie_usuario_l =findViewById(R.id.tie_usuario_l);
        tie_clave_l=findViewById(R.id.tie_clave_l);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usuario = tie_usuario_l.getText().toString();
                clave=tie_clave_l.getText().toString();

                if(usuario.equals(usuarioR.toString())&&clave.equals(claveR.toString())){
                    Intent intent=new Intent(MainActivity.this, Buscar.class);
                    intent.putExtra("usuario", usuario);
                    intent.putExtra("nombre", nombre);
                    startActivity(intent);
                }else{
                    Intent intent=new Intent(MainActivity.this, Cuenta.class);
                    intent.putExtra("usuario", usuario);
                    intent.putExtra("clave", clave);
                    startActivity(intent);
                }
            }
        });
    }
}