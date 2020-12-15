package com.example.canto.FoodDetails;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
