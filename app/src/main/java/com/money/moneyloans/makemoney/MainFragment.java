package com.money.moneyloans.makemoney;


import android.app.Activity;
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
public class MainFragment extends Fragment {

    TextView insurance,sellads,marketing,ecommerce,digitalcourse,membershipsite,directory,buysellwebsites,bitcoin,youtube;
    private AdView adView;
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
        ecommerce = view.findViewById(R.id.ecommerce);
        digitalcourse = view.findViewById(R.id.digitalcourse);
        membershipsite = view.findViewById(R.id.membershipsite);
        directory = view.findViewById(R.id.onlinedirectory);
        buysellwebsites = view.findViewById(R.id.buysellwebsites);
        youtube = view.findViewById(R.id.youtube);
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

        ecommerce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 1;

                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(1));
                    intent.putExtra("GOBACK", Integer.toString(2));
                    startActivity(intent);
                    getActivity().finish();

            }
        });
        membershipsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 2;

                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(3));
                    intent.putExtra("GOBACK", Integer.toString(2));
                    startActivity(intent);
                    getActivity().finish();

            }
        });
        digitalcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 3;
                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(2));
                    intent.putExtra("GOBACK", Integer.toString(2));
                    startActivity(intent);
                    getActivity().finish();

            }
        });
        buysellwebsites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 4;

                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(5));
                    intent.putExtra("GOBACK", Integer.toString(2));
                    startActivity(intent);
                    getActivity().finish();

            }
        });
        bitcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 5;

                    Intent intent = new Intent(getActivity(), BuySell.class);
                    startActivity(intent);
                    getActivity().finish();

            }
        });
        insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 6;

                    Intent intent = new Intent(getActivity(), InsuranceActivity.class);
                    startActivity(intent);
                    getActivity().finish();

            }
        });
        sellads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 7;

                    Intent intent = new Intent(getActivity(), AdSpaceActivity.class);
                    startActivity(intent);
                    getActivity().finish();

            }
        });
        marketing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 8;

                    Intent intent = new Intent(getActivity(), MarketingActivity.class);
                    startActivity(intent);
                    getActivity().finish();

            }
        });
        directory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 9;

                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(4));
                    intent.putExtra("GOBACK", Integer.toString(2));
                    startActivity(intent);
                    getActivity().finish();

            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 10;

                    Intent intent = new Intent(getActivity(), TransitionActivity.class);
                    intent.putExtra("INTENT", Integer.toString(6));
                    intent.putExtra("GOBACK", Integer.toString(2));
                    startActivity(intent);
                    ((Activity)getActivity()).finish();

            }
        });


        return view;
    }
}
