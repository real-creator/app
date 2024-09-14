package com.demo.aigirlfriend.ads.max;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.facebook.ads.NativeAdLayout;
import com.demo.aigirlfriend.ads.MyApplication;
import com.demo.aigirlfriend.ads.admob.AdMobNative;
import com.demo.aigirlfriend.ads.fb.FbNativeFullAds;

public class MAXNativeAds {

    public static MaxAd nativeAd;


    /*Reguler Native Ads*/

    public static void NativeAdsMAXFirst(Context context, FrameLayout nativeMax, FrameLayout admob_native_frame, NativeAdLayout nativeAdLayout) {

        nativeMax.setVisibility(View.VISIBLE);

        MaxNativeAdLoader nativeAdLoader = new MaxNativeAdLoader( MyApplication.MAX_Native, context );
        nativeAdLoader.setNativeAdListener( new MaxNativeAdListener()
        {
            @Override
            public void onNativeAdLoaded(final MaxNativeAdView nativeAdView, final MaxAd ad)
            {
                // Clean up any pre-existing native ad to prevent memory leaks.
                if ( nativeAd != null )
                {
                    nativeAdLoader.destroy( nativeAd );
                }

                // Save ad for cleanup.
                nativeAd = ad;

                // Add ad view to view.
                nativeMax.removeAllViews();
                nativeMax.addView( nativeAdView );
            }

            @Override
            public void onNativeAdLoadFailed(final String adUnitId, final MaxError error)
            {

                nativeMax.setVisibility(View.GONE);

                if(MyApplication.Type2.contains("max")){

                    MAXNativeAds.NativeAdsMAXSecond(context, nativeMax, admob_native_frame, nativeAdLayout);

                } else if(MyApplication.Type2.contains("admob")){

                    AdMobNative.getInstance().showNativeBigSecond((Activity) context, admob_native_frame, nativeAdLayout, nativeMax);

                } else if(MyApplication.Type2.contains("fb")){

                    com.facebook.ads.NativeAd nativeAd = new com.facebook.ads.NativeAd(context, MyApplication.Fbnative);
                    nativeAd.loadAd(nativeAd.buildLoadAdConfig().withAdListener(new FbNativeFullAds(nativeAd, context, nativeAdLayout, admob_native_frame, nativeMax, "type3")).build());

                } else if(MyApplication.Type2.contains("qureka")){

                    /*if(MyApplication.CheckQureka != 0){
                        new QurekaBigNative((Activity) context, admob_native_frame);
                    }*/

                } else {

                }

            }

            @Override
            public void onNativeAdClicked(final MaxAd ad)
            {
                // Optional click callback
            }
        } );

        nativeAdLoader.loadAd();

    }

    public static void NativeAdsMAXSecond(Context context, FrameLayout nativeMax, FrameLayout admob_native_frame, NativeAdLayout nativeAdLayout) {

        nativeMax.setVisibility(View.VISIBLE);

        MaxNativeAdLoader nativeAdLoader = new MaxNativeAdLoader( MyApplication.MAX_Native, context );
        nativeAdLoader.setNativeAdListener( new MaxNativeAdListener()
        {
            @Override
            public void onNativeAdLoaded(final MaxNativeAdView nativeAdView, final MaxAd ad)
            {
                // Clean up any pre-existing native ad to prevent memory leaks.
                if ( nativeAd != null )
                {
                    nativeAdLoader.destroy( nativeAd );
                }

                // Save ad for cleanup.
                nativeAd = ad;

                // Add ad view to view.
                nativeMax.removeAllViews();
                nativeMax.addView( nativeAdView );
            }

            @Override
            public void onNativeAdLoadFailed(final String adUnitId, final MaxError error)
            {

                nativeMax.setVisibility(View.GONE);

                if(MyApplication.Type3.contains("max")){

                    MAXNativeAds.NativeAdsMAXThird(context, nativeMax, admob_native_frame, nativeAdLayout);

                } else if(MyApplication.Type3.contains("admob")){

                    AdMobNative.getInstance().showNativeBigThird((Activity) context, admob_native_frame, nativeAdLayout, nativeMax);

                } else if(MyApplication.Type3.contains("fb")){

                    com.facebook.ads.NativeAd nativeAd = new com.facebook.ads.NativeAd(context, MyApplication.Fbnative);
                    nativeAd.loadAd(nativeAd.buildLoadAdConfig().withAdListener(new FbNativeFullAds(nativeAd, context, nativeAdLayout, admob_native_frame, nativeMax, "type4")).build());

                } else if(MyApplication.Type3.contains("qureka")){

                    /*if(MyApplication.CheckQureka != 0){
                        new QurekaBigNative((Activity) context, admob_native_frame);
                    }*/

                } else {

                }

            }

            @Override
            public void onNativeAdClicked(final MaxAd ad)
            {
                // Optional click callback
            }
        } );

        nativeAdLoader.loadAd();

    }

