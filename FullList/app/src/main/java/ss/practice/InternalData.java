package ss.practice;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by TOSHIBA on 13-09-2017.
 */
public class InternalData extends Activity implements View.OnClickListener {

    EditText sharedData;
    TextView dataresult;
    SharedPreferences somedata;

    FileOutputStream fos;
    String FILE="internal String";
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
        try {
            fos=openFileOutput(FILE, Context.MODE_PRIVATE);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sfsave:
                String data= sharedData.getText().toString();
                //saving data via file
                /*File f=new File(FILE);
                try {
                    fos=new FileOutputStream(f);
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } */
                fos=openFileOutput(FILE,Context.MODE_PRIVATE);
                fos.q
                SharedPreferences.Editor editor= somedata.edit();  //allows to edit string
                editor.putString("sharedstrng",strdata);  //and put this string
                editor.commit();  //saves
                break;
            case R.id.sfload:
                somedata =getSharedPreferences( FILE,0);
                String datareturned=somedata.getString("sharedstring","Couldn't loadfirst parameter");
                dataresult.setText(datareturned);

                break;
        }
    }
}
