package com.example.irtazanadeem.madproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


//jb b app 1st time chaly gi to constructor chaly ga oncreate b or onupgrade b
//oncreate check kray ga k database agr bani ho to sai ha ni to new bana dy ga
// in constructr super means parent class ka constructor call kr ry hien
// context = kon si activity ma hein , name = name of db , factory ya  ka library hein pre define k data base ko read kasay krna ha
// db ma space kya ha commas kya hein and soon is ko 99% NULL he krein gy , version
public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String databaseName = "reserveitt.db";
    public static final String tableName = "Registration";
    public static final String col1 = "email";
    public static final String col2 = "firstname";
    public static final String col3 = "lastname";
    public static final String col4 = "gender";
    public static final String col5 = "mob";
    public static final String col6 = "pass";

    /*public SQLiteHelper( Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
     *//* super(context, name, factory, version);*//*//asay b likh skty hein
    }*/

    public SQLiteHelper(Context context) {
        super(context, databaseName, null, 1);
        SQLiteDatabase db = this.getReadableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    String SQLString = "create table " + tableName +
    "(" + col1 + " Text Primary key, " + col2 + " Text, " + col3 + " Text, " + col4 + " Text, " + col5 + " Text, " + col6 + " Text " + ")";
    db.execSQL(SQLString);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("drop table if exists " + tableName);
    onCreate(db);
    }

    public boolean insertData(final String email, final String fn,final String ln,final String gen,final String mob ,final String pass)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues ourContent = new ContentValues();
        ourContent.put (col1,email);
        ourContent.put (col2,fn);
        ourContent.put (col3,ln);
        ourContent.put (col4,gen);
        ourContent.put (col5,mob);
        ourContent.put (col6,pass);

        long result = db.insert(tableName,null,ourContent);

        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean updateData(String email,String fn,String ln,String gen,String mob)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put (col1,email);
        contentValues.put (col2,fn);
        contentValues.put (col3,ln);
        contentValues.put (col4,gen);
        contentValues.put (col5,mob);
        long res = db.update(tableName, contentValues, "Name = ?",new String[] { email });
        if(res == -1)
            return false;
        else
            return true;
    }
    public boolean verify_em_ps(String e,String p)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from "+ tableName + " where email = ? and pass = ? ", new String[]{e,p});
        if (result.getCount()==1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
