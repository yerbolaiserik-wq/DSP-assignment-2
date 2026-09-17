package com.example.carsafety.factorymethod;

import java.util.Arrays;
import java.util.List;

public class FactoryMethodDemo {
    public static void run() {
        DrivingSituation situation = new DrivingSituation("A12 Expressway", 92, "rainy");

        List<SafetyCheckCreator> checks = Arrays.asList(
                new CollisionCheckCreator(),
                new LaneCheckCreator(),
                new BlindSpotCheckCreator()
        );

        for (SafetyCheckCreator check : checks) {
            System.out.println(check.runCheck(situation));
        }
    }
}

class DrivingSituation {
    private final String roadName;
    private final int speedKph;
    private final String weather;

    DrivingSituation(String roadName, int speedKph, String weather) {
        this.roadName = roadName;
        this.speedKph = speedKph;
        this.weather = weather;
    }

    String getRoadName() {
        return roadName;
    }

    int getSpeedKph() {
        return speedKph;
    }

    String getWeather() {
        return weather;
    }
}

interface SafetyAlert {
    String name();

    String messageFor(DrivingSituation situation);
}

class CollisionAlert implements SafetyAlert {
    @Override
    public String name() {
        return "Forward Collision Warning";
    }

    @Override
    public String messageFor(DrivingSituation situation) {
        if (situation.getSpeedKph() > 70) {
            return "slow down on " + situation.getRoadName() + " and prepare braking";
        }
        return "keep watching the car ahead";
    }
}

class LaneAlert implements SafetyAlert {
    @Override
    public String name() {
        return "Lane Departure Warning";
    }

    @Override
    public String messageFor(DrivingSituation situation) {
        return "watch lane markings in " + situation.getWeather() + " weather";
    }
}

class BlindSpotAlert implements SafetyAlert {
    @Override
    public String name() {
        return "Blind Spot Monitor";
    }

    @Override
    public String messageFor(DrivingSituation situation) {
        return "check side radar before changing lanes";
    }
}

abstract class SafetyCheckCreator {
    protected abstract SafetyAlert createAlert();

    String runCheck(DrivingSituation situation) {
        SafetyAlert alert = createAlert();
        return alert.name() + ": " + alert.messageFor(situation);
    }
}

class CollisionCheckCreator extends SafetyCheckCreator {
    @Override
    protected SafetyAlert createAlert() {
        return new CollisionAlert();
    }
}

class LaneCheckCreator extends SafetyCheckCreator {
    @Override
    protected SafetyAlert createAlert() {
        return new LaneAlert();
    }
}

class BlindSpotCheckCreator extends SafetyCheckCreator {
    @Override
    protected SafetyAlert createAlert() {
        return new BlindSpotAlert();
    }
}
