package com.example.game.models;

import com.example.game.R;

import java.io.Serializable;

public class Customization implements Serializable {
    private enum Language {
        ENGLISH ("en"),
        FRENCH ("fr"),
        RUSSIAN ("ru");

        private final String language;

        Language(String language){
            this.language = language;
        }

        public String getLanguage(){
            return this.language;
        }
    }

    private enum Colour {
        GREY (R.color.background2),
        RED (R.color.background1);

        private final int colour;

        Colour(int colour) {
            this.colour = colour;
        }

        public int getColour(){
            return this.colour;
        }
    }

    private enum Icon {
        MALE (R.drawable.user_male),
        FEMALE (R.drawable.user_female),
        ROBOT (R.drawable.robot);

        private final int icon;

        Icon(int icon) {
            this.icon = icon;
        }

        public int getIcon(){
            return this.icon;
        }
    }

    private Language currentLanguage;
    private Colour currentColour;
    private Icon currentIcon;

    public Customization() {
        this.currentLanguage = Language.ENGLISH;
        this.currentColour = Colour.GREY;
        this.currentIcon = Icon.ROBOT;
    }

    public String getCurrentLanguage() {
        return currentLanguage.language;
    }

    public void setCurrentLanguage(String currentLanguage) {
        for(Language l: Language.values())
            if(l.toString().equals(currentLanguage.toUpperCase())) {
                this.currentLanguage = l;
            }
    }

    public int getCurrentColour() {
        return currentColour.colour;
    }

    public void setCurrentColour(String currentColour) {
        for(Colour c: Colour.values())
            if(c.toString().equals(currentColour.toUpperCase())) {
                this.currentColour = c;
            }
    }

    public int getCurrentIcon() {
        return currentIcon.icon;
    }

    public void setCurrentIcon(String currentIcon) {
        for(Icon i: Icon.values())
            if(i.toString().equals(currentIcon.toUpperCase())) {
                this.currentIcon = i;
            }
    }
}
