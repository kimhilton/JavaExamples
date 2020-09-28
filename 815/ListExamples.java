import java.util.ArrayList;
import java.util.List;

public class ListExamples {


    public void copyOfEx(){
        List original = new ArrayList<>();
        original.add("A");
        List copy = List.copyOf(original);

        copy.set(1, "B");   // throws UnsupportedOperationException because copyOf returns immutable list, which you're trying to mutate here

        System.out.println("og: " + original + "\tcopy:" + copy);
    }

    public void ArrayListEx(){
        ArrayList<Integer> a = new ArrayList(); // valid
        //ArrayList<> b = new ArrayList<>();  // invalid
        var c = new ArrayList<>();  // valid
    }

    public void TwoDimensionalArrayEx(){
        String[][] array = new String[2][2];
        array[0] = new String[]{"hei"};
        //System.out.println(array[0][1]);  //  ArrayIndexOutOfBoundsException
        array[1] = new String[]{"og", "hå"};    //  notice that it's perfectly valid to not have a "squared" 2D-array

        print2DArray(array);

        String[][] array2 = new String[2][];
        array2[0] = new String[]{"hei", "og", "hå"};    //  notice that you can leave a row uninitialized without any errors or exceptions

        //print2DArray(array2); // NullPointerException when accessing uninitialized row
    }

    public void print2DArray(String[][] array){
        for (int i = 0; i < array.length; i++){
            System.out.println();
            for (int j = 0; j < array[i].length; j++)
                System.out.print(" " + array[i][j]);
        }
    }

    public static void main(String[] args){
        ListExamples e = new ListExamples();
        e.ArrayListEx();
        e.TwoDimensionalArrayEx();

    }
}
