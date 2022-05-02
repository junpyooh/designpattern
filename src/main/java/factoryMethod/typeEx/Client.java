package factoryMethod.typeEx;

import factoryMethod.typeEx.applyFactory.ClassA;

public class Client {
    public static void main(String[] arg) {
        ClassA classA = new ClassA();

        classA.createType("A");
        classA.createType("C");
    }
}