    public static void NativeAdsMAXThird(Context context, FrameLayout nativeMax, FrameLayout admob_native_frame, NativeAdLayout nativeAdLayout) {

        nativeMax.setVisibility(View.VISIBLE);

        MaxNativeAdLoader nativeAdLoader = new MaxNativeAdLoader( MyApplication.MAX_Native, context );
        nativeAdLoader.setNativeAdListener( new MaxNativeAdListener()
        {
            @Override
            public void onNativeAdLoaded(final MaxNativeAdView nativeAdView, final MaxAd ad)
            {
                // Clean up any pre-existing native ad to prevent memory leaks.
                if ( nativeAd != null )
                {
                    nativeAdLoader.destroy( nativeAd );
                }

                // Save ad for cleanup.
                nativeAd = ad;

                // Add ad view to view.
                nativeMax.removeAllViews();
                nativeMax.addView( nativeAdView );
            }

            @Override
            public void onNativeAdLoadFailed(final String adUnitId, final MaxError error)
            {

                nativeMax.setVisibility(View.GONE);

                if(MyApplication.Type4.contains("max")){

                    MAXNativeAds.NativeAdsMAXFour(context, nativeMax, admob_native_frame, nativeAdLayout);

                } else if(MyApplication.Type4.contains("admob")){

                    AdMobNative.getInstance().showNativeBigFour((Activity) context, admob_native_frame, nativeAdLayout, nativeMax);

                } else if(MyApplication.Type4.contains("fb")){

                    com.facebook.ads.NativeAd nativeAd = new com.facebook.ads.NativeAd(context, MyApplication.Fbnative);
                    nativeAd.loadAd(nativeAd.buildLoadAdConfig().withAdListener(new FbNativeFullAds(nativeAd, context, nativeAdLayout, admob_native_frame, nativeMax, "")).build());

                } else if(MyApplication.Type4.contains("qureka")){

                    /*if(MyApplication.CheckQureka != 0){
                        new QurekaBigNative((Activity) context, admob_native_frame);
                    }*/

                } else {

                }

            }

            @Override
            public void onNativeAdClicked(final MaxAd ad)
            {
                // Optional click callback
            }
        } );

        nativeAdLoader.loadAd();

    }

    public static void NativeAdsMAXFour(Context context, FrameLayout nativeMax, FrameLayout admob_native_frame, NativeAdLayout nativeAdLayout) {

        nativeMax.setVisibility(View.VISIBLE);

        MaxNativeAdLoader nativeAdLoader = new MaxNativeAdLoader( MyApplication.MAX_Native, context );
        nativeAdLoader.setNativeAdListener( new MaxNativeAdListener()
        {
            @Override
            public void onNativeAdLoaded(final MaxNativeAdView nativeAdView, final MaxAd ad)
            {
                // Clean up any pre-existing native ad to prevent memory leaks.
                if ( nativeAd != null )
                {
                    nativeAdLoader.destroy( nativeAd );
                }

                // Save ad for cleanup.
                nativeAd = ad;

                // Add ad view to view.
                nativeMax.removeAllViews();
                nativeMax.addView( nativeAdView );
            }

            @Override
            public void onNativeAdLoadFailed(final String adUnitId, final MaxError error)
            {

                nativeMax.setVisibility(View.GONE);

            }

            @Override
            public void onNativeAdClicked(final MaxAd ad)
            {
                // Optional click callback
            }
        } );

        nativeAdLoader.loadAd();

    }

}
