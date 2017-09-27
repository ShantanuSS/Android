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

    public void createentry(String name, String ratept) {
    }

    private static class DBHelper extends SQLiteOpenHelper{
public DBHelper(Context context){
    super(context,DATABASE_NAME,null, Integer.parseInt(DATABASE_VERSION));
}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE" + DATABASE_TABLE +" ("+
                KEY_ROWID +"INTEGER PRIMARY KEY AUTOINCREMENT, "+
                KEY_NAME+" TEXT NOT NULL, " +
                KEY_RATINGS+" TEXT NOT NULL);"
        ); //this sets up the DB
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ DATABASE_TABLE);
        onCreate(db);  //upgrades the DB
    }
}
    public Rater(Context c){
        ourCon=c;
    }

    public Rater open(){
        ourHelper=new DBHelper(ourCon);
        ourDB=ourHelper.getWritableDatabase();//writing to DB
            return this;
    }
    public void close(){  //for closing DB
        ourHelper.close();

    }
}
