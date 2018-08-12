package com.example.acer.poem;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Telephony;

public class DBAdapter {

    private static final String DB_NAME = "poem.db";
    private static final String DB_TABLE = "myworks";
    private static final int DB_VERSION = 1;
    private static final String KEY_ID = "_id";
    private static final String TITLE = "title";
    private static final String CONTENT = "content";
    private static final String DATE = "date";
    private SQLiteDatabase db;
    private final Context context;//

    private DBOpenHelper dbOpenHelper;

    public DBAdapter(Context _context){
        context = _context;
    }

    //close database
    public void close(){
        if (db != null){
            db.close();
            db = null;
        }
    }

    //create and open the database
    public void open() throws SQLiteException {
        dbOpenHelper = new DBOpenHelper(context, DB_NAME, null, DB_VERSION);

        try {
            db = dbOpenHelper.getWritableDatabase();
        } catch (SQLiteException ex){
            db = dbOpenHelper.getReadableDatabase();
        }
    }

    //delete database
    public void delete() throws SQLiteException{
            context.deleteDatabase(DB_NAME);
    }

    //create table
    public void creat_table(String creatTableSql) throws SQLiteException{
        db.execSQL(creatTableSql);
    }

    //delete table
    public void delete_table(String tableName)throws SQLiteException{
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
    }

    //add items
    public long insert(WritingItem writingItem){
        //contentvalues ?
        ContentValues newValues = new ContentValues();
        newValues.put(TITLE, writingItem.Title);
        newValues.put(CONTENT, writingItem.Content);
        newValues.put(DATE, writingItem.Date);
        return db.insert(DB_TABLE, null, newValues);
    }

    //update items
    public long updateOneData(long id, WritingItem writingItem){
        ContentValues updateValues = new ContentValues();
        updateValues.put(TITLE, writingItem.Title);
        updateValues.put(CONTENT, writingItem.Content);
        updateValues.put(DATE, writingItem.Date);
        return db.update(DB_TABLE, updateValues, KEY_ID + "+" + id, null);
    }

    //delete items
    public long deleteAllData(){
        return db.delete(DB_TABLE, null, null);
    }
    public long deleteOneData(long id){
        return db.delete(DB_TABLE, KEY_ID + "=" + id, null);
    }

    ///*
    //query
    public Cursor queryAllData(){
        Cursor results = db.query(DB_TABLE, new String[]{KEY_ID, TITLE, CONTENT, DATE}, null, null, null, null, null);
        //return ConvertToWritingItem(results);
        return results;
    }
    public WritingItem[] queryOneData(long id){
        Cursor results = db.query(DB_TABLE, new String[]{KEY_ID, TITLE, CONTENT, DATE}, KEY_ID + "=" + id, null, null, null, null);
        return ConvertToWritingItem(results);
    }
    public WritingItem[] ConvertToWritingItem(Cursor cursor){
        int resultCounts = cursor.getCount();
        if (resultCounts == 0 || !cursor.moveToFirst())//moveToFirst(): 游标移动到结果集的第一行记录
            return null;
        WritingItem[] writingItems = new WritingItem[resultCounts];
        for (int i = 0; i < resultCounts; i++){
            writingItems[i] = new WritingItem();
            writingItems[i].ID = cursor.getInt(0);
            writingItems[i].Title = cursor.getString(cursor.getColumnIndex(TITLE));
            writingItems[i].Content = cursor.getString(cursor.getColumnIndex(CONTENT));
            writingItems[i].Date = cursor.getString(cursor.getColumnIndex(DATE));
            cursor.moveToNext();
        }
        return writingItems;
    }
    //*/

    //public static class DBOpenHelper extends SQLiteOpenHelper {
    public static class DBOpenHelper extends SQLiteOpenHelper {

        public DBOpenHelper(Context context, String db_name, SQLiteDatabase.CursorFactory factory, int version){
            super(context, db_name, factory, version);
        }

        private static final String DB_CREATE =
                "create table poem ("
                        + "id integer primary key autoincrement, "
                        + "content text , "
                        + "date text);";

        @Override
        public void onCreate(SQLiteDatabase _db) {
            _db.execSQL(DB_CREATE);
        }

        //refer to the book
        @Override
        public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion) {
            _db.execSQL("DROP TABLE IF EXISTS " + _oldVersion);
            onCreate(_db);
        }
    }

}
