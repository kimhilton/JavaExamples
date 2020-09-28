import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/*  Demonstrating Exceptions in Java 11, including some stuff that isn't allowed and some stuff that is allowed.

- methodA() and methodB() demonstrates how calls between methods that throw exceptions works
- methodC() demonstrates the relationship between throws, throw, and try-catch
- methodD() demonstrates try-catch
- methodE() demonstrates try-with-resources

Note that pretty much all of this applies to checked exceptions, as there is no need to handle or catch unchecked exceptions.

*/
public class Exceptions {


    public void methodA() throws IOException{
        methodB();  // works because FileNotFoundException is a subclass of IOException
    }

    public void methodB() throws FileNotFoundException{
    //    methodA();  // doesn't work because IOException is a superclass of FileNotFoundException
    }

    public void methodC() throws FileNotFoundException{ //  see main() for interaction
        System.out.println("Do you have to use the throw keyword if you declare your class with throws?");
        throw new FileNotFoundException("well yes. but also no.");
    }

    public void methodD(){
        try {
            throw new IOException();

        //} catch (FileNotFoundException | IOException e){    // does not compile because FNFE is a subtype of IOE, and is therefore redundant. Note that the order doesnt matter. It will result in unreachable code either way.
        //} catch (ArithmeticException e | IOException e){    // does not compile because variable e is specified more than once
            
        } catch (ArithmeticException | IOException e) { //  does compile. Note that the two exceptions arent related and that variable e is only specified once.
            e.printStackTrace();
        //} catch (ArithmeticException e) {   // does not compile because ArithmeticException is already caught
        }
    }

    public void methodE(){

        //  try-with-resources statement. Requires classes that implement AutoCloseable interface - which in turn has method close()
        //  resources are closed in reverse order from they where created. f2 is as such closed before f1
        try (FileInputStream f1 = new FileInputStream("thisfiledoesnotexist.txt");
                FileInputStream f2 = new FileInputStream("thisfiledoesnotexisteither")){
       
                    //try (var f1 = new FileInputStream("thisfiledoesnotexist.txt");
            //var f2 = new FileInputStream("thisfiledoesnotexisteither")){  // can also be declared with var. cleaner that way

                } catch (FileNotFoundException e){  //  must be caught because FileInputStream throws FileNotFoundException. Resources are closed at this point, meaning that f1 and f2 are out of scope

                } catch (IOException e){    //  must also be caught, because close() in FileInputStream throws IOException. Close is automatically called with a try-with-resources
                    
                } finally { // note that neither catch nor finally are required here, because try-with-resources provides an implicit finally clause
                    System.out.println("Remember that this explicit finally block is ALWAYS called AFTER the implicit one given from try-with-resources");
                }
    }


    class Animal {
        void eat() throws IOException{} // superclass method can have an equal or larger "exception view" than the subclass method
    }

    class Dog extends Animal {
        void eat() {}   // valid. overriding method can have have a narrower "exception view" than the overriden method
        //void eat() throws FileNotFoundException {}   // valid. overriding method can have have a narrower "exception view" than the overriden method
        //void eat() throws Exception {}  // invalid unless Animal.eat() also throws exception. overriding method cannot add new exceptions or have a wider exception scope than the overriden method
    }

    public static void main(String[] args){ // throws FileNotFoundException has to be there if you want to call methodC, or...

        //  ...you can catch FileNotFoundException like this. But you HAVE to do one of them.
        
        try{
            new Exceptions().methodC();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
