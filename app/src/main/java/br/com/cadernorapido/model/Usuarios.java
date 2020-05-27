package br.com.cadernorapido.model;

import android.app.Application;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import br.com.cadernorapido.application.App;

@Entity
public class Usuarios  extends BaseModel{

    @Id(autoincrement = true)
    private Long id;
    @NotNull
    private String user;
    private String senha;

    private static Usuarios instance = new Usuarios();

    public static Usuarios getInstance(String u, String s){
        instance.setUser(u);
        instance.setSenha(s);
        return  instance;
    }

    @Generated(hash = 432310538)
    public Usuarios(Long id, @NotNull String user, String senha) {
        this.id = id;
        this.user = user;
        this.senha = senha;
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

    public static UsuariosDao daoSessionUsuarios(Application application){
        DaoSession daoSession = ((App) application).getDaoSession();
        UsuariosDao usuariosDao =  daoSession.getUsuariosDao();
        return  usuariosDao;
    }

    @Override
    public String toString() {
        return
                "\nid:" + id +
                "\nuser:" + user +
                "\nsenha:" + senha +
                "\n";
    }
}
