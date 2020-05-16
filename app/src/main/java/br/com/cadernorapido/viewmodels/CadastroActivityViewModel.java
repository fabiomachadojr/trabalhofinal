package br.com.cadernorapido.viewmodels;

import android.content.Context;

import androidx.databinding.Bindable;
import androidx.lifecycle.ViewModel;

import java.security.PublicKey;

import br.com.cadernorapido.activitys.CadastroActivity;
import br.com.cadernorapido.models.Usuario;

public class CadastroActivityViewModel extends ViewModel {

    private Context context;
    private Usuario model;

    public CadastroActivityViewModel(Context context, Usuario usuario) {
        this.context = context;
        this.model = usuario;
    }

    @Bindable
    public Usuario getModel() {
        return model;
    }

    @Bindable
    public void setModel(Usuario model) {
        this.model = model;
    }

    @Bindable
    public void save(){
        model.save();
    }
}
