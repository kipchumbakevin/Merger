package com.money.moneyloans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class LandingPage extends AppCompatActivity {
    TextView kenya,nigeria,india;
    private AdView adView;
    private InterstitialAd interstitialAd;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        kenya = findViewById(R.id.kenya);
        nigeria = findViewById(R.id.nigeria);
        india = findViewById(R.id.india);

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
        kenya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 1;

                    Intent intent = new Intent(LandingPage.this, Kenya.class);
                    startActivity(intent);
                    finish();

                            }
        });
        india.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 2;
                    Intent intent = new Intent(LandingPage.this, India.class);
                    startActivity(intent);
                    finish();
            }
        });
        nigeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 3;

                    Intent intent = new Intent(LandingPage.this, Nigeria.class);
                    startActivity(intent);
                    finish();


            }
        });
    }

    @Override
    public void onBackPressed() {
        i = 57;
        if (interstitialAd.isLoaded()){
            interstitialAd.show();
        }else {
            Intent intent = new Intent(LandingPage.this,OptionsActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
