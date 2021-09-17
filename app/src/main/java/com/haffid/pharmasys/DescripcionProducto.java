package com.haffid.pharmasys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class DescripcionProducto extends AppCompatActivity {
    private Fragment fragment;
    private String id, nombre, tipo, descripcion, precio;
    //private Double precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_producto);
        fragment = new fragment_descripcion();
        getSupportFragmentManager().beginTransaction().add(R.id.frlDetalle,fragment).commit();
        this.obtenerDatos();
        this.trasladoFragment();

    }

    private void obtenerDatos(){
        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");
        nombre = bundle.getString("nombre");
        tipo = bundle.getString("tipo");
        descripcion = bundle.getString("descripcion");
        precio = bundle.getString("precio");
    }

    private void trasladoFragment(){
        Bundle bundle = new Bundle();
        bundle.putString("id",id);
        bundle.putString("nombre",nombre);
        bundle.putString("tipo",tipo);
        bundle.putString("descripcion",descripcion);
        bundle.putString("precio",precio);

        fragment.setArguments(bundle);

    }
}