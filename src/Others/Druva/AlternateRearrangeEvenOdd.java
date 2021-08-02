package Others.Druva;

public class AlternateRearrangeEvenOdd {
    public static void main(String[] args) {
        int arr[] = {11, 9, 10, 45, 22};
        func(arr);
        for (int i : arr) {
            System.out.print(i % 2);
        }
    }

    static void func(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
