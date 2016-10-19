package com.example.fabiana.trabalhop1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btAcessar;
    private Button btLimpar;
    private EditText usuarioEditText;
    private EditText senhaEditText;
    private TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btAcessar = (Button) findViewById(R.id.buttonAcessar);
        btLimpar = (Button)findViewById(R.id.buttonLimpar);
        usuarioEditText = (EditText) findViewById(R.id.usuarioEditText);
        senhaEditText = (EditText) findViewById(R.id.senhaEditText);
        resultadoTextView = (TextView) findViewById(R.id.resultadoTextView);

        btAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acessarButtonAction();
            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparButtonAction();
            }
        });
    }

    private void acessarButtonAction() {
        String usuarioInserido = usuarioEditText.getText().toString();
        String senhaInserida = senhaEditText.getText().toString();

        if (usuarioInserido.equals("Fabiana")&&
                senhaInserida.equals("123")){
            resultadoTextView.setText("Acesso OK");

            Intent newtela = new Intent(MainActivity.this, TelaTarefa.class);
            startActivity(newtela);

        } else{
            resultadoTextView.setText("Acesso Negado");
        }
    }

    private void limparButtonAction() {
    }


}
