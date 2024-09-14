package com.demo.aigirlfriend.ads;

import android.app.Activity;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.multidex.MultiDex;

import com.demo.aigirlfriend.constants.SPKeys;
import com.demo.aigirlfriend.utils.SPUtils;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.appopen.AppOpenAd.AppOpenAdLoadCallback;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import com.onesignal.OneSignal;

import org.litepal.LitePal;

import java.util.Calendar;
import java.util.Date;

public class MyApplication extends Application implements Application.ActivityLifecycleCallbacks, LifecycleObserver {

    private static final String ONESIGNAL_APP_ID = "";  // add your onesignal id

    public static SharedPreferences sharedPreferencesInApp;
    public static SharedPreferences.Editor editorInApp;

    private AppOpenAdManager appOpenAdManager;
    private Activity currentActivity;

    //test ads id admob
    public static String AdMob_Banner1 = "ca-app-pub-3940256099942544/6300978111";  // add google admob banner ads id
    public static String AdMob_Int1 = "ca-app-pub-3940256099942544/1033173712";     // add google admob interstitial ads id 1
    public static String AdMob_Int2 = "ca-app-pub-3940256099942544/1033173712";     // add google admob interstitial ads id 2
    public static String AdMob_NativeAdvance1 = "ca-app-pub-3940256099942544/2247696110";  // add google admob native ads id 1
    public static String AdMob_NativeAdvance2 = "ca-app-pub-3940256099942544/2247696110";  // add google admob native ads id 2
    public static String App_Open = "ca-app-pub-3940256099942544/9257395921";  // add google admob openapp ads id

    //test ads id fb
    public static String FbBanner = "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID";  // add facebook banner ads id
    public static String FbInter = "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID";   // add facebook interstitial ads id
    public static String Fbnative = "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID";  // add facebook native ads id
    public static String FbNativeB = "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID"; // add facebook native small ads id


    public static String MAX_Banner = "";  //add app lovin MAX banner ads id
    public static String MAX_Int = "";     //add app lovin MAX interstitial ads id
    public static String MAX_Native = "";  //add app lovin MAX native ads id


    public static int click = 2;     //Interstital ads click here
    public static int backclick = 2; //Interstital back ads click here

    public static int AdsClickCount = 0;     //fixed
    public static int backAdsClickCount = 0; //fixed


    public static String Type1 = "admob";  //admob | fb | max
    public static String Type2 = "fb";  //admob | fb | max
    public static String Type3 = "";  //admob | fb | max
    public static String Type4 = "";  //admob | fb | max

    public static String MoreApps = "More+Apps"; //your_moreapp_account_name_here
    public static String PrivacyPolicy = "https://www.freeprivacypolicy.com/blog/privacy-policy-url/";  //your_privacy_policy_here

    public static int checkInAppUpdate = 0; // 0==FLEXIBLE &&  1==IMMEDIATE

    public static Context context1;



    @Override
    public void onCreate() {
        super.onCreate();
        this.registerActivityLifecycleCallbacks(this);


        sharedPreferencesInApp = getSharedPreferences("my", MODE_PRIVATE);
        editorInApp = sharedPreferencesInApp.edit();


        context1 = getApplicationContext();

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);


        AudienceNetworkAds.initialize(context1);


        MobileAds.initialize(
                this,
                new OnInitializationCompleteListener() {
                    @Override
                    public void onInitializationComplete(
                            @NonNull InitializationStatus initializationStatus) {
                    }
                });

        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
        appOpenAdManager = new AppOpenAdManager();


