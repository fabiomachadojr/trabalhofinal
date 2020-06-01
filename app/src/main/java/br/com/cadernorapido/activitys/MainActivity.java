package br.com.cadernorapido.activitys;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import java.util.List;

import br.com.cadernorapido.AdapterUsuarios.AdapterUsuarios;
import br.com.cadernorapido.R;
import br.com.cadernorapido.databinding.ActivityMainBinding;
import br.com.cadernorapido.model.Usuarios;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        getSupportActionBar().setTitle("Lista Usuario");

        loadListView();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_sair) {
            Usuarios.deslogarUsuario();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    public void loadListView() {
        AdapterUsuarios adapterUsuarios = new AdapterUsuarios(Usuarios.getDaoSession().loadAll(), this);
        binding.listView.setAdapter(adapterUsuarios);
        adapterUsuarios.notifyDataSetChanged();

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Usuarios usuarios = Usuarios.getDaoSession().loadAll().get(i);

                Intent intent = new Intent(MainActivity.this, ListaAlmocosActivity.class);
                intent.putExtra(ListaAlmocosActivity.USUARIO_ID, usuarios.getId());
                startActivity(intent);
            }
        });

    }
}
