package com.example.acer.poem;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PoemDataBaseHelper extends SQLiteOpenHelper {

    public static final String CreatePoem = "create table poem ("
            + "id integer primary key autoincrement, "
            + "content text , "
            + "date text)";

    public PoemDataBaseHelper(Context context) {
        super(context, "note", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CreatePoem);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }

}