        /*app code*/
        mContext = getApplicationContext();
        LitePal.initialize(getApplicationContext());
        initUseApp();

    }

    @Override
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void onMoveToForeground() {
        // Show the ad (if available) when the app moves to foreground.
        appOpenAdManager.showAdIfAvailable(currentActivity);
    }

    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {
        if (!appOpenAdManager.isShowingAd) {
            currentActivity = activity;
        }
    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {
    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {
    }

    public void showAdIfAvailable(
            @NonNull Activity activity,
            @NonNull OnShowAdCompleteListener onShowAdCompleteListener) {
        appOpenAdManager.showAdIfAvailable(activity, onShowAdCompleteListener);
    }

    public interface OnShowAdCompleteListener {
        void onShowAdComplete();
    }

    private class AppOpenAdManager {

        private static final String LOG_TAG = "AppOpenAdManager";

        private AppOpenAd appOpenAd = null;
        private boolean isLoadingAd = false;
        private boolean isShowingAd = false;
        private long loadTime = 0;


        public AppOpenAdManager() {
        }

        private void loadAd(Context context) {
            if (isLoadingAd || isAdAvailable()) {
                return;
            }

            if (MyApplication.getuser_balance() == 0 && !MyApplication.App_Open.equals("")) {

                isLoadingAd = true;
                AdRequest request = new AdRequest.Builder().build();
                AppOpenAd.load(
                        context,
                        App_Open,
                        request,
                        AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT,
                        new AppOpenAdLoadCallback() {
                            @Override
                            public void onAdLoaded(AppOpenAd ad) {
                                appOpenAd = ad;
                                isLoadingAd = false;
                                loadTime = (new Date()).getTime();

                                Log.d(LOG_TAG, "onAdLoaded.");
                            }

                            @Override
                            public void onAdFailedToLoad(LoadAdError loadAdError) {
                                isLoadingAd = false;
                                Log.d(LOG_TAG, "onAdFailedToLoad: " + loadAdError.getMessage());
                            }
                        });

            }

        }

        private boolean wasLoadTimeLessThanNHoursAgo(long numHours) {
            long dateDifference = (new Date()).getTime() - loadTime;
            long numMilliSecondsPerHour = 3600000;
            return (dateDifference < (numMilliSecondsPerHour * numHours));
        }

        private boolean isAdAvailable() {
            return appOpenAd != null && wasLoadTimeLessThanNHoursAgo(4);
        }

        private void showAdIfAvailable(@NonNull final Activity activity) {
            showAdIfAvailable(
                    activity,
                    new OnShowAdCompleteListener() {
                        @Override
                        public void onShowAdComplete() {
                        }
                    });
        }

        private void showAdIfAvailable(
                @NonNull final Activity activity,
                @NonNull OnShowAdCompleteListener onShowAdCompleteListener) {
            if (isShowingAd) {
                Log.d(LOG_TAG, "The app open ad is already showing.");
                return;
            }

            if (!isAdAvailable()) {
                Log.d(LOG_TAG, "The app open ad is not ready yet.");
                onShowAdCompleteListener.onShowAdComplete();
                loadAd(activity);
                return;
            }

            Log.d(LOG_TAG, "Will show ad.");

            appOpenAd.setFullScreenContentCallback(
                    new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            appOpenAd = null;
                            isShowingAd = false;

                            Log.d(LOG_TAG, "onAdDismissedFullScreenContent.");

                            onShowAdCompleteListener.onShowAdComplete();
                            loadAd(activity);
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(AdError adError) {
                            appOpenAd = null;
                            isShowingAd = false;

                            Log.d(LOG_TAG, "onAdFailedToShowFullScreenContent: " + adError.getMessage());

                            onShowAdCompleteListener.onShowAdComplete();
                            loadAd(activity);
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            Log.d(LOG_TAG, "onAdShowedFullScreenContent.");
                        }
                    });

            isShowingAd = true;
            appOpenAd.show(activity);
        }
    }

    public static void setuser_balance(Integer user_balance) {
        editorInApp.putInt("user_balance", user_balance).commit();
    }
    public static Integer getuser_balance() {
        return sharedPreferencesInApp.getInt("user_balance", 0);
    }

    public static void setuser_onetime(Integer user_onetime) {
        editorInApp.putInt("user_onetime", user_onetime).commit();
    }
    public static Integer getuser_onetime() {
        return sharedPreferencesInApp.getInt("user_onetime", 0);
    }

    public static void setuser_permission(Integer user_permission) {
        editorInApp.putInt("user_permission", user_permission).commit();
    }
    public static Integer getuser_permission() {
        return sharedPreferencesInApp.getInt("user_permission", 0);
    }

    public static void setuser_guideline(Integer user_guideline) {
        editorInApp.putInt("user_guideline", user_guideline).commit();
    }
    public static Integer getuser_guideline() {
        return sharedPreferencesInApp.getInt("user_guideline", 0);
    }



    /*app code*/

    public static Context mContext;

    private void initUseApp() {
        String todayDate = getTodayDate();
        if (!SPUtils.get(mContext, SPKeys.LAST_DATE, "").equals(todayDate)) {
            SPUtils.put(mContext, SPKeys.VIEW_REWARDED, 0);
            SPUtils.put(mContext, SPKeys.LAST_DATE, todayDate);
        }
    }

    private String getTodayDate() {
        Calendar instance2 = Calendar.getInstance();
        int i = instance2.get(1);
        int i2 = instance2.get(2);
        return String.valueOf(i) + i2 + instance2.get(5);
    }


}