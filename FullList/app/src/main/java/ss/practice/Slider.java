package ss.practice;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SlidingDrawer;

/**
 * Created by TOSHIBA on 05-09-2017.
 */
public class Slider extends Activity implements View.OnClickListener,CompoundButton.OnCheckedChangeListener,SlidingDrawer.OnDrawerOpenListener {

    SlidingDrawer sd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sliding);
        Button handle1=(Button)findViewById(R.id.hand1);
        Button handle2=(Button)findViewById(R.id.hand2);
        Button handle3=(Button)findViewById(R.id.hand3);
        Button handle4=(Button)findViewById(R.id.hand4);
        CheckBox checkBox=(CheckBox)findViewById(R.id.cbSlide);
        checkBox.setOnClickListener(this);
        sd=(SlidingDrawer)findViewById(R.id.slidingDrawer);
        sd.setOnDrawerOpenListener(this);
        handle1.setOnClickListener(this);
        handle2.setOnClickListener(this);
        handle3.setOnClickListener(this);
        handle4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.hand1:
            sd.open();
            break;
        case R.id.hand2:

            break;
        case R.id.hand3:
            sd.toggle();
            break;
        case R.id.hand4:
            sd.close();
            break;

    }
    }


    @Override
    public void onDrawerOpened() {
        MediaPlayer mp=MediaPlayer.create(this,R.raw.explosion);
        mp.start();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(buttonView.isChecked()){
                sd.lock();   //it locks handle and make slider to not work
            }
            else{
                sd.unlock();
            }

}
}