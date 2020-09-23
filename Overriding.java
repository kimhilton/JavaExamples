
class OverridingSuper {

    static String field = "Super";

    static void printField(){
        System.out.println("i super: " + field);
    }
}

public class Overriding extends OverridingSuper{

    static String field = "Sub";

    static void printField(){
        System.out.println("i sub: " + field);
    }

    public static void main(String ...arg){
        OverridingSuper o = new Overriding();
        o.printField();
    }
}