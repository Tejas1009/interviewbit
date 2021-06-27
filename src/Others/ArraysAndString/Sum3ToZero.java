package Others.ArraysAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3ToZero {

    //-1,0,1,2,-1,-4
    //1) sort
    //-4,-1,-1,0,1,2
    //2) Make a constant and then find a pair such that summation will be zero
    //example: -4 is constant
    //we need to find a pair such that sum of them should be +4. No such pair exists so continue
    //we would use 2 pointer technique
    //j starts from i+1 and k starts from last
    //if sum we get is less than required than increment j else decrement k

    //-1,-1,2
    //-1,0,1
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            int f = nums[i];
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (f + sum == 0) {
                    res.add(Arrays.asList(f, nums[j], nums[k]));
                    break;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Sum3ToZero s = new Sum3ToZero();
        int nums[] = {-1, 0, 1, 2, -1, -4};
        s.threeSum(nums);
    }
}