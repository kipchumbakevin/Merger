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

public class Paysense extends AppCompatActivity {

    ListView list;
    String[] itemname = {};


    TextView textView;
    String content = "<h1>Fast Cash Loans</h1>\n" +
            "<p> PaySense is a personal loan app which offers instant personal loans upto ₹5 lakhs at attractive interest rates, zero collateral & flexible EMI.</p>"+
            "        <p><b>Eligibility</b>\n" +
            "        \n" +
            "        <P><li> Salary should be more than ₹20,000 (Net monthly take home) for Mumbai & Delhi based users.</li>\n " +

            "<li>Between 21 to 60 years.\nA resident of India\n</li> " +

            "<li>Salary should be more than ₹18,000 (Net monthly take home) for Other Locations.\n</li> " +
            "      \n" +
            "        <p><b>Other fees</b>\n" +
            "        \n" +
            "<li>The standard processing fee is 2% of the loan amount.</li> " +
            "<li> Annual Percentage Rate (APR) on loans between 16% to 36% (on a reducing balance basis).";

    AdView mAdview;
    private InterstitialAd interstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_details);


        getSupportActionBar().setTitle("PaySense Loan App");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        // mAdview = findViewById(R.id.adView);
        final String  appId= "com.gopaysense.android.boost";

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
