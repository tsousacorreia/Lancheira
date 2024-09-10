package br.com.etec.lancheira;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class AlimentosPagerAdapter extends FragmentStateAdapter {

    public AlimentosPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new ConstrutoresFragment();
            case 1:
                return new ReguladoresFragment();
            case 2:
                return new EnergeticosFragment();
            case 3:
                return new MontarLancheiraFragment();
            default:
                throw new IllegalArgumentException("Posição inválida: " + position);
        }
    }

    @Override
    public int getItemCount() {
        return 4; // Número de abas
    }

    // Caso precise definir os títulos das abas em outro lugar
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Construtores";
            case 1:
                return "Reguladores";
            case 2:
                return "Energéticos";
            case 3:
                return "Montar Lancheira";
            default:
                throw new IllegalArgumentException("Posição inválida: " + position);
        }
    }
}