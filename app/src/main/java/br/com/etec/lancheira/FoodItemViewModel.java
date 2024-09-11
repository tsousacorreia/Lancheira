package br.com.etec.lancheira;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class FoodItemViewModel extends AndroidViewModel {

    private final FoodItemRepository repository;
    private LiveData<List<FoodItem>> construtores;
    private LiveData<List<FoodItem>> reguladores;
    private LiveData<List<FoodItem>> energeticos;

    // Lógica para selecionar alimentos para a lancheira
    private final MutableLiveData<List<FoodItem>> selectedItems = new MutableLiveData<>(new ArrayList<>());

    public FoodItemViewModel(@NonNull Application application) {
        super(application);
        repository = new FoodItemRepository(application);
        // Chama o repositório para buscar os alimentos
        loadConstrutores();
        loadReguladores();
        loadEnergeticos();
    }

    // Carrega construtores chamando o repositório e observando as mudanças
    private void loadConstrutores() {
        construtores = repository.getConstrutores();
    }

    // Carrega reguladores chamando o repositório e observando as mudanças
    private void loadReguladores() {
        reguladores = repository.getReguladores();
    }

    // Carrega energéticos chamando o repositório e observando as mudanças
    private void loadEnergeticos() {
        energeticos = repository.getEnergeticos();
    }

    // Expor construtores para a UI
    public LiveData<List<FoodItem>> getConstrutores() {
        return construtores;
    }

    // Expor reguladores para a UI
    public LiveData<List<FoodItem>> getReguladores() {
        return reguladores;
    }

    // Expor energéticos para a UI
    public LiveData<List<FoodItem>> getEnergeticos() {
        return energeticos;
    }

    // Retorna os itens selecionados
    public LiveData<List<FoodItem>> getSelectedItems() {
        return selectedItems;
    }

    // Seleciona um item de alimento e adiciona à lista de itens selecionados
    public void selectItem(FoodItem item) {
        List<FoodItem> currentItems = selectedItems.getValue();
        if (currentItems != null) {
            currentItems.add(item);
            selectedItems.setValue(currentItems);
        }
    }

    // Remove um item de alimento da lista de selecionados
    public void removeItem(FoodItem item) {
        List<FoodItem> currentItems = selectedItems.getValue();
        if (currentItems != null) {
            currentItems.remove(item);
            selectedItems.setValue(currentItems);
        }
    }
}