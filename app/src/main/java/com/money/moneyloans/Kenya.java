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

public class Kenya extends AppCompatActivity {

    private final String TAG = Kenya.class.getSimpleName();
    LinearLayoutCompat adContainer;
    ListView listView;
    String mTitle[] = {"Tala-Instant Loans to Your M-Pesa","Zenka Loan App-Kenya","Opesa-Safe Credit Loans to M-Pesa","Timiza","iPesa-Reliable and Safe Credit Loans to M-Pesa",
    "Carbon","KCB","Stawika","Branch-Personal Finance Loans"};


    String mDescription[] = {"Bringing your instant loans directly to your mpesa","Introducing a quick and easy tool to get a loan","Looking for good credit loans in Kenya?","Convenience and style"
    ,"Reliable loans to mpesa in Kenya","Get instant loans and make payments","Open a world of possibilities",
    "Get affordable loans direct to your mpesa","Financial access.Anytime,anywhere"};


    int images[]={R.drawable.tala,R.drawable.zenka,R.drawable.opesa,R.drawable.timiza,R.drawable.ipesa,R.drawable.carbon,
    R.drawable.kcb,R.drawable.stawika,R.drawable.branch};
    ProgressBar pr;
    int i = 0;
    private AdView adView;
    private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kenya);
        listView = findViewById(R.id.listview);
        pr  = findViewById(R.id.pr);

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
        final MyAdapter adapter = new MyAdapter(this,mTitle,mDescription,images);
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
                    i=1;

                        Intent intent = new Intent(Kenya.this, Tala.class);
                        startActivity(intent);
                        finish();

                }
                if (position == 1){
                    i=2;

                        Intent intent = new Intent(Kenya.this, Zenka.class);
                        startActivity(intent);
                        finish();

                }
                if (position == 2){
                    i=3;

                        Intent intent = new Intent(Kenya.this, Opesa.class);
                        startActivity(intent);
                        finish();

                }
                if (position == 3){
                    i=4;

                        Intent intent = new Intent(Kenya.this, Timiza.class);
                        startActivity(intent);
                        finish();

                }
                if (position == 4){
                    i=5;

                        Intent intent = new Intent(Kenya.this, Ipesa.class);
                        startActivity(intent);
                        finish();

                }
                if (position == 5){
                    i=6;

                        Intent intent = new Intent(Kenya.this, Carbon.class);
                        intent.putExtra("TT",Integer.toString(3));
                        startActivity(intent);
                        finish();

                }
                if (position == 6){
                    i=7;

                        Intent intent = new Intent(Kenya.this, KCB.class);
                        startActivity(intent);
                        finish();

                }
                if (position == 7){
                    i=8;

                        Intent intent = new Intent(Kenya.this, Stawika.class);
                        startActivity(intent);
                        finish();

                }
                if (position == 8) {
                    i=9;

                        Intent intent = new Intent(Kenya.this, Branch.class);
                        intent.putExtra("TT",Integer.toString(1));
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
            Intent intent = new Intent(Kenya.this,LandingPage.class);
            startActivity(intent);
            finish();
        }

    }
}
