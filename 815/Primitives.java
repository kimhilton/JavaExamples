public class Primitives {
    public static void  main(String[] args) {
        
        byte b = 100;   // valid, bytes range between -128 and 127
        short s = b;    // valid, s is 16b without decimals, while byte is 8bits without decimals
       // char c = s; // invalid, cannot assign char to any other primitives (think it's because it's just different)
        int i = s;  // valid, both are whole numbers and int can hold more dataa
        float f = 1.0f; // valid, float is fractiona 32b and int is whole number 32 bit
        //long l = f; // invalid, long used decimal
        double d = 1; // valid, d == 1.0
    }
}
