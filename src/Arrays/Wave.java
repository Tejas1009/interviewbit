import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Wave {
    public static void swap(ArrayList<Integer> arr, int x, int y) {
        int temp = arr.get(x);
        arr.set(x, arr.get(y));
        arr.set(y, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(10, 90, 49, 2, 1, 5, 23));
        Collections.sort(A);
        for (int i = 0; i < A.size(); i = i + 2) {
            if (i > 0 && A.get(i) < A.get(i - 1)) {
                swap(A, i, i - 1);
            }
            if (i < A.size() - 1 && A.get(i) < A.get(i + 1)) {
                swap(A, i, i + 1);
            }
        }
        System.out.println(A);
    }
}
