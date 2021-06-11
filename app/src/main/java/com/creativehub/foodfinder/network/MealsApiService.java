package com.creativehub.foodfinder.network;

import com.creativehub.foodfinder.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MealsApiService {
    private static MealsApi mealsApi;
    private static final String BASE_URL = "https://www.themealdb.com/";

    private MealsApiService() {}

    public static MealsApi getInstance(){
        if (mealsApi == null) {
            mealsApi = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getHttpClient())
                    .build()
                    .create(MealsApi.class);
        }
        return mealsApi;
    }

    private static OkHttpClient getHttpClient() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClientBuilder.addInterceptor(interceptor);
        }
        return okHttpClientBuilder.build();
    }
}
