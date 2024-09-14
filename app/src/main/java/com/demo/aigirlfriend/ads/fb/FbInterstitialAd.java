package com.demo.aigirlfriend.ads.fb;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.demo.aigirlfriend.R;
import com.demo.aigirlfriend.ads.MyApplication;
import com.demo.aigirlfriend.ads.admob.AdMobInterstitialClick;
import com.demo.aigirlfriend.ads.max.MAXInterstitialAds;

public class FbInterstitialAd {

    public static InterstitialAd interstitialAd;
    private static String TAG = "";
    private static Activity mContext;
    private static FbInterstitialAd mInstance;
    private Dialog mDialogue;
    private Intent mIntent;

    public static FbInterstitialAd getInstance() {
        if (mInstance == null) {
            mInstance = new FbInterstitialAd();
        }
        return mInstance;
    }



    /*Show Interstial Ads With Only Intent*/

    public void showInterFBFirst(Activity context, Dialog dialog, Intent intent) {

        mContext = context;
        mDialogue = dialog;
        mIntent = intent;

        AudienceNetworkAds.initialize(context);

        interstitialAd = new InterstitialAd(context, MyApplication.FbInter);

        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                mContext.startActivity(intent);
                context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//                mContext.finish();

            }

            @Override
            public void onError(Ad ad, AdError adError) {

                mDialogue.dismiss();
                context.startActivity(intent);

                if(MyApplication.Type2.contains("fb")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    FbInterstitialAd.getInstance().showInterFBSecond( context, dialog, intent);

                } else if(MyApplication.Type2.contains("admob")){

                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterAdMobSecond((Activity) context, intent, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type2.contains("max")){

                    //final Dialog dialog = new Dialog(context);
                    //dialog.setContentView(R.layout.ads_dialog);
                    //dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterMAXSecond((Activity) context, dialog, intent);

                } else if(MyApplication.Type2.contains("qureka")){

                    //mContext.startActivity(intent);

                    /*if(MyApplication.CheckQureka != 0){
                        mContext.startActivity(new Intent(mContext, QurekaInterstitialClick.class));
                        mContext.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //mContext.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }

//                mContext.finish();
//                loadFbInter(mContext, mDialogue, mIntent);

            }


            @Override
            public void onAdLoaded(Ad ad) {
                mDialogue.dismiss();
                if (interstitialAd != null && interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };

        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());

    }

    public void showInterFBSecond(Activity context, Dialog dialog, Intent intent) {

        mContext = context;
        mDialogue = dialog;
        mIntent = intent;

        AudienceNetworkAds.initialize(context);

        interstitialAd = new InterstitialAd(context, MyApplication.FbInter);

        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                //mContext.startActivity(intent);
                //context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//                mContext.finish();

            }

            @Override
            public void onError(Ad ad, AdError adError) {

                mDialogue.dismiss();

                if(MyApplication.Type3.contains("fb")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    FbInterstitialAd.getInstance().showInterFBThird( context, dialog, intent);

                } else if(MyApplication.Type3.contains("admob")){

                    //context.startActivity(intent);
                    //context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterAdMobThird((Activity) context, intent, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type3.contains("max")){

                    //final Dialog dialog = new Dialog(context);
                    //dialog.setContentView(R.layout.ads_dialog);
                    //dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterMAXThird((Activity) context, dialog, intent);

                } else if(MyApplication.Type3.contains("qureka")){

                    /*if(MyApplication.CheckQureka != 0){
                        mContext.startActivity(new Intent(mContext, QurekaInterstitialClick.class));
                        mContext.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //mContext.startActivity(intent);
                    //context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }

//                mContext.finish();
//                loadFbInter(mContext, mDialogue, mIntent);

            }


            @Override
            public void onAdLoaded(Ad ad) {
                mDialogue.dismiss();
                if (interstitialAd != null && interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };

        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());

    }

    public void showInterFBThird(Activity context, Dialog dialog, Intent intent) {

        mContext = context;
        mDialogue = dialog;
        mIntent = intent;

        AudienceNetworkAds.initialize(context);

        interstitialAd = new InterstitialAd(context, MyApplication.FbInter);

        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                //mContext.startActivity(intent);
                context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//                mContext.finish();

            }

            @Override
            public void onError(Ad ad, AdError adError) {

                mDialogue.dismiss();

                if(MyApplication.Type4.contains("fb")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    FbInterstitialAd.getInstance().showInterFBFour( context, dialog, intent);

                } else if(MyApplication.Type4.contains("admob")){

                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterAdMobFour((Activity) context, intent, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type4.contains("max")){

                    //final Dialog dialog = new Dialog(context);
                    //dialog.setContentView(R.layout.ads_dialog);
                    //dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterMAXFour((Activity) context, dialog, intent);

                } else if(MyApplication.Type4.contains("qureka")){

                    //mContext.startActivity(intent);

                    /*if(MyApplication.CheckQureka != 0){
                        mContext.startActivity(new Intent(mContext, QurekaInterstitialClick.class));
                        mContext.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //mContext.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }

//                mContext.finish();
//                loadFbInter(mContext, mDialogue, mIntent);

            }


            @Override
            public void onAdLoaded(Ad ad) {
                mDialogue.dismiss();
                if (interstitialAd != null && interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };

        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());

    }

    public void showInterFBFour(Activity context, Dialog dialog, Intent intent) {

        mContext = context;
        mDialogue = dialog;
        mIntent = intent;

        AudienceNetworkAds.initialize(context);

        interstitialAd = new InterstitialAd(context, MyApplication.FbInter);

        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                //mContext.startActivity(intent);
                context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//                mContext.finish();

            }

            @Override
            public void onError(Ad ad, AdError adError) {

                mDialogue.dismiss();

                //mContext.startActivity(intent);
                context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);


//                mContext.finish();
//                loadFbInter(mContext, mDialogue, mIntent);

            }


            @Override
            public void onAdLoaded(Ad ad) {
                mDialogue.dismiss();
                if (interstitialAd != null && interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };

        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());

    }


    /*Show Interstial Ads with Intent & Finish*/

    public void showInterOnFinishFBFirst(Activity context, Dialog dialog, Intent intent) {

        mContext = context;
        mDialogue = dialog;
        mIntent = intent;

        AudienceNetworkAds.initialize(context);

        interstitialAd = new InterstitialAd(context, MyApplication.FbInter);

        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                mContext.startActivity(intent);
                mContext.finish();
                context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//                mContext.finish();

            }

            @Override
            public void onError(Ad ad, AdError adError) {

                mDialogue.dismiss();
                context.startActivity(intent);
                context.finish();

                if(MyApplication.Type2.contains("fb")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    FbInterstitialAd.getInstance().showInterOnFinishFBSecond((Activity) context, dialog, intent);

                } else if(MyApplication.Type2.contains("admob")){

                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterOnFinishAdMobSecond((Activity) context, intent, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type2.contains("max")){

                    //final Dialog dialog = new Dialog(context);
                    //dialog.setContentView(R.layout.ads_dialog);
                    //dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterOnFinishMAXSecond((Activity) context, dialog, intent);

                } else if(MyApplication.Type2.contains("qureka")){

                    //mContext.startActivity(intent);

                    /*if(MyApplication.CheckQureka != 0){
                        mContext.startActivity(new Intent(mContext, QurekaInterstitialClick.class));
                        mContext.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //mContext.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }

//                mContext.finish();
//                loadFbInter(mContext, mDialogue, mIntent);

            }


            @Override
            public void onAdLoaded(Ad ad) {
                mDialogue.dismiss();
                if (interstitialAd != null && interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };

        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());

    }

    public void showInterOnFinishFBSecond(Activity context, Dialog dialog, Intent intent) {

        mContext = context;
        mDialogue = dialog;
        mIntent = intent;

        AudienceNetworkAds.initialize(context);

        interstitialAd = new InterstitialAd(context, MyApplication.FbInter);

        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                //mContext.startActivity(intent);
                //context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//                mContext.finish();

            }

            @Override
            public void onError(Ad ad, AdError adError) {

                mDialogue.dismiss();

                if(MyApplication.Type3.contains("fb")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    FbInterstitialAd.getInstance().showInterOnFinishFBThird((Activity) context, dialog, intent);

                } else if(MyApplication.Type3.contains("admob")){

                    //context.startActivity(intent);
                    //context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterOnFinishAdMobThird((Activity) context, intent, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type3.contains("max")){

                    //final Dialog dialog = new Dialog(context);
                    //dialog.setContentView(R.layout.ads_dialog);
                    //dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterOnFinishMAXThird((Activity) context, dialog, intent);

                } else if(MyApplication.Type3.contains("qureka")){

                    /*if(MyApplication.CheckQureka != 0){
                        mContext.startActivity(new Intent(mContext, QurekaInterstitialClick.class));
                        mContext.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //mContext.startActivity(intent);
                    //context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }

//                mContext.finish();
//                loadFbInter(mContext, mDialogue, mIntent);

            }


            @Override
            public void onAdLoaded(Ad ad) {
                mDialogue.dismiss();
                if (interstitialAd != null && interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };

        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());

    }

    public void showInterOnFinishFBThird(Activity context, Dialog dialog, Intent intent) {

        mContext = context;
        mDialogue = dialog;
        mIntent = intent;

        AudienceNetworkAds.initialize(context);

        interstitialAd = new InterstitialAd(context, MyApplication.FbInter);

        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                //mContext.startActivity(intent);
                context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//                mContext.finish();

            }

            @Override
            public void onError(Ad ad, AdError adError) {

                mDialogue.dismiss();

                if(MyApplication.Type4.contains("fb")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    FbInterstitialAd.getInstance().showInterOnFinishFBFour((Activity) context, dialog, intent);

                } else if(MyApplication.Type4.contains("admob")){

                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterOnFinishAdMobFour((Activity) context, intent, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type4.contains("max")){

                    //final Dialog dialog = new Dialog(context);
                    //dialog.setContentView(R.layout.ads_dialog);
                    //dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterOnFinishMAXFour((Activity) context, dialog, intent);

                } else if(MyApplication.Type4.contains("qureka")){

                    //mContext.startActivity(intent);

                    /*if(MyApplication.CheckQureka != 0){
                        mContext.startActivity(new Intent(mContext, QurekaInterstitialClick.class));
                        mContext.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //mContext.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }

//                mContext.finish();
//                loadFbInter(mContext, mDialogue, mIntent);

            }


            @Override
            public void onAdLoaded(Ad ad) {
                mDialogue.dismiss();
                if (interstitialAd != null && interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };

        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());

    }

    public void showInterOnFinishFBFour(Activity context, Dialog dialog, Intent intent) {

        mContext = context;
        mDialogue = dialog;
        mIntent = intent;

        AudienceNetworkAds.initialize(context);

        interstitialAd = new InterstitialAd(context, MyApplication.FbInter);

        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                //mContext.startActivity(intent);
                context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//                mContext.finish();

            }

            @Override
            public void onError(Ad ad, AdError adError) {

                mDialogue.dismiss();

                //mContext.startActivity(intent);
                context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);


//                mContext.finish();
//                loadFbInter(mContext, mDialogue, mIntent);

            }


            @Override
            public void onAdLoaded(Ad ad) {
                mDialogue.dismiss();
                if (interstitialAd != null && interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };

        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());

    }


    /*Show Interstial Ads On Back Press*/

    public void showInterOnBackFBFirst(Activity context, Dialog dialog) {

        mContext = context;
        mDialogue = dialog;

        AudienceNetworkAds.initialize(context);

        interstitialAd = new InterstitialAd(context, MyApplication.FbInter);

        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                mContext.finish();
                context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//                mContext.finish();

            }

            @Override
            public void onError(Ad ad, AdError adError) {

                mDialogue.dismiss();
                mContext.finish();

                if(MyApplication.Type2.contains("fb")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    FbInterstitialAd.getInstance().showInterOnBackFBSecond((Activity) context, dialog);

                } else if(MyApplication.Type2.contains("admob")){

                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterOnBackAdMobSecond((Activity) context, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type2.contains("max")){

                    //final Dialog dialog = new Dialog(context);
                    //dialog.setContentView(R.layout.ads_dialog);
                    //dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterOnBackMAXSecond((Activity) context, dialog);

                } else if(MyApplication.Type2.contains("qureka")){

                    //mContext.startActivity(intent);

                    /*if(MyApplication.CheckQureka != 0){
                        mContext.startActivity(new Intent(mContext, QurekaInterstitialClick.class));
                        mContext.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //mContext.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }

//                mContext.finish();
//                loadFbInter(mContext, mDialogue, mIntent);

            }


            @Override
            public void onAdLoaded(Ad ad) {
                mDialogue.dismiss();
                if (interstitialAd != null && interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };

        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());

    }

    public void showInterOnBackFBSecond(Activity context, Dialog dialog) {

        mContext = context;
        mDialogue = dialog;

        AudienceNetworkAds.initialize(context);

        interstitialAd = new InterstitialAd(context, MyApplication.FbInter);

        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                //mContext.startActivity(intent);
                //context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//                mContext.finish();

            }

            @Override
            public void onError(Ad ad, AdError adError) {

                mDialogue.dismiss();

                if(MyApplication.Type3.contains("fb")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    FbInterstitialAd.getInstance().showInterOnBackFBThird((Activity) context, dialog);

                } else if(MyApplication.Type3.contains("admob")){

                    //context.startActivity(intent);
                    //context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterOnBackAdMobThird((Activity) context, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type3.contains("max")){

                    //final Dialog dialog = new Dialog(context);
                    //dialog.setContentView(R.layout.ads_dialog);
                    //dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterOnBackMAXThird((Activity) context, dialog);

                } else if(MyApplication.Type3.contains("qureka")){

                    /*if(MyApplication.CheckQureka != 0){
                        mContext.startActivity(new Intent(mContext, QurekaInterstitialClick.class));
                        mContext.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //mContext.startActivity(intent);
                    //context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }

//                mContext.finish();
//                loadFbInter(mContext, mDialogue, mIntent);

            }


            @Override
            public void onAdLoaded(Ad ad) {
                mDialogue.dismiss();
                if (interstitialAd != null && interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };

        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());

    }

    public void showInterOnBackFBThird(Activity context, Dialog dialog) {

        mContext = context;
        mDialogue = dialog;

        AudienceNetworkAds.initialize(context);

        interstitialAd = new InterstitialAd(context, MyApplication.FbInter);

        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                //mContext.startActivity(intent);
                context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//                mContext.finish();

            }

            @Override
            public void onError(Ad ad, AdError adError) {

                mDialogue.dismiss();

                if(MyApplication.Type4.contains("fb")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    FbInterstitialAd.getInstance().showInterOnBackFBFour((Activity) context, dialog);

                } else if(MyApplication.Type4.contains("admob")){

                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterOnBackAdMobFour((Activity) context, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type4.contains("max")){

                    //final Dialog dialog = new Dialog(context);
                    //dialog.setContentView(R.layout.ads_dialog);
                    //dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterOnBackMAXFour((Activity) context, dialog);

                } else if(MyApplication.Type4.contains("qureka")){

                    //mContext.startActivity(intent);

                    /*if(MyApplication.CheckQureka != 0){
                        mContext.startActivity(new Intent(mContext, QurekaInterstitialClick.class));
                        mContext.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //mContext.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }

//                mContext.finish();
//                loadFbInter(mContext, mDialogue, mIntent);

            }


            @Override
            public void onAdLoaded(Ad ad) {
                mDialogue.dismiss();
                if (interstitialAd != null && interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };

        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());

    }

    public void showInterOnBackFBFour(Activity context, Dialog dialog) {

        mContext = context;
        mDialogue = dialog;

        AudienceNetworkAds.initialize(context);

        interstitialAd = new InterstitialAd(context, MyApplication.FbInter);

        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                //mContext.startActivity(intent);
                context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//                mContext.finish();

            }

            @Override
            public void onError(Ad ad, AdError adError) {

                mDialogue.dismiss();

                //mContext.startActivity(intent);
                context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);


//                mContext.finish();
//                loadFbInter(mContext, mDialogue, mIntent);

            }


            @Override
            public void onAdLoaded(Ad ad) {
                mDialogue.dismiss();
                if (interstitialAd != null && interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };

        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());

    }


    /*Show Interstial Ads Only*/

    public void showInterOnlyFBFirst(Activity context, Dialog dialog) {

        mContext = context;
        mDialogue = dialog;

        AudienceNetworkAds.initialize(context);

        interstitialAd = new InterstitialAd(context, MyApplication.FbInter);

        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
//                mContext.finish();

            }

            @Override
            public void onError(Ad ad, AdError adError) {

                mDialogue.dismiss();

                if(MyApplication.Type2.contains("fb")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    FbInterstitialAd.getInstance().showInterOnlyFBSecond((Activity) context, dialog);

                } else if(MyApplication.Type2.contains("admob")){

                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterOnlyAdMobSecond((Activity) context, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type2.contains("max")){

                    //final Dialog dialog = new Dialog(context);
                    //dialog.setContentView(R.layout.ads_dialog);
                    //dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterOnlyMAXSecond((Activity) context, dialog);

                } else if(MyApplication.Type2.contains("qureka")){

                    //mContext.startActivity(intent);

                    /*if(MyApplication.CheckQureka != 0){
                        mContext.startActivity(new Intent(mContext, QurekaInterstitialClick.class));
                        mContext.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //mContext.startActivity(intent);
                }

//                mContext.finish();
//                loadFbInter(mContext, mDialogue, mIntent);

            }


            @Override
            public void onAdLoaded(Ad ad) {
                mDialogue.dismiss();
                if (interstitialAd != null && interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };

        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());

    }

    public void showInterOnlyFBSecond(Activity context, Dialog dialog) {

        mContext = context;
        mDialogue = dialog;

        AudienceNetworkAds.initialize(context);

        interstitialAd = new InterstitialAd(context, MyApplication.FbInter);

        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                //mContext.startActivity(intent);
                //context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//                mContext.finish();

            }

            @Override
            public void onError(Ad ad, AdError adError) {

                mDialogue.dismiss();

                if(MyApplication.Type3.contains("fb")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    FbInterstitialAd.getInstance().showInterOnlyFBThird((Activity) context, dialog);

                } else if(MyApplication.Type3.contains("admob")){

                    //context.startActivity(intent);
                    //context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterOnlyAdMobThird((Activity) context, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type3.contains("max")){

                    //final Dialog dialog = new Dialog(context);
                    //dialog.setContentView(R.layout.ads_dialog);
                    //dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterOnlyMAXThird((Activity) context, dialog);

                } else if(MyApplication.Type3.contains("qureka")){

                    /*if(MyApplication.CheckQureka != 0){
                        mContext.startActivity(new Intent(mContext, QurekaInterstitialClick.class));
                        mContext.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //mContext.startActivity(intent);
                    //context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }

//                mContext.finish();
//                loadFbInter(mContext, mDialogue, mIntent);

            }


            @Override
            public void onAdLoaded(Ad ad) {
                mDialogue.dismiss();
                if (interstitialAd != null && interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };

        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());

    }

    public void showInterOnlyFBThird(Activity context, Dialog dialog) {

        mContext = context;
        mDialogue = dialog;

        AudienceNetworkAds.initialize(context);

        interstitialAd = new InterstitialAd(context, MyApplication.FbInter);

        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                //mContext.startActivity(intent);
                context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//                mContext.finish();

            }

            @Override
            public void onError(Ad ad, AdError adError) {

                mDialogue.dismiss();

                if(MyApplication.Type4.contains("fb")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    FbInterstitialAd.getInstance().showInterOnlyFBFour((Activity) context, dialog);

                } else if(MyApplication.Type4.contains("admob")){

                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterOnlyAdMobFour((Activity) context, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type4.contains("max")){

                    //final Dialog dialog = new Dialog(context);
                    //dialog.setContentView(R.layout.ads_dialog);
                    //dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterOnlyMAXFour((Activity) context, dialog);

                } else if(MyApplication.Type4.contains("qureka")){

                    //mContext.startActivity(intent);

                    /*if(MyApplication.CheckQureka != 0){
                        mContext.startActivity(new Intent(mContext, QurekaInterstitialClick.class));
                        mContext.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //mContext.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }

//                mContext.finish();
//                loadFbInter(mContext, mDialogue, mIntent);

            }


            @Override
            public void onAdLoaded(Ad ad) {
                mDialogue.dismiss();
                if (interstitialAd != null && interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };

        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());

    }

    public void showInterOnlyFBFour(Activity context, Dialog dialog) {

        mContext = context;
        mDialogue = dialog;

        AudienceNetworkAds.initialize(context);

        interstitialAd = new InterstitialAd(context, MyApplication.FbInter);

        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                //mContext.startActivity(intent);
                context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//                mContext.finish();

            }

            @Override
            public void onError(Ad ad, AdError adError) {

                mDialogue.dismiss();

                //mContext.startActivity(intent);
                context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);


//                mContext.finish();
//                loadFbInter(mContext, mDialogue, mIntent);

            }


            @Override
            public void onAdLoaded(Ad ad) {
                mDialogue.dismiss();
                if (interstitialAd != null && interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };

        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());

    }



}
