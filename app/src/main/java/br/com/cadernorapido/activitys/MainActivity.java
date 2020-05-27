package br.com.cadernorapido.activitys;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

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

        loadListView();

    }

    public void loadListView(){
        AdapterUsuarios adapterUsuarios = new AdapterUsuarios(Usuarios.daoSessionUsuarios(getApplication()).loadAll(),this);
        binding.listView.setAdapter(adapterUsuarios);
        adapterUsuarios.notifyDataSetChanged();
    }
}
