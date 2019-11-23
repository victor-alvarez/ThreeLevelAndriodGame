package com.example.game;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    /**
     * Creates a LocaleManager to change language on all activities
     */
    public static LocaleManager localeManager;

    /**
     * Ensures locale is attached to configuration of context
     */
    @Override
    protected void attachBaseContext(Context base) {
        localeManager = new LocaleManager(base);
        super.attachBaseContext(localeManager.setLocale(base));
    }

    /**
     * Called when activity loads
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Called when activity is resumed
     */
    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * Ensures configurations are updated
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        localeManager.setLocale(this);
    }
}
