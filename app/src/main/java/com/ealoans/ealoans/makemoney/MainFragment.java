package com.ealoans.ealoans.makemoney;


import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ealoans.ealoans.R;
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
public class MainFragment extends Fragment {

    RelativeLayout bitcoin;
    LinearLayoutCompat insurance,sellads,marketing,ecommerce,digitalcourse,membershipsite,directory,buysellwebsites,youtube;
    CardView share,rate;
    private AdView adView;
    TextView policy;
    private InterstitialAd interstitialAd;
    int i = 0;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        bitcoin = view.findViewById(R.id.bitcoin);
        insurance = view.findViewById(R.id.insurance);
        sellads = view.findViewById(R.id.sellads);
        marketing = view.findViewById(R.id.marketing);
        share = view.findViewById(R.id.share);
        rate = view.findViewById(R.id.rate);
        policy = view.findViewById(R.id.policy);
        ecommerce = view.findViewById(R.id.ecommerce);
        digitalcourse = view.findViewById(R.id.digitalcourse);
        membershipsite = view.findViewById(R.id.membershipsite);
        directory = view.findViewById(R.id.onlinedirectory);
        buysellwebsites = view.findViewById(R.id.buysellwebsites);
        youtube = view.findViewById(R.id.youtube);
        AudienceNetworkAds.initialize(getActivity());

        adView = new AdView(getActivity(), getString(R.string.banner), AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) view.findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();
        interstitialAd = new InterstitialAd(getActivity(), getString(R.string.interstitial));
        final InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                // Interstitial ad displayed callback
                //  Log.e(TAG, "Interstitial ad displayed.");
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                // Interstitial dismissed callback
                //  Log.e(TAG, "Interstitial ad dismissed.");
                if (i == 1){
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(1));
                    intent.putExtra("GOBACK", Integer.toString(2));
                    startActivity(intent);
                    getActivity().finish();
                }else if (i == 2){
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(3));
                    intent.putExtra("GOBACK", Integer.toString(2));
                    startActivity(intent);
                    getActivity().finish();
                }else if (i == 3){
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(2));
                    intent.putExtra("GOBACK", Integer.toString(2));
                    startActivity(intent);
                    getActivity().finish();
                }else if (i == 4){
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(5));
                    intent.putExtra("GOBACK", Integer.toString(2));
                    startActivity(intent);
                    getActivity().finish();
                }else if (i == 5){
                    Intent intent = new Intent(getActivity(), BuySell.class);
                    startActivity(intent);
                    getActivity().finish();
                }else if (i == 6){
                    Intent intent = new Intent(getActivity(), InsuranceActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }else if (i == 7){
                    Intent intent = new Intent(getActivity(), AdSpaceActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }else if (i == 8){
                    Intent intent = new Intent(getActivity(), MarketingActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }else if (i == 9){
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(4));
                    intent.putExtra("GOBACK", Integer.toString(2));
                    startActivity(intent);
                    getActivity().finish();
                }else if (i == 10){
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(6));
                    intent.putExtra("GOBACK", Integer.toString(2));
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

        ecommerce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 1;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(1));
                    intent.putExtra("GOBACK", Integer.toString(2));
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        membershipsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 2;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(3));
                    intent.putExtra("GOBACK", Integer.toString(2));
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        digitalcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 3;if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(2));
                    intent.putExtra("GOBACK", Integer.toString(2));
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        buysellwebsites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 4;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(5));
                    intent.putExtra("GOBACK", Integer.toString(2));
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        bitcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 5;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(getActivity(), BuySell.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 6;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(getActivity(), InsuranceActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        sellads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 7;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(getActivity(), AdSpaceActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        marketing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 8;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(getActivity(), MarketingActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        directory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 9;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(4));
                    intent.putExtra("GOBACK", Integer.toString(2));
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 10;
                if (interstitialAd.isAdLoaded()){
                    interstitialAd.show();
                }else {
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(6));
                    intent.putExtra("GOBACK", Integer.toString(2));
                    startActivity(intent);
                    ((Activity)getActivity()).finish();
                }
            }
        });
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=" + getActivity().getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=" + getActivity().getPackageName())));
                }
            }
        });
        policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://lovidovi.co.ke/appprivacypolicy");
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://lovidovi.co.ke/appprivacypolicy")));
                }
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBody =
                        "Find ideas to earn you money!. Download cashASAP App now at https://play.google.com/store/apps/details?id="
                                + getActivity().getPackageName();
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
                intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(intent, "Share via"));
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
