package com.creativehub.foodfinder.model;

import java.util.List;

public class MealDetailsResponse {
    public final List<MealDetails> meals;

    public MealDetailsResponse(List<MealDetails> meals) {
        this.meals = meals;
    }
}
