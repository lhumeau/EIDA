package hynit.eida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Usuario extends AppCompatActivity {
    TextView tvUsuario, tvApellido, tvCorreo, tvContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        tvUsuario = (TextView) findViewById(R.id.TextV_Nombre);
        tvApellido = (TextView) findViewById(R.id.TextV_Apellido);
        tvCorreo = (TextView) findViewById(R.id.TextV_Correo);
        tvContrasena = (TextView) findViewById(R.id.TextV_Contrasena);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String apellido = intent.getStringExtra("apellido");
        String correo = intent.getStringExtra("correo");
        String contrasena = intent.getStringExtra("contrasena");
        //Aplicamos nombre a las variables Text View en este activity

        tvUsuario.setText(nombre);
        tvApellido.setText(apellido);
        tvCorreo.setText(correo);
        tvContrasena.setText(contrasena);

    }
}
