package br.com.etec.lancheira;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.ViewHolder> {

    private final List<FoodItem> foodItemList;
    private final FoodItemViewModel foodItemViewModel;

    public FoodItemAdapter(List<FoodItem> foodItemList, FoodItemViewModel foodItemViewModel) {
        this.foodItemList = foodItemList;
        this.foodItemViewModel = foodItemViewModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodItem foodItem = foodItemList.get(position);
        holder.bind(foodItem);

        holder.itemView.setOnClickListener(v -> {
            foodItemViewModel.selectItem(foodItem);
        });
    }

    @Override
    public int getItemCount() {
        return foodItemList.size();
    }

    public void updateFoodItems(List<FoodItem> newItems) {
        foodItemList.clear();
        foodItemList.addAll(newItems);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(FoodItem foodItem) {
            // Implementar binding de dados para os itens de alimentos
        }
    }
}