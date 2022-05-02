package factoryMethod.typeEx.applyFactory;

import factoryMethod.typeEx.type.Type;

public class ClassA {
    public Type createType(String type){
        TypeFactory factory = new TypeFactory();
        Type returnType = factory.createType(type);

        return returnType;
    }
}