package ss.practice;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by TOSHIBA on 18-09-2017.
 */
public class Rater {
    public static final String KEY_ROWID="_id";
    public static final String KEY_NAME="persons_name";
    public static final String KEY_RATINGS="ratings";


    private static final String DATABASE_NAME="MYDB";
    private static final String DATABASE_TABLE="peopleTable";
    private static final String DATABASE_VERSION="1";

    private DBHelper ourHelper;//setting instance pf class
    private final Context ourCon;
    private SQLiteDatabase ourDB;

    private static class DBHelper extends SQLiteOpenHelper{
public DBHelper(Context context){
    super(context,DATABASE_NAME,null, Integer.parseInt(DATABASE_VERSION));
}

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
    public Rater(Context c){
        ourCon=c;
    }
}
