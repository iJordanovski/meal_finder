package com.creativehub.foodfinder.model;

import java.util.List;

public class CategoriesResponse {
    public final List<Category> categories;

    public CategoriesResponse(List<Category> categories) {
        this.categories = categories;
    }
}
