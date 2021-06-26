package Others;

import java.util.HashMap;
import java.util.Map;

public class FindSubArrayWithGivenSum {

    public static void find(int[] arr, int sum) {
        //arr = 10, 15, -5, 15, -10, 5
        //sum = 5
        Map<Integer, Integer> map = new HashMap<>();// key is sum till ith element and value is index
        int currSum = 0;
        int startIdx = 0;
        int endIdx = -1;
        for (int i = 0; i < arr.length; i++) {
            currSum = currSum + arr[i];
            if (currSum - sum == 0) {
                startIdx = 1;
                endIdx = i + 1;
                break;
            }
            if (map.containsKey(currSum - sum)) {
                startIdx = map.get(currSum - sum) + 1;//+1 due to zero base indexing
                endIdx = i + 1;
                break;
            }
            map.put(currSum, i);
        }
        if (endIdx == -1) {
            System.out.println("Not Found!");
        } else {
            System.out.println("Found - start index: " + startIdx + " end index: " + endIdx);
        }
    }

    public static void main(String[] args) {
        int arr[] = {10, 15, -5, 15, -10, 5};
        int sum = 0;
        find(arr, sum);
    }
}
