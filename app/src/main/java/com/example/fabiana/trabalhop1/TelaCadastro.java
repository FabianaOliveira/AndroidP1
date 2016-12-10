package com.example.fabiana.trabalhop1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog.Builder;
import android.widget.Toast;

public class TelaCadastro extends Activity {

    private Usuario usuario = new Usuario();
    private EditText editCadastraNome, editEmail ;
    private Button btnCadastrar , btnLimpar;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);

        editCadastraNome = (EditText) findViewById(R.id.editTextCadastraNome);
        editEmail = (EditText) findViewById(R.id.editTextEmail);
        btnCadastrar = (Button) findViewById(R.id.btCadastrar);
        btnLimpar = (Button)findViewById(R.id.btLimpar);

        //db = openOrCreateDatabase("ContatosDB", Context.MODE_PRIVATE, null);
        //db.execSQL("CREATE TABLE IF NOT EXISTS contatos (Nome VARCHAR, Matricula VARCHAR, Email VARCHAR, Git VARCHAR);");

        Intent intent = getIntent();
        if(intent !=null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){

                usuario.setId(bundle.getInt("id"));
                usuario.setNome(bundle.getString("nome"));
                usuario.setEmail(bundle.getString("email"));

                editCadastraNome.setText(usuario.getNome());
                editEmail.setText(usuario.getEmail());

                btnCadastrar.setVisibility(View.GONE);
                btnLimpar.setVisibility(View.GONE);
            }
        }
    }

    public void salvarUsuario(View view){

    usuario.setNome(editCadastraNome.getText().toString());
    usuario.setEmail(editEmail.getText().toString());

        BD bd = new BD(this);
        bd.inserir(usuario);

        Toast.makeText(this, "Usuario inserido com sucesso!", Toast.LENGTH_LONG).show();
    }

    public void editarUsuari(View view){
        usuario.setNome(editCadastraNome.getText().toString());
        usuario.setEmail(editEmail.getText().toString());

        BD bd = new BD(this);
        bd.atualizar(usuario);

        Toast.makeText(this, "Usuário \""+usuario.getNome()+"\" atualizado com sucesso.", Toast.LENGTH_SHORT).show();
    }

    public void btCadastrar (View view){

            if(editCadastraNome.getText().toString().trim().length()==0 || editEmail.getText().toString().trim().length()==0  )
            {
                showMessage("Erro", "Preencha corretamente todos os campos");
                return;
            }

            //db.execSQL("INSERT INTO contatos VALUES('"+editCadastraNome.getText()+"','"+editMatricula.getText()+"','"+editEmail.getText()+"',"+editContaGit.getText()+"');");
            // showMessage("OK","Dados Gravados");
            //clearText();
    }


    public void btLimpar (View view){

            if( editCadastraNome.getText().toString().trim().length()==0)
            {
                showMessage("Erro", "Entre com o Nome");
                return;
            }

            //Cursor c=db.rawQuery("SELECT * FROM contatos WHERE Nome = '"+editCadastraNome.getText()+"'",null);
            //if (c.moveToFirst())
            //{
            //    db.execSQL("DELETE FROM contatos WHERE Nome='"+editCadastraNome.getText()+"'");
            //    showMessage("Sucesso", "Dados Deletados");
            //}
            //else
            //{
            //    showMessage("Erro", "Inválido");
            //}
            //clearText();

       // }


    public void showMessage(String title, String message){
            Builder builder=new Builder(this);
            builder.setCancelable(true);
            builder.setTitle(title);
            builder.setMessage(message);
            builder.show();
    }


    public void clearText(){
            editCadastraNome.setText("");
            editEmail.setText("");
    }

    public void limparcampos(View view){
        editCadastraNome.setText("");
        editEmail.setText("");
    }

}
