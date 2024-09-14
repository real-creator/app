package com.demo.aigirlfriend.ads;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeBannerAd;
import com.demo.aigirlfriend.R;
import com.demo.aigirlfriend.ads.admob.AdMobBanner;
import com.demo.aigirlfriend.ads.admob.AdMobInterstitialClick;
import com.demo.aigirlfriend.ads.admob.AdMobNative;
import com.demo.aigirlfriend.ads.fb.FbBannerAds;
import com.demo.aigirlfriend.ads.fb.FbInterstitialAd;
import com.demo.aigirlfriend.ads.fb.FbNativeFullAds;
import com.demo.aigirlfriend.ads.fb.FbNativeSmallAds;
import com.demo.aigirlfriend.ads.max.MAXBannerAds;
import com.demo.aigirlfriend.ads.max.MAXInterstitialAds;
import com.demo.aigirlfriend.ads.max.MAXNativeAds;
import com.demo.aigirlfriend.ads.max.MAXNativeSmallAds;

public class AdsCommon {

    public static void OneTimeCall(Context context) {

        if (MyApplication.getuser_balance() == 0) {
            AdMobInterstitialClick.getInstance().loadInterOne((Activity) context);
            AdMobInterstitialClick.getInstance().loadInterTwo((Activity) context);
            AdMobInterstitialClick.getInstance().loadInterThree((Activity) context);

            AppLovinSdk.getInstance( context ).setMediationProvider( "max" );
            AppLovinSdk.initializeSdk( context, new AppLovinSdk.SdkInitializationListener() {
                @Override
                public void onSdkInitialized(final AppLovinSdkConfiguration configuration)
                {
                    // AppLovin SDK is initialized, start loading ads
                }
            } );
        }
    }

    //click to play game

