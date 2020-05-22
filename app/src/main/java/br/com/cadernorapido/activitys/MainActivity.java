package br.com.cadernorapido.activitys;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
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
        final ArrayAdapter<Usuarios> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Usuarios.daoSessionUsuarios(getApplication()).loadAll());
        binding.listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
