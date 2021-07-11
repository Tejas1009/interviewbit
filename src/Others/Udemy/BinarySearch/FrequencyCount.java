package Others.Udemy.BinarySearch;

/*
Given a sorted array which can contain repeated elements, and an element k, we need to find the
frequency of a given element.
Sample Input: 0,1,1,1,1,2,2,2,3,4,4,5,10
              k=2
Sample Output: 3
 */
public class FrequencyCount {
    private static int lower_bound(int arr[], int key) {
        int res = -1;
        int s = 0, e = arr.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == key) {
                res = mid;
                e = mid - 1;
            } else if (arr[mid] > key) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return res;
    }

    private static int upper_bound(int arr[], int key) {
        int res = -1;
        int s = 0, e = arr.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == key) {
                res = mid;
                s = mid + 1;
            } else if (arr[mid] > key) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return res;
    }

    public static int frequency(int arr[], int key) {
        int lb = lower_bound(arr, key);
        int hb = upper_bound(arr, key);
        return hb - lb + 1;
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 1, 1, 2, 2, 2, 3, 4, 4, 5, 10};
        System.out.println(frequency(arr, 2));
        System.out.println(frequency(arr, 1));
        System.out.println(frequency(arr, 3));
        System.out.println(frequency(arr, 4));
    }
}