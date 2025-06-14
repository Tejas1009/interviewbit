package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * Medium
 * Topics
 * Companies
 * Hint
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * <p>
 * <p>
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{6, 9, 7}};
        List<Integer> result = spiralOrder(matrix);
        result.forEach(System.out::println);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0, left = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            int i = left;
            //left to right
            while (i <= right) {
                result.add(matrix[top][i]);
                i++;
            }
            top++;
            //top to bottom
            int j = top;
            while (j <= bottom) {
                result.add(matrix[j][right]);
                j++;
            }
            right--;
            if (top <= bottom) {
                //right to left
                int k = right;
                while (k >= left) {
                    result.add(matrix[bottom][k]);
                    k--;
                }
                bottom--;
            }
            if (left <= right) {
                //bottom to top
                int l = bottom;
                while (l >= top) {
                    result.add(matrix[l][left]);
                    l--;
                }
                left++;
            }
        }
        return result;
    }

}
