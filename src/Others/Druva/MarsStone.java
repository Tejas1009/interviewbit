package Others.Druva;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MarsStone {

    public int maxUniqueStones(int i1, int i2, int i3[]) {
        int sum = i1;
        int max = Integer.MIN_VALUE;
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < i3.length; i++) {
            l.add(i3[i]);
        }
        for (int i = 1; i <= i1; i++) {
            sum = sum - i;
            int count = 0;
            if (!l.contains(i)) {
                for (int j = i + 1; j <= i1; j++) {
                    if (!l.contains(j) && (sum - j) >= 0) {
                        sum = sum - j;
                        count++;
                    }
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MarsStone ms = new MarsStone();
        int input1 = 10;
        int input2 = 3;
        int input3[] = {1, 3, 5};
        System.out.println(ms.maxUniqueStones(input1, input2, input3));
    }
}
//2