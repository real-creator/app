package com.demo.aigirlfriend;

import android.app.Application;
import android.content.Context;
import androidx.multidex.MultiDex;
import com.demo.aigirlfriend.constants.SPKeys;
import com.demo.aigirlfriend.utils.SPUtils;
import java.util.Calendar;
import org.litepal.LitePal;

public class BaseApp extends Application {
    public static Context mContext;

    @Override
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        callBaseApp(this);
    }

    public void callBaseApp(BaseApp baseApp) {
        super.onCreate();
        mContext = baseApp;
        LitePal.initialize(baseApp);
        baseApp.initUseApp();
    }

    private void initUseApp() {
        String todayDate = getTodayDate();
        if (!SPUtils.get(mContext, SPKeys.LAST_DATE, "").equals(todayDate)) {
            SPUtils.put(mContext, SPKeys.VIEW_REWARDED, 0);
            SPUtils.put(mContext, SPKeys.LAST_DATE, todayDate);
        }
    }

    private String getTodayDate() {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(1);
        int i2 = instance.get(2);
        return String.valueOf(i) + i2 + instance.get(5);
    }
}
