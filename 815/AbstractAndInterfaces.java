/*  Demonstrating abstract classes and interfaces in Java 11

*/
public class AbstractAndInterfaces {

    public static void main(String[] args){
        new Pug().howl();   //  notice that Pug inherits DogClass' howl(), which in turn hides DogInterfaces' howl() implementation. Also notice that DogClass.howl() needs to be public
    }
}


interface DogInterface{
    /*
    default void howl(){
        System.out.println("DogInterface howls");
    }
*/
    void howl();
}

interface DogInterface2{
    void howl(int i);
}

abstract class DogClass{
    
    // Even though abstract classes can't be instantiated, they can have a constructor. This constructor can only be called from a subclass
    public DogClass(){
        System.out.println("Dog initialized");
    }
/*
    public void howl(){
        System.out.println("Dog howls");
    }
*/
    //abstract void howl();   //  valid
    //static void howl(){}    // invalid if Dog is not static
    //static void howl();   //  invalid. static methods cannot be overriden
    //void howl(){}   // valid
    //abstract void howl(){}  //  invalid because it provides an implementation
    //final abstract void howl(); //  invalid because final expects a final implementation to be defined, while abstract expects somebody else to implement
    //private abstract void howl();   // invalid because howl needs to be implemented by a subclass, which it can't if howl is private
}

/*
    In this case, Pug will inherit DogClass' howl(), even if DogInterface provides its own howl() implementation
    extends has to be specified before implements
*/
class Pug extends DogClass implements DogInterface, DogInterface2{
    //public void howl(){}   // valid, and required. the first regular (compact) class to inherit from an abstract class must provide implementations
    //private void howl(){}   //  invalid. similarly to regular classes, æ subclass cannot define an overriding method that is more restrictive than the superclasses'
    //abstract void howl();   //  invalid. regular class cannot have abstract methods
    //static void howl(){}    //  invalid if Dog and Dog.howl() is not static
    public void howl(){
        System.out.println("howling");
    }

    public void howl(int i){
        System.out.println("howling again");
    }
}
