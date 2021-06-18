import java.util.ArrayList;

public class FindPermutation {
    public static ArrayList<Integer> findPerm(final String A, int B) {
        int highest = B, lowest = 1;
        ArrayList<Integer> arr = new ArrayList<>(B);
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'D') {
                arr.add(highest);
                highest--;
            } else {
                arr.add(lowest);
                lowest++;
            }
        }
        if (A.charAt(A.length() - 1) == 'D') {
            arr.add(Math.abs(arr.get(A.length() - 1) - 1));
        } else {
            arr.add(Math.abs(arr.get(A.length() - 1) + 1));
        }
        return arr;
    }

    public static void main(String[] args) {
        findPerm("DDI", 4);
    }
}
