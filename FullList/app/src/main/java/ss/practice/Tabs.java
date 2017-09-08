package ss.practice;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by TOSHIBA on 08-09-2017.
 */
public class Tabs extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);
        TabHost th=(TabHost)findViewById(R.id.tabHost);
        th.setup();//makes initialization to go on
        TabHost.TabSpec specs=th.newTabSpec("tag1");//gives string reference or name of tag,we don't know much abt this(maybe for future use)
        specs.setContent(R.id.tab1);   //for linear layout that holds 2 button and a textview
        specs.setIndicator("Stopwatch"); //tab's name(appears on tab)
        th.addTab(specs);
        specs=th.newTabSpec("tag2");//2nd tag
        specs.setContent(R.id.tab2);   //for linear layout2
        specs.setIndicator("Tab 2");
        th.addTab(specs);
        specs=th.newTabSpec("tag3");//2nd tag
        specs.setContent(R.id.tab3);   //for linear layout2
        specs.setIndicator("Add a Tab");
        th.addTab(specs);
    }

}
