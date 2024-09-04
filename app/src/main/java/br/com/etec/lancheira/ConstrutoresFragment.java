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

public class ConstrutoresFragment extends Fragment {
    private RecyclerView recyclerView;
    private FoodItemAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_construtores, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_construtores);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Exemplo de lista de alimentos Construtores
        List<FoodItem> foodItems = new ArrayList<>();
        foodItems.add(new FoodItem("Iogurte", R.drawable.yogurt));
        foodItems.add(new FoodItem("Carne", R.drawable.meat));
        foodItems.add(new FoodItem("Queijo", R.drawable.cheese));

        adapter = new FoodItemAdapter(foodItems, foodItem -> {
            // Ação ao clicar no item
        });

        recyclerView.setAdapter(adapter);
        return view;
    }
}