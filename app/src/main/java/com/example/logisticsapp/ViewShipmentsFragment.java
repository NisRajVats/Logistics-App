package com.example.logisticsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class ViewShipmentsFragment extends Fragment {
    private ListView listViewShipments;
    private TextView tvNoShipments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_view_shipments_fragment, container, false);

        listViewShipments = view.findViewById(R.id.listViewShipments);
        tvNoShipments = view.findViewById(R.id.tvNoShipments);

        displayShipments();

        return view;
    }

    private void displayShipments() {
        if (AddShipmentFragment.shipments.isEmpty()) {
            tvNoShipments.setVisibility(View.VISIBLE);
            listViewShipments.setVisibility(View.GONE);
        } else {
            tvNoShipments.setVisibility(View.GONE);
            listViewShipments.setVisibility(View.VISIBLE);

            ArrayAdapter<Shipment> adapter = new ArrayAdapter<>(
                    requireContext(),
                    android.R.layout.simple_list_item_1,
                    AddShipmentFragment.shipments
            );
            listViewShipments.setAdapter(adapter);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        displayShipments();
    }
}
