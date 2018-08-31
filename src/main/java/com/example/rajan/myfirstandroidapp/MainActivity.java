package com.example.rajan.myfirstandroidapp;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonOne,buttonTwo,buttonThree,buttonClear;
    Button buttonFour,buttonFive,buttonSix,buttonOk,buttonSavePass;
    TextView passwordHint;
    //EditText userNewPassword;
    String password="";
    String newUserPassStr;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       preferences= getSharedPreferences("mydata",MODE_PRIVATE);

        buttonOne=findViewById(R.id.btn_1);
        buttonTwo=findViewById(R.id.my_button_2);
        buttonThree=findViewById(R.id.btn_3);
        buttonFour=findViewById(R.id.btn_4);
        buttonFive=findViewById(R.id.btn_5);
        buttonSix=findViewById(R.id.btn_6);
        buttonOk=findViewById(R.id.submit_btn);
        buttonClear=findViewById(R.id.clear_btn);
        buttonSavePass=findViewById(R.id.save_pass_btn);

        //  userNewPassword=findViewById(R.id.user_password);

        passwordHint=findViewById(R.id.user_password_hint);

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                password=password+"1";
                passwordHint.setText(password);
//                //Toast.makeText();
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password=password+"2";
                passwordHint.setText(password);
                //   Toast.makeText(MyActivity.this, password, Toast.LENGTH_SHORT).show();
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password=password+"3";
                passwordHint.setText(password);
                // Toast.makeText(MyActivity.this, password, Toast.LENGTH_SHORT).show();
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password=password+"4";
                passwordHint.setText(password);
                // Toast.makeText(MyActivity.this, password, Toast.LENGTH_SHORT).show();
            }
        });

        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password=password+"5";
                passwordHint.setText(password);
                // Toast.makeText(MyActivity.this, password, Toast.LENGTH_SHORT).show();
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password=password+"6";
                passwordHint.setText(password);
                // Toast.makeText(MyActivity.this, password, Toast.LENGTH_SHORT).show();
            }
        });

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String temp=preferences.getString("password","");
                if (password.equals(temp))
                {
                   Toast.makeText(MainActivity.this, "valid user", Toast.LENGTH_SHORT).show();
                   Intent sendtohome=new Intent(MainActivity.this,homeactivity.class);
                   startActivity(sendtohome);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Invalid password", Toast.LENGTH_SHORT).show();
                }

            }
        });

        buttonSavePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           // makeText(MainActivity.this,"gotonextpage",Toast.LENGTH_SHORT).show();
                Intent sendtosavepasswordscreen = new Intent(MainActivity.this,savepassactivity.class);
                startActivity(sendtosavepasswordscreen);
              // SharedPreferences.Editor editor = preferences.edit();
           //editor.putString("password",newUserPassStr).commit();
            }
        });


        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password="";
                passwordHint.setText(password);
            }
        });

    }

    @Override
    public void onBackPressed(){

        final Dialog dlg=new Dialog(this);
        View dialogview= LayoutInflater.from(this).inflate(R.layout.mydialoglayout,null);
        dlg.setContentView(dialogview);

        TextView txtposbtn=dialogview.findViewById(R.id.pos_btn);
        TextView txtnegbtn=dialogview.findViewById(R.id.neg_btn);

        txtposbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.super.onBackPressed();
            }
        });

        dlg.show();

    }
}
