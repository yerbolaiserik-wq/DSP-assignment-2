# Assignment 2 Design Patterns

## Theme

This project uses a car safety system theme.

The code is simplified into only a few Java files, but it still shows the required pattern
parts: interfaces, concrete products, creators, factories, and a client.

## How to run

From the project root:

```powershell
powershell -ExecutionPolicy Bypass -File .\scripts\run.ps1
```

Main class:

```text
com.example.carsafety.Main
```

## Part A Factory Method

File:

```text
src/main/java/com/example/carsafety/factorymethod/FactoryMethodDemo.java
```

Product interface:

```text
SafetyAlert
```

Concrete products:

```text
CollisionAlert
LaneAlert
BlindSpotAlert
```

Abstract creator:

```text
SafetyCheckCreator
```

Concrete creators:

```text
CollisionCheckCreator
LaneCheckCreator
BlindSpotCheckCreator
```

Why this is Factory Method:

`SafetyCheckCreator` has the business method `runCheck(...)`, but it does not directly
choose a concrete alert. It calls the factory method `createAlert()`. Each subclass
overrides that method and returns a different `SafetyAlert`.

## Part B Abstract Factory

File:

```text
src/main/java/com/example/carsafety/abstractfactory/AbstractFactoryDemo.java
```

Abstract product interfaces:

```text
Sensor
WarningDevice
```

Abstract factory:

```text
SafetyPackageFactory
```

Concrete factories:

```text
HighwaySafetyFactory
CitySafetyFactory
```

Client:

```text
CarSafetyController
```

Why this is Abstract Factory:

The client receives a `SafetyPackageFactory` object. It uses that factory to create a
compatible family of products: a `Sensor` and a `WarningDevice`. If the selected factory
is `HighwaySafetyFactory`, both products are highway-style. If the selected factory is
`CitySafetyFactory`, both products are city-style.

The family is selected in exactly one place:

```text
SafetyPackageSelector.chooseFactory(...)
```

## Main difference

Factory Method creates one product type:

```text
SafetyAlert
```

Abstract Factory creates a family of related product types:

```text
Sensor + WarningDevice
```

Factory Method uses inheritance because subclasses override `createAlert()`.

Abstract Factory uses composition because `CarSafetyController` receives a factory object
in its constructor.

## SOLID notes

Open/Closed Principle:

You can add a new safety alert by creating a new `SafetyAlert` class and a new
`SafetyCheckCreator` subclass. The business logic in `SafetyCheckCreator.runCheck(...)`
does not need to change.

Single Responsibility Principle:

Each class has one job. Alerts describe alert messages. Creators decide which alert to
create. Factories create matching safety components. The controller uses the components
through interfaces.

## Drawback

These patterns are useful when creation logic changes often. They can be too much if the
program is very small and only creates one or two simple objects.
