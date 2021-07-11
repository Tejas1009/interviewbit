package Others.Udemy.SlidingWindow;

/*
Along one side of a road  there is a sequence  of vacant plots of land. Each plot has a different area (non-zero). So, the areas form a sequence A[1], A[2] ...A[n].
You want to buy K acres of land to build a house. You want to find all segments of continguous plots(i.e., a subsection in the sequence) of whose sum is exactly K.
 Input: 1,3,2,1,4,1,3,2,1,1,2 k = 8
 Output:
        2 5
        4 6
        5 9
output has indexes
 */

public class Housing {

    public static void housing(int arr[], int k) {
        int i = 0, j = 0, sum = 0;
        while (i < arr.length && j < arr.length) {
            if (sum <= k) {
                if (sum == k) System.out.println(i + " " + (j - 1));
                sum += arr[j];
                j++;
            } else {
                sum -= arr[i];
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int arr1[] = {1, 3, 2, 1, 4, 1, 3, 2, 1, 1, 2};
        housing(arr1, 8);
    }
}
