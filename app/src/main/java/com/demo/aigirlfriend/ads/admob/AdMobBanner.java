package com.demo.aigirlfriend.ads.admob;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.demo.aigirlfriend.ads.MyApplication;
import com.demo.aigirlfriend.ads.fb.FbBannerAds;
import com.demo.aigirlfriend.ads.max.MAXBannerAds;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

public class AdMobBanner {

    private Activity activity;
    private adMobSmallAdCallback listener;
    private RelativeLayout admob_banner;
    String TAG = "BannerAdClass";
    private AdView adView;
    LinearLayout adContainer;
    FrameLayout qureka;
    String type;

    public interface adMobSmallAdCallback {
        void onAdLoaded();

        void onAdError(String error);
    }

    public void showAd(Activity context, RelativeLayout admob_banner, LinearLayout madContainer, FrameLayout mqureka, String mtype, adMobSmallAdCallback adMobSmallAdCallback) {
        this.activity = context;
        this.listener = adMobSmallAdCallback;
        this.admob_banner = admob_banner;
        this.adContainer = madContainer;
        this.qureka = mqureka;
        this.type = mtype;
        if (!isOnline()) {
            listener.onAdError("No Internet Connection");
            return;
        }
        loadAd();
    }

    private void loadAd() {
        adView = new AdView(activity);
        adView.setAdSize(getAdSize());
        adView.setAdUnitId(MyApplication.AdMob_Banner1);
        adView.setAdListener(new AdListener() {
            public void onAdLoaded() {
                listener.onAdLoaded();
                admob_banner.removeAllViews();
                RelativeLayout.LayoutParams bannerParameters = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                bannerParameters.addRule(RelativeLayout.CENTER_HORIZONTAL);
                admob_banner.addView(adView, bannerParameters);
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                Log.e(TAG, "onAdFailedToLoad: " + adError.toString());
                admob_banner.setVisibility(View.GONE);

                if(type.equals("type2")){

                    if(MyApplication.Type2.contains("admob")){

                        admob_banner.setVisibility(View.VISIBLE);
                        new AdMobBanner().showAd((Activity) activity, admob_banner, adContainer, qureka, "type3", new adMobSmallAdCallback() {
                            @Override
                            public void onAdLoaded() {
                            }

                            @Override
                            public void onAdError(String error) {
                            }
                        });

                    } else if(MyApplication.Type2.contains("fb")){

                        FbBannerAds.showFbAds(activity, admob_banner, adContainer, qureka, "type3");

                    } else if(MyApplication.Type2.contains("max")){

                        MAXBannerAds.MAXBanner(activity, admob_banner, adContainer, qureka, "type3");

                    } else if(MyApplication.Type2.contains("qureka")){

                        /*if(MyApplication.CheckQureka != 0){
                            new QurekaBannerAds((Activity) activity, qureka);
                        }*/

                    } else {

                    }

                } else if(type.equals("type3")){

                    if(MyApplication.Type3.contains("admob")){

                        admob_banner.setVisibility(View.VISIBLE);
                        new AdMobBanner().showAd((Activity) activity, admob_banner, adContainer, qureka, "type4", new adMobSmallAdCallback() {
                            @Override
                            public void onAdLoaded() {
                            }

                            @Override
                            public void onAdError(String error) {
                            }
                        });

                    } else if(MyApplication.Type3.contains("fb")){

                        FbBannerAds.showFbAds(activity, admob_banner, adContainer, qureka, "type4");

                    } else if(MyApplication.Type3.contains("max")){

                        MAXBannerAds.MAXBanner(activity, admob_banner, adContainer, qureka, "type4");

                    } else if(MyApplication.Type3.contains("qureka")){

                        /*if(MyApplication.CheckQureka != 0){
                            new QurekaBannerAds((Activity) activity, qureka);
                        }*/

                    } else {

                    }

                } else if(type.equals("type4")){

                    if(MyApplication.Type4.contains("admob")){

                        admob_banner.setVisibility(View.VISIBLE);
                        new AdMobBanner().showAd((Activity) activity, admob_banner, adContainer, qureka, "", new adMobSmallAdCallback() {
                            @Override
                            public void onAdLoaded() {
                            }

                            @Override
                            public void onAdError(String error) {
                            }
                        });

                    } else if(MyApplication.Type4.contains("fb")){

                        FbBannerAds.showFbAds(activity, admob_banner, adContainer, qureka, "");

                    } else if(MyApplication.Type4.contains("max")){

                        MAXBannerAds.MAXBanner(activity, admob_banner, adContainer, qureka, "");

                    } else if(MyApplication.Type4.contains("qureka")){

                        /*if(MyApplication.CheckQureka != 0){
                            new QurekaBannerAds((Activity) activity, qureka);
                        }*/

                    } else {

                    }

                }

            }

        });
        adView.loadAd(new AdRequest.Builder().build());
    }

    private AdSize getAdSize() {
        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;
        int adWidth = (int) (widthPixels / density);
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, adWidth);
    }

    public boolean isOnline() {
        NetworkInfo netInfo = ((ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (netInfo == null || !netInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

}
