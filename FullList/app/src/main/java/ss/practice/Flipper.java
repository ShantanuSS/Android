package ss.practice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

/**
 * Created by TOSHIBA on 10-09-2017.
 */
public class Flipper extends Activity implements View.OnClickListener
{
    ViewFlipper flip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flipper);
        flip=(ViewFlipper)findViewById(R.id.viewFlipper1);
        flip.setOnClickListener(this);
        flip.setFlipInterval(500); //flips every half of sec ;500 ms
        flip.startFlipping();
    }

    @Override
    public void onClick(View v) {
        flip.showNext();
    }
}
