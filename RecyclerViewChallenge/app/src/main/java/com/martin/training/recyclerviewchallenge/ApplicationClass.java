package com.martin.training.recyclerviewchallenge;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    public static ArrayList<Car> cars;

    @Override
    public void onCreate() {
        super.onCreate();

        cars  = new ArrayList<Car>();
        cars.add(new Car("Mercedes", "180E", "Martin", "8293842"));
        cars.add(new Car("Volkswagen", "Beetle", "Quackle", "472938742"));
    }
}
