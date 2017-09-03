package ss.practice;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by TOSHIBA on 03-09-2017.
 */
public class GraphicsSurface extends Activity implements View.OnTouchListener {

    MyDreamSurface ourSurfaceView;
    float x,y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ourSurfaceView=new MyDreamSurface(this);
        ourSurfaceView.setOnTouchListener(this);
        x=0;y=0;
        setContentView(ourSurfaceView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ourSurfaceView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ourSurfaceView.resume();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x=event.getX();
        y=event.getY();
        return false;
    }
    public class MyDreamSurface extends SurfaceView implements Runnable{
        SurfaceHolder ourHolder; //Holder tells whether surface is valid or not,if valid then we can paint
        //it also helps to lock the canvas so no other thread can  draw without permission
        Thread t=null;
        boolean isrunning=false;
        public MyDreamSurface(Context context) {
            super(context);
            ourHolder=getHolder();
        }

        public void pause(){
            isrunning=false;
            while(true){
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            t=null;
        }
        public void resume(){
            isrunning=true;
            t=new Thread(this);
            t.start();
        }
        @Override
        public void run() {
            while (isrunning)
            {
                if(!ourHolder.getSurface().isValid()) //if surface is not valid
                    continue;
                Canvas canvas=ourHolder.lockCanvas();//now no other process(activity or thread) can acces this canvas
                canvas.drawRGB(02,07,150);
                if(x!=0&&y!=0){
                    Bitmap test= BitmapFactory.decodeResource(getResources(),R.drawable.myscene);
                    canvas.drawBitmap(test,x,y,null);
                }
                ourHolder.unlockCanvasAndPost(canvas);//it unlocks the canvas and posts it
            }
        }
    }

}
