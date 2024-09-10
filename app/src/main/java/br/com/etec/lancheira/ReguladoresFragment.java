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

import java.util.ArrayList;
import java.util.List;

public class ReguladoresFragment extends Fragment {

    private RecyclerView recyclerView;
    private FoodItemAdapter adapter;
    private FoodItemViewModel foodItemViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reguladores, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_reguladores);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        foodItemViewModel = new ViewModelProvider(requireActivity()).get(FoodItemViewModel.class);

        adapter = new FoodItemAdapter(new ArrayList<>(), foodItemViewModel);
        recyclerView.setAdapter(adapter);

        foodItemViewModel.getReguladores().observe(getViewLifecycleOwner(), new Observer<List<FoodItem>>() {
            @Override
            public void onChanged(List<FoodItem> foodItems) {
                adapter.updateFoodItems(foodItems);
            }
        });

        return view;
    }
}