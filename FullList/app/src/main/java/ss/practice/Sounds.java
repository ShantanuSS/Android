package ss.practice;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

/**
 * Created by TOSHIBA on 05-09-2017.
 */
public class Sounds extends Activity implements View.OnClickListener,View.OnLongClickListener {

    SoundPool sp;
    int explosion=0;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v=new View(this);
        v.setOnClickListener(this);
        v.setOnLongClickListener(this);  //plays sound when we hold the cursor on screen for more than 1 sec
        setContentView(v);
            sp=new SoundPool(5, AudioManager.STREAM_MUSIC,0);//parameters states no.of max sounds at one time,way we want to stream audio,sample rate(currently mo effect)
            explosion=sp.load(this,R.raw.explosion,1);
        mp=MediaPlayer.create(this,R.raw.ktone);
    }

    @Override
    public void onClick(View v) {
        if(explosion!=0)
        sp.play(explosion,1,1,0,0,1);

    }

    @Override
    public boolean onLongClick(View v) {
        mp.start();
        return false;
    }
}
