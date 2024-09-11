package br.com.etec.lancheira;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

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

        // Adicionar funcionalidade para quando o botão "Adicionar" for clicado
        holder.addButton.setOnClickListener(v -> {
            // Aqui você pode definir o que acontece quando o botão "Adicionar" for clicado
            foodItemViewModel.selectItem(foodItem);  // Exemplo: adicionar o item selecionado à lancheira
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

        private final TextView foodName;
        private final TextView foodDescription;
        private final ImageView foodImage;
        private final Button addButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.text_food_name);
            foodDescription = itemView.findViewById(R.id.text_food_description);
            foodImage = itemView.findViewById(R.id.image_food);
            addButton = itemView.findViewById(R.id.button_add_food);
        }

        public void bind(FoodItem foodItem) {
            // Definir o nome e a descrição
            foodName.setText(foodItem.getNome());
            foodDescription.setText(foodItem.getDescricao());

            // Carregar a imagem do alimento usando Glide
            Glide.with(itemView.getContext())
                    .load(foodItem.getImagemUrl())  // URL da imagem do alimento
                    .placeholder(R.drawable.placeholder_image)  // Imagem de placeholder
                    .error(R.drawable.error_image)  // Imagem em caso de erro
                    .into(foodImage);  // Carregar a imagem na ImageView
        }
    }
}