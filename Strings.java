import java.util.ArrayList;
import java.util.List;

public class Strings {
    public static void main(String[] args){
        Strings s = new Strings();
        s.setEx();
    }

    void setEx(){
        List list = new ArrayList<>(List.of("A", "B", "C"));
        System.out.println(list);
        list.set(1, "C");
        System.out.println(list);
    }
}
