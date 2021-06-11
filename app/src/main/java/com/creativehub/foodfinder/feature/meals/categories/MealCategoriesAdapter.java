package com.creativehub.foodfinder.feature.meals.categories;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.creativehub.foodfinder.databinding.ItemMealCategoryBinding;
import com.creativehub.foodfinder.feature.meals.incategory.MealsInCategoryActivity;
import com.creativehub.foodfinder.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MealCategoriesAdapter extends RecyclerView.Adapter<MealCategoriesAdapter.MealCategoryViewHolder> {

    private List<Category> categories = new ArrayList<>();

    public void addAll(List<Category> categoryList) {
        categories.clear();
        categories.addAll(categoryList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MealCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemMealCategoryBinding binding = ItemMealCategoryBinding.inflate(inflater, parent, false);
        return new MealCategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MealCategoryViewHolder holder, int position) {
        holder.bind(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    static class MealCategoryViewHolder extends RecyclerView.ViewHolder {
        private ItemMealCategoryBinding binding;

        public MealCategoryViewHolder(@NonNull ItemMealCategoryBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void bind(Category category) {
            binding.categoryName.setText(category.name);
            if (!TextUtils.isEmpty(category.url)) {
                Glide.with(binding.imageUrl.getContext())
                        .load(category.url)
                        .into(binding.imageUrl);
            } else {
                //TODO:Show placeholder image
            }

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    MealsInCategoryActivity.start(v.getContext(), category.name);
                }
            });
        }
    }
}
