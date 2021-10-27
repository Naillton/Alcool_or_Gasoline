package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText alcool;
    private TextInputEditText gasoline;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.alcool = findViewById(R.id.alcool);
        this.gasoline = findViewById(R.id.gasolina);
        this.resultado = findViewById(R.id.resultText);
    }

    public void calc(View view) {
        String result = "";
        String priceAlcool = alcool.getText().toString();
        String priceGasoline = gasoline.getText().toString();
        Boolean validate = validateFields(priceAlcool, priceGasoline);
        //se validade for verdade e os campos estiverem completos faremos os calculos para saber qual a melhor opcao
        if(validate){
            Double valueAlcool = Double.parseDouble(priceAlcool);
            Double valueGasoline = Double.parseDouble(priceGasoline);
            double cont = valueAlcool / valueGasoline;
            if(cont >= 0.7){
                result = "Melhor utilizar gasolina";
            }else{
                result = "Melhor utilizar alcool";
            }

            resultado.setText(result);

        }else {
            resultado.setText("Preencha os precos primeiro!");
        }
    }
    //metodo para saber se os campos estao completos ou nulos
    public Boolean validateFields(String pAlcool, String pGasoline){
        Boolean validate = true;
        if(pAlcool == null || pAlcool.equals("") && pGasoline == null || pGasoline.equals("")){
            validate = false;
        }
        return validate;
    }
}