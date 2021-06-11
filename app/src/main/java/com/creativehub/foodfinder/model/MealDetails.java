package com.creativehub.foodfinder.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MealDetails {
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
    @SerializedName("strInstructions")
    public final String instructions;
    @SerializedName("strIngredient1")
    public final String ingredient1;
    @SerializedName("strIngredient2")
    public final String ingredient2;
    @SerializedName("strIngredient3")
    public final String ingredient3;
    @SerializedName("strIngredient4")
    public final String ingredient4;
    @SerializedName("strIngredient5")
    public final String ingredient5;
    @SerializedName("strIngredient6")
    public final String ingredient6;
    @SerializedName("strIngredient7")
    public final String ingredient7;
    @SerializedName("strIngredient8")
    public final String ingredient8;
    @SerializedName("strIngredient9")
    public final String ingredient9;
    @SerializedName("strIngredient10")
    public final String ingredient10;
    @SerializedName("strIngredient11")
    public final String ingredient11;
    @SerializedName("strIngredient12")
    public final String ingredient12;
    @SerializedName("strIngredient13")
    public final String ingredient13;
    @SerializedName("strIngredient14")
    public final String ingredient14;
    @SerializedName("strIngredient15")
    public final String ingredient15;
    @SerializedName("strIngredient16")
    public final String ingredient16;
    @SerializedName("strIngredient17")
    public final String ingredient17;
    @SerializedName("strIngredient18")
    public final String ingredient18;
    @SerializedName("strIngredient19")
    public final String ingredient19;
    @SerializedName("strIngredient20")
    public final String ingredient20;

    public MealDetails(String name, String category, String area, String tag, String videoUrl, String imageUrl, String id, String instructions, String ingredient1, String ingredient2, String ingredient3, String ingredient4, String ingredient5, String ingredient6, String ingredient7, String ingredient8, String ingredient9, String ingredient10, String ingredient11, String ingredient12, String ingredient13, String ingredient14, String ingredient15, String ingredient16, String ingredient17, String ingredient18, String ingredient19, String ingredient20) {
        this.name = name;
        this.category = category;
        this.area = area;
        this.tag = tag;
        this.videoUrl = videoUrl;
        this.imageUrl = imageUrl;
        this.id = id;
        this.instructions = instructions;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.ingredient4 = ingredient4;
        this.ingredient5 = ingredient5;
        this.ingredient6 = ingredient6;
        this.ingredient7 = ingredient7;
        this.ingredient8 = ingredient8;
        this.ingredient9 = ingredient9;
        this.ingredient10 = ingredient10;
        this.ingredient11 = ingredient11;
        this.ingredient12 = ingredient12;
        this.ingredient13 = ingredient13;
        this.ingredient14 = ingredient14;
        this.ingredient15 = ingredient15;
        this.ingredient16 = ingredient16;
        this.ingredient17 = ingredient17;
        this.ingredient18 = ingredient18;
        this.ingredient19 = ingredient19;
        this.ingredient20 = ingredient20;
    }

    public List<String> getIngredients() {
        List<String> ingredientList = new ArrayList<>();
        ingredientList.add(ingredient1);
        ingredientList.add(ingredient2);
        ingredientList.add(ingredient3);
        ingredientList.add(ingredient4);
        ingredientList.add(ingredient5);
        ingredientList.add(ingredient6);
        ingredientList.add(ingredient7);
        ingredientList.add(ingredient8);
        ingredientList.add(ingredient9);
        ingredientList.add(ingredient10);
        ingredientList.add(ingredient11);
        ingredientList.add(ingredient12);
        ingredientList.add(ingredient13);
        ingredientList.add(ingredient14);
        ingredientList.add(ingredient15);
        ingredientList.add(ingredient16);
        ingredientList.add(ingredient17);
        ingredientList.add(ingredient18);
        ingredientList.add(ingredient19);
        ingredientList.add(ingredient20);

        return ingredientList;
    }
}
