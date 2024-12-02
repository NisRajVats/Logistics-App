package com.example.logisticsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class AddShipmentFragment extends Fragment {

    private EditText etShipmentId, etOrigin, etDestination, etWeight;
    private Button btnAddShipment, btnClearAllShipments;
    private TextView tvShipmentStatus;  // New TextView for displaying shipment status
    public static List<Shipment> shipments = new ArrayList<>();

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_add_shipment_fragment, container, false);

        etShipmentId = view.findViewById(R.id.etShipmentId);
        etOrigin = view.findViewById(R.id.etOrigin);
        etDestination = view.findViewById(R.id.etDestination);
        etWeight = view.findViewById(R.id.etWeight);
        btnAddShipment = view.findViewById(R.id.btnAddShipment);
        btnClearAllShipments = view.findViewById(R.id.btnClearAllShipments);  // New button for clearing all shipments
        tvShipmentStatus = view.findViewById(R.id.tvShipmentStatus);  // New TextView for shipment status

        btnAddShipment.setOnClickListener(v -> addShipment());
        btnClearAllShipments.setOnClickListener(v -> clearAllShipments());  // Set listener to clear all shipments

        return view;
    }

    private void addShipment() {
        String shipmentId = etShipmentId.getText().toString().trim();
        String origin = etOrigin.getText().toString().trim();
        String destination = etDestination.getText().toString().trim();
        String weightString = etWeight.getText().toString().trim();

        if (shipmentId.isEmpty() || origin.isEmpty() || destination.isEmpty() || weightString.isEmpty()) {
            Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        double weight = 0;
        try {
            weight = Double.parseDouble(weightString);
        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Invalid weight input", Toast.LENGTH_SHORT).show();
            return;
        }

        Shipment shipment = new Shipment(shipmentId, origin, destination, weight);
        shipments.add(shipment);

        updateShipmentStatus();  // Update shipment status after adding a shipment
        clearFields();
        Toast.makeText(getContext(), "Shipment Added Successfully", Toast.LENGTH_SHORT).show();
    }

    private void clearAllShipments() {
        shipments.clear();
        updateShipmentStatus();  // Update shipment status after clearing
        Toast.makeText(getContext(), "All Shipments Cleared", Toast.LENGTH_SHORT).show();
    }

    private void updateShipmentStatus() {
        // Update the TextView with the current number of shipments
        tvShipmentStatus.setText("Total Shipments: " + shipments.size());
    }

    private void clearFields() {
        etShipmentId.setText("");
        etOrigin.setText("");
        etDestination.setText("");
        etWeight.setText("");
    }
}
