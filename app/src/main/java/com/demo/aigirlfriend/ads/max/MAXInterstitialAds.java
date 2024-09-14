package com.demo.aigirlfriend.ads.max;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.demo.aigirlfriend.R;
import com.demo.aigirlfriend.ads.MyApplication;
import com.demo.aigirlfriend.ads.admob.AdMobInterstitialClick;
import com.demo.aigirlfriend.ads.fb.FbInterstitialAd;

public class MAXInterstitialAds {

    public static MaxInterstitialAd maxInterstitialAd;


    /*Show Interstial Ads With Only Intent*/

    public static void showInterMAXFirst(Activity context, Dialog dialog, Intent intent) {

        maxInterstitialAd = new MaxInterstitialAd(MyApplication.MAX_Int, context);
        MaxAdListener adListener = new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {
                dialog.dismiss();
                if (maxInterstitialAd.isReady()) {
                    maxInterstitialAd.showAd();
                }
            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {
                dialog.dismiss();
                context.startActivity(intent);
            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                dialog.dismiss();
                context.startActivity(intent);

                if(MyApplication.Type2.contains("max")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterMAXSecond((Activity) context, dialog, intent);

                } else if(MyApplication.Type2.contains("admob")){

                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterAdMobSecond((Activity) context, intent, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type2.contains("fb")){

                    //final Dialog dialog = new Dialog(context);
                    //dialog.setContentView(R.layout.ads_dialog);
                    //dialog.setCancelable(false);
                    //dialog.show();

                    FbInterstitialAd.getInstance().showInterFBSecond( context, dialog, intent);

                } else if(MyApplication.Type2.contains("qureka")){

                    //context.startActivity(intent);

                    /*if(MyApplication.CheckQureka != 0){
                        context.startActivity(new Intent(context, QurekaInterstitialClick.class));
                        context.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }


            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        };
        maxInterstitialAd.setListener(adListener);
        maxInterstitialAd.loadAd();

    }

    public static void showInterMAXSecond(Activity context, Dialog dialog, Intent intent) {

        maxInterstitialAd = new MaxInterstitialAd(MyApplication.MAX_Int, context);
        MaxAdListener adListener = new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {
                dialog.dismiss();
                if (maxInterstitialAd.isReady()) {
                    maxInterstitialAd.showAd();
                }
            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {
                dialog.dismiss();
                //context.startActivity(intent);
            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                dialog.dismiss();
                //context.startActivity(intent);

                if(MyApplication.Type3.contains("max")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterMAXThird((Activity) context, dialog, intent);

                } else if(MyApplication.Type3.contains("admob")){

                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterAdMobThird((Activity) context, intent, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type3.contains("fb")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    dialog.show();

                    FbInterstitialAd.getInstance().showInterFBThird( context, dialog, intent);

                } else if(MyApplication.Type3.contains("qureka")){

                    //context.startActivity(intent);

                    /*if(MyApplication.CheckQureka != 0){
                        context.startActivity(new Intent(context, QurekaInterstitialClick.class));
                        context.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }


            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        };
        maxInterstitialAd.setListener(adListener);
        maxInterstitialAd.loadAd();

    }

    public static void showInterMAXThird(Activity context, Dialog dialog, Intent intent) {

        maxInterstitialAd = new MaxInterstitialAd(MyApplication.MAX_Int, context);
        MaxAdListener adListener = new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {
                dialog.dismiss();
                if (maxInterstitialAd.isReady()) {
                    maxInterstitialAd.showAd();
                }
            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {
                dialog.dismiss();
                //context.startActivity(intent);
            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                dialog.dismiss();
                //context.startActivity(intent);

                if(MyApplication.Type4.contains("max")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterMAXFour((Activity) context, dialog, intent);

                } else if(MyApplication.Type4.contains("admob")){

                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterAdMobFour((Activity) context, intent, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type4.contains("fb")){

                    //final Dialog dialog = new Dialog(context);
                    //dialog.setContentView(R.layout.ads_dialog);
                    //dialog.setCancelable(false);
                    //dialog.show();

                    FbInterstitialAd.getInstance().showInterFBFour( context, dialog, intent);

                } else if(MyApplication.Type4.contains("qureka")){

                    //context.startActivity(intent);

                    /*if(MyApplication.CheckQureka != 0){
                        context.startActivity(new Intent(context, QurekaInterstitialClick.class));
                        context.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }


            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        };
        maxInterstitialAd.setListener(adListener);
        maxInterstitialAd.loadAd();

    }

    public static void showInterMAXFour(Activity context, Dialog dialog, Intent intent) {

        maxInterstitialAd = new MaxInterstitialAd(MyApplication.MAX_Int, context);
        MaxAdListener adListener = new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {
                dialog.dismiss();
                if (maxInterstitialAd.isReady()) {
                    maxInterstitialAd.showAd();
                }
            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {
                dialog.dismiss();
                //context.startActivity(intent);
            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                dialog.dismiss();
                //context.startActivity(intent);

            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        };
        maxInterstitialAd.setListener(adListener);
        maxInterstitialAd.loadAd();

    }


    /*Show Interstial Ads with Intent & Finish*/

    public static void showInterOnFinishMAXFirst(Activity context, Dialog dialog, Intent intent) {

        maxInterstitialAd = new MaxInterstitialAd(MyApplication.MAX_Int, context);
        MaxAdListener adListener = new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {
                dialog.dismiss();
                if (maxInterstitialAd.isReady()) {
                    maxInterstitialAd.showAd();
                }
            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {
                dialog.dismiss();
                context.startActivity(intent);
                context.finish();
            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                dialog.dismiss();
                context.startActivity(intent);
                context.finish();

                if(MyApplication.Type2.contains("max")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterOnFinishMAXSecond((Activity) context, dialog, intent);

                } else if(MyApplication.Type2.contains("admob")){

                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterOnFinishAdMobSecond((Activity) context, intent, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type2.contains("fb")){

                    //final Dialog dialog = new Dialog(context);
                    //dialog.setContentView(R.layout.ads_dialog);
                    //dialog.setCancelable(false);
                    //dialog.show();

                    FbInterstitialAd.getInstance().showInterOnFinishFBSecond( context, dialog, intent);

                } else if(MyApplication.Type2.contains("qureka")){

                    //context.startActivity(intent);

                    /*if(MyApplication.CheckQureka != 0){
                        context.startActivity(new Intent(context, QurekaInterstitialClick.class));
                        context.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }


            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        };
        maxInterstitialAd.setListener(adListener);
        maxInterstitialAd.loadAd();

    }

    public static void showInterOnFinishMAXSecond(Activity context, Dialog dialog, Intent intent) {

        maxInterstitialAd = new MaxInterstitialAd(MyApplication.MAX_Int, context);
        MaxAdListener adListener = new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {
                dialog.dismiss();
                if (maxInterstitialAd.isReady()) {
                    maxInterstitialAd.showAd();
                }
            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {
                dialog.dismiss();
                //context.startActivity(intent);
            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                dialog.dismiss();
                //context.startActivity(intent);

                if(MyApplication.Type3.contains("max")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterOnFinishMAXThird((Activity) context, dialog, intent);

                } else if(MyApplication.Type3.contains("admob")){

                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterOnFinishAdMobThird((Activity) context, intent, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type3.contains("fb")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    dialog.show();

                    FbInterstitialAd.getInstance().showInterOnFinishFBThird( context, dialog, intent);

                } else if(MyApplication.Type3.contains("qureka")){

                    //context.startActivity(intent);

                    /*if(MyApplication.CheckQureka != 0){
                        context.startActivity(new Intent(context, QurekaInterstitialClick.class));
                        context.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }


            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        };
        maxInterstitialAd.setListener(adListener);
        maxInterstitialAd.loadAd();

    }

    public static void showInterOnFinishMAXThird(Activity context, Dialog dialog, Intent intent) {

        maxInterstitialAd = new MaxInterstitialAd(MyApplication.MAX_Int, context);
        MaxAdListener adListener = new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {
                dialog.dismiss();
                if (maxInterstitialAd.isReady()) {
                    maxInterstitialAd.showAd();
                }
            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {
                dialog.dismiss();
                //context.startActivity(intent);
            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                dialog.dismiss();
                //context.startActivity(intent);

                if(MyApplication.Type4.contains("max")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterOnFinishMAXFour((Activity) context, dialog, intent);

                } else if(MyApplication.Type4.contains("admob")){

                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterOnFinishAdMobFour((Activity) context, intent, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type4.contains("fb")){

                    //final Dialog dialog = new Dialog(context);
                    //dialog.setContentView(R.layout.ads_dialog);
                    //dialog.setCancelable(false);
                    //dialog.show();

                    FbInterstitialAd.getInstance().showInterOnFinishFBFour( context, dialog, intent);

                } else if(MyApplication.Type4.contains("qureka")){

                    //context.startActivity(intent);

                    /*if(MyApplication.CheckQureka != 0){
                        context.startActivity(new Intent(context, QurekaInterstitialClick.class));
                        context.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }


            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        };
        maxInterstitialAd.setListener(adListener);
        maxInterstitialAd.loadAd();

    }

    public static void showInterOnFinishMAXFour(Activity context, Dialog dialog, Intent intent) {

        maxInterstitialAd = new MaxInterstitialAd(MyApplication.MAX_Int, context);
        MaxAdListener adListener = new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {
                dialog.dismiss();
                if (maxInterstitialAd.isReady()) {
                    maxInterstitialAd.showAd();
                }
            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {
                dialog.dismiss();
                //context.startActivity(intent);
            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                dialog.dismiss();
                //context.startActivity(intent);

            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        };
        maxInterstitialAd.setListener(adListener);
        maxInterstitialAd.loadAd();

    }


    /*Show Interstial Ads On Back Press*/

    public static void showInterOnBackMAXFirst(Activity context, Dialog dialog) {

        maxInterstitialAd = new MaxInterstitialAd(MyApplication.MAX_Int, context);
        MaxAdListener adListener = new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {
                dialog.dismiss();
                if (maxInterstitialAd.isReady()) {
                    maxInterstitialAd.showAd();
                }
            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {
                dialog.dismiss();
                context.finish();
            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                dialog.dismiss();
                context.finish();

                if(MyApplication.Type2.contains("max")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterOnBackMAXSecond((Activity) context, dialog);

                } else if(MyApplication.Type2.contains("admob")){

                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterOnBackAdMobSecond((Activity) context, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type2.contains("fb")){

                    //final Dialog dialog = new Dialog(context);
                    //dialog.setContentView(R.layout.ads_dialog);
                    //dialog.setCancelable(false);
                    //dialog.show();

                    FbInterstitialAd.getInstance().showInterOnBackFBSecond( context, dialog);

                } else if(MyApplication.Type2.contains("qureka")){

                    //context.startActivity(intent);

                    /*if(MyApplication.CheckQureka != 0){
                        context.startActivity(new Intent(context, QurekaInterstitialClick.class));
                        context.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }


            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        };
        maxInterstitialAd.setListener(adListener);
        maxInterstitialAd.loadAd();

    }

    public static void showInterOnBackMAXSecond(Activity context, Dialog dialog) {

        maxInterstitialAd = new MaxInterstitialAd(MyApplication.MAX_Int, context);
        MaxAdListener adListener = new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {
                dialog.dismiss();
                if (maxInterstitialAd.isReady()) {
                    maxInterstitialAd.showAd();
                }
            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {
                dialog.dismiss();
                //context.startActivity(intent);
            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                dialog.dismiss();
                //context.startActivity(intent);

                if(MyApplication.Type3.contains("max")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterOnBackMAXThird((Activity) context, dialog);

                } else if(MyApplication.Type3.contains("admob")){

                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterOnBackAdMobThird((Activity) context, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type3.contains("fb")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    dialog.show();

                    FbInterstitialAd.getInstance().showInterOnBackFBThird( context, dialog);

                } else if(MyApplication.Type3.contains("qureka")){

                    //context.startActivity(intent);

                    /*if(MyApplication.CheckQureka != 0){
                        context.startActivity(new Intent(context, QurekaInterstitialClick.class));
                        context.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }


            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        };
        maxInterstitialAd.setListener(adListener);
        maxInterstitialAd.loadAd();

    }

    public static void showInterOnBackMAXThird(Activity context, Dialog dialog) {

        maxInterstitialAd = new MaxInterstitialAd(MyApplication.MAX_Int, context);
        MaxAdListener adListener = new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {
                dialog.dismiss();
                if (maxInterstitialAd.isReady()) {
                    maxInterstitialAd.showAd();
                }
            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {
                dialog.dismiss();
                //context.startActivity(intent);
            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                dialog.dismiss();
                //context.startActivity(intent);

                if(MyApplication.Type4.contains("max")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterOnBackMAXFour((Activity) context, dialog);

                } else if(MyApplication.Type4.contains("admob")){

                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterOnBackAdMobFour((Activity) context, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type4.contains("fb")){

                    //final Dialog dialog = new Dialog(context);
                    //dialog.setContentView(R.layout.ads_dialog);
                    //dialog.setCancelable(false);
                    //dialog.show();

                    FbInterstitialAd.getInstance().showInterOnBackFBFour( context, dialog);

                } else if(MyApplication.Type4.contains("qureka")){

                    //context.startActivity(intent);

                    /*if(MyApplication.CheckQureka != 0){
                        context.startActivity(new Intent(context, QurekaInterstitialClick.class));
                        context.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }


            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        };
        maxInterstitialAd.setListener(adListener);
        maxInterstitialAd.loadAd();

    }

    public static void showInterOnBackMAXFour(Activity context, Dialog dialog) {

        maxInterstitialAd = new MaxInterstitialAd(MyApplication.MAX_Int, context);
        MaxAdListener adListener = new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {
                dialog.dismiss();
                if (maxInterstitialAd.isReady()) {
                    maxInterstitialAd.showAd();
                }
            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {
                dialog.dismiss();
                //context.startActivity(intent);
            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                dialog.dismiss();
                //context.startActivity(intent);

            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        };
        maxInterstitialAd.setListener(adListener);
        maxInterstitialAd.loadAd();

    }


    /*Show Interstial Ads Only*/

    public static void showInterOnlyMAXFirst(Activity context, Dialog dialog) {

        maxInterstitialAd = new MaxInterstitialAd(MyApplication.MAX_Int, context);
        MaxAdListener adListener = new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {
                dialog.dismiss();
                if (maxInterstitialAd.isReady()) {
                    maxInterstitialAd.showAd();
                }
            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {
                dialog.dismiss();
            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                dialog.dismiss();

                if(MyApplication.Type2.contains("max")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterOnlyMAXSecond((Activity) context, dialog);

                } else if(MyApplication.Type2.contains("admob")){

                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterOnlyAdMobSecond((Activity) context, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type2.contains("fb")){

                    //final Dialog dialog = new Dialog(context);
                    //dialog.setContentView(R.layout.ads_dialog);
                    //dialog.setCancelable(false);
                    //dialog.show();

                    FbInterstitialAd.getInstance().showInterOnlyFBSecond( context, dialog);

                } else if(MyApplication.Type2.contains("qureka")){

                    //context.startActivity(intent);

                    /*if(MyApplication.CheckQureka != 0){
                        context.startActivity(new Intent(context, QurekaInterstitialClick.class));
                        context.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }


            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        };
        maxInterstitialAd.setListener(adListener);
        maxInterstitialAd.loadAd();

    }

    public static void showInterOnlyMAXSecond(Activity context, Dialog dialog) {

        maxInterstitialAd = new MaxInterstitialAd(MyApplication.MAX_Int, context);
        MaxAdListener adListener = new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {
                dialog.dismiss();
                if (maxInterstitialAd.isReady()) {
                    maxInterstitialAd.showAd();
                }
            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {
                dialog.dismiss();
                //context.startActivity(intent);
            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                dialog.dismiss();
                //context.startActivity(intent);

                if(MyApplication.Type3.contains("max")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterOnlyMAXThird((Activity) context, dialog);

                } else if(MyApplication.Type3.contains("admob")){

                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterOnlyAdMobThird((Activity) context, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type3.contains("fb")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    dialog.show();

                    FbInterstitialAd.getInstance().showInterOnlyFBThird( context, dialog);

                } else if(MyApplication.Type3.contains("qureka")){

                    //context.startActivity(intent);

                    /*if(MyApplication.CheckQureka != 0){
                        context.startActivity(new Intent(context, QurekaInterstitialClick.class));
                        context.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }


            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        };
        maxInterstitialAd.setListener(adListener);
        maxInterstitialAd.loadAd();

    }

    public static void showInterOnlyMAXThird(Activity context, Dialog dialog) {

        maxInterstitialAd = new MaxInterstitialAd(MyApplication.MAX_Int, context);
        MaxAdListener adListener = new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {
                dialog.dismiss();
                if (maxInterstitialAd.isReady()) {
                    maxInterstitialAd.showAd();
                }
            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {
                dialog.dismiss();
                //context.startActivity(intent);
            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                dialog.dismiss();
                //context.startActivity(intent);

                if(MyApplication.Type4.contains("max")){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.ads_dialog);
                    dialog.setCancelable(false);
                    //dialog.show();

                    MAXInterstitialAds.showInterOnlyMAXFour((Activity) context, dialog);

                } else if(MyApplication.Type4.contains("admob")){

                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    AdMobInterstitialClick.getInstance().showInterOnlyAdMobFour((Activity) context, new AdMobInterstitialClick.MyCallback() {
                        @Override
                        public void callbackCall() {

                        }
                    });

                } else if(MyApplication.Type4.contains("fb")){

                    //final Dialog dialog = new Dialog(context);
                    //dialog.setContentView(R.layout.ads_dialog);
                    //dialog.setCancelable(false);
                    //dialog.show();

                    FbInterstitialAd.getInstance().showInterOnlyFBFour( context, dialog);

                } else if(MyApplication.Type4.contains("qureka")){

                    //context.startActivity(intent);

                    /*if(MyApplication.CheckQureka != 0){
                        context.startActivity(new Intent(context, QurekaInterstitialClick.class));
                        context.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                    }*/

                } else {
                    //context.startActivity(intent);
                    context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }


            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        };
        maxInterstitialAd.setListener(adListener);
        maxInterstitialAd.loadAd();

    }

    public static void showInterOnlyMAXFour(Activity context, Dialog dialog) {

        maxInterstitialAd = new MaxInterstitialAd(MyApplication.MAX_Int, context);
        MaxAdListener adListener = new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {
                dialog.dismiss();
                if (maxInterstitialAd.isReady()) {
                    maxInterstitialAd.showAd();
                }
            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {
                dialog.dismiss();
                //context.startActivity(intent);
            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                dialog.dismiss();
                //context.startActivity(intent);

            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        };
        maxInterstitialAd.setListener(adListener);
        maxInterstitialAd.loadAd();

    }


}
