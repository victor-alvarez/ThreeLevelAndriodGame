package com.example.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class LocaleManager {
    public static final String ENGLISH = "en";
    public static final String FRENCH = "fr";
    public static final String RUSSIAN = "ru";
    public static final String SPANISH = "es";
    public static final String LANGUAGE_KEY = "language_key";

    private final SharedPreferences prefs;

    public LocaleManager(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }
}
