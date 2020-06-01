package br.com.cadernorapido.model;

import android.app.Application;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.Date;
import org.greenrobot.greendao.DaoException;

import br.com.cadernorapido.application.App;

@Entity
public class Almoco extends BaseModel {

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private double valor;
    private Date data;

    private long usuarioID;
    @ToOne(joinProperty = "usuarioID")
    private Usuarios usuarios;

    private static Almoco instance = new Almoco();

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1399683616)
    private transient AlmocoDao myDao;

    @Generated(hash = 93052967)
    private transient Long usuarios__resolvedKey;

    @Generated(hash = 2041866542)
    public Almoco() {
    }

    @Generated(hash = 1482846568)
    public Almoco(Long id, double valor, Date data, long usuarioID) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.usuarioID = usuarioID;
    }

    public static Almoco getInstance(double valor, Date data) {
        instance.setValor(valor);
        instance.setData(data);
        return instance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public long getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(long usuarioID) {
        this.usuarioID = usuarioID;
    }

    public static AlmocoDao getDaoSession() {
        DaoSession daoSession = App.getDaoSession();
        return daoSession.getAlmocoDao();
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 85844894)
    public Usuarios getUsuarios() {
        long __key = this.usuarioID;
        if (usuarios__resolvedKey == null || !usuarios__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UsuariosDao targetDao = daoSession.getUsuariosDao();
            Usuarios usuariosNew = targetDao.load(__key);
            synchronized (this) {
                usuarios = usuariosNew;
                usuarios__resolvedKey = __key;
            }
        }
        return usuarios;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1865920167)
    public void setUsuarios(@NotNull Usuarios usuarios) {
        if (usuarios == null) {
            throw new DaoException(
                    "To-one property 'usuarioID' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.usuarios = usuarios;
            usuarioID = usuarios.getId();
            usuarios__resolvedKey = usuarioID;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 417505727)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getAlmocoDao() : null;
    }
}
