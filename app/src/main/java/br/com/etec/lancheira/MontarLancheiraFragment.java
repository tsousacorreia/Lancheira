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
    private ArrayList<FoodItem> selectedItems;
    private FoodItemViewModel foodItemViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_montar_lancheira, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_lancheira);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        selectedItems = new ArrayList<>();
        adapter = new FoodItemAdapter(new ArrayList<>(), foodItemViewModel);
        recyclerView.setAdapter(adapter);

        foodItemViewModel = new ViewModelProvider(requireActivity()).get(FoodItemViewModel.class);

        foodItemViewModel.getSelectedItems().observe(getViewLifecycleOwner(), new Observer<List<FoodItem>>() {
            @Override
            public void onChanged(List<FoodItem> foodItems) {
                adapter.updateFoodItems(foodItems);
            }
        });

        Button buttonFinalizar = view.findViewById(R.id.button_finalizar);
        buttonFinalizar.setOnClickListener(v -> {
            if (!selectedItems.isEmpty()) {
                Toast.makeText(getContext(), "Lancheira montada com sucesso!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Selecione ao menos um alimento para a lancheira", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}