package com.martin.training.recyclerviewchallenge;

public class Car {

    private String make, model, name, number;

    public Car(String make, String model, String name, String number) {
        this.make = make;
        this.model = model;
        this.name = name;
        this.number = number;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
