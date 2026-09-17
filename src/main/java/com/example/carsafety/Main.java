package com.example.carsafety;

import com.example.carsafety.abstractfactory.AbstractFactoryDemo;
import com.example.carsafety.factorymethod.FactoryMethodDemo;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Factory Method ===");
        FactoryMethodDemo.run();

        System.out.println();
        System.out.println("=== Abstract Factory ===");
        AbstractFactoryDemo.run();
    }
}