    /*Inter Ads Click*/
    public static void InterstitialAd(Activity context, Intent intent) {

        if(MyApplication.getuser_balance() == 0) {

            MyApplication.AdsClickCount++;

            if(MyApplication.AdsClickCount == MyApplication.click) {

                MyApplication.AdsClickCount = 0;

                if(MyApplication.Type1.contains("admob")){

                    context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterAdMobFirst((Activity) context, intent, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type1.contains("fb")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    dialog.show();

                    FbInterstitialAd.getInstance().showInterFBFirst((Activity) context, dialog, intent);

                } else if(MyApplication.Type1.contains("max")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterMAXFirst((Activity) context, dialog, intent);

                } else if(MyApplication.Type1.contains("qureka")){

                    context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    /*if(MyApplication.CheckQureka != 0){
                        context.startActivity(new Intent(context, QurekaInterstitialClick.class));
                        context.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            } else {
                context.startActivity(intent);
                context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        } else {
            context.startActivity(intent);
            context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }

    }

    /*Inter Intent With Finish*/
    public static void InterstitialAdFinish(Activity context, Intent intent) {

        if(MyApplication.getuser_balance() == 0) {

            MyApplication.AdsClickCount++;

            if(MyApplication.AdsClickCount == MyApplication.click) {

                MyApplication.AdsClickCount = 0;

                if(MyApplication.Type1.contains("admob")){

                    context.startActivity(intent);
                    context.finish();
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterOnFinishAdMobFirst((Activity) context, intent, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type1.contains("fb")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    dialog.show();

                    FbInterstitialAd.getInstance().showInterOnFinishFBFirst((Activity) context, dialog, intent);

                } else if(MyApplication.Type1.contains("max")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterOnFinishMAXFirst((Activity) context, dialog, intent);

                } else if(MyApplication.Type1.contains("qureka")){

                    context.startActivity(intent);
                    context.finish();
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    /*if(MyApplication.CheckQureka != 0){
                        context.startActivity(new Intent(context, QurekaInterstitialClick.class));
                        context.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    context.startActivity(intent);
                    context.finish();
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            } else {
                context.startActivity(intent);
                context.finish();
                context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        } else {
            context.startActivity(intent);
            context.finish();
            context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }

    }

    /*Inter On Back Press*/
    public static void InterstitialAdBackClick(Activity context) {

        if(MyApplication.getuser_balance() == 0) {

            MyApplication.backAdsClickCount++;

            if(MyApplication.backAdsClickCount == MyApplication.backclick) {

                MyApplication.backAdsClickCount = 0;

                if(MyApplication.Type1.contains("admob")){

                    context.finish();
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterOnBackAdMobFirst((Activity) context,  new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type1.contains("fb")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    FbInterstitialAd.getInstance().showInterOnBackFBFirst((Activity) context, dialog);

                } else if(MyApplication.Type1.contains("max")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterOnBackMAXFirst((Activity) context, dialog);

                } else if(MyApplication.Type1.contains("qureka")){

                    context.finish();
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    /*if(MyApplication.CheckQureka != 0){
                        context.startActivity(new Intent(context, QurekaInterstitialClick.class));
                        context.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    context.finish();
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            } else {
                context.finish();
                context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        } else {
            context.finish();
            context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }

    }

    /*Inter Only*/
    public static void InterstitialAdsOnly(Activity context) {

        if(MyApplication.getuser_balance() == 0) {

            MyApplication.AdsClickCount++;

            if(MyApplication.AdsClickCount == MyApplication.click) {

                MyApplication.AdsClickCount = 0;

                if(MyApplication.Type1.contains("admob")){

                    AdMobInterstitialClick.getInstance().showInterOnlyAdMobFirst((Activity) context, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type1.contains("fb")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    dialog.show();

                    FbInterstitialAd.getInstance().showInterOnlyFBFirst((Activity) context, dialog);

                } else if(MyApplication.Type1.contains("max")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterOnlyMAXFirst((Activity) context, dialog);

                } else if(MyApplication.Type1.contains("qureka")){

                    /*if(MyApplication.CheckQureka != 0){
                        context.startActivity(new Intent(context, QurekaInterstitialClick.class));
                        context.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {

                }
            } else {

            }
        } else {

        }

    }



    /*Reguler Big Native Ads*/
    public static void RegulerBigNative(Context context, FrameLayout admob_native_frame, NativeAdLayout nativeAdLayout, FrameLayout nativeMax) {

        if (MyApplication.getuser_balance() == 0) {

            if(MyApplication.Type1.contains("admob")){

                AdMobNative.getInstance().showNativeBigFirst((Activity) context, admob_native_frame, nativeAdLayout, nativeMax);

            } else if(MyApplication.Type1.contains("fb")){

                com.facebook.ads.NativeAd nativeAd = new com.facebook.ads.NativeAd(context, MyApplication.Fbnative);
                nativeAd.loadAd(nativeAd.buildLoadAdConfig().withAdListener(new FbNativeFullAds(nativeAd, context, nativeAdLayout, admob_native_frame, nativeMax, "type2")).build());

            } else if(MyApplication.Type1.contains("max")){

                MAXNativeAds.NativeAdsMAXFirst(context, nativeMax, admob_native_frame, nativeAdLayout);

            } else if(MyApplication.Type1.contains("qureka")){

                /*if(MyApplication.CheckQureka != 0){
                    new QurekaBigNative((Activity) context, admob_native_frame);
                }*/

            } else {
                admob_native_frame.setVisibility(View.GONE);
                nativeAdLayout.setVisibility(View.GONE);
            }

        } else {
            admob_native_frame.setVisibility(View.GONE);
            nativeAdLayout.setVisibility(View.GONE);
        }

    }

    /*Reguler Small Native Ads*/
    public static void SmallNative(Context context, FrameLayout admob_small_native, NativeAdLayout native_banner_ad_container) {

        if (MyApplication.getuser_balance() == 0) {

            if(MyApplication.Type1.contains("admob")){

                AdMobNative.getInstance().showNativeSmallFirst((Activity) context, admob_small_native, native_banner_ad_container);

            } else if(MyApplication.Type1.contains("fb")){

                NativeBannerAd nativeBannerAd = new NativeBannerAd(context, MyApplication.FbNativeB);
                nativeBannerAd.loadAd(nativeBannerAd.buildLoadAdConfig().withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withAdListener(
                        new FbNativeSmallAds(nativeBannerAd, context, new LinearLayout[1], native_banner_ad_container, admob_small_native, "type2")).build());

            } else if(MyApplication.Type1.contains("max")){

                MAXNativeSmallAds.MAXNativeSmallFirst(context, admob_small_native, native_banner_ad_container);

            } else if(MyApplication.Type1.contains("qureka")){

                /*if(MyApplication.CheckQureka != 0){
                    new QurekaSmallNative((Activity) context, admob_small_native);
                }*/

            } else {
                admob_small_native.setVisibility(View.GONE);
                native_banner_ad_container.setVisibility(View.GONE);
            }

        } else {
            admob_small_native.setVisibility(View.GONE);
            native_banner_ad_container.setVisibility(View.GONE);
        }

    }

    /*Reguler Banner Ads*/
    public static void RegulerBanner(Context context, RelativeLayout admob_banner, LinearLayout adContainer, FrameLayout qureka) {

        if (MyApplication.getuser_balance() == 0) {

            if(MyApplication.Type1.contains("admob")){

                admob_banner.setVisibility(View.VISIBLE);
                new AdMobBanner().showAd((Activity) context, admob_banner, adContainer, qureka, "type2", new AdMobBanner.adMobSmallAdCallback() {
                    @Override
                    public void onAdLoaded() {
                    }

                    @Override
                    public void onAdError(String error) {
                    }
                });

            } else if(MyApplication.Type1.contains("fb")){

                FbBannerAds.showFbAds(context, admob_banner, adContainer, qureka, "type2");

            } else if(MyApplication.Type1.contains("max")){

                MAXBannerAds.MAXBanner(context, admob_banner, adContainer, qureka, "type2");

            } else if(MyApplication.Type1.contains("qureka")){

                /*if(MyApplication.CheckQureka != 0){
                    new QurekaBannerAds((Activity) context, qureka);
                }*/

            } else {
                admob_banner.setVisibility(View.GONE);
                adContainer.setVisibility(View.GONE);
            }

        } else {
            admob_banner.setVisibility(View.GONE);
            adContainer.setVisibility(View.GONE);
        }

    }

}
