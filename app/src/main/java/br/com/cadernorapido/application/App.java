package br.com.cadernorapido.application;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

import br.com.cadernorapido.model.DaoMaster;
import br.com.cadernorapido.model.DaoSession;

public class App extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "database");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
