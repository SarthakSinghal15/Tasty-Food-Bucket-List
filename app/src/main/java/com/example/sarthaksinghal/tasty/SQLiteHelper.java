package com.example.sarthaksinghal.tasty;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

/**
 * Created by sarthaksinghal on 2/28/19.
 */

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){
    SQLiteDatabase database = getWritableDatabase();
    database.execSQL(sql);
    }

    public void insertUserData(String name, String pasword){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO USERS VALUES (NULL, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,name);
        statement.bindString(2,pasword);
        statement.executeInsert();
    }

    public void insertData(String name, String price, byte[] image){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO FOOD VALUES (NULL, ?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindString(2, price);
        statement.bindBlob(3, image);

        statement.executeInsert();
    }

    public  void deleteData(int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM FOOD WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);

        statement.execute();
        database.close();
    }

    public void updateData(String name, String price, byte[] image, int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "UPDATE FOOD SET name = ?, price = ?, image = ? WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindString(1, name);
        statement.bindString(2, price);
        statement.bindBlob(3, image);
        statement.bindDouble(4, (double)id);

        statement.execute();
        database.close();
    }

    public String searchUser(String username, String password){
        SQLiteDatabase database = getReadableDatabase();
        String query = "SELECT name, password FROM USERS";
        Cursor cursor = database.rawQuery(query,null);
        String a,b;
        b="not found";
        if(cursor.moveToFirst())
        {
            do {
                a=cursor.getString(0);
                if(a.equals(username))
                {
                    b=cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        if(b.equals("not found")){
            return null;
        }
        else{
            return b;
        }

    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
