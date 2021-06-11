package com.creativehub.foodfinder.feature.meals.categories;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.creativehub.foodfinder.model.Category;
import com.creativehub.foodfinder.network.MealsApiService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MealCategoriesViewModel extends ViewModel {

    private Disposable disposable;
    public final MutableLiveData<List<Category>> categoryList;
    public final MutableLiveData<Boolean> showProgressView;
    public final MutableLiveData<Boolean> showError;

    public MealCategoriesViewModel() {
        this.categoryList = new MutableLiveData<>();
        showProgressView = new MutableLiveData<>();
        showError = new MutableLiveData<>();
    }

    void getMealCategories() {
        showProgressView.setValue(true);
        disposable = MealsApiService.getInstance()
                .getMealCategories()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    showProgressView.setValue(false);
                    showError.setValue(false);
                    if (result.categories != null && !result.categories.isEmpty()) {
                        categoryList.setValue(result.categories);
                    } else {
                        //TODO:Empty list view
                    }

                }, error -> {
                    showProgressView.setValue(false);
                    showError.setValue(true);
                });
    }

    @Override
    protected void onCleared() {
        if (disposable != null) {
            disposable.dispose();
        }
        super.onCleared();
    }
}
