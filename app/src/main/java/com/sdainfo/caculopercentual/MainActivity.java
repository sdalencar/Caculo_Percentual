package com.sdainfo.caculopercentual;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText valor;
    private TextView percentual, valor_percentual, valor_somado;
    private SeekBar seekBar;
    private double porcentagem = 0;
    private int acrescimo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor = findViewById(R.id.etValorDeclarado);
        percentual = findViewById(R.id.tv_percentual);
        valor_percentual = findViewById(R.id.tv_valor_percentual);
        valor_somado = findViewById(R.id.tv_valor_somado);
        seekBar = findViewById(R.id.seekBarCalculo);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                valor.getText().toString();
                porcentagem = seekBar.getProgress();
                percentual.setText(String.valueOf(Math.round(porcentagem)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!valor.getText().toString().equals("")) {
                    calcuclo();
                }
            }
        });


    }

    @SuppressLint("SetTextI18n")
    private void calcuclo() {
        double valorDigitado = Double.parseDouble(valor.getText().toString());

        double calculoPercentual = valorDigitado * (porcentagem / 100);
        valor_percentual.setText(" R$ " + String.valueOf(Math.round(calculoPercentual)+".00"));

        double valorTotal = calculoPercentual + valorDigitado;
        valor_somado.setText(" R$ " + String.valueOf(valorTotal)+"0");
    }


}