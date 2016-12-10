package com.example.fabiana.trabalhop1;

import android.app.ListActivity;
import android.os.Bundle;

import java.util.List;

/**
 * Created by casa on 10/12/2016.
 */
public class ListUserActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BD bd = new BD(this);

        List<Usuario> list = bd.buscar();
        setListAdapter(new UsuarioAdapter(this, list));

    }
}
