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
    float x,y,sx,sy,fx,fy,dx,dy,anix,aniy,scalx,scaly;

    Bitmap test,plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ourSurfaceView=new MyDreamSurface(this);
        ourSurfaceView.setOnTouchListener(this);
        x=0;y=0;
        sx=0;fy=0;fx=0;sy=0;
        dx=dy=anix=aniy=scalx=scaly=0;
        test= BitmapFactory.decodeResource(getResources(),R.drawable.myscene);
        plus= BitmapFactory.decodeResource(getResources(),R.drawable.plus);
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
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        x=event.getX();
        y=event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                sx=event.getX();
                sy=event.getY();
                dx=dy=anix=aniy=scalx=scaly=fx=fy=0;
                break;
            case MotionEvent.ACTION_UP:
                fx=event.getX();
                fy=event.getY();
                dx=fx-sx; //change in x direction
                dy=fy-sy;
                scalx=dx/30; //displacement in x direction
                scaly=dy/30;
                x=y=0;
                break;
        }
        return true;
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
                          canvas.drawBitmap(test,x-(test.getWidth()/2),y-(test.getHeight()/2),null);
                }
                if(sx!=0&&sy!=0){
                    canvas.drawBitmap(plus,sx-(plus.getWidth()/2),sy-(plus.getHeight()/2),null);
                }
                if(fx!=0&&fy!=0){
                    canvas.drawBitmap(test,fx-(test.getWidth()/2)-anix,fy-(test.getHeight()/2)-aniy,null);
                    canvas.drawBitmap(plus,fx-(plus.getWidth()/2),fy-(plus.getHeight()/2),null);
            }
                anix=anix+scalx; //adds displacement everytime when loops
                aniy=aniy+scaly;
                ourHolder.unlockCanvasAndPost(canvas);//it unlocks the canvas and posts it
            }
        }
    }

}
