package ss.practice;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by TOSHIBA on 18-09-2017.
 */
public class SqlView extends Activity{

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.sqlview);
    }
}
