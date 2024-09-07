package br.com.etec.lancheira;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.FoodViewHolder> {

    private final List<FoodItem> foodItemList;
    private final List<FoodItem> selectedItems;

    public FoodItemAdapter(List<FoodItem> foodItemList, List<FoodItem> selectedItems) {
        this.foodItemList = foodItemList;
        this.selectedItems = selectedItems;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item_layout, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        FoodItem foodItem = foodItemList.get(position);
        holder.foodName.setText(foodItem.getName());
        holder.foodImage.setImageResource(foodItem.getImageResource());

        holder.itemView.setOnClickListener(v -> {
            if (!selectedItems.contains(foodItem)) {
                selectedItems.add(foodItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodItemList.size();
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {

        TextView foodName;
        ImageView foodImage;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.food_name);
            foodImage = itemView.findViewById(R.id.food_image);
        }
    }
}