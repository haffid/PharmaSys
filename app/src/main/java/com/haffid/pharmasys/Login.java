package com.haffid.pharmasys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.haffid.pharmasys.complementos.ClienteVO;
import com.haffid.pharmasys.complementos.MetodosSW;

import org.json.JSONArray;
import org.json.JSONObject;

public class Login extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    EditText editTextCorreoL, editTextClaveL;
    MetodosSW metodosSW = new MetodosSW();
    //Guardar sesion
    SharedPreferences preferences;

     String keypref = "pref";
     String keycorreo = "correo";
     String keyclave = "clave";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        editTextCorreoL = findViewById(R.id.edtCorreoL);
        editTextClaveL = findViewById(R.id.edtClaveL);

        //Guardar sesion
        preferences = getSharedPreferences(keypref, Context.MODE_PRIVATE);
        String name = preferences.getString(keycorreo, null);
        if (name != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
    }


    public void Registrar(View view) {
        startActivity(new Intent(getApplicationContext(),Registrar.class));
        finish();
    }

    public void Login(View view) {
        this.login();

    }

    private void login() {
        if (!editTextCorreoL.getText().toString().isEmpty() && !editTextClaveL.getText().toString().isEmpty()) {
            //Utilizamos el metodo MetodosSW
            metodosSW.loginSW(this, editTextCorreoL.getText().toString(), editTextClaveL.getText().toString(),this, this);
            editTextCorreoL.setText("");
            editTextClaveL.setText("");
        } else {
            Toast.makeText(this, "Debe llenar todos los datos", Toast.LENGTH_SHORT).show();
        }
    }

    private void resultadoConsulta(JSONObject response){
        ClienteVO clienteVO = new ClienteVO();
        JSONArray jsonArray = response.optJSONArray("tbl_cliente_Android");
        try {
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            clienteVO.setCorreoCliente(jsonObject.optString("correo_cliente"));
            clienteVO.setClaveCliente(jsonObject.optString("clave_cliente"));

            String dato = clienteVO.getCorreoCliente();
            if (!dato.equals("...")) {
                //guardar sesion
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(keycorreo,editTextCorreoL.getText().toString());
                editor.putString(keyclave,editTextClaveL.getText().toString());
                editor.commit();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
                Toast.makeText(this, "Ingreso con exito", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Usuario o Contraseña incorrectos", Toast.LENGTH_LONG).show();
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();

            }


        }catch (Exception e){
            Toast.makeText(this, "Error referente a Login ", Toast.LENGTH_LONG).show();
            System.err.println("B--- "+e.getCause()+" --- "+e.getMessage());
        }

    }

    @Override
    public void onResponse(JSONObject response) {
        this.resultadoConsulta(response);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error referente a L " + error, Toast.LENGTH_SHORT).show();
        System.err.println("L**** "+error);

    }

}