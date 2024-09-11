package br.com.etec.lancheira;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MontarLancheiraFragment extends Fragment {

    private RecyclerView recyclerView;
    private FoodItemAdapter adapter;
    private FoodItemViewModel foodItemViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_montar_lancheira, container, false);

        // Inicializar o ViewModel antes de usar
        foodItemViewModel = new ViewModelProvider(requireActivity()).get(FoodItemViewModel.class);

        recyclerView = view.findViewById(R.id.recycler_view_lancheira);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Inicializar o adapter com o ViewModel
        adapter = new FoodItemAdapter(new ArrayList<>(), foodItemViewModel);
        recyclerView.setAdapter(adapter);

        // Observar as mudanças na lista de itens selecionados
        foodItemViewModel.getSelectedItems().observe(getViewLifecycleOwner(), new Observer<List<FoodItem>>() {
            @Override
            public void onChanged(List<FoodItem> foodItems) {
                // Atualiza o adaptador quando os itens selecionados mudam
                adapter.updateFoodItems(foodItems);
            }
        });

        Button buttonFinalizar = view.findViewById(R.id.button_finalizar);
        buttonFinalizar.setOnClickListener(v -> {
            List<FoodItem> selectedItems = foodItemViewModel.getSelectedItems().getValue();
            if (selectedItems != null && !selectedItems.isEmpty()) {
                Toast.makeText(getContext(), "Lancheira montada com sucesso!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Selecione ao menos um alimento para a lancheira", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
