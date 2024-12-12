package com.example.adventureland;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class PreOnboardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_onboarding);

        // Handle button click
        findViewById(R.id.get_started_button).setOnClickListener(view -> {
            Intent intent = new Intent(PreOnboardingActivity.this, OnboardingActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
