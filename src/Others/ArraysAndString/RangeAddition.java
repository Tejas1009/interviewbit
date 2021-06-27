package Others.ArraysAndString;

/*Description
        Assume you have an array of length n initialized with all 0's and are given k update operations.

        Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

        Return the modified array after all k operations were executed.

        Example
        Given:
        length = 5,
        updates =
        [
        [1,  3,  2],
        [2,  4,  3],
        [0,  2, -2]
        ]
        return [-2, 0, 3, 5, 3]

        Explanation:
        Initial state:
        [ 0, 0, 0, 0, 0 ]
        After applying operation [1, 3, 2]:
        [ 0, 2, 2, 2, 0 ]
        After applying operation [2, 4, 3]:
        [ 0, 2, 5, 5, 3 ]
        After applying operation [0, 2, -2]:
        [-2, 0, 3, 5, 3 ]*/
public class RangeAddition {

    public int[] getModifiedArray(int length, int[][] updates) {
        int res[] = new int[length];
        //apply queries
        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int inc = updates[i][2];
            res[start] += inc;
            if (end + 1 < length) {
                res[end + 1] -= inc;
            }
        }
        for (int i = 1; i < length; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        RangeAddition r = new RangeAddition();
        int update[][] = {
                {1, 3, 2},
                {2, 4, 3},
                {0, 2, -2}
        };
        //r.getModifiedArray(5, update);
        int update1[][] = {
                {0, 2, 100},
                {1, 5, 100},
                {2, 3, 100}
        };
        r.getModifiedArray(6, update1);
    }
}