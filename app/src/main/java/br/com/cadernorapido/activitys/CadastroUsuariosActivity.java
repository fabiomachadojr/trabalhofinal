package br.com.cadernorapido.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import br.com.cadernorapido.R;
import br.com.cadernorapido.databinding.ActivityCadastroUsuariosBinding;
import br.com.cadernorapido.model.Usuarios;


public class CadastroUsuariosActivity extends AppCompatActivity {

    ActivityCadastroUsuariosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cadastro_usuarios);


        binding.buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuarios.daoSessionUsuarios(getApplication()).insert(
                        Usuarios.getInstance(binding.editTextCadastroUsuario.getText().toString(), binding.editTextCadastroSenha.getText().toString()));
                Toast.makeText(CadastroUsuariosActivity.this, "Usuário cadastrado", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
