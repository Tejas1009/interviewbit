import java.util.ArrayList;

public class MaxSumSubArray {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(336465782);
        A.add(-278722862);
        A.add(-2145174067);
        A.add(1101513929);
        A.add(1315634022);
        A.add(-1369133069);
        A.add(1059961393);
        A.add(628175011);
        A.add(-1131176229);
        A.add(-859484421 );
        int subArrays = 0;
        ArrayList<ArrayList<Integer>> subArr = new ArrayList<>(A.size() - 1);
        subArr.add(new ArrayList<>());
        subArr.set(0, new ArrayList<>());
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) < 0) {
                subArr.add(new ArrayList<>());
                subArr.set(subArrays + 1, new ArrayList<>());
                subArrays++;
            } else {
                subArr.get(subArrays).add(A.get(i));
            }
        }
        int bestSubArrayIdx = 0;
        long bestSum = 0;
        for (int i = 0; i < subArr.size(); i++) {
            long sum = 0;
            for (int j = 0; j < subArr.get(i).size(); j++) {
                sum = sum + subArr.get(i).get(j);
            }
            if (sum > bestSum) {
                bestSum = sum;
                bestSubArrayIdx = i;
            }
            if (sum == bestSum && subArr.get(bestSubArrayIdx).size() < subArr.get(i).size()) {
                bestSum = sum;
                bestSubArrayIdx = i;
            }
        }
        for (int i = 0; i < subArr.get(bestSubArrayIdx).size(); i++) {
            System.out.println(subArr.get(bestSubArrayIdx).get(i));
        }
    }
}
