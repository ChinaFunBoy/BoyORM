package com.chinaboy.orm.app;

import android.app.Application;
import android.content.pm.PackageManager;

import com.chinaboy.orm.db.DatabaseManager;
import com.chinaboy.orm.model.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maoweiwei on 16/6/23
 * BoyORM
 */
public class MyApplication extends Application {

    private static MyApplication INSTANCE_;

    @Override
    public void onCreate() {
        INSTANCE_ = this;
        super.onCreate();

        initDB();

    }

    public void initDB() {
        if (DatabaseManager.getInstance().isInited())
            return;
        String dbName = "teacher.db";
        int version = 0;
        try {
            version = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        List<Class<?>> list = new ArrayList<>();
        list.add(Teacher.class);

        DatabaseManager.getInstance().initDataBase(getApplicationContext(), dbName, version, list);
    }


}
