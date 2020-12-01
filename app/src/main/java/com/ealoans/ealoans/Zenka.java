package com.ealoans.ealoans;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;


import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;

public class Zenka extends AppCompatActivity {


    ListView list;
    String[] itemname = {};


    TextView textView;
    String content = "<h1>Fast Cash Loans</h1>\n" +
            "<p>Zenka is the most flexible personal loan platform on the market, giving Kenyans more control over their finances with its unique features.</p>"+
            "        <p><b>Eligibility</b>\n" +
            "        \n" +
            "        <P><li> Mpesa registered line</li> \n" +

            "<li>Register a personal account in the app.\n Upon successful registration,choose your loan amount and loan terms\n</li> " +

            "<li>Transaction fee: zero</li> " +
            "      \n" +
            "        <p><b>Other fees</b>\n" +
            "        \n" +
            "<li> 61-day loan payment terms have a one-time processing fee of 9-30%</li> " +
            "<li>No registration fees\n" +
            "<li>Grow with Zenka and build your limit up to KSh 30,000 by making your loan repayments on time</li> " ;

    AdView mAdview;
    private InterstitialAd interstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_details);


        getSupportActionBar().setTitle("Zeenka Loan App");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


       // mAdview = findViewById(R.id.adView);
        final String  appId= "com.zenkafinance.microloans";

        findViewById(R.id.download).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse("market://details?id=" + appId);
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id="
                                    + appId)));
                }

            }
        });


 /*        messageAdapter adapter = new messageAdapter(this, itemname);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
*/
        // init TextView
        textView = (TextView) findViewById(R.id.simpleTextView);
        textView.setMovementMethod(new ScrollingMovementMethod());
        // set Text in TextView using fromHtml() method with version check
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(content, Html.FROM_HTML_MODE_LEGACY));
        } else
            textView.setText(Html.fromHtml(content));

    }

    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();

        return true;
    }
}