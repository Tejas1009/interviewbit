import java.util.ArrayList;

public class RotateArray {
    public static ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        //ArrayList<Integer> ret = new ArrayList<Integer>();
        int temp = 0;
        for (int i = 0; i < B; i++) {
            temp = A.get(0);
            for (int j = 0; j < A.size(); j++) {
                if (j + 1 >= A.size()) {
                    A.set(A.size() - 1, temp);
                } else {
                    A.set(j, A.get(j + 1));
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        int b = 1;
        ArrayList<Integer> ret = rotateArray(arr, b);
    }
}
