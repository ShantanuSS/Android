package ss.practice;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

/**
 * Created by TOSHIBA on 12-08-2017.
 */
public class TextPlay extends Activity implements View.OnClickListener {  //everytime we setup a new activity we have to define it in manifest
    Button chkCmd;
     ToggleButton passTog; EditText input;  //no need to declare final here
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text); //setting referencing to text.xml
        myfuncname();  //creating and calling method

        /*chkCmd=(Button) findViewById(R.id.bResults);
         passTog=(ToggleButton)findViewById(R.id.tbPassword); //automatically converted to final as we wrote .isChecked in onClick()
        input=(EditText) findViewById(R.id.etCommands);
         display=(TextView)findViewById(R.id.tvResults);              we can use it here or in below func. */
        //working with toggle now
        passTog.setOnClickListener(this);
    //working with button now
        chkCmd.setOnClickListener(this);
    }

    private void myfuncname() {

        chkCmd=(Button) findViewById(R.id.bResults);
        passTog=(ToggleButton)findViewById(R.id.tbPassword);
        input=(EditText) findViewById(R.id.etCommands);
        display=(TextView)findViewById(R.id.tvResults);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bResults:
                String check=input.getText().toString(); //obtains EditText & converts into string
                display.setText(check); //displays
                if(check.contentEquals("left")){
                    display.setGravity(Gravity.LEFT);   //moves textview to left side of screen
                }else if(check.contentEquals("center")){
                    display.setGravity(Gravity.CENTER);
                }
                else if(check.contentEquals("right")){
                    display.setGravity(Gravity.RIGHT);
                }
                else if(check.contentEquals("blue"))
                    display.setTextColor(Color.BLUE);
                else if(check.contentEquals("WTF")){
                    Random aa=new Random();
                    display.setText("aaaaaaa");
                    display.setTextSize(aa.nextInt(75));  //pics random integer from 1 to 75
                    display.setTextColor(Color.rgb(aa.nextInt(255),aa.nextInt(255),aa.nextInt(255))); //random colors
                    switch (aa.nextInt(3)){
                        case 0:
                            display.setGravity(Gravity.LEFT);
                            break;
                        case 1:
                            display.setGravity(Gravity.CENTER);
                            break;
                        case 2:
                            display.setGravity(Gravity.RIGHT);
                            break;
                    }
                }
                else{
                    display.setText("invalid");
                    display.setGravity(Gravity.CENTER);
                    display.setTextColor(Color.RED);
                }
                break;
            case R.id.tbPassword:
                if (passTog.isChecked()) {  //.isChecked() is boolean func  ; if ON
                    input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD); //giving error then  make EditTExt final
                } else {
                    input.setInputType(InputType.TYPE_CLASS_TEXT); //if toggle off show password in plain text

                }
                break;

        }
    }
}
