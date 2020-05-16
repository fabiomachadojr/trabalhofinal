package br.com.cadernorapido.activitys;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import br.com.cadernorapido.R;
import br.com.cadernorapido.databinding.ActivityCadastroBinding;
import br.com.cadernorapido.models.Usuario;
import br.com.cadernorapido.viewmodels.CadastroActivityViewModel;


public class CadastroActivity extends AppCompatActivity {

    private ActivityCadastroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_cadastro);

        Usuario usuario = new Usuario();

        CadastroActivityViewModel viewModel = new CadastroActivityViewModel(this, usuario);
        binding.setViewModel(viewModel);

    }
}
