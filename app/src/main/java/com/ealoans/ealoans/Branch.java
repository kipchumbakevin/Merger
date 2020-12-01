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

public class Branch extends AppCompatActivity {

    ListView list;
    String[] itemname = {};


    TextView textView;
    String content = "<h1>Fast Cash Loans</h1>\n" +
            "<p>Branch is the simplest and most secure way to borrow, save, and improve your financial health all from the convenience of your phone</p>\n"+
            "        <p><b>Eligibility</b>\n" +
            "        \n" +
            "        <P><li>No paperwork, collateral or office visits needed</li> \n" +

            "<li>Register a personal account in the app.\n Upon successful registration,choose your loan amount and loan terms\n</li> " +

            "<li>Must be 18yrs and above.</li> " +
            "      \n" +
            "        <p><b>Other fees</b>\n" +
            "        \n" +
            "<li> APR: 22% to 240%</li> " +
            "<li>Loan Amounts: Ksh 250 to Ksh 70,000\n" +
            "<li> No late charges or rollover fees on loans</li> " ;

    AdView mAdview;
    private InterstitialAd interstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_details);


        getSupportActionBar().setTitle("Branch Loan App");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        // mAdview = findViewById(R.id.adView);
        final String  appId= "com.branch_international.branch.branch_demo_android";

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
