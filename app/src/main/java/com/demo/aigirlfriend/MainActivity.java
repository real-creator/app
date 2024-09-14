package com.demo.aigirlfriend;

import android.app.Dialog;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.demo.aigirlfriend.ads.AdsCommon;
import com.demo.aigirlfriend.ads.MyApplication;
import com.demo.aigirlfriend.constants.SPKeys;
import com.demo.aigirlfriend.databinding.ActivityMainBinding;
import com.demo.aigirlfriend.ui.BaseActivity;
import com.demo.aigirlfriend.ui.ChatFragment;
import com.demo.aigirlfriend.ui.LovelistFragment;
import com.demo.aigirlfriend.ui.SettingActivity;
import com.demo.aigirlfriend.utils.ChatUtil;
import com.demo.aigirlfriend.utils.SPUtils;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.Task;

public class MainActivity extends BaseActivity {


    AppUpdateManager appUpdateManager;

    ReviewManager reviewManager;
    ReviewInfo reviewInfo;
    public static int intentClick = 2;
    ActivityMainBinding binding;
    private int mCurrentFragmentIndex = -1;
    private final Fragment[] mFragments = new Fragment[2];


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        ActivityMainBinding inflate = ActivityMainBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        setContentView((View) inflate.getRoot());


        //InAppUpdate
        checkInAppUpdate();

        //InApp Review
        googleReviewInApp();


        //Reguler Banner Ads
        RelativeLayout admob_banner = (RelativeLayout) binding.btm1.AdmobBannerFrame;
        LinearLayout adContainer = (LinearLayout) binding.btm1.bannerContainer;
        FrameLayout qureka = (FrameLayout) binding.btm1.qureka;
        AdsCommon.RegulerBanner(this, admob_banner, adContainer, qureka);


