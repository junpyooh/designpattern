package factoryMethod.typeEx.unapplyFactory;

import factoryMethod.typeEx.type.Type;
import factoryMethod.typeEx.type.TypeA;
import factoryMethod.typeEx.type.TypeB;
import factoryMethod.typeEx.type.TypeC;

public class ClassA {
    public Type createType(String type) {
        Type returnType = null;
        switch (type){
            case "A":
                returnType = new TypeA();
                break;

            case "B":
                returnType = new TypeB();
                break;

            case "C":
                returnType = new TypeC();
                break;
        }
        return returnType;
    }
}
