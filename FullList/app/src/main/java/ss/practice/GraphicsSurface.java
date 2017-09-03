package ss.practice;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
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
}
