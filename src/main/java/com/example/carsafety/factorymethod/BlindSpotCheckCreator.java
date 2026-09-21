package com.example.carsafety.factorymethod;

public class BlindSpotCheckCreator extends SafetyCheckCreator {
    @Override
    protected SafetyAlert createAlert() {
        return new BlindSpotAlert();
    }
}
