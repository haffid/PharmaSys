package com.haffid.pharmasys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.haffid.pharmasys.complementos.ClienteVO;
import com.haffid.pharmasys.complementos.MetodosSW;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity2 extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    ArrayList<ClienteVO> listaClienteVO;
    MetodosSW metodosSW = new MetodosSW();
    ArrayList<String> listaDatos;

    private TextView textViewIdP, textViewPreP, textViewNomP, textViewTotalP, textViewIdCliente, textViewEstadoP, textViewFechaP;
    private EditText editTextCantidadP;
    private String idClientes, id, nombre, precio, estado, fechaP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textViewIdCliente = findViewById(R.id.idClientesP);
        textViewIdP = findViewById(R.id.idProductos);
        textViewNomP = findViewById(R.id.descripcionPedidos);
        textViewPreP = findViewById(R.id.precioPedidos);
        textViewFechaP = findViewById(R.id.fechaP);
        textViewEstadoP = findViewById(R.id.estadoPedido);
        editTextCantidadP = findViewById(R.id.cantidadPedidos);
        textViewTotalP = findViewById(R.id.totalPedidos);

        this.obtenerDatos();
        this.fechaActual();
        textViewEstadoP.setText(String.valueOf(1));

        editTextCantidadP.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cambioCantidad();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //metodosSW.consultaCliente(this,this,this);
    }

    //Consulta de la BD de Clientes Android
    private void resultadoConsulta(JSONObject response){
        ClienteVO clienteVO = new ClienteVO();
        JSONArray jsonArray = response.optJSONArray("tbl_cliente_Android");
        try {
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            clienteVO.setIdCliente(jsonObject.optInt("id_cliente"));

            String dato = clienteVO.getNombreCliente();
            if (!dato.equals("n")) {
                textViewIdCliente.setText(String.valueOf(clienteVO.getIdCliente()));
            }else{
                textViewIdCliente.setText("...");
                Toast.makeText(this, "Datos no Encontrados ", Toast.LENGTH_LONG).show();
            }

        }catch (Exception e){
            Toast.makeText(this, "Error referente a B ", Toast.LENGTH_LONG).show();
            System.err.println("B--- "+e.getCause()+" --- "+e.getMessage());
        }

    }

    private void obtenerDatos(){
        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");
        precio = bundle.getString("precio");
        nombre = bundle.getString("nombre");
        //Cambiar
        idClientes = bundle.getString("1");

        textViewIdP.setText(id);
        textViewNomP.setText(nombre);
        textViewPreP.setText(precio);

        //cambiar
        textViewIdCliente.setText("1");

    }


    //Metodo para calcular el total del pedido
    private void cambioCantidad(){
            String preciop = textViewPreP.getText().toString();
            String cantidadp = editTextCantidadP.getText().toString();
            if(!cantidadp.isEmpty()) {
                double resultadop = Double.parseDouble(cantidadp) * Double.parseDouble(preciop);
                textViewTotalP.setText(String.valueOf(resultadop));
        }else{
            Toast.makeText(this, "Debe de agregar por lo menos un prducto", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para poner la fecha actual al campo fecha del pedido
    public void fechaActual (){
        Date today = Calendar.getInstance().getTime();//getting date
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");//formating according to my need
        String date = formatter.format(today);
        textViewFechaP.setText(date);
    }

    private void insertarPedido() {
        if (!editTextCantidadP.getText().toString().isEmpty()) {
            //Utilizamos el metodo MetodosSW
            metodosSW.insertarPedido(this, textViewFechaP.getText().toString(), Integer.parseInt(textViewIdCliente.getText().toString()),
                    Integer.parseInt(textViewIdP.getText().toString()), textViewNomP.getText().toString(), Double.parseDouble(textViewPreP.getText().toString()),
                    Integer.parseInt(editTextCantidadP.getText().toString()), Double.parseDouble(textViewTotalP.getText().toString()),
                    Integer.parseInt(textViewEstadoP.getText().toString()),this, this);

            editTextCantidadP.setText("");


        } else {
            Toast.makeText(this, "Debe Agregar una cantidad", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse(JSONObject response) {
        this.resultadoConsulta(response);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }


    public void pedido(View view) {
        this.insertarPedido();
    }
}