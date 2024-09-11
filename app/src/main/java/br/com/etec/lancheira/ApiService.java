package br.com.etec.lancheira;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    // Construtores
    @GET("api/Api.php?apicall=getConstrutores")
    Call<ApiResponse<List<FoodItem>>> getConstrutores();

    // Reguladores
    @GET("api/Api.php?apicall=getReguladores")
    Call<ApiResponse<List<FoodItem>>> getReguladores();

    // Energéticos
    @GET("api/Api.php?apicall=getEnergeticos")
    Call<ApiResponse<List<FoodItem>>> getEnergeticos();
}