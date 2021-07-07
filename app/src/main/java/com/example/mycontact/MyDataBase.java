package com.example.mycontact;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mycontact.model.Product;

import java.util.ArrayList;

public class MyDataBase extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "testproduct";
    private final static String TABLE_NAME = "product";
    private final static String PRODUCT_NAME = "product_name";
    private final static String PRODUCT_CODE = "product_code";
    private final static String PRODUCT_DES = "product_des";
    private final static String PRODUCT_PRICE = "product_price";

    private String createTable = "create table product (product_name TEXT, product_code TEXT)";
    private String deleteTable = "drop table if exists product";


    public MyDataBase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public MyDataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MyDataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(deleteTable);
        sqLiteDatabase.execSQL(createTable);
    }

    public void insertData(String name, String code, String desc, String price) {
        String sql = "insert into " + TABLE_NAME + " values ('" + name + "','" + code + "', '" + desc + "', '" + price + "')";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public void updateData(String name, String code) {
        String sql = "update " + TABLE_NAME + " set name='" + name + "' where " + PRODUCT_CODE + "='" + code + "'";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }
    public void deleteData(String code) {
        String sql = "delete from " + TABLE_NAME + " where " + PRODUCT_CODE + "='" + code + "'";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public ArrayList<Product> getProducts(){
        ArrayList<Product> listProductname = new ArrayList<>();
        String sql="select * from "+TABLE_NAME;
        listProductname.add(new Product("Tao","M01","Đây là một loại quả", 200));
        listProductname.add(new Product("Dao","M02","Đây là một loại quả", 300));
        listProductname.add(new Product("Nho","M03","Đây là một loại quả", 400));
        listProductname.add(new Product("Buoi","M04","Đây là một loại quả", 500));
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            listProductname.add(new Product((cursor.getString(cursor.getColumnIndexOrThrow("product_name"))),
                                cursor.getString(cursor.getColumnIndexOrThrow("product_code"))));
        }
        cursor.close();
        return listProductname;
    }
}
