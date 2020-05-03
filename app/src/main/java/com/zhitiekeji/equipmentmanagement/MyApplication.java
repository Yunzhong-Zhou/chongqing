package com.zhitiekeji.equipmentmanagement;

import android.app.Application;
import android.support.multidex.MultiDex;

import com.tencent.bugly.Bugly;

/**
 * Created by fafukeji01 on 2017/2/28.
 */

public class MyApplication extends Application {
    private static MyApplication myApplication;

    public static MyApplication getInstance() {
        return myApplication;
    }

    @Override
    public final void onCreate() {
        super.onCreate();
        myApplication = this;
        MultiDex.install(this);
        Bugly.init(getApplicationContext(), "dc617a11b1", false);
    }

}
