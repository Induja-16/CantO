package com.example.canto.retrofit;

import android.content.Context;

import java.util.List;

public interface ApiInterface {
    public void readFoodData(String json);
    public List<Food> getAllFoodData();
}
