package com.haffid.pharmasys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.haffid.pharmasys.complementos.ClienteVO;
import com.haffid.pharmasys.complementos.MetodosSW;
import com.haffid.pharmasys.complementos.ProductoVO;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    //Toolbar
    private Toolbar toolbar;
    SearchView searchView;
    ListView listView;
    ArrayList<String> listaDatos;
    ArrayList<ProductoVO> listaProductoVO;
    MetodosSW metodosSW = new MetodosSW();

    //cerrar sesion
    TextView textViewUser;
    SharedPreferences preferences;
    String keypref = "pref";
    String keycorreo = "correo";
    String keyclave = "clave";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Cerrar sesion
        textViewUser = findViewById(R.id.txtUser);

        preferences = getApplicationContext().getSharedPreferences(keypref, Context.MODE_PRIVATE);
        String name = preferences.getString(keycorreo, null);

        if (name != null){
            textViewUser.setText(" "+name);
        }

        //Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Pone el titulo de la toolabar en blanco, permitiendo que tome el titulo del toolbar
        getSupportActionBar().setTitle("");

        //Muestra lista de productos
        listView = findViewById(R.id.lvProductos);
        //Barra de busqueda de productos
        searchView = findViewById(R.id.buscarProducto);
        metodosSW.consultaProducto(this, this, this);

        //Al presionar sobre el producto de la lista, traslada la informacion al fragment_descripcion
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                trasladoInformacion(position);
            }
        });
    }

    //Consulta de la BD de productos
    private void consulta(JSONObject response) {
        JSONArray jsonArray = response.optJSONArray("tbl_producto");
        listaProductoVO = new ArrayList<>();
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
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
            for (int i = 0; i < listaProductoVO.size(); i++) {
                //Muestra los datos que mostrara el listview en este caso Nombre del producto
                listaDatos.add(listaProductoVO.get(i).getNombreProducto());
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDatos);
            listView.setAdapter(arrayAdapter);


            //Realiza una busqueda en la lista de productos por medio de la barra de busqueda y muesra el resultado en la lista
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    arrayAdapter.getFilter().filter(newText);
                    return false;
                }
            });
        } catch (Exception e) {
            Toast.makeText(this, "Error referente a P ", Toast.LENGTH_LONG).show();
            System.err.println("C----- " + e.getCause() + " ----- " + e.getMessage());
        }

    }


    @Override
    public void onResponse(JSONObject response) {
        this.consulta(response);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error referente a ConsultaProducto " + error, Toast.LENGTH_LONG).show();
        System.err.println("C **** " + error);
    }

    private void trasladoInformacion(int position) {
        String idP, nombreP, tipoP, descripcionP, precioP;
        idP = String.valueOf(listaProductoVO.get(position).getIdProducto());
        nombreP = listaProductoVO.get(position).getNombreProducto();
        tipoP = listaProductoVO.get(position).getTipoProducto();
        descripcionP = listaProductoVO.get(position).getDescripcionProducto();
        precioP = String.valueOf(listaProductoVO.get(position).getPrecioProducto());

        Intent intent = new Intent(getApplicationContext(), DescripcionProducto.class);
        intent.putExtra("id", idP);
        intent.putExtra("nombre", nombreP);
        intent.putExtra("tipo", tipoP);
        intent.putExtra("descripcion", descripcionP);
        intent.putExtra("precio", precioP);
        startActivity(intent);
    }

    public void salir(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
        Toast.makeText(this, "Sesión cerrada", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }

    public void home(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}