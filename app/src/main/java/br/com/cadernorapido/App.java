package br.com.cadernorapido;

import android.app.Application;
import android.content.Context;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;

import br.com.cadernorapido.models.DaoMaster;
import br.com.cadernorapido.models.DaoSession;


public class App extends Application {
    private static DaoSession daoSession;
    private static App instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "trabalho-final");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();

    }

    public static Context getAppContext() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    public Context getContext() {
        return getApplicationContext();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static DaoSession getAppDaoSession(Context context) {
        return daoSession;
    }

    public static DaoSession getAppDaoSession() {
        return daoSession;
    }

    public static void getAppDaoSessionDelete() {
        for (AbstractDao abstractDao : getAppDaoSession().getAllDaos()) {
            abstractDao.deleteAll();
        }
    }
}
