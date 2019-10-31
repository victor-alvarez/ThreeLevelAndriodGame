package com.example.game.Game1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Platform implements GameObject{
    private Rect rectangle;
    private int color;

    public Platform(Rect rectangle, int color){
        this.rectangle = rectangle;
        this.color = color;
    }

    public Rect getRectangle(){
        return rectangle;
    }

    @Override
    public void draw(Canvas canvas){
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(rectangle, paint);
    }

    @Override
    public void update(){

    }
}
