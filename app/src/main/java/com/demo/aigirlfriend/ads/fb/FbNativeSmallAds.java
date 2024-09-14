package com.demo.aigirlfriend.ads.fb;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.demo.aigirlfriend.R;
import com.demo.aigirlfriend.ads.MyApplication;
import com.demo.aigirlfriend.ads.admob.AdMobNative;
import com.demo.aigirlfriend.ads.max.MAXNativeSmallAds;

import java.util.ArrayList;
import java.util.List;

public class FbNativeSmallAds implements NativeAdListener {

    final NativeBannerAd mNativeBannerAd;
    final Context mContext;
    final LinearLayout[] mLinearLayoutArr;
    final NativeAdLayout mNativeAdLayout;
    FrameLayout admob_native_frame;
    String type;

    public FbNativeSmallAds(NativeBannerAd nativeBannerAd, Context context, LinearLayout[] linearLayoutArr, NativeAdLayout nativeAdLayout, FrameLayout madmob_native_frame, String mtype) {
        this.mNativeBannerAd = nativeBannerAd;
        this.mContext = context;
        this.mLinearLayoutArr = linearLayoutArr;
        this.mNativeAdLayout = nativeAdLayout;
        this.admob_native_frame = madmob_native_frame;
        this.type = mtype;
    }

    public void onAdClicked(Ad ad) {
    }

    public void onAdLoaded(Ad ad) {

        mNativeAdLayout.setVisibility(View.VISIBLE);
        Log.e("divrsity", "onAdLoaded: " + ad);
        NativeBannerAd nativeBannerAd = this.mNativeBannerAd;

        nativeBannerAd.unregisterView();
        this.mLinearLayoutArr[0] = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.ads_fb_banner_native, this.mNativeAdLayout, false);
        this.mNativeAdLayout.removeAllViews();
        this.mNativeAdLayout.addView(this.mLinearLayoutArr[0]);
        RelativeLayout relativeLayout = (RelativeLayout) this.mLinearLayoutArr[0].findViewById(R.id.ad_choices_container);
        AdOptionsView adOptionsView = new AdOptionsView(this.mContext, this.mNativeBannerAd, this.mNativeAdLayout, AdOptionsView.Orientation.HORIZONTAL, 20);
        relativeLayout.removeAllViews();
        relativeLayout.addView(adOptionsView, 0);
        TextView textView = (TextView) this.mLinearLayoutArr[0].findViewById(R.id.native_ad_title);
        TextView textView2 = (TextView) this.mLinearLayoutArr[0].findViewById(R.id.native_ad_social_context);
        TextView textView3 = (TextView) this.mLinearLayoutArr[0].findViewById(R.id.native_ad_sponsored_label);
        MediaView mediaView = (MediaView) this.mLinearLayoutArr[0].findViewById(R.id.native_icon_view);
        Button button = (Button) this.mLinearLayoutArr[0].findViewById(R.id.native_ad_call_to_action);
        button.setText(this.mNativeBannerAd.getAdCallToAction());
        button.setVisibility(this.mNativeBannerAd.hasCallToAction() ? 0 : 4);
        textView.setText(this.mNativeBannerAd.getAdvertiserName());
        textView2.setText(this.mNativeBannerAd.getAdSocialContext());
        textView3.setText("Sponsored");
        ArrayList arrayList = new ArrayList();
        arrayList.add(button);
        this.mNativeBannerAd.registerViewForInteraction((View) this.mLinearLayoutArr[0], mediaView, (List<View>) arrayList);
//            if (nativeBannerAd != null && nativeBannerAd == ad) {
//            }
    }

    public void onError(Ad ad, AdError adError) {
        Log.e("diversity", "onError: " + adError.getErrorMessage());

        mNativeAdLayout.setVisibility(View.GONE);

        onErrorCheckAds();

    }

    public void onLoggingImpression(Ad ad) {
    }

    public void onMediaDownloaded(Ad ad) {
    }

    private void onErrorCheckAds() {

        if(type.equals("type2")){

            if(MyApplication.Type2.contains("fb")){

                NativeBannerAd nativeBannerAd = new NativeBannerAd(mContext, MyApplication.FbNativeB);
                nativeBannerAd.loadAd(nativeBannerAd.buildLoadAdConfig().withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withAdListener(
                        new FbNativeSmallAds(nativeBannerAd, mContext, new LinearLayout[1], mNativeAdLayout, admob_native_frame, "type3")).build());

            } else if(MyApplication.Type2.contains("admob")){

                AdMobNative.getInstance().showNativeSmallSecond((Activity) mContext, admob_native_frame, mNativeAdLayout);

            } else if(MyApplication.Type2.contains("max")){

                MAXNativeSmallAds.MAXNativeSmallSecond(mContext, admob_native_frame, mNativeAdLayout);

            } else if(MyApplication.Type2.contains("qureka")){

                /*if(MyApplication.CheckQureka != 0){
                    new QurekaSmallNative((Activity) mContext, admob_native_frame);
                }*/

            } else {

            }

        } else if(type.equals("type3")){

            if(MyApplication.Type3.contains("fb")){

                NativeBannerAd nativeBannerAd = new NativeBannerAd(mContext, MyApplication.FbNativeB);
                nativeBannerAd.loadAd(nativeBannerAd.buildLoadAdConfig().withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withAdListener(
                        new FbNativeSmallAds(nativeBannerAd, mContext, new LinearLayout[1], mNativeAdLayout, admob_native_frame, "type4")).build());

            } else if(MyApplication.Type3.contains("admob")){

                AdMobNative.getInstance().showNativeSmallThird((Activity) mContext, admob_native_frame, mNativeAdLayout);

            } else if(MyApplication.Type3.contains("max")){

                MAXNativeSmallAds.MAXNativeSmallThird(mContext, admob_native_frame, mNativeAdLayout);

            } else if(MyApplication.Type3.contains("qureka")){

                /*if(MyApplication.CheckQureka != 0){
                    new QurekaSmallNative((Activity) mContext, admob_native_frame);
                }*/

            } else {

            }

        } else if(type.equals("type4")){

            if(MyApplication.Type4.contains("fb")){

                NativeBannerAd nativeBannerAd = new NativeBannerAd(mContext, MyApplication.FbNativeB);
                nativeBannerAd.loadAd(nativeBannerAd.buildLoadAdConfig().withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withAdListener(
                        new FbNativeSmallAds(nativeBannerAd, mContext, new LinearLayout[1], mNativeAdLayout, admob_native_frame, "")).build());

            } else if(MyApplication.Type4.contains("admob")){

                AdMobNative.getInstance().showNativeSmallFour((Activity) mContext, admob_native_frame, mNativeAdLayout);

            } else if(MyApplication.Type4.contains("max")){

                MAXNativeSmallAds.MAXNativeSmallFour(mContext, admob_native_frame, mNativeAdLayout);

            } else if(MyApplication.Type4.contains("qureka")){

                /*if(MyApplication.CheckQureka != 0){
                    new QurekaSmallNative((Activity) mContext, admob_native_frame);
                }*/

            } else {

            }

        }

    }

}