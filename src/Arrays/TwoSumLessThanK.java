package Arrays;

import java.util.Arrays;
import java.util.Map;

public class TwoSumLessThanK {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30};
        int k = 15;
        System.out.println(twoSumLessThanK(nums, k));
    }

    public static int twoSumLessThanK(int[] nums, int k) {
        int result = -1;
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < k) {
                result = Math.max(result, sum);
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}
