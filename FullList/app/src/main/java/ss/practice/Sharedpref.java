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
    SharedPreferences somedata
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
        somedata=getSharedPreferences(file,0);  //it will retrieve and hold the contents
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sfsave:
                String strdata= sharedData.getText().toString();
                break;
            case R.id.sfload:

                break;
        }
    }
}
