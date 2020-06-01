package br.com.cadernorapido.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import br.com.cadernorapido.R;
import br.com.cadernorapido.databinding.ActivityLoginBinding;
import br.com.cadernorapido.model.Usuarios;
import br.com.cadernorapido.model.UsuariosDao;


public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        getSupportActionBar().hide();

        if (Usuarios.verificaUsuarioLogado()) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

        binding.buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Usuarios.validUsuario(binding.editTextUsuario.getText().toString(), binding.editTextSenha.getText().toString())) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Usuário não cadastrado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.buttonCadastrese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, CadastroUsuariosActivity.class);
                startActivity(intent);
            }
        });

    }
}
