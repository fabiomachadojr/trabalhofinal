package br.com.cadernorapido.AdapterUsuarios;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.cadernorapido.R;
import br.com.cadernorapido.model.Almoco;
import br.com.cadernorapido.model.Usuarios;

public class AdapterAlmocos extends BaseAdapter {

    List<Almoco> almocoList;
    Activity activity;

    public AdapterAlmocos(List<Almoco> almocoList, Activity activity) {
        this.almocoList = almocoList;
        this.activity = activity;
    }


    @Override
    public int getCount() {
        // select count(1) from Pessoas;
        return almocoList.size();
    }

    @Override
    public Object getItem(int i) {
        // select * from Pessoas where id_pessoa = 1;
        return almocoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Almoco almoco = almocoList.get(i);
        view = activity.getLayoutInflater().inflate(R.layout.item_usuario, viewGroup, false);
        TextView nome = view.findViewById(R.id.tvNome);
        TextView senha = view.findViewById(R.id.tvSenha);

        nome.setText("Valor:");
        senha.setText("Data:");

        TextView nomeUsuario = view.findViewById(R.id.tVnomeUsuario);

        TextView senhaUsuario = view.findViewById(R.id.tvSenhaUsuario);

        senhaUsuario.setText(almoco.getData().toString());
        nomeUsuario.setText(String.valueOf(almoco.getValor()));
        return view;
    }
}
