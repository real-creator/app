package com.demo.aigirlfriend.splashAds;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.demo.aigirlfriend.MainActivity;
import com.demo.aigirlfriend.R;
import com.demo.aigirlfriend.ads.MyApplication;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class PrivacyTermsActivity extends AppCompatActivity {

    Button accept_button;
    CheckBox first_check, second_check;
    Activity activity;

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_terms);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorlight));
        }

        activity = PrivacyTermsActivity.this;

        first_check = findViewById(R.id.first_check);
        second_check = findViewById(R.id.second_check);
        accept_button = findViewById(R.id.accept_button);
        accept_button.setOnClickListener(new android.view.View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(android.view.View v) {
                if (!first_check.isChecked() || !second_check.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Check above options to continue", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    MyApplication.setuser_onetime(1);
                    Intent i = new Intent(activity, MainActivity.class);
                    startActivity(i);
                    finish();
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);


                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            accept_button.setText("Get Started");
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}