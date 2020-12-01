package com.ealoans.ealoans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ealoans.ealoans.makemoney.MainActivity;

public class OptionsActivity extends AppCompatActivity {
    TextView loans,earnings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        loans = findViewById(R.id.loans);
        earnings = findViewById(R.id.earnings);


        loans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OptionsActivity.this,LandingPage.class);
                startActivity(intent);
                finish();
            }
        });
        earnings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OptionsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
