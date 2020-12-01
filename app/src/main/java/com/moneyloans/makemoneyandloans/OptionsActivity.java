package com.moneyloans.makemoneyandloans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.moneyloans.makemoneyandloans.makemoney.MainActivity;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;

public class OptionsActivity extends AppCompatActivity {
    TextView loans,earnings;
    InterstitialAdListener interstitialAdListener;
    private AdView adView;
    private InterstitialAd interstitialAd;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        loans = findViewById(R.id.loans);
        earnings = findViewById(R.id.earnings);

        AudienceNetworkAds.initialize(this);
        adView = new AdView(OptionsActivity.this, getString(R.string.banner), AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();
        interstitialAd = new InterstitialAd(OptionsActivity.this, getString(R.string.interstitial));

        interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                // Interstitial ad displayed callback
                //  Log.e(TAG, "Interstitial ad displayed.");
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                // Interstitial dismissed callback
                //  Log.e(TAG, "Interstitial ad dismissed.");
                if (i == 1) {
                    Intent intent = new Intent(OptionsActivity.this, LandingPage.class);
                    startActivity(intent);
                    finish();
                }else if (i == 2){
                    Intent intent = new Intent(OptionsActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else if (i == 57){
                    Intent intent = new Intent(OptionsActivity.this,Splash.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                //Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Interstitial ad is loaded and ready to be displayed
                // Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");
                // Show the ad
                //interstitialAd.show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
                // Log.d(TAG, "Interstitial ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
                // Log.d(TAG, "Interstitial ad impression logged!");
            }
        };
        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());

        loans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 1;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(OptionsActivity.this, LandingPage.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        earnings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 2;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(OptionsActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        i = 57;
        if (interstitialAd.isAdLoaded()){
            interstitialAd.show();
        }else {
            Intent intent = new Intent(OptionsActivity.this,Splash.class);
            startActivity(intent);
            finish();
        }
    }
}
