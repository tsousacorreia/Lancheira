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
        apiService = RetrofitClient.getApiService();
        allFoodItems = new MutableLiveData<>();
    }

    public LiveData<List<FoodItem>> getConstrutores() {
        apiService.getConstrutores().enqueue(new Callback<ApiResponse<List<FoodItem>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<FoodItem>>> call, Response<ApiResponse<List<FoodItem>>> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().isError()) {
                    allFoodItems.setValue(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<List<FoodItem>>> call, Throwable t) {
                // Handle failure
            }
        });
        return allFoodItems;
    }

    public LiveData<List<FoodItem>> getReguladores() {
        apiService.getReguladores().enqueue(new Callback<ApiResponse<List<FoodItem>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<FoodItem>>> call, Response<ApiResponse<List<FoodItem>>> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().isError()) {
                    allFoodItems.setValue(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<List<FoodItem>>> call, Throwable t) {
                // Handle failure
            }
        });
        return allFoodItems;
    }

    public LiveData<List<FoodItem>> getEnergeticos() {
        apiService.getEnergeticos().enqueue(new Callback<ApiResponse<List<FoodItem>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<FoodItem>>> call, Response<ApiResponse<List<FoodItem>>> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().isError()) {
                    allFoodItems.setValue(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<List<FoodItem>>> call, Throwable t) {
                // Handle failure
            }
        });
        return allFoodItems;
    }
}