package ss.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

/**
 * Created by TOSHIBA on 03-09-2017.
 */
public class MyDream extends View {

    float changer;
    Bitmap sscene;
    public MyDream(Context context) {
        super(context);
        sscene= BitmapFactory.decodeResource(getResources(),R.drawable.myscene);
        changer=0;
    }

    @Override
    protected void onDraw(Canvas canvas) {  //creating some background color
        super.onDraw(canvas);
        canvas.drawColor(Color.RED);
        canvas.drawBitmap(sscene,(canvas.getWidth()/2),changer,null);
        if(changer <canvas.getHeight())
            changer+=10;
        else
            changer=0;
        //Rect middleRect=new Rect();
        //midd
        invalidate();

    }
}
