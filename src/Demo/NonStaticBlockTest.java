package Demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class NonStaticBlockTest {
    private int a;

    {
        int b;
        System.out.println("First Non-Static Block" + a); // first non-static block
    }

    {

        System.out.println("Second Non-Static Block" + a); // second non-static block
    }


    NonStaticBlockTest() {
        System.out.println("Execution of a Constructor"); // Constructor
    }


    public static void main(String args[]) {
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
    }
}
