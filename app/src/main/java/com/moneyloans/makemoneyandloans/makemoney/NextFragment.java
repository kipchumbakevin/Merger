package com.moneyloans.makemoneyandloans.makemoney;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class NextFragment extends Fragment {
    TextView sellprogramming,instagram,affiliatewebsite,resellhosting,sellyours,
            jobboard,survey,socialmedia,graphic, websitedeveloper;
    private AdView adView;
    private InterstitialAd interstitialAd;
    int i = 0;
    public NextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for getActivity() fragment
        View view = inflater.inflate(R.layout.fragment_next, container, false);
        sellprogramming = view.findViewById(R.id.sellprogramming);
        websitedeveloper = view.findViewById(R.id.websitedeveloper);
        affiliatewebsite = view.findViewById(R.id.affiliatewebsite);
        instagram = view.findViewById(R.id.instagram);
        resellhosting = view.findViewById(R.id.resellwebshosting);
        sellyours = view.findViewById(R.id.sellyourservices);
        jobboard = view.findViewById(R.id.jobboard);
        survey = view.findViewById(R.id.survey);
        socialmedia = view.findViewById(R.id.socialmedia);
        graphic = view.findViewById(R.id.graphic);
        AudienceNetworkAds.initialize(getActivity());

        adView = new AdView(getActivity(), getString(R.string.banner), AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) view.findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();
        interstitialAd = new InterstitialAd(getActivity(), getString(R.string.interstitial));
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
                if (i == 11){
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
                else if (i == 1){
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT",Integer.toString(7));
                    startActivity(intent);
                    getActivity().finish();
                }else if (i == 2){
                    Intent intent = new Intent(getActivity(),TransitionActivity.class);
                    intent.putExtra("INTENT",Integer.toString(9));
                    startActivity(intent);
                    getActivity().finish();
                }else if (i == 3){
                    Intent intent = new Intent(getActivity(),TransitionActivity.class);
                    intent.putExtra("INTENT",Integer.toString(11));
                    startActivity(intent);
                    getActivity().finish();
                }else if (i == 4){
                    Intent intent = new Intent(getActivity(),TransitionActivity.class);
                    intent.putExtra("INTENT",Integer.toString(14));
                    startActivity(intent);
                    getActivity().finish();
                }else if (i == 5){
                    Intent intent = new Intent(getActivity(),TransitionActivity.class);
                    intent.putExtra("INTENT",Integer.toString(15));
                    startActivity(intent);
                    getActivity().finish();
                }else if (i == 6){
                    Intent intent = new Intent(getActivity(),TransitionActivity.class);
                    intent.putExtra("INTENT",Integer.toString(12));
                    startActivity(intent);
                    getActivity().finish();
                }else if (i == 7){
                    Intent intent = new Intent(getActivity(),TransitionActivity.class);
                    intent.putExtra("INTENT",Integer.toString(13));
                    startActivity(intent);
                    getActivity().finish();
                }else if (i == 8){
                    Intent intent = new Intent(getActivity(),TransitionActivity.class);
                    intent.putExtra("INTENT",Integer.toString(10));
                    startActivity(intent);
                    getActivity().finish();
                }else if (i == 9){
                    Intent intent = new Intent(getActivity(),TransitionActivity.class);
                    intent.putExtra("INTENT",Integer.toString(8));
                    startActivity(intent);
                    getActivity().finish();
                }else if (i == 10){
                    Intent intent = new Intent(getActivity(),TransitionActivity.class);
                    intent.putExtra("INTENT",Integer.toString(16));
                    startActivity(intent);
                    getActivity().finish();
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

        sellprogramming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 1;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(7));
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 2;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(9));
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        resellhosting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 3;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(11));
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 4;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(14));
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        socialmedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 5;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(15));
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        sellyours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 6;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(12));
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        jobboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 7;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(13));
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        affiliatewebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 8;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(10));
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        websitedeveloper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 9;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(8));
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        graphic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 10;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(16));
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }if (interstitialAd != null){
            interstitialAd.destroy();
        }
        super.onDestroy();
    }
}
