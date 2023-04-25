package P2InheritanceFeatures;


public class SubClass extends superClass { // 2.1.1. Creating subclass, superclass, instance of subclass.
    private int c;
    private int d; //Variables for overriding demonstration
    private boolean subTrue;

    // 2.1.4. Overloaded methods.
    public SubClass() {
        // 2.1.7. Calling parent class constructor using super keyword in child class constructor.
        super();
        setTrue(false);
        setSubTrue(true);
    }

    // 2.1.4. Overloaded methods
    public SubClass(int newOne, int newTwo, boolean newTrue, boolean NewSubTrue, String newString) {
        setOne(newOne);
        setTwo(newTwo);
        setTrue(newTrue);
        setSubTrue(NewSubTrue);
        setCommonString(newString);
    }

    // 2.1.5. Overridden method
    public void overridingDemonstration() {
        c = 600;
        d = 4;
        System.out.println(c + d);
        // 2.1.6. Calling overridden method from the overriding method using super keyword.
        super.overridingDemonstration();
    }

    public void setSubTrue(boolean newTrue) {
        subTrue = newTrue;
    }

    public boolean getSubTrue() {
        return subTrue;
    }

    public void printSubInfo() {
        System.out.printf("This SubClass's commonIntOne is %d, commonIntTwo %d, common true is %b\n But SubTrue is %b\n common String is %s \n", getOne(),
                getTwo(), getTrue(), subTrue, commonString);
    }

}
