package com.money.moneyloans;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Nigeria extends AppCompatActivity {

    private final String TAG = Kenya.class.getSimpleName();
    LinearLayoutCompat adContainer;
    ListView listView;
    String mTitle[] = {"Palmcredit-Personal loan,Fast Cash,Instant loan","sokoloan-Fast Loan,Quick Online Cash in Nigeria","Aella App","QuickCheck-Instant Cash Money Loan App"
    ,"Carbon","FairMoney:Instant loan app,bill payment and more","Branch-Personal Finance Loans"};


    String mDescription[] = {"First loan and instant cash in nigeria","Get instant loan from soko","Quick and easy money solution","Quick loans app in Nigeria"
    ,"Get instant loans and make payments","Instant loan app where you can also pay bills","Financial Access,Anytime,anywhere"};


    int images[]={R.drawable.palm,R.drawable.soko,R.drawable.aella,R.drawable.quick,R.drawable.carbon,R.drawable.fairmoney,R.drawable.branch};

    ProgressBar pr;
    private AdView adView;
    private InterstitialAd interstitialAd;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nigeria);
        listView = findViewById(R.id.listview);
        pr = findViewById(R.id.pr);
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
        final Nigeria.MyAdapter adapter = new Nigeria.MyAdapter(this,mTitle,mDescription,images);

            new CountDownTimer(3000, 1000) { // 60 seconds, in 1 second intervals
                public void onTick(long millisUntilFinished) {
                    pr.setVisibility(View.VISIBLE);
                }

                public void onFinish() {
                    pr.setVisibility(View.GONE);
                    listView.setAdapter(adapter);
                }
            }.start();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    i = 1;

                        Intent intent = new Intent(Nigeria.this, PalmCredit.class);
                        startActivity(intent);
                        finish();

                }
                if (position == 1){
                    i = 2;

                        Intent intent = new Intent(Nigeria.this, Sokoloan.class);
                        startActivity(intent);
                        finish();

                }
                if (position == 2){
                    i = 3;

                        Intent intent = new Intent(Nigeria.this, Aella.class);
                        startActivity(intent);
                        finish();

                }
                if (position == 3){
                    i = 4;

                        Intent intent = new Intent(Nigeria.this, Quickcheck.class);
                        startActivity(intent);
                        finish();

                }
                if (position == 4){
                    i = 5;

                        Intent intent = new Intent(Nigeria.this, Carbon.class);
                        intent.putExtra("TT",Integer.toString(4));
                        startActivity(intent);
                        finish();

                }
                if (position == 5){
                    i = 6;

                        Intent intent = new Intent(Nigeria.this, Fairmoney.class);
                        startActivity(intent);
                        finish();

                }
                if (position == 6){
                    i = 7;

                        Intent intent = new Intent(Nigeria.this, Branch.class);
                        intent.putExtra("TT",Integer.toString(2));
                        startActivity(intent);
                        finish();

                }
            }
        });
    }
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c, String title[],String description[],int imgs[]){
            super(c,R.layout.row,R.id.textView1,title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row,parent,false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription  =row.findViewById(R.id.textView2);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }

@Override
public void onBackPressed() {
        i = 57;
    if (interstitialAd.isLoaded()){
        interstitialAd.show();
    }else {
        Intent intent = new Intent(Nigeria.this,LandingPage.class);
        startActivity(intent);
        finish();
    }
}
}
