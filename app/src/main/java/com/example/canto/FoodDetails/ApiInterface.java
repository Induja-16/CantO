package com.example.canto.FoodDetails;

import java.util.List;

public interface ApiInterface {
    public void readFoodData(String json);
    public List<Food> getAllFoodData();
}
