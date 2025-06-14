package Arrays;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/description/?envType=problem-list-v2&envId=plakya4j
 * <p>
 * 74. Search a 2D Matrix
 * Medium
 * Topics
 * Companies
 * You are given an m x n integer matrix matrix with the following two properties:
 * <p>
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 * <p>
 * You must write a solution in O(log(m * n)) time complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */
public class SearchOn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(matrix, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        if (row == -1) {
            return false;
        }
        int start = 0, end = matrix[0].length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (target > matrix[row][mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    private static int findRow(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        int row = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][matrix[0].length - 1]) {
                return mid;
            } else if (target > matrix[mid][0]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return row;
    }
}
