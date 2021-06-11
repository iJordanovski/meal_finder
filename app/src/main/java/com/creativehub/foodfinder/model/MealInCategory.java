package com.creativehub.foodfinder.model;

import com.google.gson.annotations.SerializedName;

public class MealInCategory {
    @SerializedName("strMeal")
    public final String title;
    @SerializedName("strMealThumb")
    public final String imgUrl;
    @SerializedName("idMeal")
    public final String id;

    public MealInCategory(String title, String imgUrl, String id) {
        this.title = title;
        this.imgUrl = imgUrl;
        this.id = id;
    }
}
