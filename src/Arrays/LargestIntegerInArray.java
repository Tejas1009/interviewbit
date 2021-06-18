import java.util.*;
import java.util.stream.Collectors;

public class LargestIntegerInArray {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(1, 0, 0, 0));
        List<String> arr = new ArrayList<>(A.stream().map(x -> x.toString()).collect(Collectors.toList()));
        StringBuilder ans = new StringBuilder();
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String XY = x + y;
                String YX = y + x;
                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });
        for (int i = 0; i < arr.size(); i++) {
            if (!ans.toString().equals("0")) {
                ans = ans.append(arr.get(i));
            }
        }
        System.out.println(ans);
    }
}
