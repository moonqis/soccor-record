package com.example.dazuoye.adds;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 实体类
 */
public class Person {

    public int id;
    public String name;//数据库自增ID
    public long time;
    public String msg;

    public Person(){
    }

    public Person(String n, long t, String m){
        name = n;
        time = t;
        msg = m;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        builder.append(id).append("--");
        builder.append(name).append("--");
        // 将时间戳转换成特定格式的字符串
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        builder.append(format.format(date)).append("--");
        builder.append(msg).append("]");
        return builder.toString();
    }
}
