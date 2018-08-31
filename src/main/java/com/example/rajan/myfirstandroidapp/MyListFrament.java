package com.example.rajan.myfirstandroidapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class MyListFrament extends Fragment {

    ListView taskList;
    Button btnback;
    String[] data ={"Task1","Task2","Task3"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View mylistfragmentview= inflater.inflate(R.layout.mylist_activity,container,false);
        Log.i("listtask","listtaskoncreateloaded");
        taskList=mylistfragmentview.findViewById(R.id.list_tasks);
        //SAMPLE CUSTOM LIST VIEW LINKS BELOW
        //https://abhiandroid.com/ui/listview
        //https://abhiandroid.com/ui/custom-arrayadapter-tutorial-example.html
        //https://www.sitepoint.com/custom-data-layouts-with-your-own-android-arrayadapter/

        mycustomlistviewadapt();
        btnback=mylistfragmentview.findViewById(R.id.btn_back);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ftmytasktransaction=getFragmentManager().beginTransaction();
                ftmytasktransaction.replace(R.id.container,new MyTaskFragment()).commit();
                ftmytasktransaction.addToBackStack("mylistfragment");
            }
        });


        return mylistfragmentview;
    }

    private void mycustomlistviewadapt()
    {
        DataSource source = new DataSource(getActivity());
        ArrayList<Map<String,Object>> itemDataList=source.getData();
        // ArrayAdapter adapter = new ArrayAdapter(getActivity(),
        //        android.R.layout.simple_list_item_1,source.getData());

       MyCustomListAdapter simplecustomAdapter = new MyCustomListAdapter(getActivity(),source);
                ;

        taskList.setAdapter(simplecustomAdapter);
    }

    private void CustomListViewAdapter()
    {
        DataSource source = new DataSource(getActivity());
        ArrayList<Map<String,Object>> itemDataList=source.getData();
        // ArrayAdapter adapter = new ArrayAdapter(getActivity(),
        //        android.R.layout.simple_list_item_1,source.getData());

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(),itemDataList,android.R.layout.simple_list_item_2,
                new String[]{"task_title","task_details"},new int[]{android.R.id.text1,android.R.id.text2});

        taskList.setAdapter(simpleAdapter);

    }

    // Create a BaseAdapter instance.
    BaseAdapter customBaseAdapter = new BaseAdapter() {

        DataSource source = new DataSource(getActivity());
        // Return list view item count.
        @Override
        public int getCount() {
            Log.i("datact","nodata");
            Log.i("datasrcecoiunt","" + source.getData().size());
            return source.getData().size();
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
        public View getView(int itemIndex, View itemView, ViewGroup viewGroup) {

            if(itemView == null)
            {   // First inflate the RelativeView object.
                itemView = LayoutInflater.from(getActivity()).inflate(R.layout.mylistcustomadapter, null);
            }

            // Find related view object inside the itemView.

            TextView titleView = (TextView)itemView.findViewById(R.id.tasktitle);
            TextView descView = (TextView)itemView.findViewById(R.id.taskdetails);

            // Set background color by row number.
            int colorPos = itemIndex % 2;
            if(colorPos==0) {
                itemView.setBackgroundColor(Color.YELLOW);
            }else
            {
                itemView.setBackgroundColor(Color.GREEN);
            }
            // Set resources.

            final String title =source.getData().get(itemIndex).toString();
            final String desc = source.getData().get(itemIndex).toString();
            titleView.setText(title);
            descView.setText(desc);

            return itemView;
        }
    };
}
