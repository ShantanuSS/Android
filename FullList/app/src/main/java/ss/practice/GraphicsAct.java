package ss.practice;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;

/**
 * Created by TOSHIBA on 03-09-2017.
 */
public class GraphicsAct extends Activity {
    MyDream ourview;
    PowerManager.WakeLock wl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //here we create wake-lock
        PowerManager pm=(PowerManager)getSystemService(Context.POWER_SERVICE);
        wl=pm.newWakeLock(PowerManager.FULL_WAKE_LOCK,"whatever");

        super.onCreate(savedInstanceState);
        wl.acquire();
        ourview=new MyDream(this);
        setContentView(ourview);
    }

    @Override
    protected void onPause() {
        super.onPause();
        wl.release();
    }
}
