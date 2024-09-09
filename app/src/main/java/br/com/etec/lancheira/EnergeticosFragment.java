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

public class EnergeticosFragment extends Fragment {

    private List<FoodItem> foodItems;
    private ArrayList<FoodItem> selectedItems;

    public EnergeticosFragment(ArrayList<FoodItem> selectedItems) {
        this.selectedItems = selectedItems;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_energeticos, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_energeticos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        // Lista de alimentos Energéticos
        List<FoodItem> foodItems = new ArrayList<>();
        foodItems.add(new FoodItem("Pão", R.drawable.bread));
        foodItems.add(new FoodItem("Biscoito", R.drawable.cookie));
        foodItems.add(new FoodItem("Arroz", R.drawable.rice));

        FoodItemAdapter adapter = new FoodItemAdapter(foodItems, selectedItems);
        recyclerView.setAdapter(adapter);

        return view;
    }
}