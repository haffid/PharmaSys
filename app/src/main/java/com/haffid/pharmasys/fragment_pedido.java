package com.haffid.pharmasys;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class fragment_pedido extends Fragment {
    private String precio;

    public fragment_pedido() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            precio = getArguments().getString("precio");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pedido, container, false);
        TextView textViewprecio = v.findViewById(R.id.precioP);
        //textViewID = v.findViewById(R.id.idFrag);
       // textViewNombreCliente = v.findViewById(R.id.idClienteP);
        //textViewTipo = v.findViewById(R.id.tipoP);
        //textViewDescripcion = v.findViewById(R.id.descripcionP);
        //textViewPrecio = v.findViewById(R.id.precioP);

        //textViewID.setText(id);
        //textViewNombreCliente.setText(nombrecliente);
        //textViewTipo.setText(tipoP);
        //textViewDescripcion.setText(descripcionP);
        textViewprecio.setText(precio);
        //textViewPrecio.setText(precioP);

        return v;
    }
}