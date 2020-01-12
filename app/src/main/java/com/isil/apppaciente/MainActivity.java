package com.isil.apppaciente;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //delaracion
    TextView resultado;
    RadioGroup radio_group;
    EditText cantidad;
    DecimalFormat df = new DecimalFormat("0.00");
    String mensaje = "";
    double cant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //extraccion de datos por id

        radio_group = findViewById(R.id.radioGroup);
        resultado = findViewById(R.id.txtresultado);
        cantidad = findViewById(R.id.txtcantidad);

    }

    public void calcular(View view) {

        double precio=0;
        switch (radio_group.getCheckedRadioButtonId()) {

            case R.id.rb1:
                precio = 200.0;
                break;
            case R.id.rb12:
                precio = 350.0;
                break;
            case R.id.rb13:
                precio = 420.0;
                break;
            default:
                mensaje = "Seleccione una opcion";

        }

        if (!cantidad.getText().toString().isEmpty()){
            cant = Integer.parseInt(cantidad.getText().toString());
        }

        else {
            mensaje = mensaje + "\n" +
                    "Debe asignar una cantidad";

        }

        if (mensaje.isEmpty()) {

            double precioTotal = cant * precio;
            resultado.setText("Precio Total: S/." + df.format(precioTotal ));
        } else {
            resultado.setText(mensaje);
            borrar();

        }

    }
    void borrar(){
        mensaje="";
    }

}


