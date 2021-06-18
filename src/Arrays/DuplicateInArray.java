import java.util.*;

public class DuplicateInArray {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(3, 1, 5, 4, 2));
        Map dupes = new HashMap<Integer, Integer>();
        int ans = -1;
        for (int i = 0; i < A.size(); i++) {
            if (dupes.containsKey(A.get(i))) {
                ans = A.get(i);
                break;
            } else {
                dupes.put(A.get(i), 1);
            }
        }
        System.out.println(ans);
    }
}