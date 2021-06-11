package com.creativehub.foodfinder.feature.details;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.creativehub.foodfinder.model.MealDetails;
import com.creativehub.foodfinder.network.MealsApiService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MealDetailsViewModel extends ViewModel {
    private Disposable disposable;
    public final MutableLiveData<MealDetails> mealDetails;
    public final MutableLiveData<Boolean> isLoading;
    public final MutableLiveData<Boolean> showError;

    public MealDetailsViewModel(){

        this.mealDetails = new MutableLiveData<>();
        this.isLoading = new MutableLiveData<>();
        this.showError = new MutableLiveData<>();
    }

    public void getMeals(String id){
        isLoading.setValue(true);
        disposable = MealsApiService.getInstance()
                .getMealById(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    if (result != null && !result.meals.isEmpty()) {
                        MealDetails meal = result.meals.get(0);
                        mealDetails.setValue(meal);
                    }
                    showError.setValue(false);
                    isLoading.setValue(false);

                },error -> {
                    showError.setValue(true);
                    isLoading.setValue(false);

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
