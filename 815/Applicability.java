public class Applicability {


    /**
     * Based on the method call in main, the "priority line" goes like this:
     * 1) Integer add() will be called. The compiler will look for a suitable method without having to box/unbox the parameter or apply variable arity (...)
     * 2) If Integer add() is commented out, int add() will be called. If the compiler can't find a suitable method without boxing/unboxing, it will box/unbox the parameter
     * and look for suitable methods. In this case, the Integer parameter is unboxed to a primitive int.
     * 3) If int add() is also commented out, int add(int... x) will be called. This is because the third and final step is to apply variable arity,
     * i.e. check for an arbitrary number of arguments of the same type with '...'
    */

    Integer add(Integer x){
        System.out.println("Integer: " + x);    return x;
    }

    int add(int x){
        System.out.println("int: " + x);    return x;
    }

    int add(int... x){
        System.out.println("int..." + x);   return 1;
    }

    public static void main(String args[]){
        new Applicability().add(Integer.valueOf("1"));
    }
}
