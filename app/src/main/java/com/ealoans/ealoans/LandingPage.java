package com.ealoans.ealoans;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.facebook.ads.AdView;


public class LandingPage extends AppCompatActivity {
    TextView kenya,nigeria,india;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        kenya = findViewById(R.id.kenya);
        nigeria = findViewById(R.id.nigeria);
        india = findViewById(R.id.india);




        kenya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LandingPage.this,Kenya.class);
                startActivity(intent);
                finish();
                            }
        });
        india.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LandingPage.this,India.class);
                startActivity(intent);
                finish();

            }
        });
        nigeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LandingPage.this,Nigeria.class);
                startActivity(intent);
                finish();


            }
        });
    }

}
