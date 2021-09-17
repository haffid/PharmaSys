package com.haffid.pharmasys.complementos;


import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class MetodosSW {

    //Declarar una constante de la IP del servidor local en mi red LAN
    public static final String IP_SERVER = "http://192.168.3.20/";
    //public static final String IP_SERVER = "http://192.168.1.2/";

    //Implementar variables para la conexion y obtencion de informacion
    //Vienen del lado de Volley
    Context context;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;

    public MetodosSW() {
    }

    //Metodo de Insertar
    public void insertarSW(Context context, String nombre, String apellido, String direccion, String correo, String clave,
                           Response.Listener listener, Response.ErrorListener errorListener) {
        this.context = context;
        try {
            String url;
            url = IP_SERVER + "pharmasys/insertar_cliente.php?nombre_cliente="+nombre+"&apellido_cliente="+apellido+
                    "&direccion_cliente="+direccion+"&correo_cliente="+correo+"&clave_cliente="+clave;
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, listener, errorListener);
            requestQueue.add(jsonObjectRequest);

        } catch (Exception e) {
            Toast.makeText(context, "ConflictoR " + e.getMessage(), Toast.LENGTH_SHORT).show();
            System.err.println("I---- " + e.getCause() + " ---- " + e.getMessage());
        }

    }

    //Metodo de Login
    public void loginSW(Context context, String correoL, String claveL,
                           Response.Listener listener, Response.ErrorListener errorListener) {
        this.context = context;
        try {
            String url;
            url = IP_SERVER + "pharmasys/login_cliente.php?correo_cliente="+correoL+"&clave_cliente="+claveL;
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, listener, errorListener);
            requestQueue.add(jsonObjectRequest);

        } catch (Exception e) {
            Toast.makeText(context, "ConflictoL " + e.getMessage(), Toast.LENGTH_SHORT).show();
            System.err.println("L---- " + e.getCause() + " ---- " + e.getMessage());
        }

    }

    //Metodo consultar prducto
    public void consultaProducto(Context context, Response.Listener listener, Response.ErrorListener errorListener){

        this.context = context;
        try {
            String url;
            url = IP_SERVER+"pharmasys/mostrar_producto.php";
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, listener, errorListener);
            requestQueue.add(jsonObjectRequest);

        } catch (Exception e) {
            Toast.makeText(context, "ConflictoP " + e.getMessage(), Toast.LENGTH_LONG).show();
            System.err.println("C---- " + e.getCause() + " ---- " + e.getMessage());
        }
    }



}
