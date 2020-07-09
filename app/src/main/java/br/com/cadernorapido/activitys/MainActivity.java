package br.com.cadernorapido.activitys;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import br.com.cadernorapido.AdapterUsuarios.AdapterUsuarios;
import br.com.cadernorapido.service.CustomSnackBar;
import br.com.cadernorapido.service.CustomToast;
import br.com.cadernorapido.service.FeedBackManager;
import br.com.cadernorapido.R;
import br.com.cadernorapido.databinding.ActivityMainBinding;
import br.com.cadernorapido.model.Usuarios;
import br.com.cadernorapido.service.SynchronizationService;
import br.com.cadernorapido.task.MyTask;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Intent syncService;
    private AdapterUsuarios adapterUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        getSupportActionBar().setTitle("Lista Usuario");

        loadListView();
        initSynchronization();

        binding.fabAddCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroUsuariosActivity.class);
                startActivity(intent);
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Usuarios.getUsuarioAtivo() == null) {
            finish();
        }
        loadListView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(syncService);
    }

    public void initSynchronization() {
        syncService = new Intent(this, SynchronizationService.class);
        startService(syncService);
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
        if (item.getItemId() == R.id.action_sincronizar) {
            new MyTask(new MyTask.OnFinishListener() {
                @Override
                public void onFinishListener() {
                    Toast.makeText(MainActivity.this, "Dados sincronizados!", Toast.LENGTH_SHORT).show();
                }
            });
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    public void loadListView() {
        adapterUsuarios = new AdapterUsuarios(Usuarios.getDaoSession().loadAll(), this);
        binding.listView.setAdapter(adapterUsuarios);
        adapterUsuarios.notifyDataSetChanged();
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mostrarDialogo(i);

            }
        });
        binding.listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Usuarios usuarios = Usuarios.getDaoSession().loadAll().get(position);
                Intent intent = new Intent(MainActivity.this, EditarUsuariosActivity.class);
                Bundle bd = new Bundle();
                bd.putLong("id",usuarios.getId());
                intent.putExtras(bd);
                startActivity(intent);
                return false;
            }
        });

    }

    private void mostrarDialogo(int i) {
        final Usuarios usuarios = Usuarios.getDaoSession().loadAll().get(i);
        final AlertDialog alerta;
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Cancelamento");
        builder.setMessage("Tem certeza que deseja cancelar?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                usuarios.delete();
                loadListView();
                FeedBackManager feedBackManager = new FeedBackManager(binding.getRoot());
                feedBackManager.showSpeclMessage(new CustomToast());
            }
        });
        builder.setNegativeButton("Negativo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                FeedBackManager feedBackManager = new FeedBackManager(binding.getRoot());
                feedBackManager.showSpeclMessage(new CustomSnackBar());
            }
        });
        alerta = builder.create();
        alerta.show();
    }

}


