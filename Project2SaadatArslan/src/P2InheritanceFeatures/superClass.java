package P2InheritanceFeatures;


public class superClass extends AbstractClassDemonstration { // 2.1.1. Creating subclass, superclass, instance of subclass
    // 2.1.3. Creating instance variables with different access modifiers
    private int commonIntOne; //Private Instance Variable, it needs getter and setter methods to be accessed in other classes
    private int commonIntTwo; //Private Instance Variable, it needs getter and setter methods to be accessed in other classes
    private boolean commonTrue; //Private Instance Variable, it needs getter and setter methods to be accessed in other classes
    protected String commonString; //Protected Instance Variable, it can be accessed directly in child methods.
    private int a; private int b; //Variables for overriding demonstration
    // 2.1.4. Overloaded methods
    public superClass(){
        setOne(1);
        setTwo(2);
        setTrue(true);
        setCommonString("String");
    }
    //
    // 2.1.4. Overloaded methods
    public superClass(int newOne, int newTwo, boolean newTrue){
        setOne(newOne);
        setTwo(newTwo);
        setTrue(newTrue);
    }

    //getters
    public int getOne(){
        return commonIntOne;
    }
    public int getTwo(){
        return commonIntTwo;
    }
    public boolean getTrue(){
        return commonTrue;
    }
    public String getCommonString(){
        return commonString;
    }
    //setters
    public void setOne(int newOne){
        commonIntOne = newOne;
    }
    public void setTwo(int newTwo){
        commonIntTwo = newTwo;
    }
    public void setTrue(boolean newTrue){
        commonTrue = newTrue;
    }
    public void setCommonString(String newString){
        commonString = newString;
    }
    // 2.1.5. Overridden method
    public void overridingDemonstration(){
        a = 500;
        b = 5;
        System.out.println(a + b);
    }

    public void printInfo(){
        System.out.printf("This SuperClass's commonIntOne is %d, commonIntTwo %d, common true is %b\n common String is %s \n", commonIntOne,
                commonIntTwo  , commonTrue, commonString);
    }

    @Override
    public void MyAbstractMethod() {
        System.out.println("Abstract Print in SuperClass");
    }
}
