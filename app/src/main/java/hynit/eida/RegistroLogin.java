package hynit.eida;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegistroLogin extends AppCompatActivity implements View.OnClickListener {

    EditText NombreEtvar,ApellidoEtvar,EmailEtvar;
    EditText contrasenaVar;
    Button btn_registrar;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_login);
//Editview
        NombreEtvar = (EditText) findViewById(R.id.NombreEt);
        ApellidoEtvar = (EditText) findViewById(R.id.ApellidoEt);
        EmailEtvar = (EditText) findViewById(R.id.CorreoEt);
        contrasenaVar = (EditText) findViewById(R.id.ContrasenaET);
        //Button

        btn_registrar = (Button) findViewById(R.id.btn_registrarLoginActivirty);

//Evento

        btn_registrar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        final String nombre=NombreEtvar.getText().toString();
        final String apellido=ApellidoEtvar.getText().toString();
        final String correo=EmailEtvar.getText().toString();
        final String contrasena=contrasenaVar.getText().toString();
        final String contrasena2=contrasenaVar.getText().toString();

        Response.Listener<String> respoListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                  //JSONObject  jsonResponse = new JSONObject(convertStandardJSONString(response).substring(3));
                     boolean success = jsonResponse.getBoolean("success");

                    if(success){
                        Intent intent = new Intent(RegistroLogin.this,LoginActivity.class);
                        RegistroLogin.this.startActivity(intent);
                    }else {

                        AlertDialog.Builder builder = new AlertDialog.Builder(RegistroLogin.this);
                        builder.setMessage("Error en el Registro")
                                .setNegativeButton("Retry",null)
                                .create().show();

                    }

                }

                catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        };






        RegisterRequest registerRequest = new RegisterRequest(nombre,apellido,correo,contrasena,respoListener);
        RequestQueue queue = Volley.newRequestQueue(RegistroLogin.this);
        queue.add(registerRequest);


    }


    public static String convertStandardJSONString(String data_json) {
        data_json = data_json.replaceAll("\\\\r\\\\n", "");
        data_json = data_json.replace("\"{", "{");
        data_json = data_json.replace("}\",", "},");
        data_json = data_json.replace("}\"", "}");
        return data_json;
    }

}
