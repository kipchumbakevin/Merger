package com.money.moneyloans.makemoney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.money.moneyloans.R;

public class InsuranceActivity extends AppCompatActivity {
    TextView broker,agent,title;
    ImageView imageView;
    private AdView adView;
    private InterstitialAd interstitialAd;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance);
        broker = findViewById(R.id.broker);
        agent = findViewById(R.id.agent);
        title = findViewById(R.id.title);
        imageView = findViewById(R.id.imageview);
        adView = findViewById(R.id.banner_container);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial));
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }
        });
        broker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 2;

                    Intent intent = new Intent(InsuranceActivity.this, BrokerActivity.class);
                    startActivity(intent);
                    finish();

            }
        });
        agent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 3;

                    Intent intent = new Intent(InsuranceActivity.this, AgentActivity.class);
                    startActivity(intent);
                    finish();

            }
        });
    }

    @Override
    public void onBackPressed() {
        i = 1;
        if (interstitialAd.isLoaded()){
            interstitialAd.show();
        }else {
            Intent intent = new Intent(InsuranceActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
