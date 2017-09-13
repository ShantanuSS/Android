package ss.practice;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by TOSHIBA on 13-09-2017.
 */
public class Sharedpref extends Activity implements View.OnClickListener {
    EditText sharedData;
    TextView dataresult;
    SharedPreferences somedata;
    public static String file="SharedString";  //this won't change

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedpreferences);
        setupVar();
    }

    private void setupVar() {
        Button save=(Button)findViewById(R.id.sfsave);
        Button load=(Button)findViewById(R.id.sfload);
        sharedData=(EditText)findViewById(R.id.etsharedpref);
        dataresult=(TextView)findViewById(R.id.tvloaddata);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
        somedata=getSharedPreferences(file,0);  //it will retrieve and hold the contents;basically a key values system
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sfsave:
                String strdata= sharedData.getText().toString();
                //purpose of SharedPreferences is it allows to save string,boolean,etc values
                SharedPreferences.Editor editor= somedata.edit();  //allows to edit string
                editor.putString("sharedstrng",strdata);  //and put this string
                editor.commit();  //saves
                break;
            case R.id.sfload:
                somedata =getSharedPreferences( file,0);
                String datareturned=somedata.getString("sharedstring","Couldn't loadfirst parameter");
                dataresult.setText(datareturned);

                break;
        }
    }
}
