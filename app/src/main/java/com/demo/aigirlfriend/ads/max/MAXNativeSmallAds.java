package com.demo.aigirlfriend.ads.max;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeBannerAd;
import com.demo.aigirlfriend.R;
import com.demo.aigirlfriend.ads.MyApplication;
import com.demo.aigirlfriend.ads.admob.AdMobNative;
import com.demo.aigirlfriend.ads.fb.FbNativeSmallAds;


public class MAXNativeSmallAds {

    public static void MAXNativeSmallFirst(Context context, FrameLayout adContainer, NativeAdLayout native_banner_ad_container) {

        adContainer.setVisibility(View.VISIBLE);

        MaxAdView adView = new MaxAdView(MyApplication.MAX_Banner, context);
        adView.setListener(new MaxAdViewAdListener() {
            @Override
            public void onAdExpanded(MaxAd ad) {

            }

            @Override
            public void onAdCollapsed(MaxAd ad) {

            }

            @Override
            public void onAdLoaded(MaxAd ad) {

            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {

            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {

                adContainer.setVisibility(View.GONE);

                if(MyApplication.Type2.contains("max")){

                    MAXNativeSmallAds.MAXNativeSmallSecond(context, adContainer, native_banner_ad_container);

                } else if(MyApplication.Type2.contains("admob")){

                    AdMobNative.getInstance().showNativeSmallSecond((Activity) context, adContainer, native_banner_ad_container);

                } else if(MyApplication.Type2.contains("fb")){

                    NativeBannerAd nativeBannerAd = new NativeBannerAd(context, MyApplication.FbNativeB);
                    nativeBannerAd.loadAd(nativeBannerAd.buildLoadAdConfig().withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withAdListener(
                            new FbNativeSmallAds(nativeBannerAd, context, new LinearLayout[1], native_banner_ad_container, adContainer, "type3")).build());

                } else if(MyApplication.Type2.contains("qureka")){

                    /*if(MyApplication.CheckQureka != 0){
                        new QurekaSmallNative((Activity) context, adContainer);
                    }*/

                } else {

                }

            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        });

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = context.getResources().getDimensionPixelSize(R.dimen.banner_height_90);
        adView.setLayoutParams(new FrameLayout.LayoutParams(width, height));
        adContainer.addView(adView);
        adView.loadAd();

    }

    public static void MAXNativeSmallSecond(Context context, FrameLayout adContainer, NativeAdLayout native_banner_ad_container) {

        adContainer.setVisibility(View.VISIBLE);

        MaxAdView adView = new MaxAdView(MyApplication.MAX_Banner, context);
        adView.setListener(new MaxAdViewAdListener() {
            @Override
            public void onAdExpanded(MaxAd ad) {

            }

            @Override
            public void onAdCollapsed(MaxAd ad) {

            }

            @Override
            public void onAdLoaded(MaxAd ad) {

            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {

            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {

                adContainer.setVisibility(View.GONE);

                if(MyApplication.Type3.contains("max")){

                    MAXNativeSmallAds.MAXNativeSmallThird(context, adContainer, native_banner_ad_container);

                } else if(MyApplication.Type3.contains("admob")){

                    AdMobNative.getInstance().showNativeSmallThird((Activity) context, adContainer, native_banner_ad_container);

                } else if(MyApplication.Type3.contains("fb")){

                    NativeBannerAd nativeBannerAd = new NativeBannerAd(context, MyApplication.FbNativeB);
                    nativeBannerAd.loadAd(nativeBannerAd.buildLoadAdConfig().withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withAdListener(
                            new FbNativeSmallAds(nativeBannerAd, context, new LinearLayout[1], native_banner_ad_container, adContainer, "type4")).build());

                } else if(MyApplication.Type3.contains("qureka")){

                    /*if(MyApplication.CheckQureka != 0){
                        new QurekaSmallNative((Activity) context, adContainer);
                    }*/

                } else {

                }

            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        });

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = context.getResources().getDimensionPixelSize(R.dimen.banner_height_90);
        adView.setLayoutParams(new FrameLayout.LayoutParams(width, height));
        adContainer.addView(adView);
        adView.loadAd();

    }

    public static void MAXNativeSmallThird(Context context, FrameLayout adContainer, NativeAdLayout native_banner_ad_container) {

        adContainer.setVisibility(View.VISIBLE);

        MaxAdView adView = new MaxAdView(MyApplication.MAX_Banner, context);
        adView.setListener(new MaxAdViewAdListener() {
            @Override
            public void onAdExpanded(MaxAd ad) {

            }

            @Override
            public void onAdCollapsed(MaxAd ad) {

            }

            @Override
            public void onAdLoaded(MaxAd ad) {

            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {

            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {

                adContainer.setVisibility(View.GONE);

                if(MyApplication.Type4.contains("max")){

                    MAXNativeSmallAds.MAXNativeSmallFour(context, adContainer, native_banner_ad_container);

                } else if(MyApplication.Type4.contains("admob")){

                    AdMobNative.getInstance().showNativeSmallFour((Activity) context, adContainer, native_banner_ad_container);

                } else if(MyApplication.Type4.contains("fb")){

                    NativeBannerAd nativeBannerAd = new NativeBannerAd(context, MyApplication.FbNativeB);
                    nativeBannerAd.loadAd(nativeBannerAd.buildLoadAdConfig().withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withAdListener(
                            new FbNativeSmallAds(nativeBannerAd, context, new LinearLayout[1], native_banner_ad_container, adContainer, "")).build());

                } else if(MyApplication.Type4.contains("qureka")){

                    /*if(MyApplication.CheckQureka != 0){
                        new QurekaSmallNative((Activity) context, adContainer);
                    }*/

                } else {

                }

            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        });

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = context.getResources().getDimensionPixelSize(R.dimen.banner_height_90);
        adView.setLayoutParams(new FrameLayout.LayoutParams(width, height));
        adContainer.addView(adView);
        adView.loadAd();

    }

    public static void MAXNativeSmallFour(Context context, FrameLayout adContainer, NativeAdLayout native_banner_ad_container) {

        adContainer.setVisibility(View.VISIBLE);

        MaxAdView adView = new MaxAdView(MyApplication.MAX_Banner, context);
        adView.setListener(new MaxAdViewAdListener() {
            @Override
            public void onAdExpanded(MaxAd ad) {

            }

            @Override
            public void onAdCollapsed(MaxAd ad) {

            }

            @Override
            public void onAdLoaded(MaxAd ad) {

            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {

            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {

                adContainer.setVisibility(View.GONE);

            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        });

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = context.getResources().getDimensionPixelSize(R.dimen.banner_height_90);
        adView.setLayoutParams(new FrameLayout.LayoutParams(width, height));
        adContainer.addView(adView);
        adView.loadAd();

    }

}
