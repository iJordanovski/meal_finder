package com.creativehub.foodfinder.model;

import java.util.List;

public class MealsInCategoryResponse {
    public final List<MealInCategory> mealInCategories;

    public MealsInCategoryResponse(List<MealInCategory> mealInCategories) {
        this.mealInCategories = mealInCategories;
    }
}
