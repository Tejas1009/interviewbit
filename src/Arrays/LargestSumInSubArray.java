import java.util.ArrayList;
import java.util.List;

public class LargestSumInSubArray {
    public static int maxSubArray(final List<Integer> A) {
        int sum = 0, best = A.get(0);
        for (int i = 0; i < A.size(); i++) {
            sum = Math.max(A.get(i), sum + A.get(i));
            best = Math.max(sum, best);
        }
        return best;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(-10);
        System.out.println(maxSubArray(arr));
    }
}
