package com.example.projeto2_mediaaluno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView prova1, prova2, prova3, mf, st;
    private Button calcular, limpar, enviar;
    private int cor = Color.parseColor("#FF0000");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fCalcular(view);
            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fLimpar(view);
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fEnviar(view);
            }
        });
    }

    public void fLimpar(View view) {
        prova1.setText("");
        prova2.setText("");
        prova3.setText("");
        mf.setText("");
        st.setText("");
    }

    public void fCalcular(View view) {
        try {
            DecimalFormat df = new DecimalFormat("0.00");

            float iP1 = Float.parseFloat(prova1.getText().toString());
            float iP2 = Float.parseFloat(prova2.getText().toString());
            float iP3 = Float.parseFloat(prova3.getText().toString());

            prova1.setText(String.valueOf(df.format(iP1)));
            prova2.setText(String.valueOf(df.format(iP2)));
            prova3.setText(String.valueOf(df.format(iP3)));

            float resultado = (iP1 * 2 + iP2 * 3)/5;
            String sitacao = "Reprovado";

            if ( (resultado < 6.0) && ( (iP3 > iP1) || (iP3 > iP2) ) ) {
                if (iP1 > iP2) {
                    resultado = (iP1 * 2 + iP3 * 3) / 5;
                } else if (iP1 < iP2){
                    resultado = (iP3 * 2 + iP2 * 3) / 5;
                } else {
                    resultado = (iP1 * 2 + iP3 * 3) / 5;
                }
            }

            cor = Color.parseColor("#FF0000");
            if (resultado >= 6.0) {
                sitacao = "Aprovado";
                cor = Color.parseColor("#0000FF");
            }

            if( (iP1 > 10 || iP1 < 0) || (iP2 > 10 || iP2 < 0) || (iP3 > 10 || iP3 < 0) ) {
                resultado = 0;
                cor = Color.parseColor("#FF0000");
                sitacao = "A nota deve ser entre 0.00 e 10.00";
            }

            String msg = "Média Final: " + String.valueOf(df.format(resultado));
            mf.setText(msg);
            st.setText(sitacao);
            st.setTextColor(cor);

        } catch (Exception e) {
            cor = Color.parseColor("#FF00FF");
            e.printStackTrace();
            st.setText("Inválido");
            st.setTextColor(cor);
        }
    }

    public void fEnviar(View view) {
        Intent intent = new Intent(getApplicationContext(), cadastroAluno.class);
        intent.putExtra("prova1", prova1.getText().toString());
        intent.putExtra("prova2", prova2.getText().toString());
        intent.putExtra("prova3", prova3.getText().toString());
        intent.putExtra("mediafinal", mf.getText().toString());
        intent.putExtra("status", st.getText().toString());
        intent.putExtra("cor", cor);
        startActivity(intent);
    }
}