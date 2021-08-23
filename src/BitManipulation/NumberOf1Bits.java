package BitManipulation;

/*
Problem Description

Write a function that takes an integer and returns the number of 1 bits it has.


Problem Constraints
1 <= A <= 109


Input Format
First and only argument contains integer A


Output Format
Return an integer as the answer


Example Input
Input1:
    11


Example Output
Output1:
3


Example Explanation
Explaination1:
11 is represented as 1101 in binary
 */
public class NumberOf1Bits {
    public int numSetBits(long n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n = n & (n - 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        NumberOf1Bits n = new NumberOf1Bits();
        System.out.println(n.numSetBits(11));
    }
}
