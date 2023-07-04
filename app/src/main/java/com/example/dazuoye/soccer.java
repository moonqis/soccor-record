package com.example.dazuoye;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dazuoye.adds.Person;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class soccer extends AppCompatActivity {
    private Button but;
    private soccerAdapter adapter;
    private List<Integer> List = new ArrayList<>();


    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.hide();

        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soccer);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.ls);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
//设置adapter

        soccerAdapter myAdapter=new soccerAdapter(this,List);
        mRecyclerView.setAdapter(myAdapter);
//        AppBarLayout appBarLayout = findViewById(R.id.appBar);
//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
//                int color = Color.argb(200,0,0,0);
//                collapsingToolbar.setCollapsedTitleTextColor(color);
//
//                if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
//                    collapsingToolbar.setTitle("朋友圈");
//
//                } else {
//                    collapsingToolbar.setTitle("");
//
//                }
//            }
//        });


    }

    public void go2(View view){
        Intent intent = new Intent(soccer.this,MainActivity.class);
        startActivity(intent);
    }
    public void go3(View view){
        Intent intent = new Intent(soccer.this,add.class);
        startActivity(intent);
    }
    private void initView() {
        but = (Button) findViewById(R.id.button6);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("tag","添加成功");
                Toast.makeText(soccer.this,"添加成功", Toast.LENGTH_SHORT).show();

                String str="";
                EditText editText =(EditText)findViewById(R.id.in);
                str=editText.getText().toString();
                String str1="";
                EditText editText1 =(EditText)findViewById(R.id.in1);
                str1=editText1.getText().toString();
                String str2="";
                EditText editText2 =(EditText)findViewById(R.id.in2);
                str2=editText2.getText().toString();
                String str3="";
                EditText editText3 =(EditText)findViewById(R.id.in3);
                str3=editText3.getText().toString();
                String str4="";
                EditText editText4=(EditText)findViewById(R.id.in4);
                str4=editText4.getText().toString();
                String str5="";
                EditText editText5=(EditText)findViewById(R.id.in5);
                str5=editText5.getText().toString();
                String str6="";
                EditText editText6 =(EditText)findViewById(R.id.in6);
                str6=editText6.getText().toString();
                String str7="";
                EditText editText7 =(EditText)findViewById(R.id.in7);
                str7=editText7.getText().toString();

            }
        });
    }


}

