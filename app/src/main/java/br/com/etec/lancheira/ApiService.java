package br.com.etec.lancheira;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ApiService {

    @GET("construtores")
    Call<List<FoodItem>> getConstrutores();

    @GET("reguladores")
    Call<List<FoodItem>> getReguladores();

    @GET("energeticos")
    Call<List<FoodItem>> getEnergeticos();
}