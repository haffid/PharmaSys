package com.haffid.pharmasys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DescripcionProducto extends AppCompatActivity {
    private Fragment fragment;
    private String id, nombre, tipo, descripcion, precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_producto);

        //Fragmento del producto
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

    public void comprar(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        intent.putExtra("id", id);
        intent.putExtra("precio", precio);
        intent.putExtra("nombre",nombre);
        startActivity(intent);

    }
}