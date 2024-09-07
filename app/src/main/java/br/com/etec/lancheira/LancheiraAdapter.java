package br.com.etec.lancheira;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LancheiraAdapter extends RecyclerView.Adapter<LancheiraAdapter.LancheiraViewHolder> {
    private ArrayList<Lancheira> lancheiras;

    public LancheiraAdapter(ArrayList<Lancheira> lancheiras) {
        this.lancheiras = lancheiras;
    }

    @Override
    public LancheiraViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lancheira_layout, parent, false);
        return new LancheiraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LancheiraViewHolder holder, int position) {
        Lancheira lancheira = lancheiras.get(position);
        holder.bind(lancheira);
    }

    @Override
    public int getItemCount() {
        return lancheiras.size();
    }

    public static class LancheiraViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public LancheiraViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.lancheira_data);
        }

        public void bind(Lancheira lancheira) {
            textView.setText(lancheira.toString()); // Customize this as needed
        }
    }
}