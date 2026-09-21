package com.example.carsafety.abstractfactory;

public class AbstractFactoryDemo {
    public static void run() {
        DrivingProfile selectedProfile = DrivingProfile.HIGHWAY;
        SafetyPackageFactory factory = SafetyPackageSelector.chooseFactory(selectedProfile);

        CarSafetyController controller = new CarSafetyController(factory);
        System.out.println(controller.activate());
    }
}
