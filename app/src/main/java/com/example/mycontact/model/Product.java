package com.example.mycontact.model;

import java.util.ArrayList;

public class Product {

        private String mName, mCode, mMota;
        private double mPrice;

    public Product(String mName, String mCode, String mMota, double mPrice) {
        this.mName = mName;
        this.mCode = mCode;
        this.mMota = mMota;
        this.mPrice = mPrice;
    }

    public Product(String mName, String mCode) {
        this.mName = mName;
        this.mCode = mCode;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmCode() {
        return mCode;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode;
    }

    public String getmMota() {
        return mMota;
    }

    public void setmMota(String mMota) {
        this.mMota = mMota;
    }

    public double getmPrice() {
        return mPrice;
    }

    public void setmPrice(double mPrice) {
        this.mPrice = mPrice;
    }

    public static int getLastContactId() {
        return lastContactId;
    }

    public static void setLastContactId(int lastContactId) {
        Product.lastContactId = lastContactId;
    }

    private static int lastContactId = 0;

        public static ArrayList<Product> createContactsList() {
            ArrayList<Product> products = new ArrayList<Product>();

            products.add(new Product("Tao","M" + ++lastContactId,"Đây là một loại quả", 200));
            products.add(new Product("Dao","M" + ++lastContactId,"Đây là một loại quả", 300));
            products.add(new Product("Nho","M" + ++lastContactId,"Đây là một loại quả", 400));
            products.add(new Product("Buoi","M" + ++lastContactId,"Đây là một loại quả", 500));
            return products;
        }

}
