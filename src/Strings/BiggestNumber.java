package Strings;

import java.util.Arrays;

/*
You are given a vector of numbers. You want to concatenate these numbers together to form the lexicographically largest number.
Print that largest number number. You can't rearrange the digits of any number, however you can place the numbers next to each other in any order.
Input: 10,11,20,30,3
Output: 330201110
 */
public class BiggestNumber {

    //10,11,20,30,3
    //330201110
    public static String biggestNumber(String nums[]) {
        StringBuilder res = new StringBuilder();
        Arrays.sort(nums, (x, y) -> {
            String xy = x + y;
            String yx = y + x;
            return yx.compareTo(xy);
        });
        for (String num : nums) {
            res = res.append(num);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] nums = {"10", "11", "20", "30", "3"};
        System.out.println(biggestNumber(nums));
    }
}