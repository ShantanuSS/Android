package ss.practice;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
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
                try {
                    fos=openFileOutput(FILE,Context.MODE_PRIVATE);
                    fos.write(data.getBytes());
                    fos.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.sfload:
                new loader().execute(FILE);
                break;
        }
    }
    public class loader extends AsyncTask<String,Integer,String>{ //parameters states- what we passing in,what progess is,what we are returning
        ProgressDialog dialog;
        protected void onPreExecute(){
            //setting up someting
        dialog=new ProgressDialog(InternalData.this); //context of main class
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setMax(100);
            dialog.show();
        }
        @Override
        protected String doInBackground(String... params) {

            String collected=null;
            FileInputStream fis=null;
            for(int i=0;i<20;i++){
                publishProgress(5); //sends 5 to onProgressUpdate func
                try {
                    Thread.sleep(88);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            dialog.dismiss();
            try {
                fis=openFileInput(FILE);
                byte[] dataarr=new byte[fis.available()];// this returns bytes in our input stream
                while (fis.read(dataarr)!=-1){ //once we have read everything
                    collected=new String(dataarr);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    fis.close();
                    return collected;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    protected void onProgressUpdate(Integer...progress){ //Integer...name is integer array
        dialog.incrementProgressBy(progress[0]); //references 5 each time
    }
        protected void onPostExecute(String result){
                dataresult.setText(result);
        }
    }

}
