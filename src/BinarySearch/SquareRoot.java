package BinarySearch;
/*
Given an integar A.

        Compute and return the square root of A.

        If A is not a perfect square, return floor(sqrt(A)).

        DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY



        Input Format

        The first and only argument given is the integer A.
        Output Format

        Return floor(sqrt(A))
        Constraints

        1 <= A <= 10^9
        For Example

        Input 1:
        A = 11
        Output 1:
        3

        Input 2:
        A = 9
        Output 2:
        3
        Seen this question in a real interview before*/

public class SquareRoot {

    public int sqrt(int A) {
        if (A <= 1) {
            return A;
        }
        int ans = -1, low = 1, high = A;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (A / mid >= mid) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SquareRoot sr = new SquareRoot();
        System.out.println(sr.sqrt(9));
        //2147483647
        //930675566
    }
}
