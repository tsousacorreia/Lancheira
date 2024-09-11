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
    private MutableLiveData<ApiResponse<List<FoodItem>>> construtores;
    private MutableLiveData<ApiResponse<List<FoodItem>>> reguladores;
    private MutableLiveData<ApiResponse<List<FoodItem>>> energeticos;

    public FoodItemRepository(Application application) {
        apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
        construtores = new MutableLiveData<>();
        reguladores = new MutableLiveData<>();
        energeticos = new MutableLiveData<>();
    }

    public LiveData<ApiResponse<List<FoodItem>>> getConstrutores() {
        apiService.getConstrutores().enqueue(new Callback<ApiResponse<List<FoodItem>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<FoodItem>>> call, Response<ApiResponse<List<FoodItem>>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    construtores.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<List<FoodItem>>> call, Throwable t) {
                // Handle failure case here
                construtores.setValue(null);  // You can choose how to handle errors
            }
        });
        return construtores;
    }

    public LiveData<ApiResponse<List<FoodItem>>> getReguladores() {
        apiService.getReguladores().enqueue(new Callback<ApiResponse<List<FoodItem>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<FoodItem>>> call, Response<ApiResponse<List<FoodItem>>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    reguladores.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<List<FoodItem>>> call, Throwable t) {
                // Handle failure case here
                reguladores.setValue(null);  // Handle errors as needed
            }
        });
        return reguladores;
    }

    public LiveData<ApiResponse<List<FoodItem>>> getEnergeticos() {
        apiService.getEnergeticos().enqueue(new Callback<ApiResponse<List<FoodItem>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<FoodItem>>> call, Response<ApiResponse<List<FoodItem>>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    energeticos.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<List<FoodItem>>> call, Throwable t) {
                // Handle failure case here
                energeticos.setValue(null);  // Handle errors appropriately
            }
        });
        return energeticos;
    }
}