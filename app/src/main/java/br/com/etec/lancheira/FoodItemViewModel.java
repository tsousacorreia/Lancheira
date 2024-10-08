package br.com.etec.lancheira;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;
import java.util.List;

public class FoodItemViewModel extends AndroidViewModel {

    private FoodItemRepository repository;
    private LiveData<ApiResponse<List<FoodItem>>> construtores;
    private LiveData<ApiResponse<List<FoodItem>>> reguladores;
    private LiveData<ApiResponse<List<FoodItem>>> energeticos;

    public FoodItemViewModel(@NonNull Application application) {
        super(application);
        repository = new FoodItemRepository(application);
        construtores = repository.getConstrutores();
        reguladores = repository.getReguladores();
        energeticos = repository.getEnergeticos();
    }

    public LiveData<ApiResponse<List<FoodItem>>> getConstrutores() {
        return construtores;
    }

    public LiveData<ApiResponse<List<FoodItem>>> getReguladores() {
        return reguladores;
    }

    public LiveData<ApiResponse<List<FoodItem>>> getEnergeticos() {
        return energeticos;
    }

    // Lógica para selecionar alimentos para a lancheira
    private MutableLiveData<List<FoodItem>> selectedItems = new MutableLiveData<>(new ArrayList<>());

    public LiveData<List<FoodItem>> getSelectedItems() {
        return selectedItems;
    }

    public void selectItem(FoodItem item) {
        List<FoodItem> currentItems = selectedItems.getValue();
        currentItems.add(item);
        selectedItems.setValue(currentItems);
    }
}