        this.binding.mRbTabChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.clickTabChat();
            }
        });
        this.binding.mRbTabList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.clickTabList();
            }
        });
        ChatUtil.initChats();
        if (((Boolean) SPUtils.get(MyApplication.mContext, SPKeys.FIRST_OPEN, true)).booleanValue()) {
            SPUtils.put(MyApplication.mContext, SPKeys.FIRST_OPEN, false);
            ChatUtil.sendDefaultMsg();
            clickTabList();
        } else {
            clickTabList();
        }
        resize();
        this.binding.btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                AdsCommon.InterstitialAd(MainActivity.this, intent);
            }
        });
    }

    private void resize() {
        HelperResizer.getheightandwidth(this);
        HelperResizer.setSize(this.binding.mImageTabChat, 120, 120);
        HelperResizer.setSize(this.binding.mImageTabList, 120, 120);
        HelperResizer.setSize(this.binding.btnSetting, 120, 120);
        HelperResizer.setSize(this.binding.conTopBar, 1080, 150);
        HelperResizer.setSize(this.binding.conBottom, 1080, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    }

    
    public void clickTabChat() {
        this.binding.titleTopBar.setText(getResources().getString(R.string.Chat));
        this.binding.titleTopBar.setGravity(17);
        this.mCurrentFragmentIndex = 0;
        this.binding.mImageTabChat.setImageResource(R.drawable.chat_press);
        this.binding.mTvTabChat.setTextColor(getResources().getColor(R.color.color_FF3E71));
        this.binding.mImageTabList.setImageResource(R.drawable.love_unpress);
        this.binding.mTvTabList.setTextColor(getResources().getColor(R.color.white));
        loadFragment(new ChatFragment());
    }

    
    public void clickTabList() {
        this.binding.titleTopBar.setText(getResources().getString(R.string.ai_gf_anime_girl));
        this.binding.titleTopBar.setGravity(16);
        this.mCurrentFragmentIndex = 1;
        this.binding.mImageTabChat.setImageResource(R.drawable.chat_unpress);
        this.binding.mTvTabChat.setTextColor(getResources().getColor(R.color.white));
        this.binding.mImageTabList.setImageResource(R.drawable.love_press);
        this.binding.mTvTabList.setTextColor(getResources().getColor(R.color.color_FF3E71));
        loadFragment(new LovelistFragment());
    }

    private void replaceFragment(int i) {
        newCurrentFragment(i);
    }


    private void newCurrentFragment(int i) {
        Fragment fragment;
        if (i == 1) {
            fragment = LovelistFragment.newInstance();
        } else {
            fragment = ChatFragment.newInstance();
        }
        this.mFragments[i] = fragment;
        addAndShowFragment(fragment);
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.mFlContent, fragment);
        beginTransaction.commit();
    }

    private void addAndShowFragment(Fragment fragment) {
        if (fragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().show(fragment).commitAllowingStateLoss();
        } else {
            getSupportFragmentManager().beginTransaction().add((int) R.id.mFlContent, fragment).commitAllowingStateLoss();
        }
    }

    private void hideFragment(Fragment fragment) {
        if (fragment.isVisible()) {
            getSupportFragmentManager().beginTransaction().hide(fragment).commitAllowingStateLoss();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        int i = intentClick;
        if (i == 0) {
            clickTabChat();
        } else if (i == 1) {
            clickTabList();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ChatUtil.recycle();
    }


    @Override
    public void onBackPressed() {
        ExitDialog();
    }

    private void ExitDialog() {

        final Dialog dialog = new Dialog(MainActivity.this, R.style.DialogTheme);
        dialog.setContentView(R.layout.popup_exit_dialog);
        dialog.setCancelable(false);

        RelativeLayout no = (RelativeLayout) dialog.findViewById(R.id.no);
        RelativeLayout rate = (RelativeLayout) dialog.findViewById(R.id.rate);
        RelativeLayout yes = (RelativeLayout) dialog.findViewById(R.id.yes);

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String rateapp = getPackageName();
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + rateapp));
                startActivity(intent1);
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                finish();
                System.exit(0);
                //Intent intent = new Intent(AppMainHomeActivity.this, AppThankYouActivity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                //AdsCommon.InterstitialAd(AppMainHomeActivity.this, intent);
            }
        });

        dialog.show();
    }

    //InAppUpdate Code
    private void checkInAppUpdate() {
        appUpdateManager = AppUpdateManagerFactory.create(this);
        Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();
        appUpdateInfoTask.addOnSuccessListener(appUpdateInfo -> {

            if(MyApplication.checkInAppUpdate == 0){

                if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                        && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE)) {
                    // Request the update.
                    try {
                        appUpdateManager.startUpdateFlowForResult(
                                // Pass the intent that is returned by 'getAppUpdateInfo()'.
                                appUpdateInfo,
                                // an activity result launcher registered via registerForActivityResult
                                AppUpdateType.FLEXIBLE,
                                this,
                                // Or pass 'AppUpdateType.FLEXIBLE' to newBuilder() for
                                // flexible updates.
                                100);
                    } catch (IntentSender.SendIntentException e) {
                        e.printStackTrace();
                    }
                }

                appUpdateManager.registerListener(listener);

            } else {

                if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                        && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)) {
                    // Request the update.
                    try {
                        appUpdateManager.startUpdateFlowForResult(
                                // Pass the intent that is returned by 'getAppUpdateInfo()'.
                                appUpdateInfo,
                                // an activity result launcher registered via registerForActivityResult
                                AppUpdateType.IMMEDIATE,
                                this,
                                // Or pass 'AppUpdateType.FLEXIBLE' to newBuilder() for
                                // flexible updates.
                                100);
                    } catch (IntentSender.SendIntentException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

    }

    /*InApp Update Flexible*/
    InstallStateUpdatedListener listener = state -> {
        if(state.installStatus() == InstallStatus.DOWNLOADED){
            popupSnackbarForCompleteUpdate();
        }
    };

    private void popupSnackbarForCompleteUpdate(){
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "An Update has just been downloaded.", Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("INSTALL", v -> appUpdateManager.completeUpdate());
        snackbar.setActionTextColor(getResources().getColor(android.R.color.holo_blue_bright));
        snackbar.show();
    }

    //InAppReview
    private void googleReviewInApp() {
        reviewManager = ReviewManagerFactory.create(this);
        Task<ReviewInfo> request = reviewManager.requestReviewFlow();
        request.addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                // We can get the ReviewInfo object
                reviewInfo = task.getResult();
                Task<Void> flow = reviewManager.launchReviewFlow(this, reviewInfo);
                flow.addOnCompleteListener(task1 -> {
                    // The flow has finished. The API does not indicate whether the user
                    // reviewed or not, or even whether the review dialog was shown. Thus, no
                    // matter the result, we continue our app flow.
                });
            } else {
            }
        });
    }
}
