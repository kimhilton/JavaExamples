import java.util.ArrayList;
import java.util.List;

public class Strings {
    public static void main(String[] args){
        Strings s = new Strings();
        s.setEx();
        s.StringBuilderCapacity();
    }

    public void StringBuilderCapacity(){
        StringBuilder a = new StringBuilder();  //  a's capacity is default, which is 16
        System.out.println(a.capacity());
        a.append("hello");
        System.out.println(a.capacity());   //  notice that a's capacity is still default (16), event tough we appended a string of length 5

        StringBuilder b = new StringBuilder("hello");   // notice that b's capacity is default capacity + length of parameter string
        System.out.println(b.capacity());
    }

    void setEx(){
        List list = new ArrayList<>(List.of("A", "B", "C"));
        System.out.println(list);
        list.set(1, "C");
        System.out.println(list);
    }
}
