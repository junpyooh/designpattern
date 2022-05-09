package factoryMethod.carEx.factory;

import factoryMethod.carEx.Car;

public interface CarFactory {
    Car createCar(String carName);
}