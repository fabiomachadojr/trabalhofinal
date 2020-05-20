package br.com.cadernorapido;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import br.com.cadernorapido.databinding.ActivityMainBinding;
import br.com.cadernorapido.viewmodels.CadastroActivityViewModel;
import br.com.cadernorapido.viewmodels.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private WorkMain mWorkMain;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        final MainActivityViewModel viewModel = new MainActivityViewModel(this);

        binding.setViewModel(viewModel);

        View view = binding.getRoot();

        mWorkMain = ((App) view.getContext().getApplicationContext()).getWorkMain();

    }
}
