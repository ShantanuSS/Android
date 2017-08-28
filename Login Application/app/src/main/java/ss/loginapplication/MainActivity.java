package ss.loginapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static EditText username;
    private static EditText password;
    private static TextView attempt;
    private static Button login_button;
    int at_count=5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginButton();

    }

    private void LoginButton() {
        username=(EditText)findViewById(R.id.etUser);
        password=(EditText)findViewById(R.id.etPass);
        attempt=(TextView)findViewById(R.id.tvAttempt);
        login_button=(Button)findViewById(R.id.btLog);
        attempt.setText(Integer.toString(at_count));
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("user")
                        &&
                        password.getText().toString().equals("pass")){
                    Toast.makeText(MainActivity.this,"Username and Password is correct",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent("ss.loginapplication.User");
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,"Incorrect!!",Toast.LENGTH_SHORT).show();
                    at_count--;
                    attempt.setText(Integer.toString(at_count));
                    if(at_count==0)
                        login_button.setEnabled(false);

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;}

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.action_settings){ return true;}
        return super.onOptionsItemSelected(item);
    }
}
