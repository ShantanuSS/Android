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


    }

    @Override
    public void onClick(View v) {

    }
}
