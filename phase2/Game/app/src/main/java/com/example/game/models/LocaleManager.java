package com.example.game.models;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import java.util.Locale;

public class LocaleManager {
    private static final String LANGUAGE_KEY = "language_key";
    private static final String ENGLISH = "en";
    private static final String FRENCH = "fr";
    private static final String RUSSIAN = "ru";

    private final SharedPreferences prefs;

    /**
     * Creates a LocaleManager, which saves changed to global ChangedPreferences
     */
    public LocaleManager(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * sets the current language
     */
    public Context setLocale(Context context) {
        return updateResources(context, prefs.getString(LANGUAGE_KEY, ENGLISH));
    }

    /**
     * sets the language to the given language
     */
    public void setNewLocale(Context context, String language) {
        prefs.edit().putString(LANGUAGE_KEY, language).apply();
        updateResources(context, language);
    }

    /**
     * updates the language through baseActivity context
     */
    private Context updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources resources = context.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.setLocale(locale);
        context = context.createConfigurationContext(configuration);
        return context;
    }

    public static String getEnglish(){
        return ENGLISH;
    }

    public static String getFrench(){
        return FRENCH;
    }

    public static String getRussian(){
        return RUSSIAN;
    }
}
