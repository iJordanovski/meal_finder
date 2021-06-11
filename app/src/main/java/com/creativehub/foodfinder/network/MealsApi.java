package com.creativehub.foodfinder.network;

import com.creativehub.foodfinder.model.CategoriesResponse;
import com.creativehub.foodfinder.model.MealDetailsResponse;
import com.creativehub.foodfinder.model.MealsInCategoryResponse;
import com.creativehub.foodfinder.model.MealsResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealsApi {
    @GET("api/json/v1/1/search.php")
    Single<MealsResponse>searchMeals(@Query("s") String mealName);
    @GET("api/json/v1/1/lookup.php")
    Single<MealDetailsResponse>getMealById(@Query("i") String id);
    @GET("api/json/v1/1/categories.php")
    Single<CategoriesResponse> getMealCategories();
    @GET("api/json/v1/1/filter.php")
    Single<MealsInCategoryResponse> getMealByCategory(@Query("c") String categoryName);

}
