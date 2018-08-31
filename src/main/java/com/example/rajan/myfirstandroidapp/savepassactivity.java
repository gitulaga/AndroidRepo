package com.example.rajan.myfirstandroidapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class savepassactivity extends AppCompatActivity {

    EditText userPasswordEd;
    Button savePasswordBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.savepass_activity);
        userPasswordEd=findViewById(R.id.edituserpassword);
        savePasswordBtn=findViewById(R.id.btnsavepassword);

        final SharedPreferences pref = getSharedPreferences("mydata",MODE_PRIVATE);

        savePasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp= userPasswordEd.getText().toString();
                SharedPreferences.Editor edit = pref.edit();
                edit.putString("password",temp).commit();
                Toast.makeText(savepassactivity.this,"Password saved successfully",Toast.LENGTH_LONG).show();
                Intent goback=new Intent(savepassactivity.this,MainActivity.class);
                startActivity(goback);
            }
        });
    }
}
