package com.moneyloans.makemoneyandloans.makemoney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.moneyloans.makemoneyandloans.R;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;

public class AdSpaceActivity extends AppCompatActivity {
    TextView site,blog,title;
    ImageView imageView;
    private AdView adView;
    private InterstitialAd interstitialAd;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_space);
        site = findViewById(R.id.site);
        title = findViewById(R.id.title);
        blog = findViewById(R.id.blog);
        imageView = findViewById(R.id.imageview);
        // Initialize the Audience Network SDK
        AudienceNetworkAds.initialize(this);

        adView = new AdView(this, getString(R.string.banner), AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();
        interstitialAd = new InterstitialAd(this, getString(R.string.interstitial));
        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
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
                    Intent intent = new Intent(AdSpaceActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else if (i == 2){
                    Intent intent = new Intent(AdSpaceActivity.this, BlogActivity.class);
                    startActivity(intent);
                    finish();
                }else if (i == 3){
                    Intent intent = new Intent(AdSpaceActivity.this, WebsiteActivity.class);
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
        site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 3;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(AdSpaceActivity.this, WebsiteActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 2;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(AdSpaceActivity.this, BlogActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        if (interstitialAd != null){
            interstitialAd.destroy();
        }
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        i = 1;
        if (interstitialAd.isAdLoaded()){
            interstitialAd.show();
        }else {
            Intent intent = new Intent(AdSpaceActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
