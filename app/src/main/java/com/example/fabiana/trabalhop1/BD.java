package com.example.fabiana.trabalhop1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by casa on 10/12/2016.
 */
public class BD {
    private SQLiteDatabase bd;

    public BD(Context context){
        BDCore auxBd = new BDCore(context);
        bd = auxBd.getWritableDatabase();
    }

    public void inserir(Usuario usuario){
        ContentValues valores = new ContentValues();
        valores.put("nome", usuario.getNome());
        valores.put("matricula", usuario.getMatricula());
        valores.put("email", usuario.getEmail());
        valores.put("git", usuario.getGit());

        bd.insert("usuario", null, valores);
    }

    public void atualizar(Usuario usuario){
        ContentValues valores = new ContentValues();
        valores.put("nome", usuario.getNome());
        valores.put("matricula", usuario.getMatricula());
        valores.put("email", usuario.getEmail());
        valores.put("git", usuario.getGit());

        bd.update("usuario", valores, "_id = ?", new String[]{""+usuario.getId(),usuario.getNome()});
    }

    public void deletar(Usuario usuario){
        bd.delete("usuario", "_id = "+usuario.getId(), null);
    }

    public List<Usuario> buscar(){
        List<Usuario> list = new ArrayList<Usuario>();
        String[] colunas = new String[]{"_id", "nome", "email"};

        Cursor cursor = bd.query("usuario", colunas, null, null, null, null, "nome ASC");

        if(cursor.getCount() > 0 ){
            cursor.moveToFirst();

            do{
                Usuario u = new Usuario();
                u.setId(cursor.getInt(0));
                u.setNome(cursor.getString(1));
                u.setMatricula(cursor.getString(2));
                u.setEmail(cursor.getString(3));
                u.setGit(cursor.getString(4));
                list.add(u);
            }while(cursor.moveToNext());
        }
        return (list);
    }

}
