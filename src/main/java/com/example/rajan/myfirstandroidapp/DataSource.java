package com.example.rajan.myfirstandroidapp;


import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataSource extends SQLiteOpenHelper {

    public DataSource(Context context) {
        super(context, "mydatabase",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="create table todolist_database" +
                "(task_title varchar(50),task_details varchar(200));";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists todolist_database ");
    }


    public void insertNewTask(String title,String desc)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("task_title",title);
        values.put("task_details",desc);
        database.insert("todolist_database",
                null,
                values);

    }

    public ArrayList<Map<String,Object>> getData()
    {
        Log.i("fromdatasource","getdatacalled");
       // ArrayList data= new ArrayList();
        ArrayList<Map<String,Object>> itemDataList = new ArrayList<Map<String,Object>>();;
        SQLiteDatabase database =this.getReadableDatabase();
        Cursor cursor=database.query("todolist_database",
                new String[]{"task_title","task_details"},
                null,null,
                null,null,
                null);
        Log.i("fromdatasourcecursor", cursor.toString());
        if (cursor!=null)
        {

            Log.i("cursorworking", cursor.toString());
            if (cursor.moveToFirst())
            {

                while (cursor.moveToNext())
                {
                    Map<String,Object> listitemmap = new HashMap<String,Object>();
                    String title = cursor.getString(0);
                    String taskdet = cursor.getString(1);
                    listitemmap.put("task_title",title);
                    listitemmap.put("task_details",taskdet);
                    //data.add(title);
                    itemDataList.add(listitemmap);
                    Log.i("itemDataList", String.valueOf(itemDataList.get(0)));
                }
            }
        }
        else
        {
            Log.i("cursornull","nullcursor");
            //Toast.makeText(DataSource.this, "cursor is null",Toast.LENGTH_SHORT).show();
        }

        return itemDataList;
    }
}
