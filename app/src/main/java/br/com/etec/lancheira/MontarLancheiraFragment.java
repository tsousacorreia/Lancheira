package br.com.etec.lancheira;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MontarLancheiraFragment extends Fragment {

    private ArrayList<FoodItem> construtores;
    private ArrayList<FoodItem> reguladores;
    private ArrayList<FoodItem> energeticos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_montar_lancheira, container, false);

        construtores = new ArrayList<>();
        reguladores = new ArrayList<>();
        energeticos = new ArrayList<>();

        ViewPager viewPager = view.findViewById(R.id.view_pager);
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());

        adapter.addFragment(new ConstrutoresFragment(construtores), "Construtores");
        adapter.addFragment(new ReguladoresFragment(reguladores), "Reguladores");
        adapter.addFragment(new EnergeticosFragment(energeticos), "Energéticos");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        Button finalizarButton = view.findViewById(R.id.btn_finalizar_lancheira);
        finalizarButton.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putParcelableArrayListExtra("construtores", construtores);
            resultIntent.putParcelableArrayListExtra("reguladores", reguladores);
            resultIntent.putParcelableArrayListExtra("energeticos", energeticos);
            resultIntent.putExtra("data_lancheira", "Data Personalizada"); // Ajustar para pegar data do usuário
            getActivity().setResult(getActivity().RESULT_OK, resultIntent);
            getActivity().finish();
        });

        return view;
    }
}
