package com.demo.aigirlfriend.ads.fb;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.demo.aigirlfriend.ads.MyApplication;
import com.demo.aigirlfriend.ads.admob.AdMobBanner;
import com.demo.aigirlfriend.ads.max.MAXBannerAds;

public class FbBannerAds {

    public static void showFbAds(Context context, RelativeLayout admob_banner, LinearLayout adContainer, FrameLayout qureka, String type) {

        adContainer.setVisibility(View.VISIBLE);
        com.facebook.ads.AdView adView = new com.facebook.ads.AdView(context, MyApplication.FbBanner, AdSize.BANNER_HEIGHT_50);
        adContainer.addView(adView);

        AdListener adListener = new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {

                if(type.equals("type2")){

                    if(MyApplication.Type2.contains("fb")){

                        FbBannerAds.showFbAds(context, admob_banner, adContainer, qureka, "type3");

                    } else if(MyApplication.Type2.contains("admob")){

                        admob_banner.setVisibility(View.VISIBLE);
                        new AdMobBanner().showAd((Activity) context, admob_banner, adContainer, qureka, "type3", new AdMobBanner.adMobSmallAdCallback() {
                            @Override
                            public void onAdLoaded() {
                            }

                            @Override
                            public void onAdError(String error) {
                            }
                        });

                    } else if(MyApplication.Type2.contains("max")){

                        MAXBannerAds.MAXBanner(context, admob_banner, adContainer, qureka, "type3");

                    } else if(MyApplication.Type2.contains("qureka")){

                        /*if(MyApplication.CheckQureka != 0){
                            new QurekaBannerAds((Activity) context, qureka);
                        }*/

                    } else {

                    }

                } else if(type.equals("type3")){

                    if(MyApplication.Type3.contains("fb")){

                        FbBannerAds.showFbAds(context, admob_banner, adContainer, qureka, "type4");

                    } else if(MyApplication.Type3.contains("admob")){

                        admob_banner.setVisibility(View.VISIBLE);
                        new AdMobBanner().showAd((Activity) context, admob_banner, adContainer, qureka, "type4", new AdMobBanner.adMobSmallAdCallback() {
                            @Override
                            public void onAdLoaded() {
                            }

                            @Override
                            public void onAdError(String error) {
                            }
                        });

                    } else if(MyApplication.Type3.contains("max")){

                        MAXBannerAds.MAXBanner(context, admob_banner, adContainer, qureka, "type4");

                    } else if(MyApplication.Type3.contains("qureka")){

                        /*if(MyApplication.CheckQureka != 0){
                            new QurekaBannerAds((Activity) context, qureka);
                        }*/

                    } else {

                    }

                } else if(type.equals("type4")){

                    if(MyApplication.Type4.contains("fb")){

                        FbBannerAds.showFbAds(context, admob_banner, adContainer, qureka, "");

                    } else if(MyApplication.Type4.contains("admob")){

                        admob_banner.setVisibility(View.VISIBLE);
                        new AdMobBanner().showAd((Activity) context, admob_banner, adContainer, qureka, "", new AdMobBanner.adMobSmallAdCallback() {
                            @Override
                            public void onAdLoaded() {
                            }

                            @Override
                            public void onAdError(String error) {
                            }
                        });

                    } else if(MyApplication.Type4.contains("max")){

                        MAXBannerAds.MAXBanner(context, admob_banner, adContainer, qureka, "");

                    } else if(MyApplication.Type4.contains("qureka")){

                        /*if(MyApplication.CheckQureka != 0){
                            new QurekaBannerAds((Activity) context, qureka);
                        }*/

                    } else {

                    }

                }

            }

            @Override
            public void onAdLoaded(Ad ad) {

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {
            }
        };

        adView.loadAd(adView.buildLoadAdConfig().withAdListener(adListener).build());

    }


}
