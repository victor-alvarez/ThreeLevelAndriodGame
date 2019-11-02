package com.example.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import java.util.Locale;

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

    public static Locale getLocale(Resources resources) {
        Configuration configuration = resources.getConfiguration();
        return configuration.getLocales().get(0);
    }

    public Context setLocale(Context context) {
        return updateResources(context, prefs.getString(LANGUAGE_KEY, ENGLISH));
    }

    public Context setNewLocale(Context context, String language) {
        prefs.edit().putString(LANGUAGE_KEY, language).apply();
        return updateResources(context, language);
    }

    private Context updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.setLocale(locale);
        context = context.createConfigurationContext(configuration);
        return context;
    }
}
