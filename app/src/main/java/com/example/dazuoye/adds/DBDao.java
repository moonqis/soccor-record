package com.example.dazuoye.adds;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.List;

/**
 * 数据库操作类
 */
public class DBDao {
    private static final String DB_NAME = "per.db";
    private static final String TABLE_NAME = "person_info";
    private static final int DB_VERSION = 1;

    private static String KEY_ID = "id";
    private static String KEY_NAME = "name";
    private static String KEY_TIME = "time";
    private static String KEY_MSG = "msg";

    private SQLiteDatabase mDatabase;
    private Context mContext;
    private DBOpenHelper mDbOpenHelper;


    public DBDao(Context context) {
        mContext = context;
    }

    /**
     * 打开数据库
     */
    public void openDataBase() {
        mDbOpenHelper = new DBOpenHelper(mContext, DB_NAME, null, DB_VERSION);
        try {
            mDatabase = mDbOpenHelper.getWritableDatabase();//获取可写数据库
        } catch (SQLException e) {
            mDatabase = mDbOpenHelper.getReadableDatabase();//获取只读数据库
        }
    }

    /**
     * 关闭数据库
     */
    public void closeDataBase() {
        if (mDatabase != null) {
            mDatabase.close();
        }
    }

    /**
     * 插入一条数据
     */
    public long insertData(Person per) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, per.name);
        values.put(KEY_TIME, per.time);
        values.put(KEY_MSG, per.msg);
        return mDatabase.insert(TABLE_NAME, null, values);
    }

    /**
     * 删除一条数据
     */
    public long deleteData(long id) {
        return mDatabase.delete(TABLE_NAME, KEY_ID + "=" + id, null);
    }

    /**
     * 删除所有数据
     */
    public long deleteAllData() {
        return mDatabase.delete(TABLE_NAME, null, null);
    }

    /**
     * 更新一条数据
     */
    public long updateData(long id, Person per) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, per.name);
        values.put(KEY_TIME, per.time);
        values.put(KEY_MSG, per.msg);
        return mDatabase.update(TABLE_NAME, values, KEY_ID + "=" + id, null);
    }

    /**
     * 查询一条数据
     */
    public List<Person> queryData(long id) {
        Cursor results = mDatabase.query(TABLE_NAME, new String[]{KEY_ID,
                        KEY_NAME,
                        KEY_TIME,
                        KEY_MSG},
                KEY_ID + "=" + id, null, null, null, null);
        return convertUtil(results);
    }

    /**
     * 查询所有数
     */
    public List<Person> queryDataList() {
        Cursor results = mDatabase.query(TABLE_NAME, new String[]{KEY_ID,
                        KEY_NAME,
                        KEY_TIME,
                        KEY_MSG},
                null, null, null, null, null);
        return convertUtil(results);

    }

    /**
     * 转换工具
     */
    private List<Person> convertUtil(Cursor cursor) {
        int resultCounts = cursor.getCount();
        if (resultCounts == 0 || !cursor.moveToFirst()) {
            return null;
        }
        List<Person> mList = new ArrayList<>();
        for (int i = 0; i < resultCounts; i++) {
            Person per = new Person();
            per.id = (cursor.getInt(0));
            per.name = (cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            per.time = (cursor.getLong(cursor.getColumnIndex(KEY_TIME)));
            per.msg = (cursor.getString(cursor.getColumnIndex(KEY_MSG)));
            mList.add(per);
            cursor.moveToNext();
        }
        return mList;
    }

    /**
     * 数据表打开帮助类
     */
    private static class DBOpenHelper extends SQLiteOpenHelper {

        public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            final String sqlStr = "create table if not exists " + TABLE_NAME + " (" +
                    KEY_ID + " integer primary key autoincrement, " +
                    KEY_NAME + " text not null, " +
                    KEY_TIME + " integer, " +
                    KEY_MSG + " text );";
            db.execSQL(sqlStr);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            final String sqlStr = "DROP TABLE IF EXISTS " + TABLE_NAME;
            db.execSQL(sqlStr);
            onCreate(db);
        }
    }
}
