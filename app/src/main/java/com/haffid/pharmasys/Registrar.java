package com.haffid.pharmasys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.haffid.pharmasys.complementos.MetodosSW;

import org.json.JSONObject;

public class Registrar extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    EditText editTextNombreR, editTextApellidoR, editTextDireccionR, editTextCorreoR, editTextClaveR;
    MetodosSW metodosSW = new MetodosSW();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        editTextNombreR = findViewById(R.id.edtNombreR);
        editTextApellidoR = findViewById(R.id.edtApellidoR);
        editTextDireccionR = findViewById(R.id.edtDireccionR);
        editTextCorreoR = findViewById(R.id.edtCorreoR);
        editTextClaveR = findViewById(R.id.edtClaveR);
    }

    public void LoginR(View view) {
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }

    public void RegistrarR(View view) {
        if (!editTextNombreR.getText().toString().isEmpty() && !editTextApellidoR.getText().toString().isEmpty()
                && !editTextDireccionR.getText().toString().isEmpty() && !editTextCorreoR.getText().toString().isEmpty()
                && !editTextClaveR.getText().toString().isEmpty()) {
            //Utilizamos el metodo MetodosSW
            metodosSW.insertarSW(this, editTextNombreR.getText().toString(), editTextApellidoR.getText().toString(),
                    editTextDireccionR.getText().toString(), editTextCorreoR.getText().toString(), editTextClaveR.getText().toString(),this, this);
            editTextNombreR.setText("");
            editTextApellidoR.setText("");
            editTextDireccionR.setText("");
            editTextCorreoR.setText("");
            editTextClaveR.setText("");
            startActivity(new Intent(getApplicationContext(),Login.class));
            finish();
        } else {
            Toast.makeText(this, "Debes llenar todos los datos", Toast.LENGTH_SHORT).show();
        }
    }

    private void insertar() {

    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this, "Tu registro fue exitoso", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error referente a " + error, Toast.LENGTH_SHORT).show();
        System.err.println("I**** "+error);
    }


}