package br.com.cadernorapido.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import br.com.cadernorapido.AdapterUsuarios.AdapterAlmocos;
import br.com.cadernorapido.AdapterUsuarios.AdapterUsuarios;
import br.com.cadernorapido.R;
import br.com.cadernorapido.databinding.ActivityMainBinding;
import br.com.cadernorapido.model.Almoco;
import br.com.cadernorapido.model.AlmocoDao;
import br.com.cadernorapido.model.Usuarios;
import br.com.cadernorapido.model.UsuariosDao;

public class ListaAlmocosActivity extends AppCompatActivity {

    public static final String USUARIO_ID = "USUARIO_ID";
    ActivityMainBinding binding;
    Long usuarioId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(ListaAlmocosActivity.this, R.layout.activity_main);

        getActionBar().setTitle("Lista de almoços");

        Bundle b = getIntent().getExtras();
        usuarioId = b.getLong(USUARIO_ID);

        loadListView();

    }

    public void loadListView() {
        List<Almoco> listAlmoco = Almoco.getDaoSession().queryBuilder().where(AlmocoDao.Properties.UsuarioID.eq(usuarioId)).list();

        if (listAlmoco.size() > 0) {
            AdapterAlmocos adapterAlmocos = new AdapterAlmocos(listAlmoco, this);
            binding.listView.setAdapter(adapterAlmocos);
            adapterAlmocos.notifyDataSetChanged();
        } else {
            Toast.makeText(this, "Usuário não possui almoços!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
