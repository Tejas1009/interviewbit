package DynamicProgramming;

/*
Unique Binary Search Trees II
        Asked in:
        Amazon
        Twitter
        Samsung
        Given an integer A, how many structurally unique BST’s (binary search trees) exist that can store values 1…A?

        Input Format:

        The first and the only argument of input contains the integer, A.
        Output Format:

        Return an integer, representing the answer asked in problem statement.
        Constraints:

        1 <= A <= 18
        Example:

        Input 1:
        A = 3

        Output 1:
        5

        Explanation 1:

        1         3     3      2      1
        \       /     /      / \      \
        3     2     1      1   3      2
        /     /       \                 \
        2     1         2                 3
*/

public class UniqueBinarySearchTreesII {

    public int numTrees(int n) {
        int c[] = new int[n + 1];
        c[0] = 1;
        c[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                c[i] += c[j] * c[i - j - 1];
            }
        }
        return c[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII u = new UniqueBinarySearchTreesII();
        System.out.println(u.numTrees(3));
    }
}
