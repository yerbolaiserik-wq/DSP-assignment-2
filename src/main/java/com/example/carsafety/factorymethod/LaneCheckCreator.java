package com.example.carsafety.factorymethod;

public class LaneCheckCreator extends SafetyCheckCreator {
    @Override
    protected SafetyAlert createAlert() {
        return new LaneAlert();
    }
}
