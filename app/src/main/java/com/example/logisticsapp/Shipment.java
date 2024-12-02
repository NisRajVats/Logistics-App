package com.example.logisticsapp;

public class Shipment {
    private String shipmentId;
    private String origin;
    private String destination;
    private double weight;

    // Constructor
    public Shipment(String shipmentId, String origin, String destination, double weight) {
        this.shipmentId = shipmentId;
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
    }

    // Getters and Setters
    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Shipment ID: " + shipmentId + "\nOrigin: " + origin + "\nDestination: " + destination + "\nWeight: " + weight + " kg";
    }
}
