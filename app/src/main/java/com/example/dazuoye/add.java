package com.example.dazuoye;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dazuoye.adds.Person;
import com.example.dazuoye.adds.DBDao;
import java.util.List;

public class add extends AppCompatActivity {
    private Context mContext = this;
    private DBDao dbDao;

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.hide();

        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adds);

        dbDao = new DBDao(mContext);
        dbDao.openDataBase();
        initView();
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        txt = (TextView) findViewById(R.id.txt_tips);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("tag","添加成功");
                Toast.makeText(add.this,"添加成功", Toast.LENGTH_SHORT).show();
                String str1="";
                EditText editText1 =(EditText)findViewById(R.id.num_input_1);
                str1=editText1.getText().toString();
                String str2="";
                EditText editText2 =(EditText)findViewById(R.id.num_input_2);
                str2=editText2.getText().toString();

                dbDao.insertData(new Person(str1, System.currentTimeMillis(), str2));//增加数据
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Person> lists = dbDao.queryDataList();//查询所有数据
                StringBuilder builder = new StringBuilder("数据如下：\n");
                for (int i = 0; i < lists.size(); i++) {
                    builder.append(lists.get(i).toString()).append("\n");
                }
                txt.setText(builder.toString());
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("tag","删除成功");
                Toast.makeText(add.this,"删除成功", Toast.LENGTH_SHORT).show();
                List<Person> lists = dbDao.queryDataList();//查询所有数据
                dbDao.deleteData(lists.get(0).id);
            }
        });
    }
}
