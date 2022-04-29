package factoryMethod.badEx;

public class Client {
    public static void main(String[] arg) {
        ClassA classA = new ClassA();

        classA.createType("A");
        classA.createType("C");
    }
}
