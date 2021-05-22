package TwoPointer;

import java.util.Arrays;

/*Find the intersection of two sorted arrays.
        OR in other words,
        Given 2 sorted arrays, find all the elements which occur in both the arrays.

        Example :

        Input :
        A : [1 2 3 3 4 5 6]
        B : [3 3 5]

        Output : [3 3 5]

        Input :
        A : [1 2 3 3 4 5 6]
        B : [3 5]

        Output : [3 5]
        NOTE : For the purpose of this problem ( as also conveyed by the sample case ), assume that elements that appear more than once in both arrays should be included multiple times in the final output.*/
public class IntersectionOfSortedArrays {
    public int[] intersect(final int[] A, final int[] B) {
        int n = A.length > B.length ? B.length : A.length;
        int res[] = new int[n];
        int i = 0, j = 0, k = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) {
                res[k] = A[i];
                k++;
                i++;
                j++;
                continue;
            }
            if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }
        int r[] = new int[k];
        for (int x = 0; x < k; x++) {
            r[x] = res[x];
        }
        return r;
    }

    public static void main(String[] args) {
        IntersectionOfSortedArrays i = new IntersectionOfSortedArrays();
        int A[] = {1, 2, 3, 3, 4, 6};
        int B[] = {8, 9, 10};
        i.intersect(A, B);
    }
}