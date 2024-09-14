package com.demo.aigirlfriend.splashAds;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.demo.aigirlfriend.MainActivity;
import com.demo.aigirlfriend.R;

import com.demo.aigirlfriend.ads.AdsCommon;
import com.demo.aigirlfriend.ads.MyApplication;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;

public class SplashActivity extends AppCompatActivity {

    String var;
    int check = 0;
    private AppOpenAd.AppOpenAdLoadCallback loadCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorlight));
        }

        MyApplication.setuser_balance(0);

        refreshItem();

    }

    private void refreshItem() {

        if(isNetworkConnected()){

            new Handler().postDelayed(new Runnable() {
                public void run() {
                    OpenAppAds();
                }
            }, 5000);

        } else {

            final Dialog dialog = new Dialog(SplashActivity.this, R.style.DialogTheme);
            dialog.setContentView(R.layout.no_internet);
            dialog.setCancelable(false);

            CardView imgRefresh = (CardView) dialog.findViewById(R.id.refresh);
            CardView imgExit = (CardView) dialog.findViewById(R.id.exit);
            ImageView imgNoInternet = (ImageView) dialog.findViewById(R.id.img);

            final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);
            imgNoInternet.startAnimation(animShake);

            imgNoInternet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgNoInternet.startAnimation(animShake);
                }
            });
            imgRefresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    refreshItem();
                    dialog.dismiss();
                }
            });
            imgExit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    finish();
                    System.exit(0);
                }
            });
            dialog.show();
        }

    }



    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    public void OpenAppAds() {
        try {

            if (MyApplication.getuser_balance() == 0 && !MyApplication.App_Open.equals("")) {

                String app_open_ads_id = MyApplication.App_Open;

                loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                        super.onAdLoaded(appOpenAd);

                        FullScreenContentCallback fullScreenContentCallback = new FullScreenContentCallback() {
                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                super.onAdFailedToShowFullScreenContent(adError);
                                goNext(1);
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                super.onAdShowedFullScreenContent();
                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                goNext(1);
                            }
                        };
                        appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                        appOpenAd.show(SplashActivity.this);

                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        goNext(1);
                    }
                };

                AppOpenAd.load((Context) this, app_open_ads_id, new AdRequest.Builder().build(), 1, this.loadCallback);

            } else {
                goNext(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void goNext(int i) {
        check = check + 1;
        if(check == 1){
            loadOpenApp();
        }
    }

    private void loadOpenApp() {

        //one time call & load ads
        AdsCommon.OneTimeCall(this);

        if (MyApplication.getuser_onetime() == 0) {
            Intent i = new Intent(SplashActivity.this, PrivacyTermsActivity.class);
            startActivity(i);
            finish();
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        } else {
            Intent i = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(i);
            finish();
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }

}
