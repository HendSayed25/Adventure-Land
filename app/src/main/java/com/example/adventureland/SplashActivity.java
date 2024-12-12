package com.example.adventureland;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "AdventureLandPrefs";
    private static final String KEY_FIRST_TIME = "isFirstTime";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Delay for 2 seconds to show the splash screen
        new Handler().postDelayed(() -> {
            // Check if it's the first time the user is opening the app
            SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
            boolean isFirstTime = prefs.getBoolean(KEY_FIRST_TIME, true);

            if (isFirstTime) {
                // Navigate to OnboardingActivity
                Intent intent = new Intent(SplashActivity.this, OnboardingActivity.class);
                startActivity(intent);

                // Update the flag in SharedPreferences
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(KEY_FIRST_TIME, false);
                editor.apply();
            } else {
                // Navigate to PreOnboardingActivity
                Intent intent = new Intent(SplashActivity.this, PreOnboardingActivity.class);
                startActivity(intent);
            }

            finish(); // Close SplashScreenActivity
        }, 2000); // 2000ms delay
    }
}
