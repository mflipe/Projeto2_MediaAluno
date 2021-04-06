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
    private TextView prova1, prova2, prova3, mf, st, disciplina, aluno, faltas, resultado;
    private Button shareResult;
    private int cor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);

        Bundle bundle = getIntent().getExtras();
        cor = bundle.getInt("cor", Color.parseColor("#FF0000"));

        shareResult = (Button) findViewById(R.id.btCompartilhar);

        //Inputs
        prova1 = findViewById(R.id.p12);
        prova2 = findViewById(R.id.p22);
        prova3 = findViewById(R.id.p32);

        prova1.setText(getIntent().getStringExtra("prova1"));
        prova2.setText(getIntent().getStringExtra("prova2"));
        prova3.setText(getIntent().getStringExtra("prova3"));

        //Outputs
        mf = findViewById(R.id.mediaFinal2);
        st = findViewById(R.id.status2);

        DecimalFormat df = new DecimalFormat("0.00");

        String msg = getIntent().getStringExtra("mediafinal");
        String sitacao = getIntent().getStringExtra("status");

        mf.setText(msg);
        st.setText(sitacao);
        st.setTextColor(cor);

        //
        disciplina = findViewById(R.id.nomeDisciplina);
        aluno = findViewById(R.id.nomeAluno);
        faltas = findViewById(R.id.nFaltas);
        resultado = findViewById(R.id.resultado2);


        shareResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compartilhar(view);
            }
        });
    }

    public void compartilhar(View view) {

        if (aluno.length() <= 0 || disciplina.length() <= 0) {
            resultado.setText("Por favor informe corretamente os dados!");
            return;
        } else {
            //"O aluno João foi Reprovado com média 5,00 em Programação WEB, com as notas P1 = 5,00, P2=4,00 e P3=5,00, e 12 faltas!"
            resultado.setText("Ok!");
            String subject = aluno.getText() + " - Resultado em " +  disciplina.getText();
            String mensagem = "O(A) aluno(a) " + aluno.getText() + " foi " + st.getText() + " com " + mf.getText() + " em " + disciplina.getText() + " com as notas P1: " + prova1.getText() + ", P2: " + prova2.getText() + ", P3: " + prova3.getText() + ", e " + faltas.getText() + " faltas!";
            resultado.setText(mensagem);

            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(intent.EXTRA_SUBJECT, subject);
            intent.putExtra(intent.EXTRA_TEXT, mensagem);
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent, "Compartilhar com " + aluno.getText()));
        }
    }

}