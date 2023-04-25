package P2InheritanceFeatures;

import P2InheritanceFeatures.*;

public class Main {
    public static void main(String[] args) { // 2.1.1. Creating subclass, superclass, instance of subclass
        superClass a = new superClass(2,3,false);
        a.printInfo();
        System.out.printf("Object A's class is %s\n",a.getClass());;
        SubClass b = new SubClass();
        b.printSubInfo();
        b.printInfo();
        System.out.printf("Object B's class is %s\n",b.getClass());;
        superClass c = new SubClass(5,15,false,true, "common"); // 2.1.2. Instance of subclass declared as a type of superclass
        //2.1.2 There is no error because SubClass is an extension of superClass, they have the same methods
        c.printInfo();
        System.out.printf("Object C's class is %s\n",c.getClass());
        b.overridingDemonstration();
        // 2.1.8. Creating abstract class and methods
        b.MyAbstractMethod();
    }
}