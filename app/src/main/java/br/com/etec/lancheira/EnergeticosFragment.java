package br.com.etec.lancheira;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EnergeticosFragment extends Fragment {
    private RecyclerView recyclerView;
    private FoodItemAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_energeticos, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_energeticos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Exemplo de lista de alimentos Energéticos
        List<FoodItem> foodItems = new ArrayList<>();
        foodItems.add(new FoodItem("Pão", R.drawable.bread));
        foodItems.add(new FoodItem("Biscoito", R.drawable.cookie));
        foodItems.add(new FoodItem("Arroz", R.drawable.rice));

        adapter = new FoodItemAdapter(foodItems, foodItem -> {
            // Ação ao clicar no item
        });

        recyclerView.setAdapter(adapter);
        return view;
    }
}