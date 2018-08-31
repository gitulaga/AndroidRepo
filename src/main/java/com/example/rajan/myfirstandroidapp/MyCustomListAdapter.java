package com.example.rajan.myfirstandroidapp;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyCustomListAdapter extends BaseAdapter {
Context context;
    ArrayList<Map<String,Object>>  tasktitlearr;
LayoutInflater inflter;
    TextView txttasktitle,txttaskdetails;
    public MyCustomListAdapter(Context applicationcontext,DataSource sourcedata){
     //   sourcedata=new DataSource(applicationcontext);
tasktitlearr=sourcedata.getData();
inflter=(LayoutInflater.from(applicationcontext));
    }


    @Override
    public int getCount() {
        return tasktitlearr.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflter.inflate(R.layout.mylistcustomadapter,null);

    //    ArrayList<Map<String,Object>> taskitems=tasktitlearr.get(i);

       /* for (HashMap<String, String> map : data)
            for (Entry<String, String> entry : map.entrySet())
                view.append(entry.getKey() + " => " + entry.getValue())*/

       int listcnt= this.getCount();
        Log.i("listcount", String.valueOf(listcnt));
        for (Map<String, Object> map : tasktitlearr)
        {
            Log.i("tasktitlearr", String.valueOf(tasktitlearr));
            for (Map.Entry<String, Object> entry : map.entrySet()) {

                if(entry.getKey().equals("task_title"))
                {
                    Log.i("entryset", String.valueOf(map.entrySet()));
                    txttasktitle=(TextView)view.findViewById(R.id.tasktitle);
                    Log.i("tasktitleprint",entry.getKey() + entry.getValue().toString());
                    txttasktitle.setText(entry.getValue().toString());

                }
                if(entry.getKey().equals("task_details"))
                {
                    Log.i("taskdetailsprint",entry.getKey() + entry.getValue().toString());
                    txttaskdetails=(TextView)view.findViewById(R.id.taskdetails);
                    txttaskdetails.setText(entry.getValue().toString());//Returns the list of values

                }
            }

        }
       //    Map<String, Object> map = new HashMap<String,Object>();

        //txttasktitle.setText(tasktitlearr.get(i).toString());
        return view;
    }
}
