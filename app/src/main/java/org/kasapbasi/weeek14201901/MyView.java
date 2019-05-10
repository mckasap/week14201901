package org.kasapbasi.weeek14201901;

import android.content.Context;
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
    Context c;

    public MyView(Context context) {
        super(context);
        this.c=context;
    }

    /**
     * Pass the touch screen motion event down to the target view, or this
     * view if it is the target.
     *
     * @param event The motion event to be dispatched.
     * @return True if the event was handled by the view, false otherwise.
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {


        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                Toast.makeText(c,  event.getY() +" Tıklandı " +event.getX(), Toast.LENGTH_SHORT).show();break;


             }



        return  true;
    }
}
