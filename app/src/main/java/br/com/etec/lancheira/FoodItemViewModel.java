package br.com.etec.lancheira;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class FoodItemViewModel extends ViewModel {

    private FoodItemRepository repository;
    private MutableLiveData<List<FoodItem>> construtores;
    private MutableLiveData<List<FoodItem>> reguladores;
    private MutableLiveData<List<FoodItem>> energeticos;

    public FoodItemViewModel() {
        repository = new FoodItemRepository();
    }

    public LiveData<List<FoodItem>> getConstrutores() {
        if (construtores == null) {
            construtores = repository.getConstrutores();
        }
        return construtores;
    }

    public LiveData<List<FoodItem>> getReguladores() {
        if (reguladores == null) {
            reguladores = repository.getReguladores();
        }
        return reguladores;
    }

    public LiveData<List<FoodItem>> getEnergeticos() {
        if (energeticos == null) {
            energeticos = repository.getEnergeticos();
        }
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