package com.dom.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dom.bean.IUser;

/**
 * Created by Administrator on 2017/6/1 0001.
 */

public class MyDB {
   private  SQLiteDatabase sqLiteDatabase;
    private SQLiteOpenHelper helper;
    public MyDB(Context context){
        helper = new DBHelper(context);
    }
    public boolean addUser(IUser user){
        sqLiteDatabase = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("mid",user.getID());
        cv.put("username",user.getUserName());
        cv.put("userage",user.getAge());
       long rowId = sqLiteDatabase.insert("user",null,cv);
        if (rowId>0){
        return true;
        }else{
        return false;
        }
    }
public IUser findUserById(String id){
sqLiteDatabase=helper.getReadableDatabase();
    Cursor cursor = sqLiteDatabase.query("user",null,"mid=?",new String[]{id},null,null,null,null);
    cursor.moveToNext();
    IUser user = new IUser(cursor.getString(1),cursor.getString(2),cursor.getInt(3));
    if (user!=null)
    return user;
    return null;
}

}
