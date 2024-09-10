package br.com.etec.lancheira;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface ApiService {

    @GET("Api.php")
    Call<List<FoodItem>> getConstrutores(@Query("apicall") String apicall);

    @GET("Api.php")
    Call<List<FoodItem>> getReguladores(@Query("apicall") String apicall);

    @GET("Api.php")
    Call<List<FoodItem>> getEnergeticos(@Query("apicall") String apicall);
}