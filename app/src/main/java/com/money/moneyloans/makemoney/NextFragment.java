package com.money.moneyloans.makemoney;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        adView = view.findViewById(R.id.banner_container);

        MobileAds.initialize(getActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        interstitialAd = new InterstitialAd(getActivity());
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

        sellprogramming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 1;

                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(7));
                    startActivity(intent);
                    getActivity().finish();

            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 2;

                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(9));
                    startActivity(intent);
                    getActivity().finish();

            }
        });
        resellhosting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 3;

                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(11));
                    startActivity(intent);
                    getActivity().finish();

            }
        });
        survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 4;

                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(14));
                    startActivity(intent);
                    getActivity().finish();

            }
        });
        socialmedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 5;

                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(15));
                    startActivity(intent);
                    getActivity().finish();

            }
        });
        sellyours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 6;

                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(12));
                    startActivity(intent);
                    getActivity().finish();

            }
        });
        jobboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 7;

                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(13));
                    startActivity(intent);
                    getActivity().finish();

            }
        });
        affiliatewebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 8;

                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(10));
                    startActivity(intent);
                    getActivity().finish();

            }
        });
        websitedeveloper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 9;

                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(8));
                    startActivity(intent);
                    getActivity().finish();

            }
        });
        graphic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 10;

                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(16));
                    startActivity(intent);
                    getActivity().finish();

            }
        });
        return view;
    }

}
