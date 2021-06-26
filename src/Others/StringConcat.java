package Others;

import java.util.LinkedList;

public class StringConcat {
    public static void main(String[] args) {
        /*String a = "hello";
        String b = "world";
        String c = a + b;
        System.out.println(c.equals(b + a));

        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);*/
        int n = 4;//011
        int k = 3;//
        int i = (1 << k - 1);
        System.out.println((n & (1 << k - 1)));

    }
}
