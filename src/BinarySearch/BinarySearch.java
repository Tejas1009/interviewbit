package BinarySearch;

public class BinarySearch {
    public int binarySearch(int arr[], int target) {
        int result = -1;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int arr[] = {1, 2, 3, 4};
        System.out.println(bs.binarySearch(arr, 0));
    }
}
