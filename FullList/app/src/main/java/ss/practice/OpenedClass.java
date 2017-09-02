package ss.practice;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by TOSHIBA on 26-08-2017.
 */
public class OpenedClass extends Activity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener{
    TextView question,test;
    Button returnData;
    RadioGroup selectionList;
    String gotbread,setData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        initialize();
        //Bundle gotBasket=getIntent().getExtras(); //as Data class is passing Bundle to opened class
        //gotbread=gotBasket.getString("key"); //file naem from data class is "key"
        //question.setText(gotbread);
//commented above 3 bcoz we are using a bundle below now and 2 bundles will give error

        SharedPreferences getData= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String et=getData.getString("name","Shantanu Sharma....."); //for edittext preference
        String values=getData.getString("list","4"); //for list preferencce
        if(values.contentEquals("1")) { //as we can't do values==1
            question.setText(et);

        }
    }

    private void initialize() {
    question=(TextView)findViewById(R.id.tvQuestion);
        test=(TextView)findViewById(R.id.tvText);
        returnData=(Button)findViewById(R.id.bReturn);
        returnData.setOnClickListener(this);
        selectionList=(RadioGroup)findViewById(R.id.rgAnswers);
        selectionList.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {  //for our return button
        Intent person=new Intent();
        Bundle bag=new Bundle();
        bag.putString("answer",setData);
        person.putExtras(bag);
        setResult(RESULT_OK,person);
        finish();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rHero:
                setData="Great! Journey is Long!";
                break;
            case R.id.rSuperStar:
                setData="You Achieved Very Much!";
                break;
            case R.id.rSecretS:
                setData="Hats Off!";
                break;
        }
        test.setText(setData);
    }
}
