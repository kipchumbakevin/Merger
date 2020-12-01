package com.ealoans.ealoans;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.ads.*;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;

public class Kenya extends AppCompatActivity {

    private AdView adView;
    private InterstitialAd interstitialAd;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kenya);
        listView = findViewById(R.id.listview);
        pr  = findViewById(R.id.pr);

        AudienceNetworkAds.initialize(this);
        adView = new AdView(this,getString(R.string.banner), AdSize.BANNER_HEIGHT_50);
        adContainer = findViewById(R.id.banner_container);
        interstitialAd = new InterstitialAd(this,getString(R.string.interstitial));
        //607402693307934_607763939938476
        interstitialAd.loadAd();
        adView.loadAd();
        adContainer.addView(adView);
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
                    Intent intent = new Intent(Kenya.this,Tala.class);
                    startActivity(intent);
                    finish();

                }
                if (position == 1){
                    Intent intent = new Intent(Kenya.this,Zenka.class);
                    startActivity(intent);
                    finish();
                }
                if (position == 2){
                    Intent intent = new Intent(Kenya.this,Opesa.class);
                    startActivity(intent);
                    finish();
                }
                if (position == 3){
                    Intent intent = new Intent(Kenya.this,Timiza.class);
                    startActivity(intent);
                    finish();
                }
                if (position == 4){
                    Intent intent = new Intent(Kenya.this,Ipesa.class);
                    startActivity(intent);
                    finish();
                }
                if (position == 5){
                    Intent intent = new Intent(Kenya.this,Carbon.class);
                    startActivity(intent);
                    finish();
                }
                if (position == 6){
                    Intent intent = new Intent(Kenya.this,KCB.class);
                    startActivity(intent);
                    finish();
                }
                if (position == 7){
                    Intent intent = new Intent(Kenya.this,Stawika.class);
                    startActivity(intent);
                    finish();
                }
                if (position == 8) {
                    Intent intent = new Intent(Kenya.this, Branch.class);
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
    protected void onDestroy() {
        if (adView != null){
            adView.destroy();
        }
        if (interstitialAd != null){
            interstitialAd.destroy();
        }
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(Kenya.this,LandingPage.class);
        startActivity(intent);
        finish();
        if (interstitialAd.isAdLoaded()){
            interstitialAd.show();
        }

    }
}
