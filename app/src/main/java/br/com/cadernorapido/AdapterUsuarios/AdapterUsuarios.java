package br.com.cadernorapido.AdapterUsuarios;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.cadernorapido.R;
import br.com.cadernorapido.model.Usuarios;

public class AdapterUsuarios extends BaseAdapter {

    List<Usuarios> listaUsuarios;
    Activity activity;

    public AdapterUsuarios(List<Usuarios> listaUsuarios, Activity activity) {
        this.listaUsuarios = listaUsuarios;
        this.activity = activity;
    }


    @Override
    public int getCount() {
        // select count(1) from Pessoas;
        return listaUsuarios.size();
    }

    @Override
    public Object getItem(int i) {
        // select * from Pessoas where id_pessoa = 1;
        return listaUsuarios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Usuarios usuario = listaUsuarios.get(i);
        view = activity.getLayoutInflater().inflate(R.layout.item_usuario, viewGroup, false);

        TextView nomeUsuario = view.findViewById(R.id.tVnomeUsuario);
        TextView senhaUsuario = view.findViewById(R.id.tvSenhaUsuario);

        senhaUsuario.setText(usuario.getSenha());
        nomeUsuario.setText(usuario.getUser());
        return view;
    }
}
