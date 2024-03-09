package com.sebas.calcular;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Seno, Coseno, Area, Perimetro;
    EditText Opuesto, Hipotenusa, Adyacente, HipotenusaCos,Base,Altura,BasePer,AlturaPer;
    Button BtnEnviar;
    String Tag ="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Thread.sleep(4000);
        setTheme(R.style.Theme_Calcular);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Seno = (TextView)findViewById(R.id.seno);
        Coseno = (TextView)findViewById(R.id.coseno);
        Area = (TextView)findViewById(R.id.area);
        Perimetro = (TextView)findViewById(R.id.perimetro);

        Opuesto=(EditText) findViewById(R.id.opuesto);
        Hipotenusa=(EditText) findViewById(R.id.hipotenusa);
        Adyacente=(EditText) findViewById(R.id.adyacente);
        HipotenusaCos=(EditText) findViewById(R.id.hipotenusaCos);
        Base=(EditText) findViewById(R.id.base);
        Altura=(EditText) findViewById(R.id.altura);
        BasePer=(EditText) findViewById(R.id.basePer);
        AlturaPer=(EditText) findViewById(R.id.alturaPer);

        BtnEnviar = findViewById(R.id.btnEnviar);



        BtnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              enviarResultados();
            }
        });

    }

    //Guardar en un string
    String numOpuesto = Opuesto.getText().toString();
    String numHipotenusa = HipotenusaCos.getText().toString();
    String numAdyacente = Adyacente.getText().toString();
    String numHipotenusaCos = HipotenusaCos.getText().toString();
    String numBase = Base.getText().toString();
    String numAltura = Altura.getText().toString();
    String numBasePer = BasePer.getText().toString();
    String numAlturaPer = AlturaPer.getText().toString();




    public int[] calcular(String numOpuesto, String numHipotenusa, String numAdyacente, String numHipotenusaCos,
                          String numBase, String numAltura, String numBasePer, String numAlturaPer){

        // convertir la cadena string en numeros enteros
        int numberOpuesto = Integer.parseInt(numOpuesto);
        int numberHipotenusa = Integer.parseInt(numHipotenusa);
        int numberAdyacente = Integer.parseInt(numAdyacente);
        int numberHipotenusaCos = Integer.parseInt(numHipotenusaCos);
        int numberBase = Integer.parseInt(numBase);
        int numberAltura = Integer.parseInt(numAltura);
        int numberBasePer = Integer.parseInt(numBasePer);
        int numberAlturPer = Integer.parseInt(numAlturaPer);

        int resultadoSeno = numberOpuesto/numberHipotenusa;
        int resultadoCoseno = numberAdyacente/numberHipotenusaCos;
        int resultadoArea = (numberBase * numberAltura) /  2;
        int resultadoPerimetro = (numberBasePer + numberBasePer) * 2;

        int [] resultados = { resultadoSeno,resultadoCoseno,resultadoArea,resultadoPerimetro, };

        return resultados ;
    };

    public void enviarResultados(){

        int [] arreglo = calcular(numOpuesto,numHipotenusa,numAdyacente,numHipotenusaCos,numBase,numAltura,numBasePer,numAlturaPer);

        Intent pasarResultados = new Intent(this,Resultados.class);
        pasarResultados.putExtra("Result",arreglo);
        startActivity(pasarResultados);

    };

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Tag,"Deseas hacer un nuevo calculo?");
    }
}