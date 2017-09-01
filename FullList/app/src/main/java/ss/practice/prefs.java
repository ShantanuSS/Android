package ss.practice;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by TOSHIBA on 31-08-2017.
 */
public class Prefs extends PreferenceActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
    }
}
