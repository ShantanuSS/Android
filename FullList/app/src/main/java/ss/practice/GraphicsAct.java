package ss.practice;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by TOSHIBA on 03-09-2017.
 */
public class GraphicsAct extends Activity {
    MyDream ourview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ourview=new MyDream(this);
        setContentView(ourview);
    }
}
