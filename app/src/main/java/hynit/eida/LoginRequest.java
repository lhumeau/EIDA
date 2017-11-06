package hynit.eida;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HYNIT-PC on 16/10/2017.
 */

public class LoginRequest extends StringRequest {


    private static final String LOGIN_REQUEST_URL = "http://192.168.198.2:8085/Login.php";
    private Map<String, String> params;

    public LoginRequest(String correo, String contrasena, Response.Listener<String> listener) {
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("correo", correo);
        params.put("contrasena", contrasena);


    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}



