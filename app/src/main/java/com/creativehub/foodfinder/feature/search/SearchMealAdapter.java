package com.creativehub.foodfinder.feature.search;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.creativehub.foodfinder.R;
import com.creativehub.foodfinder.databinding.ItemSearchMealBinding;
import com.creativehub.foodfinder.feature.details.MealDetailsActivity;
import com.creativehub.foodfinder.feature.youtubevideo.YoutubeVideoActivity;
import com.creativehub.foodfinder.model.Meal;

import java.util.ArrayList;
import java.util.List;

public class SearchMealAdapter extends RecyclerView.Adapter<SearchMealAdapter.SearchMealViewHolder> {

    private final List<Meal> meals;

    public SearchMealAdapter() {
        this.meals = new ArrayList<>();
    }

    public void addAll(List<Meal> mealList) {
        meals.clear();
        meals.addAll(mealList);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public SearchMealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSearchMealBinding binding = ItemSearchMealBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new SearchMealViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchMealViewHolder holder, int position) {
        holder.bind(meals.get(position));
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    static class SearchMealViewHolder extends RecyclerView.ViewHolder {

        private ItemSearchMealBinding binding;

        public SearchMealViewHolder(@NonNull ItemSearchMealBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
        public void bind(Meal meal) {
            binding.mealName.setText(meal.name);
            binding.area.setText(meal.area);
            binding.category.setText(meal.category);
            binding.tags.setText(meal.tag);
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO:Open details screen
                    MealDetailsActivity.start(v.getContext(),meal.id);
                }
            });
            binding.video.setVisibility(TextUtils.isEmpty(meal.videoUrl) ? View.INVISIBLE : View.VISIBLE );
            binding.video.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    YoutubeVideoActivity.start(v.getContext(),meal.videoUrl);
                }
            });
            if (TextUtils.isEmpty(meal.imageUrl))  {
                //TODO: Add placeholder image
            } else  {
                Glide.with(binding.image.getContext())
                        .load(meal.imageUrl)
                        .into(binding.image);
            }

        }
    }


}
