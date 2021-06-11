package com.creativehub.foodfinder.model;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("idCategory")
    public final String id;
    @SerializedName("strCategory")
    public final String name;
    @SerializedName("strCategoryThumb")
    public final String url;
    @SerializedName("strCategoryDescription")
    public final String description;

    public Category(String id, String name, String url, String description) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.description = description;
    }
}
