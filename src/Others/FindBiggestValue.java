package Others;

public class FindBiggestValue {

    public static int solution(int[] arr) {
        // write your code in Java SE 8
        int[] counter = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 1 && arr[i] <= arr.length) {
                counter[arr[i]] += 1;
            }
        }

        for (int i = arr.length; i >= 0; i--) {
            if (counter[i] == i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {3, 8, 2, 3, 3, 2};
        System.out.println((solution(arr)));
    }
}
