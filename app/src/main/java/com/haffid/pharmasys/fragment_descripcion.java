package com.haffid.pharmasys;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class fragment_descripcion extends Fragment {
    //Declaramos la variables
    private String id, nombreP, tipoP, descripcionP, precioP;
    //private Double precioP;


    public fragment_descripcion() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getString("id");
            nombreP = getArguments().getString("nombre");
            tipoP = getArguments().getString("tipo");
            descripcionP = getArguments().getString("descripcion");
            precioP = getArguments().getString("precio");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_descripcion, container, false);

        TextView textViewID, textViewNombre, textViewTipo, textViewDescripcion, textViewPrecio;
        //textViewID = v.findViewById(R.id.idFrag);
        textViewNombre = v.findViewById(R.id.nombreP);
        textViewTipo = v.findViewById(R.id.tipoP);
        textViewDescripcion = v.findViewById(R.id.descripcionP);
        textViewPrecio = v.findViewById(R.id.precioP);

        //textViewID.setText(id);
        textViewNombre.setText(nombreP);
        textViewTipo.setText(tipoP);
        textViewDescripcion.setText(descripcionP);
        textViewPrecio.setText(precioP);

        return v;
    }
}