package com.creativehub.foodfinder.feature.meals.categories;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativehub.foodfinder.R;
import com.creativehub.foodfinder.databinding.FragmentMealCategoriesBinding;
import com.creativehub.foodfinder.model.Category;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MealCategoriesFragment extends Fragment {
    private FragmentMealCategoriesBinding binding;
    private MealCategoriesAdapter adapter;
    private MealCategoriesViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMealCategoriesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MealCategoriesViewModel.class);
        setupUi();
        setupObservers();
        viewModel.getMealCategories();
    }

    private void setupUi() {
        adapter = new MealCategoriesAdapter();
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

    }

    private void setupObservers() {
        viewModel.showError.observe(getViewLifecycleOwner(), showError -> {
            if (showError) {
                Snackbar snackbar = Snackbar.make(binding.getRoot(), getString(R.string.default_error_msg), BaseTransientBottomBar.LENGTH_SHORT);
                snackbar.setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewModel.getMealCategories();
                        snackbar.dismiss();
                    }
                })
                .show();
            }
        });
        viewModel.showProgressView.observe(getViewLifecycleOwner(),showProgress ->{
            if (showProgress) {
                binding.progressView.getRoot().setVisibility(View.VISIBLE);
            } else {
                binding.progressView.getRoot().setVisibility(View.INVISIBLE);
            }
        });
        viewModel.categoryList.observe(getViewLifecycleOwner(),categoryList -> {
            adapter.addAll(categoryList);
        });
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}