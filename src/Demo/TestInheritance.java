package Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class a {
    int i = 10;
}

class b {
    int i = 11;
}

interface i11 {

}

interface i12 {

}

interface i13 extends i11, i12 {

}

public class TestInheritance extends a {
    static int al;

    public static void p() {
        int i = TestInheritance.al;
    }

    public void print() {
        System.out.println(i);
    }

    public void sort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        TestInheritance t = new TestInheritance();
        //t.print();
        int[] arr = {4, 5, 3, 2, 1};
        //t.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        /*Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer value = it.next();
            System.out.println("List Value:" + value);
            if (value.equals(3)) {
                list.remove(value);
                //it.remove();
            }*/
        /*CopyOnWriteArrayList<Integer> list1
                = new CopyOnWriteArrayList<Integer>(new Integer[]{1, 3, 5, 8});
        Iterator itr = list1.iterator();
        while (itr.hasNext()) {
            Integer no = (Integer) itr.next();
            System.out.println(no);
            if (no == 8)

                // This will not print,
                // hence it has created separate copy
                list1.add(14);
        }*/
        String s = "hello";
        String s1 = new String("hello").intern();
        System.out.println(s == s1);
    }
}
