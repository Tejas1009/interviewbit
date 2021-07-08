package Others.Udemy.Array;

import java.util.ArrayList;
import java.util.Arrays;

public class TripletSum {

    //arr = 1,2,3,4,5,6,7,8,9,15
    // sum = 18
    public static ArrayList<ArrayList<Integer>> triplets(int sum, int arr[]) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(arr);
        for (int k = 0; k < arr.length; k++) {
            int i = k + 1, j = arr.length - 1;
            int x = sum - arr[k];
            while (i < j) {
                //If sum of i,j,k equals sum
                if (arr[i] + arr[j] == x) {
                    res.add(new ArrayList<>(Arrays.asList(arr[k], arr[i], arr[j])));
                    i++;
                    j--;
                } else if (arr[i] + arr[j] > x) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 15};
        triplets(18, arr);
    }
}
