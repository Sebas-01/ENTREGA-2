package com.sebas.calcular;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import javax.xml.transform.Result;

public class Resultados extends AppCompatActivity {

    TextView resultadoSeno,resultadoCoseno,resultadoArea,resultadoPerimetro,ResultadoSEN,ResultadoCOS,
    ResultadoA,ResultadoPER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        resultadoSeno=findViewById(R.id.resultSeno);
        resultadoCoseno=findViewById(R.id.resultCoseno);
        resultadoArea=findViewById(R.id.resultArea);
        resultadoPerimetro=findViewById(R.id.resultPerimetro);
        ResultadoSEN=findViewById(R.id.Seno);
        ResultadoCOS=findViewById(R.id.Coseno);
        ResultadoA=findViewById(R.id.Area);
        ResultadoPER=findViewById(R.id.Perimetro);

        int [] Resulta2= getIntent().getIntArrayExtra("Result");

        for (int i=0;i<Resulta2.length;i++){
            if(i == 0){
                String SENO= String.valueOf(Resulta2[i]);
                resultadoSeno.setText(SENO);
            } else if (i==1) {
               String COSENO = String.valueOf(Resulta2[i]);
                resultadoSeno.setText(COSENO);
            } else if (i==2) {
               String AREA=String.valueOf(Resulta2[i]);
                resultadoSeno.setText(AREA);
            }else {
               String PERIMETRO=String.valueOf(Resulta2[i]);
                resultadoSeno.setText(PERIMETRO);
            }
        };




    }
}