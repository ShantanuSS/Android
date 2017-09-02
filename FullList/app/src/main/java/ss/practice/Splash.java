package ss.practice;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;

/**
 * Created by TOSHIBA on 10-08-2017.
 */
public class Splash extends Activity {
MediaPlayer ourSong;
    @Override
    protected void onCreate(Bundle AnythingCanBeHere) {
        super.onCreate(AnythingCanBeHere);
    setContentView(R.layout.splash);
        ourSong=MediaPlayer.create(Splash.this,R.raw.ktone);  //below setcontentview (good habit)
        SharedPreferences getPrefs= PreferenceManager.getDefaultSharedPreferences(getBaseContext());  //helps to egt info from preference
        boolean music =getPrefs.getBoolean("checkbox",true);// which we mentioned in prefs.xml
        if (music==true)  //if checkbox is tick then only we will play the song
        ourSong.start();

        Thread timer=new Thread()  //it looks for run method
        {
            public void run(){
                try{
                    sleep(1000);  //1000 ms or 5sec
                }catch (InterruptedException e){
                    e.printStackTrace();  //for debbugging
                }
                finally{
                    //can be written in try but here to show implementation o0f try catch finally we used here
                   //Intent is like variable ;it  is used for startActivity()
                    Intent openStartingPoint=new Intent("ss.practice.MENU");
                    startActivity(openStartingPoint);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ourSong.release();
        finish();  //finishes splash activity
    }
}