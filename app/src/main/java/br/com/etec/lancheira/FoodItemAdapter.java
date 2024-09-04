package br.com.etec.lancheira;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.FoodItemViewHolder> {
    private final List<FoodItem> foodItemList;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(FoodItem item);
    }

    public FoodItemAdapter(List<FoodItem> foodItemList, OnItemClickListener listener) {
        this.foodItemList = foodItemList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FoodItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_layout, parent, false);
        return new FoodItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodItemViewHolder holder, int position) {
        holder.bind(foodItemList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return foodItemList.size();
    }

    static class FoodItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView foodName;
        private final ImageView foodImage;

        public FoodItemViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.food_name);
            foodImage = itemView.findViewById(R.id.food_image);
        }

        public void bind(final FoodItem item, final OnItemClickListener listener) {
            foodName.setText(item.getName());
            foodImage.setImageResource(item.getImageResourceId());
            itemView.setOnClickListener(v -> listener.onItemClick(item));
        }
    }
}