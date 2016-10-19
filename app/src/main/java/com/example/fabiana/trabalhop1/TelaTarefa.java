package com.example.fabiana.trabalhop1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

/**
 * Created by Fabiana on 18/10/2016.
 */
public class TelaTarefa extends AppCompatActivity {

    private Spinner spinnerCurso;
    private Spinner spinnerAula;
    private TextView aula;
    private CheckBox exercicio;
    private CheckBox laboratorio;
    private ProgressBar progressoBar;
    private Button progresso;
    private Button cadastro;
    private Button sair;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_tarefa);

        spinnerCurso = (Spinner) findViewById(R.id.spinnerCurso);
        spinnerAula = (Spinner) findViewById(R.id.spinnerAula);
        aula = (TextView) findViewById(R.id.textViewTarefa);
        exercicio = (CheckBox) findViewById(R.id.checkBoxExec);
        laboratorio = (CheckBox) findViewById(R.id.checkBoxLab);
        progressoBar = (ProgressBar) findViewById(R.id.progressBarTarefa);
        progresso = (Button) findViewById(R.id.bt_Progresso);
        cadastro = (Button) findViewById(R.id.bt_Cadastro);
        sair = (Button) findViewById(R.id.bt_Sair);

        spinnerCurso.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                progressoBar.setProgress(0);
                exercicio.setChecked(false);
                laboratorio.setChecked(false);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerAula.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String aulaSelecionada = (String) parent.getItemAtPosition(position);
                aula.setText(aulaSelecionada.toString());
                progressoBar.setProgress(0);
                exercicio.setChecked(false);
                laboratorio.setChecked(false);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        exercicio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PreencheBarra();
            }
        });

        laboratorio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PreencheBarra();
            }
        });

        progresso.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent newtela = new Intent(TelaTarefa.this, TelaProgresso.class);
                startActivity(newtela);
            }
        });

        cadastro.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent newtela = new Intent(TelaTarefa.this, TelaCadastro.class);
                startActivity(newtela);
            }
        });

        sair.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent trocadorTela = new Intent(TelaTarefa.this, MainActivity.class);
                startActivity(trocadorTela);
            }
        });

    }
    private void PreencheBarra(){
        if(exercicio.isChecked() && laboratorio.isChecked()){
            progressoBar.setProgress(100);
        }else if(exercicio.isChecked()){
            progressoBar.setProgress(50);
        }else if(laboratorio.isChecked()){
            progressoBar.setProgress(50);
        }else{
            progressoBar.setProgress(0);
        }
    }


}
