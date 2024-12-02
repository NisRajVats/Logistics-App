package com.example.logisticsapp;

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
        setContentView(R.layout.activity_main);  // Use the correct XML layout

        // Initialize ViewPager2 and TabLayout
        viewPager = findViewById(R.id.viewPager);  // Reference to ViewPager2
        tabLayout = findViewById(R.id.tabLayout);  // Reference to TabLayout

        // Set adapter for ViewPager2
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        // Link TabLayout and ViewPager2
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Add Shipment");
                    break;
                case 1:
                    tab.setText("View Shipments");
                    break;
                case 2:
                    tab.setText("Track Shipments");
                    break;
                case 3:
                    tab.setText("Logistics Website");
                    break;
            }
        }).attach();
    }
}
