package com.example.fabiana.trabalhop1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Fabiana on 18/10/2016.
 */
public class TelaProgresso extends Activity {


    private Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_progresso);


        voltar = (Button) findViewById(R.id.bt_Voltar);

        voltar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent trocadorTela = new Intent(TelaProgresso.this, TelaTarefa.class);
                startActivity(trocadorTela);
            }
        });
    }
}
