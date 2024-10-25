package com.example.commande;

public class Car {
    private String plateNumber;
    private String brand;
    private double price;
    private boolean rented;

    // Constructeur
    public Car(String plateNumber, String brand, double price) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
        this.rented = false;
    }

    // Getters
    public String getPlateNumber() {
        return plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public boolean getRented() {
        return rented;
    }

    // Setters
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}
