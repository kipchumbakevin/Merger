package com.ealoans.ealoans;

import androidx.appcompat.app.AppCompatActivity;

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

import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;

public class Stawika extends AppCompatActivity {

    ListView list;
    String[] itemname = {};


    TextView textView;
    String content = "<h1>Fast Cash Loans</h1>\n" +
            "<p>Be among the millions of Kenyans who have benefited directly or indirectly through Stawika Loans by growing their businesses, paying school feels, medical expenses and other personal expenses.</p>"+
            "        <p><b>Eligibility</b>\n" +
            "        \n" +
            "        <P><li>Fill in your details to get verified.</li> \n" +

            "<li>Mpesa registered phone number.\n Upon successful registration,choose your loan amount and loan terms\n</li> " +

            "<li>Get a credit limit</li> " +
            "      \n" +
            "        <p><b>Other fees</b>\n" +
            "        \n" +
            "<li> 60 day loan products have a one-time fee of 10-25%*</li> " +
            "<li>90 day loan products have a one-time fee of 15-35%*";

    AdView mAdview;
    private InterstitialAd interstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_details);


        getSupportActionBar().setTitle("Stawika Loan App");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        // mAdview = findViewById(R.id.adView);
        final String  appId= "com.ke.stawika";

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
