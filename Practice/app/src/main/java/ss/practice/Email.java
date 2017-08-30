package ss.practice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by TOSHIBA on 15-08-2017.
 */
public class Email extends Activity implements View.OnClickListener{

    EditText personsEmail,intro,personsName,things,hatefulAction,outro;
    String emailAdd,beginning,name,sAction,hatefulAct,out;
    Button sendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);
        initializeVars();
        sendEmail.setOnClickListener(this); }

    private void initializeVars() {
    personsEmail=(EditText) findViewById(R.id.etEmails);
        intro=(EditText) findViewById(R.id.etIntro);
       personsName =(EditText) findViewById(R.id.etName);
        things=(EditText) findViewById(R.id.etThings);
        hatefulAction=(EditText) findViewById(R.id.etAction);
        outro=(EditText) findViewById(R.id.etOutro);
        sendEmail=(Button)findViewById(R.id.bSentEmail);
    }

    @Override
    public void onClick(View v) {
        convertEditTextVarsIntoStringsAndYesThisIsAMethodWeCreated();
        String emailaddress[]={emailAdd};
        String message="Well Hello"
                +name
                +"I just want to say"
                +beginning
                +"I see you doing"
                +sAction
                +" that makes me go numb and sometimes crazy, I just want to make"
                +hatefulAct
                +"and yaa one more thing"
                +out
                +"oh I think you got bored"
                +"\n" + "PS. I think you are the best... :D ";
        //this email activity doesn't works on emulator as Email activity action won't pop here,so phone must be connected
        Intent emailIntent =new Intent(Intent.ACTION_SEND);  //helps to open a android phone existing app; we type android.content.Intent.ACTION_SEND
        emailIntent.putExtra(Intent.EXTRA_EMAIL,emailaddress); //,emailaddress used bcoz always string array is used here or doesn't works
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"I will become a very successful software engineer " );
        emailIntent.setType("plain/text");
        emailIntent.putExtra(Intent.EXTRA_TEXT,message);
        startActivity(emailIntent);
    }

    private void convertEditTextVarsIntoStringsAndYesThisIsAMethodWeCreated() {
        emailAdd=personsEmail.getText().toString();
        beginning=intro.getText().toString();
        name=personsName.getText().toString();
        sAction=things.getText().toString();
        hatefulAct=hatefulAction.getText().toString();
        out=outro.getText().toString();
    }
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}
