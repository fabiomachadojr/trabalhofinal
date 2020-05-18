package br.com.cadernorapido.activitys;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import br.com.cadernorapido.App;
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

        final CadastroActivityViewModel viewModel = new CadastroActivityViewModel(this, usuario);
        binding.setViewModel(viewModel);

        binding.btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                viewModel.save();
            }
        });

    }
}
