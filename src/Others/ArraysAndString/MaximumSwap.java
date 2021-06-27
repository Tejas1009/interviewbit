package Others.ArraysAndString;

/*You are given an integer num. You can swap two digits at most once to get the maximum valued number.

        Return the maximum valued number you can get.



        Example 1:

        Input: num = 2736
        Output: 7236
        Explanation: Swap the number 2 and the number 7.
        Example 2:

        Input: num = 9973
        Output: 9973
        Explanation: No swap.*/

public class MaximumSwap {
    //we will have 3 variables max, s1=-1, s2-1 and we will iterate from end of array
    //max will always have maximum element found till now
    //s1 & s2 will have potential candidates for swapping
    //if current element is greater than max then we will assign max = current element
    //else if current element is small than max then we have found potential element which is small than max to it's left
    //we will continue till i is >=0
    //if s2 != -1 then we can swap s1 & s2
    //else there is no need to swap number is already in it's max value

    //99376
    public int maximumSwap(int num) {
        char arr[] = String.valueOf(num).toCharArray();
        if (arr.length <= 1) return num;
        int s1 = -1, s2 = -1, max = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            char c = arr[i];
            if (arr[max] < c) {
                max = i;
            } else if (c < arr[max]) {
                s1 = max;
                s2 = i;
            }
        }
        if (s1 != -1 && s2 != -1) {
            char ch = arr[s1];
            arr[s1] = arr[s2];
            arr[s2] = ch;
        }
        int res = Integer.valueOf(String.valueOf(arr));
        return res;
    }

    public static void main(String[] args) {
        MaximumSwap m = new MaximumSwap();
        System.out.println(m.maximumSwap(2736));
        System.out.println(m.maximumSwap(99376));
        System.out.println(m.maximumSwap(9973));
    }
}