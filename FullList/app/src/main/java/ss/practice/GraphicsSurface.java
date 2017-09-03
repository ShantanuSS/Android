package ss.practice;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by TOSHIBA on 03-09-2017.
 */
public class GraphicsSurface extends Activity {

    MyDreamSurface ourSurfaceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ourSurfaceView=new MyDreamSurface(this);
        setContentView(ourSurfaceView);


    }
}
