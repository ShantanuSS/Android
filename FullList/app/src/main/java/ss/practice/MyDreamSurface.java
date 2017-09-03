package ss.practice;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by TOSHIBA on 03-09-2017.
 */
public class MyDreamSurface extends SurfaceView implements Runnable{
    SurfaceHolder ourHolder; //Holder tells whether surface is valid or not,if valid then we can paint
    //it also helps to lock the canvas so no other thread can  draw without permission
    Thread t=null;
    public MyDreamSurface(Context context) {
        super(context);
        ourHolder=getHolder();
        t=new Thread(this);
        t.start();
    }

    @Override
    public void run() {

    }
}
