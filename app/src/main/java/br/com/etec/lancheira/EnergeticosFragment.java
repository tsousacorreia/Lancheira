package br.com.etec.lancheira;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class EnergeticosFragment extends Fragment {

    private FoodItemAdapter adapter;
    private FoodItemViewModel foodItemViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_energeticos, container, false);

        // Inicializando o ViewModel antes de usá-lo no adapter
        foodItemViewModel = new ViewModelProvider(requireActivity()).get(FoodItemViewModel.class);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_energeticos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Inicializando o adapter depois de inicializar o ViewModel
        adapter = new FoodItemAdapter(new ArrayList<>(), foodItemViewModel);
        recyclerView.setAdapter(adapter);

        // Observa as mudanças na lista de construtores
        foodItemViewModel.getEnergeticos().observe(getViewLifecycleOwner(), new Observer<ApiResponse<List<FoodItem>>>() {
            @Override
            public void onChanged(ApiResponse<List<FoodItem>> response) {
                if (response != null && response.getData() != null) {
                    adapter.updateFoodItems(response.getData());
                } else {
                    // Pode mostrar uma mensagem de erro ou lidar com o caso de erro aqui
                    // Exemplo: Log.e("ConstrutoresFragment", "Falha ao carregar construtores");
                }
            }
        });

        return view;
    }
}