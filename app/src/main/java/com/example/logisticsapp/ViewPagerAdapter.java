package com.example.logisticsapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();

    // Constructor
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        // Initialize the list of fragments
        fragmentList.add(new AddShipmentFragment());
        fragmentList.add(new ViewShipmentsFragment());
        fragmentList.add(new TrackingFragment());
        fragmentList.add(new WebViewFragment());  // Add the WebViewFragment for the logistics website
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Return the fragment based on the position from the list
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size(); // Dynamically return the number of fragments
    }

    // Method to add a fragment (useful for adding fragments in the future)
    public void addFragment(Fragment fragment) {
        fragmentList.add(fragment);
        notifyDataSetChanged();  // Notify the adapter that data has changed
    }

    // Method to remove a fragment (useful if you want to remove fragments dynamically)
    public void removeFragment(int position) {
        if (position >= 0 && position < fragmentList.size()) {
            fragmentList.remove(position);
            notifyDataSetChanged();  // Notify the adapter that data has changed
        }
    }
}
