package com.example.canto;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.canto.adapter.AllMenuAdapter;
import com.example.canto.adapter.PopularAdapter;
import com.example.canto.adapter.RecommendedAdapter;
import com.example.canto.model.Allmenu;
import com.example.canto.model.Popular;
import com.example.canto.model.Recommended;
import com.example.canto.retrofit.ApiInterface;
import com.example.canto.retrofit.FoodData;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    RecyclerView popularRecyclerView, recommendedRecyclerView, allMenuRecyclerView;
    PopularAdapter popularAdapter;
    RecommendedAdapter recommendedAdapter;
    AllMenuAdapter allMenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiInterface = new FoodData("app/src/main/java/com/example/canto/retrofit/menu.json");
        String json=loadJSONFromAsset();
        apiInterface.readFoodData(json);
//        apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
//
//        Call<List<FoodData>> call = apiInterface.getAllData();
//
//        call.enqueue(new Callback<List<FoodData>>() {
//            @Override
//            public void onResponse(Call<List<FoodData>> call, Response<List<FoodData>> response) {
//                List<FoodData> foodDataList = response.body();
//                getPopularData(foodDataList.get(0).getPopular());
//                getRecommendedData(foodDataList.get(0).getRecommended());
//                getAllMenu(foodDataList.get(0).getAllmenu());
//            }
//
//            @Override
//            public void onFailure(Call<List<FoodData>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Server is not responding.", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("menu.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
    private void  getPopularData(List<Popular> popularList){

        popularRecyclerView = findViewById(R.id.popular_recycler);
        popularAdapter = new PopularAdapter(this, popularList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        popularRecyclerView.setLayoutManager(layoutManager);
        popularRecyclerView.setAdapter(popularAdapter);

    }

    private void  getRecommendedData(List<Recommended> recommendedList){

        recommendedRecyclerView = findViewById(R.id.recommended_recycler);
        recommendedAdapter = new RecommendedAdapter(this, recommendedList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recommendedRecyclerView.setLayoutManager(layoutManager);
        recommendedRecyclerView.setAdapter(recommendedAdapter);

    }

    private void getAllMenu(List<Allmenu> allmenuList){

        allMenuRecyclerView = findViewById(R.id.all_menu_recycler);
        allMenuAdapter = new AllMenuAdapter(this, allmenuList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        allMenuRecyclerView.setLayoutManager(layoutManager);
        allMenuRecyclerView.setAdapter(allMenuAdapter);
        allMenuAdapter.notifyDataSetChanged();

    }
}