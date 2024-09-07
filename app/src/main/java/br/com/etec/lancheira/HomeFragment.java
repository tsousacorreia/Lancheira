package br.com.etec.lancheira;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private LancheiraAdapter lancheiraAdapter;
    private ArrayList<Lancheira> lancheiraList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_lancheiras);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        lancheiraList = new ArrayList<>();
        lancheiraAdapter = new LancheiraAdapter(lancheiraList);
        recyclerView.setAdapter(lancheiraAdapter);

        view.findViewById(R.id.btn_adicionar_lancheira).setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MontarLancheiraFragment.class);
            startActivityForResult(intent, 1);
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == getActivity().RESULT_OK && data != null) {
            ArrayList<FoodItem> construtores = data.getParcelableArrayListExtra("construtores");
            ArrayList<FoodItem> reguladores = data.getParcelableArrayListExtra("reguladores");
            ArrayList<FoodItem> energeticos = data.getParcelableArrayListExtra("energeticos");

            String dataLancheira = data.getStringExtra("data_lancheira");

            Lancheira lancheira = new Lancheira(construtores, reguladores, energeticos, dataLancheira);
            lancheiraList.add(lancheira);
            lancheiraAdapter.notifyDataSetChanged();
        }
    }
}
