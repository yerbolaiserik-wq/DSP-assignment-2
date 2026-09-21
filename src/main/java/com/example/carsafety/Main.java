package com.example.carsafety;

import com.example.carsafety.abstractfactory.AbstractFactory;
import com.example.carsafety.factorymethod.FactoryMethod;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Factory Method ===");
        FactoryMethod.run();

        System.out.println();
        System.out.println("=== Abstract Factory ===");
        AbstractFactory.run();
    }
}
