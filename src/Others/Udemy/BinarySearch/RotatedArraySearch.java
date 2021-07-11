package Others.Udemy.BinarySearch;

public class RotatedArraySearch {

    //4,5,6,7,0,1,2,3
    //key: 6
    public static int search(int arr[], int key) {
        int res = -1;
        int s = 0, e = arr.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[s] <= arr[mid]) {
                //line 1
                if (key <= arr[mid] && key >= arr[s]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else {
                //line 2
                if (key >= arr[mid] && key <= arr[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2, 3};
        //System.out.println(search(arr, 6));
        System.out.println(search(arr, 1));
    }
}
