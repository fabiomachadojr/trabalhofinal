package br.com.cadernorapido.model;

import android.app.Application;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import br.com.cadernorapido.application.App;

@Entity
public class Usuarios extends BaseModel {

    @Id(autoincrement = true)
    private Long id;
    @NotNull
    private String user;
    private String senha;

    private boolean ativo;

    private static Usuarios instance = new Usuarios();

    public static Usuarios getInstance(String user, String senha, boolean ativo) {
        instance.setUser(user);
        instance.setSenha(senha);
        instance.setAtivo(ativo);
        return instance;
    }

    @Generated(hash = 1780136761)
    public Usuarios(Long id, @NotNull String user, String senha, boolean ativo) {
        this.id = id;
        this.user = user;
        this.senha = senha;
        this.ativo = ativo;
    }

    public Usuarios(@NotNull String user, String senha) {
        this.user = user;
        this.senha = senha;
    }

    @Generated(hash = 225815021)
    public Usuarios() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static UsuariosDao getDaoSession() {
        DaoSession daoSession = App.getDaoSession();
        return daoSession.getUsuariosDao();
    }

    public static boolean verificarPossueCadastro(String nome) {
        return Usuarios.getDaoSession().queryBuilder().where(UsuariosDao.Properties.User.eq(nome)).list().size() > 0;
    }

    public static boolean validUsuario(String nome, String senha) {
        Usuarios usuarios = Usuarios.getDaoSession().queryBuilder().where(UsuariosDao.Properties.User.eq(nome), UsuariosDao.Properties.Senha.eq(senha)).unique();

        if (usuarios != null) {
            usuarios.setAtivo(true);
            usuarios.save();
            return true;
        }
        return false;
    }

    public static void deslogarUsuario() {
        Usuarios usuarios = Usuarios.getDaoSession().queryBuilder().where(UsuariosDao.Properties.Ativo.eq(true)).unique();
        if (usuarios != null) {
            usuarios.setAtivo(false);
            usuarios.save();
        }
    }

    public static boolean verificaUsuarioLogado() {
        Usuarios usuarios = Usuarios.getDaoSession().queryBuilder().where(UsuariosDao.Properties.Ativo.eq(true)).unique();
        return usuarios != null;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean getAtivo() {
        return this.ativo;
    }
}
