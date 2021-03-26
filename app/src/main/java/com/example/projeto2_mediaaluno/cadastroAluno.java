package com.example.projeto2_mediaaluno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class cadastroAluno extends AppCompatActivity {
    private TextView prova1, prova2, prova3, mf, st;
    private Button calcular, limpar, enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calcular = (Button)findViewById(R.id.btCalcular);
        limpar = (Button)findViewById(R.id.btLimpar);
        enviar = (Button)findViewById(R.id.btEnviar);

        //Inputs
        prova1 = findViewById(R.id.p1);
        prova2 = findViewById(R.id.p2);
        prova3 = findViewById(R.id.p3);

        //Outputs
        mf = findViewById(R.id.mediaFinal);
        st = findViewById(R.id.status);

        DecimalFormat df = new DecimalFormat("0.00");

        float iP1 = Float.parseFloat(getIntent().getStringExtra("prova1"));
        float iP2 = Float.parseFloat(getIntent().getStringExtra("prova2"));
        float iP3 = Float.parseFloat(getIntent().getStringExtra("prova3"));

        prova1.setText(String.valueOf(df.format(iP1)));
        prova2.setText(String.valueOf(df.format(iP2)));
        prova3.setText(String.valueOf(df.format(iP3)));

        String msg = getIntent().getStringExtra("mediafinal");
        String sitacao = getIntent().getStringExtra("status");

        mf.setText(msg);
        st.setText(sitacao);
        //st.setTextColor(cor);
    }
}