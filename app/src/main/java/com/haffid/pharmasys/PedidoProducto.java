package com.haffid.pharmasys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.haffid.pharmasys.complementos.ClienteVO;
import com.haffid.pharmasys.complementos.MetodosSW;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PedidoProducto extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    ArrayList<String> listaDatos;
    ArrayList<ClienteVO> listaClienteVO;
    MetodosSW metodosSW = new MetodosSW();
    private Fragment fragment;
    private String idcliente, nombrecliente, apellidocliente, direccioncliente, correocliente, clavecliente, precio;
    private int position;
    private TextView textViewPre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_producto);

        //Fragmento del pedido
        fragment = new fragment_pedido();
        getSupportFragmentManager().beginTransaction().add(R.id.frlDetallePedido,fragment).commit();


        textViewPre = findViewById(R.id.precioPedido);

        this.obtenerDatos();
        this.trasladoFragment();
    }



    //Consulta de la BD de Clientes Android
    private void consultaCliente(JSONObject response) {
        JSONArray jsonArray = response.optJSONArray("tbl_cliente_Android");
        listaClienteVO = new ArrayList<>();
        try {
            for (int i=0;i < jsonArray.length(); i++){
                ClienteVO clienteVO = new ClienteVO();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                clienteVO.setIdCliente(jsonObject.optInt("id_cliente"));
                clienteVO.setNombreCliente(jsonObject.optString("nombre_cliente"));
                clienteVO.setApellidoCliente(jsonObject.optString("apellido_cliente"));
                clienteVO.setDireccionCliente(jsonObject.optString("direccion_cliente"));
                clienteVO.setCorreoCliente(jsonObject.optString("correo_cliente"));
                clienteVO.setClaveCliente(jsonObject.optString("clave_cliente"));
                listaClienteVO.add(clienteVO);
            }

/*            listaDatos = new ArrayList<>();
            for (int i=0;i < listaClienteVO.size(); i++){
                listaDatos.add(listaClienteVO.get(i).getIdCliente()+". "+listaClienteVO.get(i).getNombreCliente()+". "
                        +listaClienteVO.get(i).getApellidoCliente()+". "+listaClienteVO.get(i).getDireccionCliente()+". "
                        +listaClienteVO.get(i).getCorreoCliente()+". "+listaClienteVO.get(i).getClaveCliente());
            }*/

        }catch (Exception e){
            Toast.makeText(this, "Error referente a P ", Toast.LENGTH_LONG).show();
            System.err.println("C----- "+e.getCause()+" ----- "+e.getMessage());
        }
    }

    @Override
    public void onResponse(JSONObject response) {
        this.consultaCliente(response);

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    //Traslado de informacion cliente
    private void trasladoInformacionCliente(int position) {
        String idCliente, nombreCliente, apellidoCliente, direccionCliente, correoCliente, claveCliente;
        idCliente = String.valueOf(listaClienteVO.get(position).getIdCliente());
        nombreCliente = listaClienteVO.get(position).getNombreCliente();
        apellidoCliente = listaClienteVO.get(position).getApellidoCliente();
        direccionCliente = listaClienteVO.get(position).getDireccionCliente();
        correoCliente = listaClienteVO.get(position).getCorreoCliente();
        claveCliente = listaClienteVO.get(position).getClaveCliente();

        Intent intent = new Intent(getApplicationContext(), DescripcionProducto.class);
        intent.putExtra("id_cliente", idCliente);
        intent.putExtra("nombre_cliente", nombreCliente);
        intent.putExtra("apellido_cliente", apellidoCliente);
        intent.putExtra("direccion_cliente", direccionCliente);
        intent.putExtra("correo_cliente", correoCliente);
        intent.putExtra("clave_cliente", claveCliente);
        startActivity(intent);
    }

    private void obtenerDatos(){
        Bundle bundle = getIntent().getExtras();
        idcliente = bundle.getString("id_cliente");
        nombrecliente = bundle.getString("nombre_cliente");
        apellidocliente = bundle.getString("apellido_cliente");
        direccioncliente = bundle.getString("direccion_cliente");
        correocliente = bundle.getString("correo_cliente");
        clavecliente = bundle.getString("clave_cliente");


    }

    private void trasladoFragment(){
        Bundle bundle = new Bundle();
        bundle.putString("id_cliente",idcliente);
        bundle.putString("nombre_cliente",nombrecliente);
        bundle.putString("apellido_cliente",apellidocliente);
        bundle.putString("direccion_cliente",direccioncliente);
        bundle.putString("correo_cliente",correocliente);
        bundle.putString("clave_cliente",clavecliente);



        fragment.setArguments(bundle);

    }


}