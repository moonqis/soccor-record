package com.example.dazuoye;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> arraylist=new ArrayList<String>();
        arraylist.add("联赛第一轮 2021.12.15 球队1 2:1 球队2 球队1主场");
        arraylist.add("联赛第二轮 2021.12.21 球队1 0:1 球队3 球队3主场");
        arraylist.add("联赛第三轮 2021.12.27 球队1 2:2 球队4 球队1主场");
        arraylist.add("联赛第四轮 2022.01.02 球队1 V S 球队5 球队5主场");



        listView=(ListView)findViewById(R.id.list_item);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,arraylist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterView,View view,int i,long l){
                //增加Item点击命令
                switch (i) {
                    case 0:
                        Intent intent= new Intent(MainActivity.this,win.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(MainActivity.this,loss.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(MainActivity.this,draw.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(MainActivity.this,bisai.class);
                        startActivity(intent3);
                        break;





                }

            }
        });

    }
    public void go1(View view){
        Intent intent = new Intent(MainActivity.this,soccer.class);
        startActivity(intent);
    }
}