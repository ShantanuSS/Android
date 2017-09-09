package ss.practice;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by TOSHIBA on 08-09-2017.
 */
public class Tabs extends Activity implements View.OnClickListener{
    TabHost th;
    TextView showans;
    long starts,stops;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);
        th=(TabHost)findViewById(R.id.tabHost);
        Button newTab=(Button)findViewById(R.id.buttonadd);
        Button bStart=(Button)findViewById(R.id.startwatch);
        Button bStop=(Button)findViewById(R.id.stopwatch);
        showans=(TextView)findViewById(R.id.tvShowResults);
        newTab.setOnClickListener(this);
        bStart.setOnClickListener(this);
        bStop.setOnClickListener(this);

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
        starts=0; //as Stopwatch needs starting time equal to 0
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonadd:        //this case addds new tab when button is clicked
                TabHost.TabSpec ourspec=th.newTabSpec("tag1");
                ourspec.setContent(new TabHost.TabContentFactory(){ //this allows to build own liitle content

                    @Override
                    public View createTabContent(String tag) {
                        TextView text=new TextView(Tabs.this);
                        text.setText("Created a New Tab");
                    return (text);
                    }
                });
                ourspec.setIndicator("New");
                th.addTab(ourspec);
                break;
            case R.id.startwatch:
            starts= System.currentTimeMillis(); //System gives time in milisecond
                break;

            case R.id.stopwatch:
            stops=System.currentTimeMillis();
                if(starts!=0){
                    long result=stops-starts;
                    int milis=(int)result;
                    int secs=(int)result/1000;
                    int mins=secs/60;
                    milis=milis%100;
                    secs=secs%60;

                    //showans.setText(Long.toString(result));
                    showans.setText(String.format("%d:%02d:%02d",mins,secs,milis));
                }
                break;

        }
    }
}
