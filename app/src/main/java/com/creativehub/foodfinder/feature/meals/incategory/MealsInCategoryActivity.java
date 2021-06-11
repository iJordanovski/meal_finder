package com.creativehub.foodfinder.feature.meals.incategory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.creativehub.foodfinder.R;
import com.creativehub.foodfinder.model.Meal;
import com.creativehub.foodfinder.network.MealsApi;
import com.creativehub.foodfinder.network.MealsApiService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MealsInCategoryActivity extends AppCompatActivity {
    private String categoryName;
    private final static String EXTRA_CATEGORY_NAME = "categoryName";
    private MealsInCategoryViewModel viewModel;

    public static void start(Context context, String categoryName) {
        Intent intent = new Intent(context, MealsInCategoryActivity.class);
        intent.putExtra(EXTRA_CATEGORY_NAME, categoryName);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_in_category);
        categoryName = getIntent().getStringExtra(EXTRA_CATEGORY_NAME);
        Log.d("categoryName", categoryName);
        viewModel = new ViewModelProvider(this).get(MealsInCategoryViewModel.class);
        setupObservers();
        viewModel.getMealsByCategory(categoryName);

    }

    private void setupObservers() {
        viewModel.mealCategoryList.observe(this, result -> {
            Log.d("success","success");
            //TODO:Display items in recycler view
        });
        viewModel.showError.observe(this, showError ->{
            //TODO:Display snack bar with retry option
            Log.e("error","error");
        });
    }

}