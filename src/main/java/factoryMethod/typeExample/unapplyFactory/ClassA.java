package factoryMethod.typeExample.unapplyFactory;

import factoryMethod.typeExample.type.Type;
import factoryMethod.typeExample.type.TypeA;
import factoryMethod.typeExample.type.TypeB;
import factoryMethod.typeExample.type.TypeC;

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
