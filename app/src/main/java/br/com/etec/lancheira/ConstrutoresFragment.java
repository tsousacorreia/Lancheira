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

public class ConstrutoresFragment extends Fragment {

    private FoodItemAdapter adapter;
    private FoodItemViewModel foodItemViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_construtores, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_construtores);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new FoodItemAdapter(new ArrayList<>(), foodItemViewModel);
        recyclerView.setAdapter(adapter);

        foodItemViewModel = new ViewModelProvider(requireActivity()).get(FoodItemViewModel.class);
        foodItemViewModel.getConstrutores().observe(getViewLifecycleOwner(), new Observer<List<FoodItem>>() {
            @Override
            public void onChanged(List<FoodItem> foodItems) {
                adapter.updateFoodItems(foodItems);
            }
        });

        return view;
    }
}