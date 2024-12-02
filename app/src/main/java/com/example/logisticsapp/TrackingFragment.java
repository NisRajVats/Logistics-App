package com.example.logisticsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class TrackingFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tracking_fragment, container, false);

        TextView tvTrackingInfo = view.findViewById(R.id.tvTrackingInfo);
        tvTrackingInfo.setText(getString(R.string.tracking_info));

        return view;
    }
}
