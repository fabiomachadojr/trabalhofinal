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
import br.com.cadernorapido.model.Usuarios;
import br.com.cadernorapido.model.UsuariosDao;


public class CadastroUsuariosActivity extends AppCompatActivity {

    ActivityCadastroUsuariosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cadastro_usuarios);


        binding.buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Usuarios.verificarPossueCadastro(binding.editTextCadastroUsuario.getText().toString())){
                    Toast.makeText(CadastroUsuariosActivity.this, "Usuário já cadastrado", Toast.LENGTH_SHORT).show();
                    return;
                }

                Usuarios.getInstance(binding.editTextCadastroUsuario.getText().toString(), binding.editTextCadastroSenha.getText().toString(),true,new Date()).save();
                Toast.makeText(CadastroUsuariosActivity.this, "Usuário cadastrado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CadastroUsuariosActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
