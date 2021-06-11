package com.creativehub.foodfinder.feature.search;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.creativehub.foodfinder.model.Meal;
import com.creativehub.foodfinder.network.MealsApiService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SearchViewModel extends ViewModel {
    private Disposable disposable;
    public final MutableLiveData<List<Meal>> meals;
    public final MutableLiveData<Boolean> showError;

    public SearchViewModel() {
        this.meals = new MutableLiveData<>();
        showError = new MutableLiveData<>();
    }

    protected void searchMeals(String mealName) {
        disposable = MealsApiService.getInstance()
                .searchMeals(mealName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mealsResponse -> {
                    if (mealsResponse != null && mealsResponse.meals != null) {
                        meals.setValue(mealsResponse.meals);
                    }
                    showError.setValue(false);
                }, error -> {
                    showError.setValue(true);
                });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
