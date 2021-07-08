package Others.ArraysAndString;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        //1,1,1,0,0,0,1,1,1,1,0
        //we need to use 2 pointer technique
        //and each time we encounter 0 we will decrement k value
        //if k goes in negative then we will increase pointer j
        //and we will return i-j as answer
        //we dont need to maintain maxLen because i & j always has same size
        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] == 0) k--;
            if (k < 0) {
                if (nums[j] == 0) {
                    k++;
                }
                j++;
            }
            i++;
        }
        return i - j;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesIII m = new MaxConsecutiveOnesIII();
        int nums[] = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(m.longestOnes(nums, 2));
        int nums1[] = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(m.longestOnes(nums1, 3));
    }
}
