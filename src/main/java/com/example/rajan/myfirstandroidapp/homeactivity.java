package com.example.rajan.myfirstandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class homeactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.homemenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.menu1)
        {
            Toast.makeText(homeactivity.this,"menu1 clicked",Toast.LENGTH_SHORT).show();
        //    Intent sendtonextpage=new Intent(homeactivity.this,mytaskfragment.class);
         //   startActivity(sendtonextpage);
            FragmentTransaction transaction1=getSupportFragmentManager().beginTransaction();
            transaction1.addToBackStack("mytaskfragment");
            transaction1.replace(R.id.container,new MyTaskFragment()).commit();
        }
        else if(item.getItemId()== R.id.menu2)
        {
            Toast.makeText(homeactivity.this,"menu2 clicked",Toast.LENGTH_SHORT).show();
           /* fragmenttwo two=new fragmenttwo();
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.addToBackStack("two");
            transaction.add(R.id.container,two).commit();*/

        }
        else if(item.getItemId()== R.id.menu3)
        {
           /* fragmentthree three=new fragmentthree();
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.addToBackStack("three");
            transaction.add(R.id.container,three).commit();*/
        }
        else if(item.getItemId()== R.id.menu4)
        {
            finish();
           /* fragmentfour fragfour=new fragmentfour();
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.addToBackStack("fragfour");
            transaction.replace(R.id.container,fragfour).commit();*/
        }

        return super.onOptionsItemSelected(item);
    }

}
