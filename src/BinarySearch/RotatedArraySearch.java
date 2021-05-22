package BinarySearch;

public class RotatedArraySearch {
    private int arrSearch(int arr[], int B, int low, int hi) {
        if (low > hi) {
            return -1;
        }
        int mid = (hi + low) / 2;
        if (arr[mid] == B) {
            return mid;
        }
        //check if arr is sorted from low to mid
        if (arr[low] <= arr[mid]) {
            if (B <= arr[mid] && B >= arr[low]) {
                return arrSearch(arr, B, low, mid - 1);
            } else {
                return arrSearch(arr, B, mid + 1, hi);
            }
        } else {
            if (B >= arr[mid] && B <= arr[hi]) {
                return arrSearch(arr, B, mid + 1, hi);
            } else {
                return arrSearch(arr, B, low, mid - 1);
            }
        }
    }

    public int search(final int[] arr, int B) {
        return this.arrSearch(arr, B, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        RotatedArraySearch r = new RotatedArraySearch();
        int arr[] = {5, 17, 100, 3};
        int B = 6;
        System.out.println(r.search(arr, B));
    }
}
