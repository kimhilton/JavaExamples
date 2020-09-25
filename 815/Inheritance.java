/*  Demonstrating basic inheritance between concrete classes in Java 11 - see AbstractAndInterfaces.java for more complex examples

*/
public class Inheritance {
    public static void main (String[] args){
        Animal a = new Dog();
        Animal b = new Animal();
        Dog c = new Dog();
       // Dog d = new Animal();   // invalid, cannot have subclass reference pointing to superclass object like this. Doesn't compile.
        Dog e = (Dog) new Animal(); // valid, can have subclass reference pointing to superclass object with a cast to subclass

        a.bark();   // prints dog bark
        b.bark();   // prints some animal noise
        c.bark();   // prints dog bark
        //d.bark(); 
        e.bark();   // results in a ClassCastException.

        //c = a;    // doesn't compile.
        c = (Dog) a;    // does compile, but will result in a ClassCastException
    }
}

class Animal {
    //static void bark(){   //  if this method is static, then Dog.bark() has to be static as well
    void bark(){
        System.out.println("*some animal noise*");
    }
}

class Dog extends Animal {
    void bark(){
        System.out.println("*dog bark*");
    }
}
