package br.com.etec.lancheira;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class FoodItemRepository {

    private ApiService apiService;

    public FoodItemRepository() {
        apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
    }

    public MutableLiveData<List<FoodItem>> getConstrutores() {
        MutableLiveData<List<FoodItem>> data = new MutableLiveData<>();
        apiService.getConstrutores().enqueue(new Callback<List<FoodItem>>() {
            @Override
            public void onResponse(Call<List<FoodItem>> call, Response<List<FoodItem>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<FoodItem>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public MutableLiveData<List<FoodItem>> getReguladores() {
        MutableLiveData<List<FoodItem>> data = new MutableLiveData<>();
        apiService.getReguladores().enqueue(new Callback<List<FoodItem>>() {
            @Override
            public void onResponse(Call<List<FoodItem>> call, Response<List<FoodItem>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<FoodItem>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public MutableLiveData<List<FoodItem>> getEnergeticos() {
        MutableLiveData<List<FoodItem>> data = new MutableLiveData<>();
        apiService.getEnergeticos().enqueue(new Callback<List<FoodItem>>() {
            @Override
            public void onResponse(Call<List<FoodItem>> call, Response<List<FoodItem>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<FoodItem>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}