package br.com.etec.lancheira;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa o ViewPager e TabLayout
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        // Configura o AlimentosPagerAdapter e o ViewPager
        AlimentosPagerAdapter adapter = new AlimentosPagerAdapter(this);
        viewPager.setAdapter(adapter);

        // Liga o TabLayout com o ViewPager usando TabLayoutMediator
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Construtores");
                    break;
                case 1:
                    tab.setText("Reguladores");
                    break;
                case 2:
                    tab.setText("Energéticos");
                    break;
                case 3:
                    tab.setText("Montar Lancheira");
                    break;
            }
        }).attach();
    }
}