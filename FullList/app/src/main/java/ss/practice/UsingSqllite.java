package ss.practice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by TOSHIBA on 17-09-2017.
 */
public class UsingSqllite extends Activity implements View.OnClickListener  {
    Button sqlupdate,sqlView;
    EditText sqlname,  sqlrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlitedb);
        sqlupdate=(Button)findViewById(R.id.btsqlUpdate);
        sqlname=(EditText)findViewById(R.id.etsqlnaam);
        sqlrate=(EditText)findViewById(R.id.etsqlrateme);

        sqlView=(Button)findViewById(R.id.btsqlView);
        sqlView.setOnClickListener(this);
        sqlupdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btsqlUpdate:
                String name=sqlname.getText().toString();
                String ratept=sqlrate.getText().toString();

                Rater entry=new Rater(UsingSqllite.this); //creating new instance of Rater class
                entry.open();
                entry.createentry(name,ratept);  //creating a new func.
                entry.close();

                    break;
            case R.id.btsqlView:

                break;

        }
    }
}
