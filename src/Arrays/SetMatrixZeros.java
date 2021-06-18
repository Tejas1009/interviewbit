import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SetMatrixZeros {

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        HashSet<Integer> r = new HashSet<>();
        HashSet<Integer> c = new HashSet<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(0).size(); j++) {
                if (a.get(i).get(j) == 0) {
                    r.add(i);
                    c.add(j);
                }
            }
        }
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(0).size(); j++) {
                if (r.contains(i)) {
                    a.get(i).set(j, 0);
                }
                if (c.contains(j)) {
                    a.get(i).set(j, 0);
                }
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeros s = new SetMatrixZeros();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        a.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        a.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        s.setZeroes(a);
    }
}
