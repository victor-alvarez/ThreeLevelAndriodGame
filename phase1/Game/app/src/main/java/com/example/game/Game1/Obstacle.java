package com.example.game.Game1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Obstacle implements GameObject{

    private Rect rectangle;
    private int color;

    public Obstacle(int rectHeight, int color, int startX, int startY, int playerGap){
        this.color = color;
        //l,t,r,b
        rectangle = new Rect(startX, startY, startX + 100, startY + rectHeight);
    }

    public Rect getRectangle(){
        return rectangle;
    }

    public void incrementY(float y) {
        rectangle.top += y;
        rectangle.bottom += y;
    }

    public boolean playerCollide(RectPlayer player){
        return Rect.intersects(rectangle, player.getRectangle());
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
