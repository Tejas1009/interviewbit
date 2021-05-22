import java.util.ArrayList;
import java.util.List;

public class Spiral2DArray {

    public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> arr) {
        List<Integer> res = new ArrayList<>();
        int t = 0, l = 0, r = arr.get(0).size() - 1, b = arr.size() - 1, dir = 0;
        while (t <= b && l <= r) {
            if (dir == 0) {
                for (int i = t; i <= r; i++) {
                    res.add(arr.get(t).get(i));
                }
                dir = 1;
                t++;
            } else if (dir == 1) {
                for (int i = t; i <= b; i++) {
                    res.add(arr.get(i).get(r));
                }
                dir = 2;
                r--;
            } else if (dir == 2) {
                for (int i = r; i >= l; i--) {
                    res.add(arr.get(b).get(i));
                }
                dir = 3;
                b--;
            } else if (dir == 3) {
                for (int i = b; i >= t; i--) {
                    res.add(arr.get(i).get(l));
                }
                l++;
                dir = 0;
            }
        }
        return (ArrayList<Integer>) res;
    }

    public static void main(String[] args) {
        List<ArrayList<Integer>> aList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(1);
        a1.add(2);
        aList.add(a1);
        ArrayList<Integer> a3 = new ArrayList<Integer>();
        a3.add(3);
        a3.add(4);
        aList.add(a3);
        ArrayList<Integer> a2 = new ArrayList<Integer>();
        a2.add(5);
        a2.add(6);
        aList.add(a2);

        spiralOrder(aList);
    }
}
