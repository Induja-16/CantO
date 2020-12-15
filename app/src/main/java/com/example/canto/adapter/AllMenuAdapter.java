package com.example.canto.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.canto.FoodDetails.Food;
import com.example.canto.R;

import java.util.List;

public class AllMenuAdapter extends RecyclerView.Adapter<AllMenuAdapter.MenuViewHolder> {
    Context context;
    List<Food> foodData;
    public AllMenuAdapter(Context context, List<Food> foodData){
        this.context=context;
        this.foodData=foodData;

    }
    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        View view = layoutInflater.inflate(R.layout.row,parent,false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        Food temp = foodData.get(position);
        holder.title.setText(temp.getName());
        holder.price.setText(temp.getPrice()+"");
        holder.rating.setText(temp.getRating()+"");
    }

    @Override
    public int getItemCount() {
        return foodData.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView title, price, rating;
        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.name);
            rating = itemView.findViewById(R.id.itemRating);

        }
    }
}
