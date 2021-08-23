package Others.Udemy.Hashing;

import java.util.HashMap;
import java.util.Map;

/*
Triplets in GP:
You are given an array and you need to count number of triplets with indices(i,j,k) such that
the elements at those indices are in geometric progression for a given common ration r and (i<j<k).

Sample input:
arr=[1,16,4,16,64,16]
r=4

Output:
3
Explanation:
1,4,16
1,4,16
4,16,64
 */
public class TripletsInGeometricProgression {

    public static int count(int r, int arr[]) {
        /*
        Algorithm:
        1) Create a left and right map. We will first fill up the left map with frequency as 0 for all and for right map
        we will count the freq of each element.
        2) Then we will iterate over each element and we will add the recently visited element to left and remove the freq count from right
        This will help us get the freq of required right and left element in O(1) time.

        Formula for finding triplets:
        We will be considering current element as middle element and we will find right and left element.
        Right element will be a*r and left element will be a/r.
         */
        int res = 0;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            left.put(arr[i], 0);
            right.putIfAbsent(arr[i], 0);
            right.put(arr[i], right.get(arr[i]) + 1);
        }
        for (int i = 1; i < arr.length - 1; i++) {
            left.put(arr[i - 1], left.get(arr[i - 1]) + 1);//adding to left
            right.put(arr[i - 1], right.get(arr[i - 1]) - 1);//removing from right
            int required_left = arr[i] / r;
            int required_right = arr[i] * r;
            if (!left.containsKey(required_left)) continue;
            if (left.get(required_left) <= 0) continue;
            if (!right.containsKey(required_right)) continue;
            if (right.get(required_right) <= 0) continue;
            int left_count = left.get(required_left), right_count = right.get(required_right);
            res += (left_count * right_count);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1, 16, 4, 16, 64, 16};
        System.out.println(count(4, arr));
    }
}
