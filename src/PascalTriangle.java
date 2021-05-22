import java.util.ArrayList;

public class PascalTriangle {
    public static void main(String[] args) {
        int A = 5;
        int n = A + 1;
        int arr[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;
        }
        for (int i = 2; i < n && i <= i; i++) {
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(i, arr[n-1][i]);
        }
    }
}
