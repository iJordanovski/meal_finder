package com.creativehub.foodfinder.feature.details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.creativehub.foodfinder.R;
import com.creativehub.foodfinder.databinding.ActivityMealDetailsBinding;
import com.creativehub.foodfinder.model.MealDetails;

import java.util.ArrayList;
import java.util.List;

public class MealDetailsActivity extends AppCompatActivity {
    private static final String EXTRA_MEAL_ID = "mealId";
    private MealDetailsViewModel viewModel;
    private ActivityMealDetailsBinding binding;
    private String mealId;

    public static void start(Context context, String mealId) {
        Intent intent = new Intent(context, MealDetailsActivity.class);
        intent.putExtra(EXTRA_MEAL_ID, mealId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMealDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(MealDetailsViewModel.class);
        setupUi();
        setupObservers();
        viewModel.getMeals(mealId);
    }

    private void setupObservers() {
        viewModel.mealDetails.observe(this, new Observer<MealDetails>() {
            @Override
            public void onChanged(MealDetails mealDetails) {
                binding.mealName.setText(mealDetails.name);
                binding.area.setText(mealDetails.area);
                binding.category.setText(mealDetails.category);
                if (!TextUtils.isEmpty(mealDetails.tag)) {
                    String[] tags = mealDetails.tag.split(",");
                    binding.mealTags.setTags(tags);
                }
                Glide.with(MealDetailsActivity.this)
                        .load(mealDetails.imageUrl)
                        .into(binding.image);
                binding.instructions.setText(mealDetails.instructions);

                List<String> ingredientList = mealDetails.getIngredients();
                for (int i = 0; i < ingredientList.size(); i++) {
                    String ingredient = ingredientList.get(i);

                    if (!TextUtils.isEmpty(ingredient)) {
                        TextView textView = new TextView(MealDetailsActivity.this);
                        textView.setText(getString(R.string.ingredient, ingredientList.get(i)));
                        binding.ingredients.addView(textView);
                    }

                }

            }
        });
    }

    private void setupUi() {
        mealId = getIntent().getStringExtra(EXTRA_MEAL_ID);
        Log.d("Meal Id", mealId);
    }
}