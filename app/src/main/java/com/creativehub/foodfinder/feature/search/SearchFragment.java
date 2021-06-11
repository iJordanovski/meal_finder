package com.creativehub.foodfinder.feature.search;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativehub.foodfinder.R;
import com.creativehub.foodfinder.databinding.FragmentSearchBinding;
import com.creativehub.foodfinder.model.Meal;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    private SearchMealAdapter adapter;
    private FragmentSearchBinding binding;
    private SearchViewModel viewModel;
    private Snackbar snackbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SearchViewModel.class);
        setupUi();
        setupObservers();
    }

    private void setupUi() {
        adapter = new SearchMealAdapter();
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        binding.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(!newText.isEmpty()) {
                    viewModel.searchMeals(newText);
                } else {
                    adapter.addAll(new ArrayList<>());
                }

                return false;
            }
        });
    }

    private void setupObservers() {
        viewModel.meals.observe(getViewLifecycleOwner(),mealList -> {
            adapter.addAll(mealList);
        });
        viewModel.showError.observe(getViewLifecycleOwner(),showError -> {
            if (showError) {
                if (snackbar == null) {
                    snackbar = Snackbar.make(binding.getRoot(),"Something went wrong,try again", BaseTransientBottomBar.LENGTH_INDEFINITE);
                    snackbar.setAction("retry", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            viewModel.searchMeals(binding.search.getQuery().toString());
                            snackbar.dismiss();
                        }
                    });
                }
                snackbar.show();

            } else {
                if(snackbar != null && snackbar.isShown()) {
                    snackbar.dismiss();
                }

            }
        });
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}