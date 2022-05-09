package factoryMethod.carEx;

public abstract class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
