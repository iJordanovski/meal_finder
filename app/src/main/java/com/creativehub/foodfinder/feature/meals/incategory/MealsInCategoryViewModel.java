package com.creativehub.foodfinder.feature.meals.incategory;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.creativehub.foodfinder.model.MealInCategory;
import com.creativehub.foodfinder.network.MealsApiService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MealsInCategoryViewModel extends ViewModel {
    private Disposable disposable;
    public MutableLiveData<Boolean> showError;
    public MutableLiveData<List<MealInCategory>> mealCategoryList;

    public MealsInCategoryViewModel() {
        this.mealCategoryList = new MutableLiveData<>();
        this.showError = new MutableLiveData<>();
    }

    public void getMealsByCategory(String categoryName) {
        disposable = MealsApiService.getInstance()
                .getMealByCategory(categoryName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    showError.setValue(false);
                    mealCategoryList.setValue(result.mealInCategories);
                    Log.d("success", "success");
                }, error -> {
                    showError.setValue(true);
                    Log.e("error", "error");
                });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null){
            disposable.dispose();
        }
    }
}
