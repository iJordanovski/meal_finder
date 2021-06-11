package com.creativehub.foodfinder.model;

import com.google.gson.annotations.SerializedName;

public class Meal {
    @SerializedName("strMeal")
    public final String name;
    @SerializedName("strCategory")
    public final String category;
    @SerializedName("strArea")
    public final String area;
    @SerializedName("strTags")
    public final String tag;
    @SerializedName("strYoutube")
    public final String videoUrl;
    @SerializedName("strMealThumb")
    public final String imageUrl;
    @SerializedName("idMeal")
    public final String id;

    public Meal(String name, String category, String area, String tag, String videoUrl, String imageUrl, String id) {
        this.name = name;
        this.category = category;
        this.area = area;
        this.tag = tag;
        this.videoUrl = videoUrl;
        this.imageUrl = imageUrl;
        this.id = id;
    }


}
