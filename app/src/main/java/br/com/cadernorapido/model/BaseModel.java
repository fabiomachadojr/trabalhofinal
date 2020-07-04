package br.com.cadernorapido.model;

        import android.app.Application;

        import org.greenrobot.greendao.AbstractDao;

        import java.io.Serializable;

        import br.com.cadernorapido.application.App;


public class BaseModel implements Serializable {

    static final long serialVersionUID = 42L;

    public void save() {
        DaoSession daoSession = App.getDaoSession();
        AbstractDao abstractDao = daoSession.getDao(this.getClass());
        abstractDao.save(this);
    }

    public void save(DaoSession daoSession) {
        AbstractDao abstractDao = daoSession.getDao(this.getClass());
        abstractDao.save(this);

    }

    public void save(AbstractDao abstractDao) {
        abstractDao.save(this);
    }

    public void delete() {
        DaoSession daoSession = App.getDaoSession();
        AbstractDao abstractDao = daoSession.getDao(this.getClass());
        abstractDao.delete(this);
    }
}
