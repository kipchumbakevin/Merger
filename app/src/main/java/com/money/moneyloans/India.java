package com.money.moneyloans;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

public class India extends AppCompatActivity {
    private final String TAG = Kenya.class.getSimpleName();
    ProgressBar pr;
    private AdView adView;
    private InterstitialAd interstitialAd;
    int i = 0;

    ListView listView;
    String mTitle[] = {"Instant Personal Loan App-PaySense","Dhani:Instant Personal Loan,Credit Line & Wallet","Loan Instant Personal Loan Online $ Credit Cards","Instant Personal Loan App Online Loan-KreditBee",
    "Loan App for Instant Personal Loan Online-NIRA","Personal Loan App Get Instant Money & Quick Loans","Instant Personal Loan App,Cash Loan-FlexSalary","IDFC FIRST Loans"};


    String mDescription[] = {"Best instant loan app in India","One stop app for instant personal loans","Loan,fast & quick personal loan online","Instant personal loan",
    "Personal loan app for loans","Personal loans,quick cash,instant credit","Instant cash loan app","Check your loan details & pay your EMI"};


    int images[]={R.drawable.paysense,R.drawable.dhani,R.drawable.n,R.drawable.kredit,R.drawable.nira,R.drawable.rebase,R.drawable.flex,R.drawable.last};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india);
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
        final India.MyAdapter adapter = new India.MyAdapter(this,mTitle,mDescription,images);

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

                        Intent intent = new Intent(India.this, Paysense.class);
                        startActivity(intent);
                        finish();

                }
                if (position == 1){
                    i = 2;

                        Intent intent = new Intent(India.this, Dhani.class);
                        startActivity(intent);
                        finish();

                }
                if (position == 2){
                    i = 3;

                        Intent intent = new Intent(India.this, Loaninstant.class);
                        startActivity(intent);
                        finish();

                }
                if (position == 3){
                    i = 4;

                        Intent intent = new Intent(India.this, KreditBee.class);
                        startActivity(intent);
                        finish();

                }
                if (position == 4){
                    i = 5;

                        Intent intent = new Intent(India.this, Nira.class);
                        startActivity(intent);
                        finish();

                }
                if (position == 5){
                    i = 6;

                        Intent intent = new Intent(India.this, Personal.class);
                        startActivity(intent);
                        finish();

                }
                if (position == 6){
                    i = 7;

                        Intent intent = new Intent(India.this, FlexSalary.class);
                        startActivity(intent);
                        finish();

                }
                if (position == 7){
                    i = 8;

                        Intent intent = new Intent(India.this, IOFC.class);
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
            Intent intent = new Intent(India.this, LandingPage.class);
            startActivity(intent);
            finish();
        }

}
}
