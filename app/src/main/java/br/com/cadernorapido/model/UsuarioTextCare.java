package br.com.cadernorapido.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import br.com.cadernorapido.application.App;

@Entity
public class UsuarioTextCare extends BaseModel{

    @Id(autoincrement = true)
    private Long id;
    private String guideUnique;
    private String nomeDoUsuario;

    @Generated(hash = 1251654989)
    public UsuarioTextCare(Long id, String guideUnique, String nomeDoUsuario) {
        this.id = id;
        this.guideUnique = guideUnique;
        this.nomeDoUsuario = nomeDoUsuario;
    }

    @Generated(hash = 335866413)
    public UsuarioTextCare() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuideUnique() {
        return guideUnique;
    }

    public void setGuideUnique(String guideUnique) {
        this.guideUnique = guideUnique;
    }

    public String getNomeDoUsuario() {
        return nomeDoUsuario;
    }

    public void setNomeDoUsuario(String nomeDoUsuario) {
        this.nomeDoUsuario = nomeDoUsuario;
    }

    public static UsuarioTextCareDao getDaoSession() {
        DaoSession daoSession = App.getDaoSession();
        return daoSession.getUsuarioTextCareDao();
    }

    public static UsuarioTextCare buscarUltimo(String id) {
        return UsuarioTextCare.getDaoSession().queryBuilder().where(UsuarioTextCareDao.Properties.GuideUnique.eq(id)).orderDesc().list().get(0);
    }

}
