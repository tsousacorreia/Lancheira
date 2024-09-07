package br.com.etec.lancheira;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ReguladoresFragment extends Fragment {

    private List<FoodItem> foodItems;
    private ArrayList<FoodItem> selectedItems;

    public ReguladoresFragment(ArrayList<FoodItem> selectedItems) {
        this.selectedItems = selectedItems;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reguladores, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_reguladores);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        foodItems = new ArrayList<>();
        foodItems.add(new FoodItem("Iogurte", R.drawable.yogurt));
        foodItems.add(new FoodItem("Carne", R.drawable.meat));
        foodItems.add(new FoodItem("Queijo", R.drawable.cheese));

        FoodItemAdapter adapter = new FoodItemAdapter(foodItems, selectedItems);
        recyclerView.setAdapter(adapter);

        return view;
    }
}