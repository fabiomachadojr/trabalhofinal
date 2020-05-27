package br.com.cadernorapido.application;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

import br.com.cadernorapido.model.DaoMaster;
import br.com.cadernorapido.model.DaoSession;

public class App extends Application {

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "database");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
