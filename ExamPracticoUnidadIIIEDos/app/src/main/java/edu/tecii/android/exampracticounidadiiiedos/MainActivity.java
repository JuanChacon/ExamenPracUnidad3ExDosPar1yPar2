package edu.tecii.android.exampracticounidadiiiedos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//cinco datos
public class MainActivity extends AppCompatActivity {

    EditText cant;
    EditText nom;
    EditText provee;
    EditText marca;
    EditText preUni;

    Button gua;
    ArrayList<String> ListaDePro =  new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cant = (EditText) findViewById(R.id.editCant);
        nom = (EditText) findViewById(R.id.editNom);
        provee = (EditText) findViewById(R.id.editProve);
        marca = (EditText) findViewById(R.id.editMarca);
        preUni = (EditText) findViewById(R.id.editPre);

        gua =  (Button) findViewById(R.id.buttonGu);

        gua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            guardar();
            }
        });


    }

    public void guardar(){
        //se agregan los datos a la lista
        ListaDePro.add("\nCantidad: " + " " +cant.getText().toString() +
          "\nNombre: " + " " + nom.getText().toString()
        + "\nProveedor: " + " " +provee.getText().toString()+
          "\nMarca: " + " " +marca.getText().toString()+
          "\nPrecio Unitario: " + " " + preUni.getText().toString());
        String lista = "";
        //For para recorrer la lista de objetos y guardarlos en una variable string
        for (String val : ListaDePro) {
            lista += val + "\t" ;
        }
                //getSharedPreferences("archivo",MODE_APPEND);
        //Clase SharedPrerefences, se uso para guardar la informacion
        SharedPreferences.Editor edi = getSharedPreferences("archivo",MODE_PRIVATE).edit();
        edi.putString("lista", lista);
       // System.out.println(cant.getText().toString());
       /*
       edi.putString("cant","\nCantidad: " + " " +cant.getText().toString());
       edi.putString("nomb", "\nNombre: " + " " +nom.getText().toString());
        edi.putString("prove", "\nProveedor: " + " " +provee.getText().toString());
        edi.putString("marca", "\nMarca: " + " " +marca.getText().toString());
        edi.putString("pU", "\nPrecio Unitario: " + " " + preUni.getText().toString());
        */
        edi.commit();

    }

    public void onStop(){
        super.onStop();
        guardar();
    }

}
