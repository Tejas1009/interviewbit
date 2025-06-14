package Arrays;

//https://leetcode.ca/all/277.html
public class FindCelebrity {
    /**
     * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one  celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
     * <p>
     * Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
     * <p>
     * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n). There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.
     */

    public static void main(String[] args) {
        int matrix[][] = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        System.out.println(findCelebrity(matrix));
    }

    public static int findCelebrity(int[][] matrix) {
        int top = 0, down = matrix.length - 1;
        while (top < down) {
            if (matrix[top][down] == 1) {
                top++;
            } else if (matrix[down][top] == 1) {
                down--;
            } else {
                top++;
                down--;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (top == i) continue;
            if (matrix[top][i] == 1) {
                return -1;
            }
            if (matrix[i][top] != 1) {
                return -1;
            }
        }
        return top;
    }
}
