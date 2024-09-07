package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * There is an integer array ‘a’ of size ‘n’.
 * <p>
 * <p>
 * <p>
 * An element is called a Superior Element if it is greater than all the elements present to its right.
 * <p>
 * <p>
 * <p>
 * You must return an array all Superior Elements in the array ‘a’.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * The last element of the array is always a Superior Element.
 * <p>
 * <p>
 * Example
 * <p>
 * Input: a = [1, 2, 3, 2], n = 4
 * <p>
 * Output: 2 3
 * <p>
 * Explanation:
 * a[ 2 ] = 3 is greater than a[ 3 ]. Hence it is a Superior Element.
 * a[ 3 ] = 2 is the last element. Hence it is a Superior Element.
 * The final answer is in sorted order.
 */
public class LeaderInArray {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 2};
        List<Integer> result = superiorElements(a);
        result.stream().forEach(System.out::println);
    }

    public static List<Integer> superiorElements(int[] a) {
        List<Integer> result = new ArrayList<>();
        if (a.length <= 1) {
            result.add(a[0]);
            return result;
        }
        int n = a.length - 1;
        result.add(a[n]);
        int maxRight = a[n];
        for (int i = n - 1; i > 0; i--) {
            if (a[i] > maxRight) {
                result.add(a[i]);
                maxRight = a[i];
            }
        }
        return result;
    }
}
