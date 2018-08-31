package com.example.rajan.myfirstandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyTaskFragment extends Fragment {

    EditText title,desc;
    Button save,viewTasks,backbutton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootview=inflater.inflate(R.layout.my_activity,container,false);

        title=rootview.findViewById(R.id.task_title);
        desc=rootview.findViewById(R.id.task_details);
        save = rootview.findViewById(R.id.save_task);
        viewTasks=rootview.findViewById(R.id.next_screen);
        backbutton=rootview.findViewById(R.id.btn_back);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t1= title.getText().toString();
                String d1 =desc.getText().toString();
                //for fragment use getactivity() instead of context like this
                //use this DataSource source = new DataSource(getActivity());
                //instead of the below line for calling fragment
                // DataSource source = new DataSource(MyTaskFragment.this);
                DataSource source = new DataSource(getActivity());
                source.insertNewTask(t1,d1);
                Toast.makeText(getActivity(), "Data inserted", Toast.LENGTH_SHORT).show();
                title.setText("");
                desc.setText("");

            }
        });

        viewTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Intent moveTo = new Intent(MyTaskFragment.this,mylistactivity.class);
             //   startActivity(moveTo);
                //INSIDE THE FRAGMENT CLASS USE GETFRAGMENTMANAGER INSTEAD OF GETFRAGMENTSUPPORTMANAGER
                //GETSUPPORTFRAGMENTMANAGER SHOULD BE USED IN ACTIVITY
                FragmentTransaction myviewlist=getFragmentManager().beginTransaction();
              //  FragmentTransaction myviewlist=getSupportFragmentManager().beginTransaction();
                myviewlist.addToBackStack("MyListFrament");
                myviewlist.replace(R.id.container,new MyListFrament()).commit();
            }
        });

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendtomainactivity=new Intent(getContext() , MainActivity.class);
                startActivity(sendtomainactivity);
            }
        });

        return rootview;
    }
}
