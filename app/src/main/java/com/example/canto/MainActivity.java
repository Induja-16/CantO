package com.example.canto;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.canto.FoodDetails.ApiInterface;
import com.example.canto.FoodDetails.Food;
import com.example.canto.FoodDetails.FoodData;
import com.example.canto.adapter.AllMenuAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    RecyclerView recyclerView;
    List<Food> allFoodData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiInterface = new FoodData("app/src/main/java/com/example/canto/retrofit/menu.json");
        String json=loadJSONFromAsset();
        apiInterface.readFoodData(json);
        allFoodData = apiInterface.getAllFoodData();
        System.out.println("allFoodData"+allFoodData.toString());
        recyclerView = findViewById(R.id.allMenu);
        AllMenuAdapter adapter = new AllMenuAdapter(this, allFoodData);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public String loadJSONFromAsset() {
        String json ;
        try {
            InputStream is = getAssets().open("menu.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }
}