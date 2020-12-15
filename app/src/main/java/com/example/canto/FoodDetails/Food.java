package com.example.canto.FoodDetails;

public class Food {
    int rating,price;
    String name, photoUrl;

    Food(String name, int rating, String photoUrl, int price){
        this.name=name;
        this.price=price;
        this.rating=rating;
        this.photoUrl=photoUrl;
    }

    public int getPrice(){ return this.price; }

    public int getRating(){
        return this.rating;
    }

    public String getName() {
        return name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
    @Override
    public String toString(){
        return name+" "+photoUrl+" "+rating+" "+price;
    }
}
