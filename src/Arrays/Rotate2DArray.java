package Arrays;

import java.util.ArrayList;

public class Rotate2DArray {

    public static void reverse(ArrayList<ArrayList<Integer>> a) {
        //step 1 : transpose i.e convert row to column
        //example:
        //  step 1:
        //      1 2 3   ->  1 4 7
        //      4 5 6   ->  2 5 8
        //      7 8 9   ->  3 6 9
        //step 2 : reverse row by row
        //      7 4 1
        //      8 5 2
        //      9 6 3

        for (int i = 0; i < a.size(); i++) {
            for (int j = i; j < a.size(); j++) {
                if (i != j) {
                    //int temp = arr[i][j];
                    int temp = a.get(i).get(j);
                    //arr[i][j] = arr[j][i];
                    a.get(i).set(j, a.get(j).get(i));
                    //arr[j][i] = temp;
                    a.get(j).set(i, temp);
                }
            }
        }

        for (int k = 0; k < a.size(); k++) {
            int i = 0, j = a.size() - 1;
            while (i < j) {
                //int temp = arr[k][i];
                int temp = a.get(k).get(i);
                //arr[k][i] = arr[k][j];
                a.get(k).set(i, a.get(k).get(j));
                //arr[k][j] = temp;
                a.get(k).set(j, temp);
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList arr1 = new ArrayList();
        arr1.add(1);
        arr1.add(2);
        a.add(arr1);
        ArrayList arr2 = new ArrayList();
        arr2.add(3);
        arr2.add(4);
        //arr2.add(6);
        a.add(arr2);
       /* ArrayList arr3 = new ArrayList();
        arr3.add(7);
        arr3.add(8);
        arr3.add(9);
        a.add(arr3);*/
        reverse(a);
    }
}
