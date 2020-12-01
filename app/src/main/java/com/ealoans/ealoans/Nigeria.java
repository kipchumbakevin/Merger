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

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;

public class Nigeria extends AppCompatActivity {

    private AdView adView;
    private InterstitialAd interstitialAd;
    private final String TAG = Kenya.class.getSimpleName();
    LinearLayoutCompat adContainer;
    ListView listView;
    String mTitle[] = {"Palmcredit-Personal loan,Fast Cash,Instant loan","sokoloan-Fast Loan,Quick Online Cash in Nigeria","Aella App","QuickCheck-Instant Cash Money Loan App"
    ,"Carbon","FairMoney:Instant loan app,bill payment and more","Branch-Personal Finance Loans"};


    String mDescription[] = {"First loan and instant cash in nigeria","Get instant loan from soko","Quick and easy money solution","Quick loans app in Nigeria"
    ,"Get instant loans and make payments","Instant loan app where you can also pay bills","Financial Access,Anytime,anywhere"};


    int images[]={R.drawable.palm,R.drawable.soko,R.drawable.aella,R.drawable.quick,R.drawable.carbon,R.drawable.fairmoney,R.drawable.branch};

    ProgressBar pr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nigeria);
        listView = findViewById(R.id.listview);
        pr = findViewById(R.id.pr);
        AudienceNetworkAds.initialize(this);
        //AdSettings.setIntegrationErrorMode(AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE);
        adView = new AdView(this,"607402693307934_607717893276414", AdSize.BANNER_HEIGHT_50);
        adContainer = findViewById(R.id.banner_container);
        interstitialAd = new InterstitialAd(this,"607402693307934_607763939938476");
        interstitialAd.loadAd();
        adView.loadAd();
        adContainer.addView(adView);
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
                    Intent intent = new Intent(Nigeria.this,PalmCredit.class);
                    startActivity(intent);
                    finish();
                }
                if (position == 1){
                    Intent intent = new Intent(Nigeria.this,Sokoloan.class);
                    startActivity(intent);
                    finish();
                }
                if (position == 2){
                    Intent intent = new Intent(Nigeria.this,Aella.class);
                    startActivity(intent);
                    finish();
                }
                if (position == 3){
                    Intent intent = new Intent(Nigeria.this,Quickcheck.class);
                    startActivity(intent);
                    finish();
                }
                if (position == 4){
                    Intent intent = new Intent(Nigeria.this,Carbon.class);
                    startActivity(intent);
                    finish();
                }
                if (position == 5){
                    Intent intent = new Intent(Nigeria.this,Fairmoney.class);
                    startActivity(intent);
                    finish();
                }
                if (position == 6){
                    Intent intent = new Intent(Nigeria.this,Branch.class);
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
    Intent intent = new Intent(Nigeria.this,LandingPage.class);
    startActivity(intent);
    finish();
    if (interstitialAd.isAdLoaded()){
        interstitialAd.show();
    }


}
}
