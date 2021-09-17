package com.haffid.pharmasys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.haffid.pharmasys.complementos.MetodosSW;
import com.haffid.pharmasys.complementos.ProductoVO;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    //Toolbar
    private Toolbar toolbar;
    ListView listView;
    ArrayList<String> listaDatos;
    ArrayList<ProductoVO> listaProductoVO;
    MetodosSW metodosSW = new MetodosSW();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Pone el titulo de la toolabar en blanco, permitiendo que tome el titulo del toolbar
        getSupportActionBar().setTitle("");

        listView = findViewById(R.id.lvProductos);
        metodosSW.consultaProducto(this,this,this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                trasladoInformacion(position);
            }
        });


    }
    private void consulta(JSONObject response) {
        JSONArray jsonArray = response.optJSONArray("tbl_producto");
        listaProductoVO = new ArrayList<>();
        try {
            for (int i=0;i < jsonArray.length(); i++){
                ProductoVO productoVO = new ProductoVO();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                productoVO.setIdProducto(jsonObject.optInt("id_producto"));
                productoVO.setNombreProducto(jsonObject.optString("nombre_producto"));
                productoVO.setTipoProducto(jsonObject.optString("tipo_producto"));
                productoVO.setDescripcionProducto(jsonObject.optString("descripcion_producto"));
                productoVO.setPrecioProducto(jsonObject.optDouble("precio_producto"));

                listaProductoVO.add(productoVO);
            }

            listaDatos = new ArrayList<>();
            for (int i=0;i < listaProductoVO.size(); i++){
                //Muestra los datos que mostrara el listview en este caso Nombre del producto
                listaDatos.add(listaProductoVO.get(i).getNombreProducto());
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDatos);
            listView.setAdapter(arrayAdapter);

        }catch (Exception e){
            Toast.makeText(this, "Error referente a P ", Toast.LENGTH_LONG).show();
            System.err.println("C----- "+e.getCause()+" ----- "+e.getMessage());
        }
    }

    @Override
    public void onResponse(JSONObject response) {
        this.consulta(response);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error referente a ConsultaProducto " + error, Toast.LENGTH_LONG).show();
        System.err.println("C **** "+error);
    }

    private void trasladoInformacion(int position) {
        String idP, nombreP, tipoP, descripcionP, precioP;
        idP = String.valueOf(listaProductoVO.get(position).getIdProducto());
        nombreP = listaProductoVO.get(position).getNombreProducto();
        tipoP = listaProductoVO.get(position).getTipoProducto();
        descripcionP = listaProductoVO.get(position).getDescripcionProducto();
        precioP = String.valueOf(listaProductoVO.get(position).getPrecioProducto());

        Intent intent = new Intent(getApplicationContext(), DescripcionProducto.class);
        //intent.putExtra("id", idP);
        intent.putExtra("nombre", nombreP);
        intent.putExtra("tipo", tipoP);
        intent.putExtra("descripcion", descripcionP);
        intent.putExtra("precio", precioP);
        startActivity(intent);

    }


}