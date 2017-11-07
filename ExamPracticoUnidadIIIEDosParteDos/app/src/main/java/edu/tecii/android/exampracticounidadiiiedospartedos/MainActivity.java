package edu.tecii.android.exampracticounidadiiiedospartedos;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {

    EditText texto;
    String listaDeProductos ="";
   /*String t1 ="";
   String t2 ="";
    String t3 ="";
    String t4 ="";
    String t5 ="";
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (EditText) findViewById(R.id.editTextRe);
        cargar();
    }


    public void cargar(){
        SharedPreferences sp;
       Context mContext;
        try{
            //Se creo un contexto para acceder a la informacion guardada por otra aplicacion
        mContext = createPackageContext("edu.tecii.android.exampracticounidadiiiedos",MODE_PRIVATE);
            //SharedPreferences sp = getSharedPreferences("archivo",Context.MODE_PRIVATE);
        sp = mContext.getSharedPreferences("archivo", MODE_PRIVATE);
       listaDeProductos = sp.getString("lista","Error");
       /*
        t1 = sp.getString("cant","cantidad");
        t2 = sp.getString("nomb","nomb");
        t3 = sp.getString("prove","proveedor");
        t4 = sp.getString("marca", "marca");
        t5 = sp.getString("pU","Precio");
        */

        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }
        texto.setText(listaDeProductos);

    }

}
