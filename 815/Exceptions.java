import java.io.FileNotFoundException;
import java.io.IOException;

public class Exceptions {


    public void methodA() throws IOException{
        methodB();  // works because FileNotFoundException is a subclass of IOException
    }

    public void methodB() throws FileNotFoundException{
        methodA();  // doesn't work because IOException is a superclass of FileNotFoundException
    }

    public static void main(String[] args){

    }
    
}
