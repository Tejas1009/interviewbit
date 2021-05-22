package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*Points on the Straight Line
        Asked in:
        Google
        Amazon
        InMobi
        Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

        Sample Input :

        (1, 1)
        (2, 2)
        Sample Output :

        2
        You will be given 2 arrays X and Y. Each point is represented by (X[i], Y[i])*/
public class PointsOnTheStraightLine {
    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        int res = 0;
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            int max = 0, overlap = 0;
            map.clear();
            for (int j = i + 1; j < a.size(); j++) {
                int y = b.get(j) - b.get(i);
                int x = a.get(j) - a.get(i);
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = _gcd(x, y);
                if (gcd != 0) {
                    y /= gcd;
                    x /= gcd;
                }
                if (map.containsKey(y)) {
                    if (map.get(y).containsKey(x)) {
                        map.get(y).put(x, map.get(y).get(x) + 1);
                    } else {
                        map.get(y).put(x, 1);
                    }
                } else {
                    HashMap<Integer, Integer> m = new HashMap<>();
                    m.put(x, 1);
                    map.put(y, m);
                }
                max = Math.max(max, map.get(y).get(x));
            }
            res = Math.max(res, max + overlap + 1);
        }
        return res;
    }

    private int _gcd(int x, int y) {
        if (y == 0) return x;
        return _gcd(y, x % y);
    }

    public static void main(String[] args) {
        PointsOnTheStraightLine p = new PointsOnTheStraightLine();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        p.maxPoints(a, b);
    }
}