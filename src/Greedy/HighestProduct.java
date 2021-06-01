package Greedy;

public class HighestProduct {

    public int maxp3(int arr[]) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = -Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, min3 = -Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = arr[i];
            } else if (arr[i] > max2) {
                max3 = max2;
                max2 = arr[i];
            } else if (arr[i] > max3) {
                max3 = arr[i];
            }
            //*********
            if (arr[i] < min1) {
                min3 = min2;
                min2 = min1;
                min1 = arr[i];
            } else if (arr[i] < min2) {
                min3 = min2;
                min2 = arr[i];
            } else if (arr[i] < min3) {
                min3 = arr[i];
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }

    public static void main(String[] args) {
        HighestProduct h = new HighestProduct();
        int arr[] = {0, -1, 3, 100, -70, -50};
        System.out.println(h.maxp3(arr));
    }
}