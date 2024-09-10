package br.com.etec.lancheira;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class FoodItemRepository {

    private ApiService apiService;
    private MutableLiveData<List<FoodItem>> allFoodItems;

    public FoodItemRepository(Application application) {
        apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
        allFoodItems = new MutableLiveData<>();
    }

    public LiveData<List<FoodItem>> getConstrutores() {
        apiService.getConstrutores("getConstrutores").enqueue(new Callback<List<FoodItem>>() {
            @Override
            public void onResponse(Call<List<FoodItem>> call, Response<List<FoodItem>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    allFoodItems.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<FoodItem>> call, Throwable t) {
                // Handle failure
            }
        });
        return allFoodItems;
    }

    public LiveData<List<FoodItem>> getReguladores() {
        apiService.getReguladores("getReguladores").enqueue(new Callback<List<FoodItem>>() {
            @Override
            public void onResponse(Call<List<FoodItem>> call, Response<List<FoodItem>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    allFoodItems.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<FoodItem>> call, Throwable t) {
                // Handle failure
            }
        });
        return allFoodItems;
    }

    public LiveData<List<FoodItem>> getEnergeticos() {
        apiService.getEnergeticos("getEnergeticos").enqueue(new Callback<List<FoodItem>>() {
            @Override
            public void onResponse(Call<List<FoodItem>> call, Response<List<FoodItem>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    allFoodItems.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<FoodItem>> call, Throwable t) {
                // Handle failure
            }
        });
        return allFoodItems;
    }
}