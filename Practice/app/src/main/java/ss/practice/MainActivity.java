package ss.practice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    int counter;
    Button add,sub;
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //connecting this java class to activity_main.xml
        counter=0;
        add=(Button)findViewById(R.id.bAdd);
        sub=(Button)findViewById(R.id.bSub);
        display=(TextView)findViewById(R.id.tvDisplay);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter+=1; //or counter++
                display.setText("your total is"+counter);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter=counter-1;
                display.setText("your total is"+counter);  //something is necessary to be written in " "
            }
        });
    }
}
