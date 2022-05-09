package factoryMethod.carEx.factory;

import factoryMethod.carEx.BenzCar;
import factoryMethod.carEx.Car;

public class BenzCarFactory implements CarFactory {
    @Override
    public Car createCar(String carName) {
        return new BenzCar(carName);
    }
}
