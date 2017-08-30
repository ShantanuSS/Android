package ss.practice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by TOSHIBA on 26-08-2017.
 */
    public class Data extends Activity implements View.OnClickListener {
    Button start,startFor;
    EditText sendET;
    TextView gotAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get);
        initialize();
    }

    private void initialize() {
    start=(Button)findViewById(R.id.bSA);
    startFor=(Button)findViewById(R.id.bSAFR);
        sendET=(EditText) findViewById(R.id.etSend);
        gotAnswer=(TextView)findViewById(R.id.tvGot);
        start.setOnClickListener(this);
        startFor.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    switch(v.getId()){
        case R.id.bSA:
        String  bread=sendET.getText().toString();
            Bundle basket=new Bundle();  //to send data in bundle
            basket.putString("key",bread);  //putting string inj bundle ;key is file name and value  is bread
            Intent a=new Intent(Data.this,OpenedClass.class); //cntext of this class is data and class name we want to open is OpenedClass
            a.putExtras(basket);  //putExtras take bundle only ;this is basically adding to intent
            startActivity(a);
            break;
        case R.id.bSAFR:
            Intent i=new Intent(Data.this,OpenedClass.class);
            startActivityForResult(i,0);//existing method;0 is default value;
            break;
    }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  //Right click -->generate-->Override Methods
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK) //resultcode is passed from OpenedClass by setResult(RESULT_OK,xyz) methood
        {
            Bundle basket=data.getExtras();
            String s=basket.getString("answer");
            gotAnswer.setText(s);
        }
    }
}
