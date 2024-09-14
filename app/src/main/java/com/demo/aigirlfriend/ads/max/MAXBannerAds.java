package com.demo.aigirlfriend.ads.max;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.demo.aigirlfriend.R;
import com.demo.aigirlfriend.ads.MyApplication;
import com.demo.aigirlfriend.ads.admob.AdMobBanner;
import com.demo.aigirlfriend.ads.fb.FbBannerAds;


public class MAXBannerAds {

    public static void MAXBanner(Context context, RelativeLayout admob_banner, LinearLayout adContainer, FrameLayout qureka, String type) {

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

                if(type.equals("type2")){

                    if(MyApplication.Type2.contains("max")){

                        MAXBannerAds.MAXBanner(context, admob_banner, adContainer, qureka, "type3");

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

                    } else if(MyApplication.Type2.contains("fb")){

                        FbBannerAds.showFbAds(context, admob_banner, adContainer, qureka, "type3");

                    } else if(MyApplication.Type2.contains("qureka")){

                        /*if(MyApplication.CheckQureka != 0){
                            new QurekaBannerAds((Activity) context, qureka);
                        }*/

                    } else {

                    }

                } else if(type.equals("type3")){

                    if(MyApplication.Type3.contains("max")){

                        MAXBannerAds.MAXBanner(context, admob_banner, adContainer, qureka, "type4");

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

                    } else if(MyApplication.Type3.contains("fb")){

                        FbBannerAds.showFbAds(context, admob_banner, adContainer, qureka, "type4");

                    } else if(MyApplication.Type3.contains("qureka")){

                        /*if(MyApplication.CheckQureka != 0){
                            new QurekaBannerAds((Activity) context, qureka);
                        }*/

                    } else {

                    }

                } else if(type.equals("type4")){

                    if(MyApplication.Type4.contains("max")){

                        MAXBannerAds.MAXBanner(context, admob_banner, adContainer, qureka, "");

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

                    } else if(MyApplication.Type4.contains("fb")){

                        FbBannerAds.showFbAds(context, admob_banner, adContainer, qureka, "");

                    } else if(MyApplication.Type4.contains("qureka")){

                        /*if(MyApplication.CheckQureka != 0){
                            new QurekaBannerAds((Activity) context, qureka);
                        }*/

                    } else {

                    }

                }

            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        });

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = context.getResources().getDimensionPixelSize(R.dimen.banner_height);
        adView.setLayoutParams(new FrameLayout.LayoutParams(width, height, Gravity.CENTER));
        adContainer.addView(adView);
        adView.loadAd();


    }

}
