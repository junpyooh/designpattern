package factoryMethod.carEx.factory;

import factoryMethod.carEx.Car;
import factoryMethod.carEx.VolkswagenCar;

public class VolkswagenCarFactory implements CarFactory {
    @Override
    public Car createCar(String carName) {
        return new VolkswagenCar(carName);
    }
}