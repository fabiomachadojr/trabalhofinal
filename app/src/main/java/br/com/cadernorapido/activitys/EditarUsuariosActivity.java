package br.com.cadernorapido.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import java.util.Date;

import br.com.cadernorapido.R;
import br.com.cadernorapido.databinding.ActivityCadastroUsuariosBinding;
import br.com.cadernorapido.model.UsuarioTextCare;
import br.com.cadernorapido.model.Usuarios;


public class EditarUsuariosActivity extends AppCompatActivity {

    ActivityCadastroUsuariosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cadastro_usuarios);

        Long id = getIntent().getExtras().getLong("id");
        final Usuarios user = Usuarios.buscarUsuario(id);
        binding.editTextCadastroUsuario.setText(user.getUser());
        binding.editTextCadastroSenha.setText(user.getSenha());

        binding.buttonUltimo.setVisibility(View.VISIBLE);
        binding.buttonUltimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsuarioTextCare u = UsuarioTextCare.buscarUltimo(user.getGuideUnique());
                binding.editTextCadastroUsuario.setText(u.getNomeDoUsuario());
            }
        });


        binding.buttonCadastrar.setText("Salvar");
        binding.buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user.setUser(String.valueOf(binding.editTextCadastroUsuario.getText()));
                user.setSenha(String.valueOf(binding.editTextCadastroSenha.getText()));
                user.save();
                Toast.makeText(EditarUsuariosActivity.this, "Usuário cadastrado", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
