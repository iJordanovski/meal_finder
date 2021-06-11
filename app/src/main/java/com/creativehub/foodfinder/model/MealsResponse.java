package com.creativehub.foodfinder.model;

import java.util.ArrayList;
import java.util.List;

public class MealsResponse {
    public final List<Meal> meals;

    public MealsResponse() {
        this.meals = new ArrayList<>();
    }

}
