package com.example.carsafety.factorymethod;

public class CollisionCheckCreator extends SafetyCheckCreator {
    @Override
    protected SafetyAlert createAlert() {
        return new CollisionAlert();
    }
}
