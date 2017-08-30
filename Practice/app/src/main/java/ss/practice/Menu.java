package ss.practice;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by TOSHIBA on 30-07-2017.
 */
public class Menu extends ListActivity {

    String classes[]={"MainActivity","TextPlay","Email ","Camera","Data","yoyo","aaaaa"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1 ,classes));
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String cheese=classes[position];
        try{
        Class ourclass =Class.forName("ss.practice."+ cheese);  //we are opening activities in list by class name
        Intent ourIntent=new Intent(Menu.this,ourclass);
        startActivity(ourIntent);
    }
    catch(ClassNotFoundException e){
        e.printStackTrace();  //for debugging
    }
    }


    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater blowUp=getMenuInflater();
        blowUp.inflate(R.menu.my_menu,menu);
        return true;
    }
}
