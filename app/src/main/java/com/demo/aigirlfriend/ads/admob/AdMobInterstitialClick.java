package com.demo.aigirlfriend.ads.admob;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.util.Log;

import com.demo.aigirlfriend.R;
import com.demo.aigirlfriend.ads.MyApplication;
import com.demo.aigirlfriend.ads.fb.FbInterstitialAd;
import com.demo.aigirlfriend.ads.max.MAXInterstitialAds;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class AdMobInterstitialClick {

    private static AdMobInterstitialClick mInstance;
    public InterstitialAd interstitialOne;
    public InterstitialAd interstitialThree;
    public InterstitialAd interstitialTwo;
    MyCallback myCallback;

    public interface MyCallback {
        void callbackCall();
    }

    public static AdMobInterstitialClick getInstance() {
        if (mInstance == null) {
            mInstance = new AdMobInterstitialClick();
        }
        return mInstance;
    }

    public void loadInterOne(final Activity activity) {
        MobileAds.initialize(activity, new OnInitializationCompleteListener() {
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        InterstitialAd.load(activity, MyApplication.AdMob_Int1, new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
            public void onAdLoaded(InterstitialAd interstitialAd) {
                AdMobInterstitialClick.this.interstitialOne = interstitialAd;
                Log.i("TAG", "onAdLoaded 1");
                AdMobInterstitialClick.this.interstitialOne.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdDismissedFullScreenContent() {
                        AdMobInterstitialClick.this.interstitialOne = null;
                        Log.d("TAG", "The ad 1 was dismissed.");


                        AdMobInterstitialClick.this.loadInterOne(activity);

                        if (AdMobInterstitialClick.this.myCallback != null) {
                            AdMobInterstitialClick.this.myCallback.callbackCall();
                            AdMobInterstitialClick.this.myCallback = null;
                        }
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        AdMobInterstitialClick.this.interstitialOne = null;
                        Log.d("TAG", "The ad 1 failed to show.");
                        AdMobInterstitialClick.this.loadInterOne(activity);

                    }
                });
            }

            public void onAdFailedToLoad(LoadAdError loadAdError) {
                Log.d("TAG", "The ad 1 Load Error.");
                AdMobInterstitialClick.this.interstitialOne = null;


            }
        });
    }

    public void loadInterTwo(final Activity activity) {
        MobileAds.initialize(activity, new OnInitializationCompleteListener() {
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        InterstitialAd.load(activity, MyApplication.AdMob_Int2, new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
            public void onAdLoaded(InterstitialAd interstitialAd) {
                AdMobInterstitialClick.this.interstitialTwo = interstitialAd;
                Log.i("TAG", "onAdLoaded 2");
                AdMobInterstitialClick.this.interstitialTwo.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdDismissedFullScreenContent() {
                        AdMobInterstitialClick.this.interstitialTwo = null;
                        Log.d("TAG", "The ad 2 was dismissed.");
                        AdMobInterstitialClick.this.loadInterTwo(activity);
                        if (AdMobInterstitialClick.this.myCallback != null) {
                            AdMobInterstitialClick.this.myCallback.callbackCall();
                            AdMobInterstitialClick.this.myCallback = null;
                        }
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        AdMobInterstitialClick.this.interstitialTwo = null;
                        Log.d("TAG", "The ad 2 failed to show.");
                        AdMobInterstitialClick.this.loadInterTwo(activity);


                    }
                });
            }

            public void onAdFailedToLoad(LoadAdError loadAdError) {
                Log.d("TAG", "The ad 2 Load Error.");
                AdMobInterstitialClick.this.interstitialTwo = null;

//                activity.startActivity(new Intent(activity, FailedInterstitial.class));
//                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
            }
        });
    }

    public void loadInterThree(final Activity activity) {
        MobileAds.initialize(activity, new OnInitializationCompleteListener() {
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        InterstitialAd.load(activity, MyApplication.AdMob_Int1, new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
            public void onAdLoaded(InterstitialAd interstitialAd) {
                AdMobInterstitialClick.this.interstitialThree = interstitialAd;
                Log.i("TAG", "onAdLoaded 2");
                AdMobInterstitialClick.this.interstitialThree.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdDismissedFullScreenContent() {
                        AdMobInterstitialClick.this.interstitialThree = null;
                        Log.d("TAG", "The ad 2 was dismissed.");
                        AdMobInterstitialClick.this.loadInterThree(activity);
                        if (AdMobInterstitialClick.this.myCallback != null) {
                            AdMobInterstitialClick.this.myCallback.callbackCall();
                            AdMobInterstitialClick.this.myCallback = null;
                        }
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        AdMobInterstitialClick.this.interstitialThree = null;
                        Log.d("TAG", "The ad 2 failed to show.");
                        AdMobInterstitialClick.this.loadInterThree(activity);


                    }
                });
            }

            public void onAdFailedToLoad(LoadAdError loadAdError) {
                Log.d("TAG", "The ad 2 Load Error.");
                AdMobInterstitialClick.this.interstitialThree = null;


//                activity.startActivity(new Intent(activity, FailedInterstitial.class));
//                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);

            }
        });
    }



    /*Show Interstial Ads With Only Intent*/

    public void showInterAdMobFirst(Activity activity, Intent intent, MyCallback myCallback2) {

        InterstitialAd interstitialAd = this.interstitialOne;

        if (interstitialAd != null) {
            interstitialAd.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd2 = this.interstitialTwo;
        if (interstitialAd2 != null) {
            interstitialAd2.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd3 = this.interstitialThree;
        if (interstitialAd3 != null) {
            interstitialAd3.show(activity);
//                return;
        } else {
            //activity.startActivity(new Intent(activity, FailedInterstitial.class));
            //activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);

            if(MyApplication.Type2.contains("admob")){

                //context.startActivity(intent);
                AdMobInterstitialClick.getInstance().showInterAdMobSecond((Activity) activity, intent, new MyCallback() {
                    @Override
                    public void callbackCall() {

                    }
                });

            } else if(MyApplication.Type2.contains("fb")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                FbInterstitialAd.getInstance().showInterFBSecond( activity, dialog, intent);

            } else if(MyApplication.Type2.contains("max")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                MAXInterstitialAds.showInterMAXSecond((Activity) activity, dialog, intent);

            } else if(MyApplication.Type2.contains("qureka")){

                /*if(MyApplication.CheckQureka != 0){
                    activity.startActivity(new Intent(activity, QurekaInterstitialClick.class));
                    activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                }*/

            } else {
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
            }

//                return;
        }

        MyCallback myCallback3 = this.myCallback;
        if (myCallback3 != null) {
            myCallback3.callbackCall();
            this.myCallback = null;
            return;
        }
        return;

    }

    public void showInterAdMobSecond(Activity activity, Intent intent, MyCallback myCallback2) {

        InterstitialAd interstitialAd = this.interstitialOne;

        if (interstitialAd != null) {
            interstitialAd.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd2 = this.interstitialTwo;
        if (interstitialAd2 != null) {
            interstitialAd2.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd3 = this.interstitialThree;
        if (interstitialAd3 != null) {
            interstitialAd3.show(activity);
//                return;
        } else {
            //activity.startActivity(new Intent(activity, FailedInterstitial.class));
            //activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);

            if(MyApplication.Type2.contains("admob")){

                //context.startActivity(intent);
                AdMobInterstitialClick.getInstance().showInterAdMobThird((Activity) activity, intent, new MyCallback() {
                    @Override
                    public void callbackCall() {

                    }
                });

            } else if(MyApplication.Type3.contains("fb")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                FbInterstitialAd.getInstance().showInterFBThird( activity, dialog, intent);

            } else if(MyApplication.Type3.contains("max")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                MAXInterstitialAds.showInterMAXThird((Activity) activity, dialog, intent);

            } else if(MyApplication.Type3.contains("qureka")){

                /*if(MyApplication.CheckQureka != 0){
                    activity.startActivity(new Intent(activity, QurekaInterstitialClick.class));
                    activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                }*/

            } else {
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
            }

//                return;
        }

        MyCallback myCallback3 = this.myCallback;
        if (myCallback3 != null) {
            myCallback3.callbackCall();
            this.myCallback = null;
            return;
        }
        return;

    }

    public void showInterAdMobThird(Activity activity, Intent intent, MyCallback myCallback2) {

        InterstitialAd interstitialAd = this.interstitialOne;

        if (interstitialAd != null) {
            interstitialAd.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd2 = this.interstitialTwo;
        if (interstitialAd2 != null) {
            interstitialAd2.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd3 = this.interstitialThree;
        if (interstitialAd3 != null) {
            interstitialAd3.show(activity);
//                return;
        } else {
            //activity.startActivity(new Intent(activity, FailedInterstitial.class));
            //activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);

            if(MyApplication.Type2.contains("admob")){

                //context.startActivity(intent);
                AdMobInterstitialClick.getInstance().showInterAdMobFour((Activity) activity, intent, new MyCallback() {
                    @Override
                    public void callbackCall() {

                    }
                });

            } else if(MyApplication.Type4.contains("fb")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                FbInterstitialAd.getInstance().showInterFBFour( activity, dialog, intent);

            } else if(MyApplication.Type4.contains("max")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                MAXInterstitialAds.showInterMAXFour((Activity) activity, dialog, intent);

            } else if(MyApplication.Type4.contains("qureka")){

                /*if(MyApplication.CheckQureka != 0){
                    activity.startActivity(new Intent(activity, QurekaInterstitialClick.class));
                    activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                }*/

            } else {
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
            }

//                return;
        }

        MyCallback myCallback3 = this.myCallback;
        if (myCallback3 != null) {
            myCallback3.callbackCall();
            this.myCallback = null;
            return;
        }
        return;

    }

    public void showInterAdMobFour(Activity activity, Intent intent, MyCallback myCallback2) {

        InterstitialAd interstitialAd = this.interstitialOne;

        if (interstitialAd != null) {
            interstitialAd.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd2 = this.interstitialTwo;
        if (interstitialAd2 != null) {
            interstitialAd2.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd3 = this.interstitialThree;
        if (interstitialAd3 != null) {
            interstitialAd3.show(activity);
//                return;
        } else {
            //activity.startActivity(new Intent(activity, FailedInterstitial.class));
            //activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);

            activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);

//                return;
        }

        MyCallback myCallback3 = this.myCallback;
        if (myCallback3 != null) {
            myCallback3.callbackCall();
            this.myCallback = null;
            return;
        }
        return;

    }


    /*Show Interstial Ads with Intent & Finish*/

    public void showInterOnFinishAdMobFirst(Activity activity, Intent intent, MyCallback myCallback2) {

        InterstitialAd interstitialAd = this.interstitialOne;

        if (interstitialAd != null) {
            interstitialAd.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd2 = this.interstitialTwo;
        if (interstitialAd2 != null) {
            interstitialAd2.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd3 = this.interstitialThree;
        if (interstitialAd3 != null) {
            interstitialAd3.show(activity);
//                return;
        } else {
            //activity.startActivity(new Intent(activity, FailedInterstitial.class));
            //activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);

            if(MyApplication.Type2.contains("admob")){

                AdMobInterstitialClick.getInstance().showInterOnFinishAdMobSecond((Activity) activity, intent, new MyCallback() {
                    @Override
                    public void callbackCall() {

                    }
                });

            } else if(MyApplication.Type2.contains("fb")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                FbInterstitialAd.getInstance().showInterOnFinishFBSecond( activity, dialog, intent);

            } else if(MyApplication.Type2.contains("max")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                MAXInterstitialAds.showInterOnFinishMAXSecond((Activity) activity, dialog, intent);

            } else if(MyApplication.Type2.contains("qureka")){

                /*if(MyApplication.CheckQureka != 0){
                    activity.startActivity(new Intent(activity, QurekaInterstitialClick.class));
                    activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                }*/

            } else {
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
            }

//                return;
        }

        MyCallback myCallback3 = this.myCallback;
        if (myCallback3 != null) {
            myCallback3.callbackCall();
            this.myCallback = null;
            return;
        }
        return;

    }

    public void showInterOnFinishAdMobSecond(Activity activity, Intent intent, MyCallback myCallback2) {

        InterstitialAd interstitialAd = this.interstitialOne;

        if (interstitialAd != null) {
            interstitialAd.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd2 = this.interstitialTwo;
        if (interstitialAd2 != null) {
            interstitialAd2.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd3 = this.interstitialThree;
        if (interstitialAd3 != null) {
            interstitialAd3.show(activity);
//                return;
        } else {
            //activity.startActivity(new Intent(activity, FailedInterstitial.class));
            //activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);

            if(MyApplication.Type3.contains("admob")){

                AdMobInterstitialClick.getInstance().showInterOnFinishAdMobThird((Activity) activity, intent, new MyCallback() {
                    @Override
                    public void callbackCall() {

                    }
                });

            } else if(MyApplication.Type3.contains("fb")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                FbInterstitialAd.getInstance().showInterOnFinishFBThird( activity, dialog, intent);

            } else if(MyApplication.Type3.contains("max")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                MAXInterstitialAds.showInterOnFinishMAXThird((Activity) activity, dialog, intent);

            } else if(MyApplication.Type3.contains("qureka")){

                /*if(MyApplication.CheckQureka != 0){
                    activity.startActivity(new Intent(activity, QurekaInterstitialClick.class));
                    activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                }*/

            } else {
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
            }

//                return;
        }

        MyCallback myCallback3 = this.myCallback;
        if (myCallback3 != null) {
            myCallback3.callbackCall();
            this.myCallback = null;
            return;
        }
        return;

    }

    public void showInterOnFinishAdMobThird(Activity activity, Intent intent, MyCallback myCallback2) {

        InterstitialAd interstitialAd = this.interstitialOne;

        if (interstitialAd != null) {
            interstitialAd.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd2 = this.interstitialTwo;
        if (interstitialAd2 != null) {
            interstitialAd2.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd3 = this.interstitialThree;
        if (interstitialAd3 != null) {
            interstitialAd3.show(activity);
//                return;
        } else {
            //activity.startActivity(new Intent(activity, FailedInterstitial.class));
            //activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);

            if(MyApplication.Type4.contains("admob")){

                AdMobInterstitialClick.getInstance().showInterOnFinishAdMobFour((Activity) activity, intent, new MyCallback() {
                    @Override
                    public void callbackCall() {

                    }
                });

            } else if(MyApplication.Type4.contains("fb")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                FbInterstitialAd.getInstance().showInterOnFinishFBFour( activity, dialog, intent);

            } else if(MyApplication.Type4.contains("max")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                MAXInterstitialAds.showInterOnFinishMAXFour((Activity) activity, dialog, intent);

            } else if(MyApplication.Type4.contains("qureka")){

                /*if(MyApplication.CheckQureka != 0){
                    activity.startActivity(new Intent(activity, QurekaInterstitialClick.class));
                    activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                }*/

            } else {
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
            }

//                return;
        }

        MyCallback myCallback3 = this.myCallback;
        if (myCallback3 != null) {
            myCallback3.callbackCall();
            this.myCallback = null;
            return;
        }
        return;

    }

    public void showInterOnFinishAdMobFour(Activity activity, Intent intent, MyCallback myCallback2) {

        InterstitialAd interstitialAd = this.interstitialOne;

        if (interstitialAd != null) {
            interstitialAd.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd2 = this.interstitialTwo;
        if (interstitialAd2 != null) {
            interstitialAd2.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd3 = this.interstitialThree;
        if (interstitialAd3 != null) {
            interstitialAd3.show(activity);
//                return;
        } else {
            //activity.startActivity(new Intent(activity, FailedInterstitial.class));
            //activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);

            activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);

//                return;
        }

        MyCallback myCallback3 = this.myCallback;
        if (myCallback3 != null) {
            myCallback3.callbackCall();
            this.myCallback = null;
            return;
        }
        return;

    }


    /*Show Interstial Ads On Back Press*/

    public void showInterOnBackAdMobFirst(Activity activity, MyCallback myCallback2) {

        InterstitialAd interstitialAd = this.interstitialOne;

        if (interstitialAd != null) {
            interstitialAd.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd2 = this.interstitialTwo;
        if (interstitialAd2 != null) {
            interstitialAd2.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd3 = this.interstitialThree;
        if (interstitialAd3 != null) {
            interstitialAd3.show(activity);
//                return;
        } else {
            //activity.startActivity(new Intent(activity, FailedInterstitial.class));
            //activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);

            if(MyApplication.Type2.contains("admob")){

                AdMobInterstitialClick.getInstance().showInterOnBackAdMobSecond((Activity) activity,  new MyCallback() {
                    @Override
                    public void callbackCall() {

                    }
                });

            } else if(MyApplication.Type2.contains("fb")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                FbInterstitialAd.getInstance().showInterOnBackFBSecond( activity, dialog);

            } else if(MyApplication.Type2.contains("max")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                MAXInterstitialAds.showInterOnBackMAXSecond((Activity) activity, dialog);

            } else if(MyApplication.Type2.contains("qureka")){

                /*if(MyApplication.CheckQureka != 0){
                    activity.startActivity(new Intent(activity, QurekaInterstitialClick.class));
                    activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                }*/

            } else {
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
            }

//                return;
        }

        MyCallback myCallback3 = this.myCallback;
        if (myCallback3 != null) {
            myCallback3.callbackCall();
            this.myCallback = null;
            return;
        }
        return;

    }

    public void showInterOnBackAdMobSecond(Activity activity, MyCallback myCallback2) {

        InterstitialAd interstitialAd = this.interstitialOne;

        if (interstitialAd != null) {
            interstitialAd.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd2 = this.interstitialTwo;
        if (interstitialAd2 != null) {
            interstitialAd2.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd3 = this.interstitialThree;
        if (interstitialAd3 != null) {
            interstitialAd3.show(activity);
//                return;
        } else {
            //activity.startActivity(new Intent(activity, FailedInterstitial.class));
            //activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);

            if(MyApplication.Type3.contains("admob")){

                AdMobInterstitialClick.getInstance().showInterOnBackAdMobThird((Activity) activity,  new MyCallback() {
                    @Override
                    public void callbackCall() {

                    }
                });

            } else if(MyApplication.Type3.contains("fb")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                FbInterstitialAd.getInstance().showInterOnBackFBThird( activity, dialog);

            } else if(MyApplication.Type3.contains("max")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                MAXInterstitialAds.showInterOnBackMAXThird((Activity) activity, dialog);

            } else if(MyApplication.Type3.contains("qureka")){

                /*if(MyApplication.CheckQureka != 0){
                    activity.startActivity(new Intent(activity, QurekaInterstitialClick.class));
                    activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                }*/

            } else {
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
            }

//                return;
        }

        MyCallback myCallback3 = this.myCallback;
        if (myCallback3 != null) {
            myCallback3.callbackCall();
            this.myCallback = null;
            return;
        }
        return;

    }

    public void showInterOnBackAdMobThird(Activity activity, MyCallback myCallback2) {

        InterstitialAd interstitialAd = this.interstitialOne;

        if (interstitialAd != null) {
            interstitialAd.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd2 = this.interstitialTwo;
        if (interstitialAd2 != null) {
            interstitialAd2.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd3 = this.interstitialThree;
        if (interstitialAd3 != null) {
            interstitialAd3.show(activity);
//                return;
        } else {
            //activity.startActivity(new Intent(activity, FailedInterstitial.class));
            //activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);

            if(MyApplication.Type4.contains("admob")){

                AdMobInterstitialClick.getInstance().showInterOnBackAdMobFour((Activity) activity,  new MyCallback() {
                    @Override
                    public void callbackCall() {

                    }
                });

            } else if(MyApplication.Type4.contains("fb")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                FbInterstitialAd.getInstance().showInterOnBackFBFour( activity, dialog);

            } else if(MyApplication.Type4.contains("max")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                MAXInterstitialAds.showInterOnBackMAXFour((Activity) activity, dialog);

            } else if(MyApplication.Type4.contains("qureka")){

                /*if(MyApplication.CheckQureka != 0){
                    activity.startActivity(new Intent(activity, QurekaInterstitialClick.class));
                    activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                }*/

            } else {
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
            }

//                return;
        }

        MyCallback myCallback3 = this.myCallback;
        if (myCallback3 != null) {
            myCallback3.callbackCall();
            this.myCallback = null;
            return;
        }
        return;

    }

    public void showInterOnBackAdMobFour(Activity activity, MyCallback myCallback2) {

        InterstitialAd interstitialAd = this.interstitialOne;

        if (interstitialAd != null) {
            interstitialAd.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd2 = this.interstitialTwo;
        if (interstitialAd2 != null) {
            interstitialAd2.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd3 = this.interstitialThree;
        if (interstitialAd3 != null) {
            interstitialAd3.show(activity);
//                return;
        } else {
            //activity.startActivity(new Intent(activity, FailedInterstitial.class));
            //activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);

            activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);

//                return;
        }

        MyCallback myCallback3 = this.myCallback;
        if (myCallback3 != null) {
            myCallback3.callbackCall();
            this.myCallback = null;
            return;
        }
        return;

    }


    /*Show Interstial Ads Only*/

    public void showInterOnlyAdMobFirst(Activity activity, MyCallback myCallback2) {

        InterstitialAd interstitialAd = this.interstitialOne;

        if (interstitialAd != null) {
            interstitialAd.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd2 = this.interstitialTwo;
        if (interstitialAd2 != null) {
            interstitialAd2.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd3 = this.interstitialThree;
        if (interstitialAd3 != null) {
            interstitialAd3.show(activity);
//                return;
        } else {
            //activity.startActivity(new Intent(activity, FailedInterstitial.class));
            //activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);

            if(MyApplication.Type2.contains("admob")){

                AdMobInterstitialClick.getInstance().showInterOnlyAdMobSecond((Activity) activity, new MyCallback() {
                    @Override
                    public void callbackCall() {

                    }
                });

            } else if(MyApplication.Type2.contains("fb")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                FbInterstitialAd.getInstance().showInterOnlyFBSecond( activity, dialog);

            } else if(MyApplication.Type2.contains("max")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                MAXInterstitialAds.showInterOnlyMAXSecond((Activity) activity, dialog);

            } else if(MyApplication.Type2.contains("qureka")){

                /*if(MyApplication.CheckQureka != 0){
                    activity.startActivity(new Intent(activity, QurekaInterstitialClick.class));
                    activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                }*/

            } else {
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
            }

//                return;
        }

        MyCallback myCallback3 = this.myCallback;
        if (myCallback3 != null) {
            myCallback3.callbackCall();
            this.myCallback = null;
            return;
        }
        return;

    }

    public void showInterOnlyAdMobSecond(Activity activity, MyCallback myCallback2) {

        InterstitialAd interstitialAd = this.interstitialOne;

        if (interstitialAd != null) {
            interstitialAd.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd2 = this.interstitialTwo;
        if (interstitialAd2 != null) {
            interstitialAd2.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd3 = this.interstitialThree;
        if (interstitialAd3 != null) {
            interstitialAd3.show(activity);
//                return;
        } else {
            //activity.startActivity(new Intent(activity, FailedInterstitial.class));
            //activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);

            if(MyApplication.Type3.contains("admob")){

                AdMobInterstitialClick.getInstance().showInterOnlyAdMobThird((Activity) activity, new MyCallback() {
                    @Override
                    public void callbackCall() {

                    }
                });

            } else if(MyApplication.Type3.contains("fb")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                FbInterstitialAd.getInstance().showInterOnlyFBThird( activity, dialog);

            } else if(MyApplication.Type3.contains("max")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                MAXInterstitialAds.showInterOnlyMAXThird((Activity) activity, dialog);

            } else if(MyApplication.Type3.contains("qureka")){

                /*if(MyApplication.CheckQureka != 0){
                    activity.startActivity(new Intent(activity, QurekaInterstitialClick.class));
                    activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                }*/

            } else {
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
            }

//                return;
        }

        MyCallback myCallback3 = this.myCallback;
        if (myCallback3 != null) {
            myCallback3.callbackCall();
            this.myCallback = null;
            return;
        }
        return;

    }

    public void showInterOnlyAdMobThird(Activity activity, MyCallback myCallback2) {

        InterstitialAd interstitialAd = this.interstitialOne;

        if (interstitialAd != null) {
            interstitialAd.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd2 = this.interstitialTwo;
        if (interstitialAd2 != null) {
            interstitialAd2.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd3 = this.interstitialThree;
        if (interstitialAd3 != null) {
            interstitialAd3.show(activity);
//                return;
        } else {
            //activity.startActivity(new Intent(activity, FailedInterstitial.class));
            //activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);

            if(MyApplication.Type4.contains("admob")){

                AdMobInterstitialClick.getInstance().showInterOnlyAdMobFour((Activity) activity, new MyCallback() {
                    @Override
                    public void callbackCall() {

                    }
                });

            } else if(MyApplication.Type4.contains("fb")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                FbInterstitialAd.getInstance().showInterOnlyFBFour( activity, dialog);

            } else if(MyApplication.Type4.contains("max")){

                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.ads_dialog);
                dialog.setCancelable(false);
                //dialog.show();

                MAXInterstitialAds.showInterOnlyMAXFour((Activity) activity, dialog);

            } else if(MyApplication.Type4.contains("qureka")){

                /*if(MyApplication.CheckQureka != 0){
                    activity.startActivity(new Intent(activity, QurekaInterstitialClick.class));
                    activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                }*/

            } else {
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
            }

//                return;
        }

        MyCallback myCallback3 = this.myCallback;
        if (myCallback3 != null) {
            myCallback3.callbackCall();
            this.myCallback = null;
            return;
        }
        return;

    }

    public void showInterOnlyAdMobFour(Activity activity, MyCallback myCallback2) {

        InterstitialAd interstitialAd = this.interstitialOne;

        if (interstitialAd != null) {
            interstitialAd.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd2 = this.interstitialTwo;
        if (interstitialAd2 != null) {
            interstitialAd2.show(activity);
            return;
        } /*else {
                activity.startActivity(new Intent(activity, FailedInterstitial.class));
                activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);
                return;
            }*/

        InterstitialAd interstitialAd3 = this.interstitialThree;
        if (interstitialAd3 != null) {
            interstitialAd3.show(activity);
//                return;
        } else {
            //activity.startActivity(new Intent(activity, FailedInterstitial.class));
            //activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);

            activity.overridePendingTransition(R.anim.slide_in_bottom, R.anim.fadeout);

//                return;
        }

        MyCallback myCallback3 = this.myCallback;
        if (myCallback3 != null) {
            myCallback3.callbackCall();
            this.myCallback = null;
            return;
        }
        return;

    }

}
