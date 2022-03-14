package com.example.japaneseapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Drawing extends View {
    float posx=0,posy=0;
    Path path;
    Paint paint;
    public static ArrayList<Path>pathlist;
    public static ArrayList<Paint>paintlist;

    public Drawing(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        pathlist = new ArrayList<>();
        paintlist = new ArrayList<>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int i=0;
        for(Path line:pathlist){
            canvas.drawPath(line,paintlist.get(i++));
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        posx=event.getX();
        posy=event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                paint = new Paint();
                paint.setStrokeWidth(30);
                paint.setColor(Color.WHITE);
                paint.setStyle(Paint.Style.STROKE);
                paintlist.add(paint);
                path = new Path();
                path.moveTo(posx,posy);
                pathlist.add(path);
                break;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                int historicpoints = event.getHistorySize();
                for(int i=0;i<historicpoints;i++){
                    path.lineTo(event.getHistoricalX(i),event.getHistoricalY(i));


                }
        }
        invalidate();
        return true;

    }
}
