package com.example.hackgsu2019;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

@SuppressLint("AppCompatCustomView")
public class PaintPotView extends ImageView implements View.OnTouchListener {
    private int dotSize;

    private final int DEFAULT_DOT_SIZE = 10;

    private final int MAX_DOT_SIZE = 100;

    private final int MIN_DOT_SIZE = 5;

    private int penColor;

    private final int DEFAULT_COLOR = Color.GREEN;

    private Path path;

    private Paint paint;

    private ArrayList<Path> paths;

    private ArrayList<Paint> paints;

    private float x,y, oldx, oldy;

    public int getPenColor() {
        return penColor;
    }

    public void setPenColor(int penColor) {
        this.penColor = penColor;
    }

    private void init() {
        this.dotSize = DEFAULT_DOT_SIZE;
        this.penColor = DEFAULT_COLOR;
        this.paths = new ArrayList<>();
        this.paints = new ArrayList<>();
        this.path = new Path();
        this.addPath();
        x = y = oldx = oldy = (float)0.0;
        this.setOnTouchListener(this);
        Log.d("This has been called.","this has been called"+this.hashCode());
    }

    private void addPath() {
        path = new Path();
        paths.add(path);
        paint = new Paint();
        paint.setColor(penColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dotSize);
        paints.add(paint);
    }

    public int getDotSize() {
        return dotSize;
    }

    public void setDotSize(int dotSize) {
        this.dotSize = dotSize;
    }

    public int getDEFAULT_DOT_SIZE() {
        return DEFAULT_DOT_SIZE;
    }

    public int getMAX_DOT_SIZE() {
        return MAX_DOT_SIZE;
    }

    public int getMIN_DOT_SIZE() {
        return MIN_DOT_SIZE;
    }

    public PaintPotView(Context context) {
        super(context);
        this.init();
        //this.addPath();
    }

    public PaintPotView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.init();
        //this.addPath();
    }

    public PaintPotView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
        //this.addPath();
    }

    public void reset() {
        // need to add stuff to clear the screen and redraw it with the dog pic.
        Log.d("elements","elements"+Integer.toString(this.paths.size()));
        Log.d("elementsdasd","elementssd dasd"+Integer.toString(this.getPenColor()));
        this.init();
        this.invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < paths.size(); i++) {
            canvas.drawPath(paths.get(i), paints.get(i));
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        x = motionEvent.getX();
        y = motionEvent.getY();
        Log.d("Touched:","Touched: (" + x + "," + y + ")");

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                this.addPath();
                this.path.moveTo(x,y);
                break;
            case MotionEvent.ACTION_MOVE:
                this.path.lineTo(x,y);
                break;
            case MotionEvent.ACTION_UP:
//                if (oldx == x && oldy == y) {
//                    this.path.addCircle(x,y,dotSize,Path.Direction.CW);
                break;


        }
        this.invalidate();
        oldx = x;
        oldy = y;

        return true;
    }
}