package Others;

public class SmallestPositiveInteger {
    public static int solution(int[] A) {
        for (int i = 0; i < A.length; i++) {
            while (A[i] >= 1 && A[i] <= A.length && A[i] != A[A[i] - 1]) {
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, -7, 6, 8, 1, -10, 15};
        System.out.println(solution(arr));
    }
}
