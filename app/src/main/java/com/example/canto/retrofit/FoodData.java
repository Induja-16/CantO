package com.example.canto.retrofit;
import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonArray;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FoodData implements ApiInterface{
    String fileName;
    public static List<Food> allFoodData = new ArrayList<>();
    public FoodData(String fileName){
        this.fileName=fileName;
    }


    public void readFoodData(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("popular");
            for(int i=0; i<jsonArray.length();i++){
                JSONObject insideObject = jsonArray.getJSONObject(i);
                Food food=new Food(insideObject.getString("name"),insideObject.getInt("rating"), insideObject.getString("imageUrl"),insideObject.getInt("price"));
                System.out.println(food.toString());
                allFoodData.add(food);
            }

        }
        catch (JSONException e){
            e.printStackTrace();
        }


    }
    public List<Food> getAllFoodData(){
        return allFoodData;
    }

}
