package Arrays;

import java.util.ArrayList;
import java.util.List;

public class DPrimer {
    static ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }

    public static void main(String[] args) {
        List<ArrayList<Integer>> aList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);
        aList.add(a1);
        ArrayList<Integer> a3 = new ArrayList<Integer>();
        a3.add(5);
        a3.add(6);
        a3.add(7);
        a3.add(8);
        aList.add(a3);
        ArrayList<Integer> a2 = new ArrayList<Integer>();
        a2.add(9);
        a2.add(10);
        a2.add(11);
        a2.add(12);
        aList.add(a2);


        ArrayList<ArrayList<Integer>> B = performOps((ArrayList<ArrayList<Integer>>) aList);
        for (int i = 0; i < B.size(); i++) {
            for (int j = 0; j < B.get(i).size(); j++) {
                System.out.print(B.get(i).get(j) + " ");
            }
        }
    }
}
