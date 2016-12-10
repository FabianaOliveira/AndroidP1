package com.example.fabiana.trabalhop1;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by casa on 10/12/2016.
 */
public class UsuarioAdapter extends BaseAdapter {

    private Context context;
    private List<Usuario> list;

    public UsuarioAdapter(Context context, List<Usuario> list){
        this.context = context;
        this.list = list;
    }

    public int getCount(){
        return list.size();
    }

    public Object getItem(int arg0){
        return list.get(arg0);
    }

    public long getItemId(int arg0){
        return list.get(arg0).getId();
    }

    public View getView(int position, View arg1, ViewGroup arg2){
        final int auxPosition = position;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.tela_cadastro,null);

        TextView tv = (TextView) layout.findViewById(R.id.editTextCadastraNome);
        tv.setText(list.get(position).getNome());

        Button btnCadastrar = (Button) layout.findViewById(R.id.btCadastrar);
        btnCadastrar.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View arg0){
                Intent intent = new Intent(context, TelaCadastro.class);
                intent.putExtra("nome", list.get(auxPosition).getNome());
                intent.putExtra("email", list.get(auxPosition).getEmail());
                intent.putExtra("id", list.get(auxPosition).getId());
            }
        });

        Button btnLimpar = (Button) layout.findViewById(R.id.btLimpar);
        btnLimpar.setOnClickListener (new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                BD bd = new BD(context);
                bd.deletar(list.get(auxPosition));

                layout.setVisibility(View.GONE);
            }
        });
        return layout;
    }

}
