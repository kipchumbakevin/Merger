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

public class Aella extends AppCompatActivity {

    ListView list;
    String[] itemname = {};


    TextView textView;
    String content = "<h1>Fast Cash Loans</h1>\n" +
            "<p>At Aella, you get simple and easy access to funds. You need to take a little credit for our hard work sometimes.\n</p>"+
            "        <p><b>Eligibility</b>\n" +
            "        \n" +
            "        <P><li>Must be 18yrs or above.</li>\n " +

            "<li>Register a personal account in the app.\n Upon successful registration,choose your loan amount and loan terms\n</li> " +

            "      \n" +
            "        <p><b>Other fees</b>\n" +
            "        \n" +
            "<li>Aella is designed to help customers build financial independence by building simple products; loans, investments, bill payments, micro-insurance plans, and peer-to-peer money transfers.</li>";

    AdView mAdview;
    private InterstitialAd interstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_details);


        getSupportActionBar().setTitle("Aella Loan App");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        // mAdview = findViewById(R.id.adView);
        final String  appId= "com.aella.comportal";

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

    @Override
    public void onBackPressed() {
    }
}
