package DynamicProgramming;

/*Min Jumps Array
        Asked in:
        Amazon
        Ebay
        Google
        Given an array of non-negative integers, A, of length N, you are initially positioned at the first index of the array.
        Each element in the array represents your maximum jump length at that position.
        Return the minimum number of jumps required to reach the last index.
        If it is not possible to reach the last index, return -1.
        Input Format:
        The first and the only argument contains an integer array, A.
        Output Format:
        Return an integer, representing the answer as described in the problem statement.
        Constraints:
        1 <= N <= 1e6
        0 <= A[i] <= 50000
        Examples:

        Input 1:
        A = [2, 1, 1]

        Output 1:
        1

        Explanation 1:
        The shortest way to reach index 2 is
        Index 0 -> Index 2
        that requires only 1 jump.

        Input 2:
        A = [2,3,1,1,4]

        Output 2:
        2
        Explanation 2:
        The shortest way to reach index 4 is
        Index 0 -> Index 1 -> Index 4
        that requires 2 jumps.*/
public class MinimumJumpArray {

    static int jump(int nums[]) {
        if (nums.length <= 1)
            return 0;
        if (nums[0] == 0)
            return -1;
        int previous = 0;
        int current = 0;
        int jumps = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > previous) {
                jumps = jumps + 1;
                previous = current;
            }
            current = Math.max(current, i + nums[i]);
        }
        return jumps;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2, 3, 1, 1, 4};
        //int arr[] = new int[]{3, 4, 2, 1, 2, 3, 7, 1, 1, 3};
        System.out.println(jump(arr));
        // calling minJumps method
        //System.out.println(minJumps(arr));
    }
}
