package com.example.carsafety.abstractfactory;

public class AbstractFactoryDemo {
    public static void run() {
        DrivingProfile selectedProfile = DrivingProfile.HIGHWAY;
        SafetyPackageFactory factory = SafetyPackageSelector.chooseFactory(selectedProfile);

        CarSafetyController controller = new CarSafetyController(factory);
        System.out.println(controller.activate());
    }
}

enum DrivingProfile {
    HIGHWAY,
    CITY
}

interface Sensor {
    String scan();
}

interface WarningDevice {
    String warn();
}

interface SafetyPackageFactory {
    Sensor createSensor();

    WarningDevice createWarningDevice();
}

class HighwaySensor implements Sensor {
    @Override
    public String scan() {
        return "Highway sensor scans fast traffic with long-range radar.";
    }
}

class HighwayWarningDevice implements WarningDevice {
    @Override
    public String warn() {
        return "Highway warning shows early lane and distance alerts.";
    }
}

class CitySensor implements Sensor {
    @Override
    public String scan() {
        return "City sensor scans pedestrians, curbs, and cyclists.";
    }
}

class CityWarningDevice implements WarningDevice {
    @Override
    public String warn() {
        return "City warning plays close-obstacle audio alerts.";
    }
}

class HighwaySafetyFactory implements SafetyPackageFactory {
    @Override
    public Sensor createSensor() {
        return new HighwaySensor();
    }

    @Override
    public WarningDevice createWarningDevice() {
        return new HighwayWarningDevice();
    }
}

class CitySafetyFactory implements SafetyPackageFactory {
    @Override
    public Sensor createSensor() {
        return new CitySensor();
    }

    @Override
    public WarningDevice createWarningDevice() {
        return new CityWarningDevice();
    }
}

class SafetyPackageSelector {
    static SafetyPackageFactory chooseFactory(DrivingProfile profile) {
        switch (profile) {
            case HIGHWAY:
                return new HighwaySafetyFactory();
            case CITY:
                return new CitySafetyFactory();
            default:
                throw new IllegalArgumentException("Unsupported profile: " + profile);
        }
    }
}

class CarSafetyController {
    private final Sensor sensor;
    private final WarningDevice warningDevice;

    CarSafetyController(SafetyPackageFactory factory) {
        this.sensor = factory.createSensor();
        this.warningDevice = factory.createWarningDevice();
    }

    String activate() {
        return sensor.scan()
                + System.lineSeparator()
                + warningDevice.warn();
    }
}
