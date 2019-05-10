package org.kasapbasi.weeek14201901;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class MyView extends View {
    /**
     * Simple constructor to use when creating a view from code.
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     */
    private Paint paint = new Paint();
    private Path path = new Path();

    Context c;
    GestureDetector gestureDetector;

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        // event when double tap occurs
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            float x = e.getX();
            float y = e.getY();

            // clean drawing area on double tap
            path.reset();
            Log.d("Double Tap", "Tapped at: (" + x + "," + y + ")");

            return true;
        }

    }





    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.c=context;

        gestureDetector = new GestureDetector(c,new GestureListener() );

        paint.setAntiAlias(true);
        paint.setStrokeWidth(6f);
        paint.setColor(Color.BLACK);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint);
        canvas.drawCircle(eventX,eventY,50,paint);

    }

    /**
     * Pass the touch screen motion event down to the target view, or this
     * view if it is the target.
     *
     * @param event The motion event to be dispatched.
     * @return True if the event was handled by the view, false otherwise.
     */
    float eventX;
    float eventY;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
         eventX = event.getX();
         eventY = event.getY();


        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX, eventY);
               // path.addCircle(eventX, eventY, 50, Path.Direction.CW);
                return true;
            case MotionEvent.ACTION_MOVE:

                path.lineTo(eventX, eventY);

                break;
            case MotionEvent.ACTION_UP:

                break;
            default:
                return false;



             }

        gestureDetector.onTouchEvent(event);
        invalidate();
        return true;


    }
}
