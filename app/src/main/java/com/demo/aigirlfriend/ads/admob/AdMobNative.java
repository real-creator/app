package com.demo.aigirlfriend.ads.admob;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeBannerAd;
import com.demo.aigirlfriend.R;
import com.demo.aigirlfriend.ads.MyApplication;
import com.demo.aigirlfriend.ads.fb.FbNativeFullAds;
import com.demo.aigirlfriend.ads.fb.FbNativeSmallAds;
import com.demo.aigirlfriend.ads.max.MAXNativeAds;
import com.demo.aigirlfriend.ads.max.MAXNativeSmallAds;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;

public class AdMobNative {

    private static AdMobNative mInstance;
    public NativeAd nativeAd;

    public static AdMobNative getInstance() {
        if (mInstance == null) {
            mInstance = new AdMobNative();
        }
        return mInstance;
    }

    /*Reguler Native Ads*/

    public void showNativeBigFirst(final Activity activity, final FrameLayout frameLayout, NativeAdLayout nativeAdLayout, FrameLayout nativeMax) {
        frameLayout.setVisibility(View.VISIBLE);
        AdLoader.Builder builder = new AdLoader.Builder(activity, MyApplication.AdMob_NativeAdvance1);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            public void onNativeAdLoaded(NativeAd nativeAd) {
                if ((Build.VERSION.SDK_INT >= 17 ? activity.isDestroyed() : false) || activity.isFinishing() || activity.isChangingConfigurations()) {
                    nativeAd.destroy();
                    return;
                }
                if (AdMobNative.this.nativeAd != null) {
                    AdMobNative.this.nativeAd.destroy();
                }
                NativeAd unused = AdMobNative.this.nativeAd = nativeAd;
                NativeAdView nativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.ads_google_big_native, (ViewGroup) null);
                AdMobNative.this.populateUnifiedNativeAdView(nativeAd, nativeAdView);
                frameLayout.removeAllViews();
                frameLayout.addView(nativeAdView);
            }
        });
        builder.withNativeAdOptions(new NativeAdOptions.Builder().setVideoOptions(new VideoOptions.Builder().setStartMuted(true).build()).build());
        builder.withAdListener(new AdListener() {
            public void onAdFailedToLoad(LoadAdError loadAdError) {

                if(MyApplication.Type2.contains("admob")){

                    AdMobNative.getInstance().showNativeBigSecond((Activity) activity, frameLayout, nativeAdLayout, nativeMax);

                } else if(MyApplication.Type2.contains("fb")){

                    com.facebook.ads.NativeAd nativeAd = new com.facebook.ads.NativeAd(activity, MyApplication.Fbnative);
                    nativeAd.loadAd(nativeAd.buildLoadAdConfig().withAdListener(new FbNativeFullAds(nativeAd, activity, nativeAdLayout, frameLayout, nativeMax, "type2")).build());

                } else if(MyApplication.Type2.contains("max")){

                    MAXNativeAds.NativeAdsMAXSecond(activity, nativeMax, frameLayout, nativeAdLayout);

                } else if(MyApplication.Type2.contains("qureka")){

                    /*if(MyApplication.CheckQureka != 0){
                        new QurekaBigNative(activity, frameLayout);
                    }*/

                } else {

                }

            }
        }).build().loadAd(new AdRequest.Builder().build());
    }

    public void showNativeBigSecond(final Activity activity, final FrameLayout frameLayout, NativeAdLayout nativeAdLayout, FrameLayout nativeMax) {
        frameLayout.setVisibility(View.VISIBLE);
        AdLoader.Builder builder = new AdLoader.Builder(activity, MyApplication.AdMob_NativeAdvance2);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            public void onNativeAdLoaded(NativeAd nativeAd) {
                if ((Build.VERSION.SDK_INT >= 17 ? activity.isDestroyed() : false) || activity.isFinishing() || activity.isChangingConfigurations()) {
                    nativeAd.destroy();
                    return;
                }
                if (AdMobNative.this.nativeAd != null) {
                    AdMobNative.this.nativeAd.destroy();
                }
                NativeAd unused = AdMobNative.this.nativeAd = nativeAd;
                NativeAdView nativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.ads_google_big_native, (ViewGroup) null);
                AdMobNative.this.populateUnifiedNativeAdView(nativeAd, nativeAdView);
                frameLayout.removeAllViews();
                frameLayout.addView(nativeAdView);
            }
        });
        builder.withNativeAdOptions(new NativeAdOptions.Builder().setVideoOptions(new VideoOptions.Builder().setStartMuted(true).build()).build());
        builder.withAdListener(new AdListener() {
            public void onAdFailedToLoad(LoadAdError loadAdError) {

                if(MyApplication.Type3.contains("admob")){

                    AdMobNative.getInstance().showNativeBigThird((Activity) activity, frameLayout, nativeAdLayout, nativeMax);

                } else if(MyApplication.Type3.contains("fb")){

                    com.facebook.ads.NativeAd nativeAd = new com.facebook.ads.NativeAd(activity, MyApplication.Fbnative);
                    nativeAd.loadAd(nativeAd.buildLoadAdConfig().withAdListener(new FbNativeFullAds(nativeAd, activity, nativeAdLayout, frameLayout, nativeMax, "type3")).build());

                } else if(MyApplication.Type3.contains("max")){

                    MAXNativeAds.NativeAdsMAXThird(activity, nativeMax, frameLayout, nativeAdLayout);

                } else if(MyApplication.Type3.contains("qureka")){

                    /*if(MyApplication.CheckQureka != 0){
                        new QurekaBigNative(activity, frameLayout);
                    }*/

                } else {

                }

            }
        }).build().loadAd(new AdRequest.Builder().build());
    }

    public void showNativeBigThird(final Activity activity, final FrameLayout frameLayout, NativeAdLayout nativeAdLayout, FrameLayout nativeMax) {
        frameLayout.setVisibility(View.VISIBLE);
        AdLoader.Builder builder = new AdLoader.Builder(activity, MyApplication.AdMob_NativeAdvance1);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            public void onNativeAdLoaded(NativeAd nativeAd) {
                if ((Build.VERSION.SDK_INT >= 17 ? activity.isDestroyed() : false) || activity.isFinishing() || activity.isChangingConfigurations()) {
                    nativeAd.destroy();
                    return;
                }
                if (AdMobNative.this.nativeAd != null) {
                    AdMobNative.this.nativeAd.destroy();
                }
                NativeAd unused = AdMobNative.this.nativeAd = nativeAd;
                NativeAdView nativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.ads_google_big_native, (ViewGroup) null);
                AdMobNative.this.populateUnifiedNativeAdView(nativeAd, nativeAdView);
                frameLayout.removeAllViews();
                frameLayout.addView(nativeAdView);
            }
        });
        builder.withNativeAdOptions(new NativeAdOptions.Builder().setVideoOptions(new VideoOptions.Builder().setStartMuted(true).build()).build());
        builder.withAdListener(new AdListener() {
            public void onAdFailedToLoad(LoadAdError loadAdError) {

                if(MyApplication.Type4.contains("admob")){

                    AdMobNative.getInstance().showNativeBigFour((Activity) activity, frameLayout, nativeAdLayout, nativeMax);

                } else if(MyApplication.Type4.contains("fb")){

                    com.facebook.ads.NativeAd nativeAd = new com.facebook.ads.NativeAd(activity, MyApplication.Fbnative);
                    nativeAd.loadAd(nativeAd.buildLoadAdConfig().withAdListener(new FbNativeFullAds(nativeAd, activity, nativeAdLayout, frameLayout, nativeMax, "type4")).build());

                } else if(MyApplication.Type4.contains("max")){

                    MAXNativeAds.NativeAdsMAXFour(activity, nativeMax, frameLayout, nativeAdLayout);

                } else if(MyApplication.Type4.contains("qureka")){

                    /*if(MyApplication.CheckQureka != 0){
                        new QurekaBigNative(activity, frameLayout);
                    }*/

                } else {

                }

            }
        }).build().loadAd(new AdRequest.Builder().build());
    }

    public void showNativeBigFour(final Activity activity, final FrameLayout frameLayout, NativeAdLayout nativeAdLayout, FrameLayout nativeMax) {
        frameLayout.setVisibility(View.VISIBLE);
        AdLoader.Builder builder = new AdLoader.Builder(activity, MyApplication.AdMob_NativeAdvance2);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            public void onNativeAdLoaded(NativeAd nativeAd) {
                if ((Build.VERSION.SDK_INT >= 17 ? activity.isDestroyed() : false) || activity.isFinishing() || activity.isChangingConfigurations()) {
                    nativeAd.destroy();
                    return;
                }
                if (AdMobNative.this.nativeAd != null) {
                    AdMobNative.this.nativeAd.destroy();
                }
                NativeAd unused = AdMobNative.this.nativeAd = nativeAd;
                NativeAdView nativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.ads_google_big_native, (ViewGroup) null);
                AdMobNative.this.populateUnifiedNativeAdView(nativeAd, nativeAdView);
                frameLayout.removeAllViews();
                frameLayout.addView(nativeAdView);
            }
        });
        builder.withNativeAdOptions(new NativeAdOptions.Builder().setVideoOptions(new VideoOptions.Builder().setStartMuted(true).build()).build());
        builder.withAdListener(new AdListener() {
            public void onAdFailedToLoad(LoadAdError loadAdError) {

            }
        }).build().loadAd(new AdRequest.Builder().build());
    }



    /*Reguler Small Native Ads*/

    public void showNativeSmallFirst(final Activity activity, final FrameLayout frameLayout, NativeAdLayout nativeAdLayout) {

        frameLayout.setVisibility(View.VISIBLE);

        AdLoader.Builder builder = new AdLoader.Builder(activity, MyApplication.AdMob_NativeAdvance1);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            public void onNativeAdLoaded(NativeAd nativeAd) {
                if ((Build.VERSION.SDK_INT >= 17 ? activity.isDestroyed() : false) || activity.isFinishing() || activity.isChangingConfigurations()) {
                    nativeAd.destroy();
                    return;
                }
                if (AdMobNative.this.nativeAd != null) {
                    AdMobNative.this.nativeAd.destroy();
                }
                NativeAd unused = AdMobNative.this.nativeAd = nativeAd;
                NativeAdView nativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.ads_google_small_native, (ViewGroup) null);
                AdMobNative.this.populateUnifiedNativeAdView2(nativeAd, nativeAdView);
                frameLayout.removeAllViews();
                frameLayout.addView(nativeAdView);
            }
        });
        builder.withNativeAdOptions(new NativeAdOptions.Builder().setVideoOptions(new VideoOptions.Builder().setStartMuted(true).build()).build());
        builder.withAdListener(new AdListener() {
            public void onAdFailedToLoad(LoadAdError loadAdError) {

                frameLayout.setVisibility(View.INVISIBLE);

                if(MyApplication.Type2.contains("admob")){

                    AdMobNative.getInstance().showNativeSmallSecond((Activity) activity, frameLayout, nativeAdLayout);

                } else if(MyApplication.Type2.contains("fb")){

                    NativeBannerAd nativeBannerAd = new NativeBannerAd(activity, MyApplication.FbNativeB);
                    nativeBannerAd.loadAd(nativeBannerAd.buildLoadAdConfig().withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withAdListener(
                            new FbNativeSmallAds(nativeBannerAd, activity, new LinearLayout[1], nativeAdLayout, frameLayout, "type2")).build());

                } else if(MyApplication.Type2.contains("max")){

                    MAXNativeSmallAds.MAXNativeSmallSecond(activity, frameLayout, nativeAdLayout);

                } else if(MyApplication.Type2.contains("qureka")){

                    /*if(MyApplication.CheckQureka != 0){
                        new QurekaSmallNative(activity, frameLayout);
                    }*/

                } else {

                }

            }
        }).build().loadAd(new AdRequest.Builder().build());
    }

    public void showNativeSmallSecond(final Activity activity, final FrameLayout frameLayout, NativeAdLayout nativeAdLayout) {

        frameLayout.setVisibility(View.VISIBLE);

        AdLoader.Builder builder = new AdLoader.Builder(activity, MyApplication.AdMob_NativeAdvance2);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            public void onNativeAdLoaded(NativeAd nativeAd) {
                if ((Build.VERSION.SDK_INT >= 17 ? activity.isDestroyed() : false) || activity.isFinishing() || activity.isChangingConfigurations()) {
                    nativeAd.destroy();
                    return;
                }
                if (AdMobNative.this.nativeAd != null) {
                    AdMobNative.this.nativeAd.destroy();
                }
                NativeAd unused = AdMobNative.this.nativeAd = nativeAd;
                NativeAdView nativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.ads_google_small_native, (ViewGroup) null);
                AdMobNative.this.populateUnifiedNativeAdView2(nativeAd, nativeAdView);
                frameLayout.removeAllViews();
                frameLayout.addView(nativeAdView);
            }
        });
        builder.withNativeAdOptions(new NativeAdOptions.Builder().setVideoOptions(new VideoOptions.Builder().setStartMuted(true).build()).build());
        builder.withAdListener(new AdListener() {
            public void onAdFailedToLoad(LoadAdError loadAdError) {

                frameLayout.setVisibility(View.INVISIBLE);

                if(MyApplication.Type3.contains("admob")){

                    AdMobNative.getInstance().showNativeSmallThird((Activity) activity, frameLayout, nativeAdLayout);

                } else if(MyApplication.Type3.contains("fb")){

                    NativeBannerAd nativeBannerAd = new NativeBannerAd(activity, MyApplication.FbNativeB);
                    nativeBannerAd.loadAd(nativeBannerAd.buildLoadAdConfig().withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withAdListener(
                            new FbNativeSmallAds(nativeBannerAd, activity, new LinearLayout[1], nativeAdLayout, frameLayout, "type3")).build());

                } else if(MyApplication.Type3.contains("max")){

                    MAXNativeSmallAds.MAXNativeSmallThird(activity, frameLayout, nativeAdLayout);

                } else if(MyApplication.Type3.contains("qureka")){

                    /*if(MyApplication.CheckQureka != 0){
                        new QurekaSmallNative(activity, frameLayout);
                    }*/

                } else {

                }

            }
        }).build().loadAd(new AdRequest.Builder().build());
    }

    public void showNativeSmallThird(final Activity activity, final FrameLayout frameLayout, NativeAdLayout nativeAdLayout) {

        frameLayout.setVisibility(View.VISIBLE);

        AdLoader.Builder builder = new AdLoader.Builder(activity, MyApplication.AdMob_NativeAdvance1);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            public void onNativeAdLoaded(NativeAd nativeAd) {
                if ((Build.VERSION.SDK_INT >= 17 ? activity.isDestroyed() : false) || activity.isFinishing() || activity.isChangingConfigurations()) {
                    nativeAd.destroy();
                    return;
                }
                if (AdMobNative.this.nativeAd != null) {
                    AdMobNative.this.nativeAd.destroy();
                }
                NativeAd unused = AdMobNative.this.nativeAd = nativeAd;
                NativeAdView nativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.ads_google_small_native, (ViewGroup) null);
                AdMobNative.this.populateUnifiedNativeAdView2(nativeAd, nativeAdView);
                frameLayout.removeAllViews();
                frameLayout.addView(nativeAdView);
            }
        });
        builder.withNativeAdOptions(new NativeAdOptions.Builder().setVideoOptions(new VideoOptions.Builder().setStartMuted(true).build()).build());
        builder.withAdListener(new AdListener() {
            public void onAdFailedToLoad(LoadAdError loadAdError) {

                frameLayout.setVisibility(View.INVISIBLE);

                if(MyApplication.Type4.contains("admob")){

                    AdMobNative.getInstance().showNativeSmallFour((Activity) activity, frameLayout, nativeAdLayout);

                } else if(MyApplication.Type4.contains("fb")){

                    NativeBannerAd nativeBannerAd = new NativeBannerAd(activity, MyApplication.FbNativeB);
                    nativeBannerAd.loadAd(nativeBannerAd.buildLoadAdConfig().withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withAdListener(
                            new FbNativeSmallAds(nativeBannerAd, activity, new LinearLayout[1], nativeAdLayout, frameLayout, "type4")).build());

                } else if(MyApplication.Type4.contains("max")){

                    MAXNativeSmallAds.MAXNativeSmallFour(activity, frameLayout, nativeAdLayout);

                } else if(MyApplication.Type4.contains("qureka")){

                    /*if(MyApplication.CheckQureka != 0){
                        new QurekaSmallNative(activity, frameLayout);
                    }*/

                } else {

                }

            }
        }).build().loadAd(new AdRequest.Builder().build());
    }

    public void showNativeSmallFour(final Activity activity, final FrameLayout frameLayout, NativeAdLayout nativeAdLayout) {

        frameLayout.setVisibility(View.VISIBLE);

        AdLoader.Builder builder = new AdLoader.Builder(activity, MyApplication.AdMob_NativeAdvance2);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            public void onNativeAdLoaded(NativeAd nativeAd) {
                if ((Build.VERSION.SDK_INT >= 17 ? activity.isDestroyed() : false) || activity.isFinishing() || activity.isChangingConfigurations()) {
                    nativeAd.destroy();
                    return;
                }
                if (AdMobNative.this.nativeAd != null) {
                    AdMobNative.this.nativeAd.destroy();
                }
                NativeAd unused = AdMobNative.this.nativeAd = nativeAd;
                NativeAdView nativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.ads_google_small_native, (ViewGroup) null);
                AdMobNative.this.populateUnifiedNativeAdView2(nativeAd, nativeAdView);
                frameLayout.removeAllViews();
                frameLayout.addView(nativeAdView);
            }
        });
        builder.withNativeAdOptions(new NativeAdOptions.Builder().setVideoOptions(new VideoOptions.Builder().setStartMuted(true).build()).build());
        builder.withAdListener(new AdListener() {
            public void onAdFailedToLoad(LoadAdError loadAdError) {

                frameLayout.setVisibility(View.INVISIBLE);

            }
        }).build().loadAd(new AdRequest.Builder().build());
    }




    public void populateUnifiedNativeAdView(NativeAd nativeAd2, NativeAdView nativeAdView) {
        nativeAdView.setMediaView((MediaView) nativeAdView.findViewById(R.id.ad_media));
        nativeAdView.setHeadlineView(nativeAdView.findViewById(R.id.ad_headline));
        nativeAdView.setBodyView(nativeAdView.findViewById(R.id.ad_body));
        nativeAdView.setCallToActionView(nativeAdView.findViewById(R.id.ad_call_to_action));
        nativeAdView.setIconView(nativeAdView.findViewById(R.id.ad_app_icon));
        nativeAdView.setPriceView(nativeAdView.findViewById(R.id.ad_price));
        nativeAdView.setStarRatingView(nativeAdView.findViewById(R.id.ad_stars));
        nativeAdView.setStoreView(nativeAdView.findViewById(R.id.ad_store));
        nativeAdView.setAdvertiserView(nativeAdView.findViewById(R.id.ad_advertiser));
        ((TextView) nativeAdView.getHeadlineView()).setText(nativeAd2.getHeadline());
        if (nativeAd2.getBody() == null) {
            nativeAdView.getBodyView().setVisibility(4);
        } else {
            nativeAdView.getBodyView().setVisibility(0);
            ((TextView) nativeAdView.getBodyView()).setText(nativeAd2.getBody());
        }
        if (nativeAd2.getCallToAction() == null) {
            nativeAdView.getCallToActionView().setVisibility(4);
        } else {
            nativeAdView.getCallToActionView().setVisibility(0);
            ((Button) nativeAdView.getCallToActionView()).setText(nativeAd2.getCallToAction());
        }
        if (nativeAd2.getIcon() == null) {
            nativeAdView.getIconView().setVisibility(8);
        } else {
            ((ImageView) nativeAdView.getIconView()).setImageDrawable(nativeAd2.getIcon().getDrawable());
            nativeAdView.getIconView().setVisibility(0);
        }
        if (nativeAd2.getPrice() == null) {
            nativeAdView.getPriceView().setVisibility(4);
        } else {
            nativeAdView.getPriceView().setVisibility(0);
            ((TextView) nativeAdView.getPriceView()).setText(nativeAd2.getPrice());
        }
        if (nativeAd2.getStore() == null) {
            nativeAdView.getStoreView().setVisibility(4);
        } else {
            nativeAdView.getStoreView().setVisibility(0);
            ((TextView) nativeAdView.getStoreView()).setText(nativeAd2.getStore());
        }
        if (nativeAd2.getStarRating() == null) {
            nativeAdView.getStarRatingView().setVisibility(4);
        } else {
            ((RatingBar) nativeAdView.getStarRatingView()).setRating(nativeAd2.getStarRating().floatValue());
            nativeAdView.getStarRatingView().setVisibility(0);
        }
        if (nativeAd2.getAdvertiser() == null) {
            nativeAdView.getAdvertiserView().setVisibility(4);
        } else {
            ((TextView) nativeAdView.getAdvertiserView()).setText(nativeAd2.getAdvertiser());
            nativeAdView.getAdvertiserView().setVisibility(0);
        }
        nativeAdView.setNativeAd(nativeAd2);
    }

    public void populateUnifiedNativeAdView2(NativeAd nativeAd2, NativeAdView nativeAdView) {
        nativeAdView.setMediaView((MediaView) nativeAdView.findViewById(R.id.ad_media));
        nativeAdView.setHeadlineView(nativeAdView.findViewById(R.id.ad_headline));
        nativeAdView.setBodyView(nativeAdView.findViewById(R.id.ad_body));
        nativeAdView.setCallToActionView(nativeAdView.findViewById(R.id.ad_call_to_action));
        nativeAdView.setIconView(nativeAdView.findViewById(R.id.ad_app_icon));
        nativeAdView.setPriceView(nativeAdView.findViewById(R.id.ad_price));
        nativeAdView.setStarRatingView(nativeAdView.findViewById(R.id.ad_stars));
        nativeAdView.setStoreView(nativeAdView.findViewById(R.id.ad_store));
        nativeAdView.setAdvertiserView(nativeAdView.findViewById(R.id.ad_advertiser));
        ((TextView) nativeAdView.getHeadlineView()).setText(nativeAd2.getHeadline());
        if (nativeAd2.getBody() == null) {
            nativeAdView.getBodyView().setVisibility(4);
        } else {
            nativeAdView.getBodyView().setVisibility(0);
            ((TextView) nativeAdView.getBodyView()).setText(nativeAd2.getBody());
        }
        if (nativeAd2.getCallToAction() == null) {
            nativeAdView.getCallToActionView().setVisibility(4);
        } else {
            nativeAdView.getCallToActionView().setVisibility(0);
            ((Button) nativeAdView.getCallToActionView()).setText(nativeAd2.getCallToAction());
        }
        if (nativeAd2.getIcon() == null) {
            nativeAdView.getIconView().setVisibility(8);
        } else {
            ((ImageView) nativeAdView.getIconView()).setImageDrawable(nativeAd2.getIcon().getDrawable());
            nativeAdView.getIconView().setVisibility(0);
        }
        if (nativeAd2.getPrice() == null) {
            nativeAdView.getPriceView().setVisibility(4);
        } else {
            nativeAdView.getPriceView().setVisibility(0);
            ((TextView) nativeAdView.getPriceView()).setText(nativeAd2.getPrice());
        }
        if (nativeAd2.getStore() == null) {
            nativeAdView.getStoreView().setVisibility(4);
        } else {
            nativeAdView.getStoreView().setVisibility(0);
            ((TextView) nativeAdView.getStoreView()).setText(nativeAd2.getStore());
        }
        if (nativeAd2.getStarRating() == null) {
            nativeAdView.getStarRatingView().setVisibility(4);
        } else {
            ((RatingBar) nativeAdView.getStarRatingView()).setRating(nativeAd2.getStarRating().floatValue());
            nativeAdView.getStarRatingView().setVisibility(0);
        }
        if (nativeAd2.getAdvertiser() == null) {
            nativeAdView.getAdvertiserView().setVisibility(4);
        } else {
            ((TextView) nativeAdView.getAdvertiserView()).setText(nativeAd2.getAdvertiser());
            nativeAdView.getAdvertiserView().setVisibility(0);
        }
        nativeAdView.setNativeAd(nativeAd2);
    }


}
