package br.com.cadernorapido.application;

import android.app.Application;
import org.greenrobot.greendao.database.Database;
import br.com.cadernorapido.model.DaoMaster;
import br.com.cadernorapido.model.DaoSession;
import br.com.cadernorapido.model.Usuarios;


//Singleton
public class App extends Application {

    private static DaoSession daoSession;
    private static Database db;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "database");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public static DaoSession getDaoSession() {

        if (daoSession == null) {
            daoSession = new DaoMaster(db).newSession();
        }

        return daoSession;
    }


}
