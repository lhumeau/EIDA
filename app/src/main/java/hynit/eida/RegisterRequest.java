package hynit.eida;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HYNIT-PC on 08/10/2017.
 */

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL="http://192.168.198.2:8085/Register.php";
    private Map<String,String> params;
    public RegisterRequest(String nombre, String apellido, String correo, String contrasena, Response.Listener<String> listener){
        super(Method.POST,REGISTER_REQUEST_URL,listener,null);
        params= new HashMap<>();
        params.put("nombre",nombre);
        params.put("apellido",apellido);
        params.put("correo",correo);
        params.put("contrasena",contrasena);


    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
