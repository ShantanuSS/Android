package ss.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     ImageButton b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onclicker();
    }

    private void onclicker() {
        b1=(ImageButton)findViewById(R.id.ib1);
        b2=(ImageButton)findViewById(R.id.ib2);
        b3=(ImageButton)findViewById(R.id.ib3);
        b4=(ImageButton)findViewById(R.id.ib4);
    }
    public void onClick2003(View v){
        Toast.makeText(MainActivity.this, "Wrong! Try Again", Toast.LENGTH_SHORT).show();
    }
    public void onClick2004(View v){
        Toast.makeText(MainActivity.this, "Wrong! Try Again", Toast.LENGTH_SHORT).show();
    }public void onClick2005(View v){
        Toast.makeText(MainActivity.this, "Right...Yipeeee!!", Toast.LENGTH_SHORT).show();
    }
    public void onClick2006(View v){
        Toast.makeText(MainActivity.this, "Wrong! Try Again", Toast.LENGTH_SHORT).show();
    }
}
