package HeadAndMap;

import java.util.*;
/*Problem Description

        Given two equally sized 1-D arrays A, B containing N integers each.
        A sum combination is made by adding one element from array A and another element of array B.
        Return the maximum C valid sum combinations from all the possible sum combinations.

        Problem Constraints
        1 <= N <= 105
        1 <= A[i] <= 103
        1 <= C <= N

        Input Format
        First argument is an one-dimensional integer array A of size N.
        Second argument is an one-dimensional integer array B of size N.
        Third argument is an integer C.

        Output Format
        Return a one-dimensional integer array of size C denoting the top C maximum sum combinations.

        NOTE:

        The returned array must be sorted in non-increasing order.
        Example Input
        Input 1:

        A = [3, 2]
        B = [1, 4]
        C = 2
        Input 2:

        A = [1, 4, 2, 3]
        B = [2, 5, 1, 6]
        C = 4*/

public class MaxSumCombination {

    class Triplet implements Comparable<Triplet> {
        int sum;
        int i;
        int j;

        public Triplet(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Triplet o) {
            return Integer.compare(o.sum, sum);
        }
    }

    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair obj = (Pair) o;
            return (i == obj.i && j == obj.j);
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public ArrayList<Integer> solve(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int b) {
        ArrayList<Integer> res = new ArrayList<>();
        Collections.sort(arr1);
        Collections.sort(arr2);
        PriorityQueue<Triplet> maxHeap = new PriorityQueue<>();
        HashSet<Pair> set = new HashSet<>();
        int i = arr1.size() - 1;
        int j = arr2.size() - 1;
        set.add(new Pair(i, j));
        maxHeap.add(new Triplet(arr1.get(i) + arr2.get(j), i, j));
        for (int k = 0; k < b && i >= 0 && j >= 0; k++) {
            Triplet tri = maxHeap.poll();
            res.add(tri.sum);
            Pair p = new Pair(tri.i - 1, tri.j);
            if (p.i >= 0 && p.j >= 0 && !set.contains(p)) {
                maxHeap.add(new Triplet(arr1.get(p.i) + arr2.get(p.j), p.i, p.j));
                set.add(new Pair(p.i, p.j));
            }
            Pair p2 = new Pair(tri.i, tri.j - 1);
            if (p2.i >= 0 && p2.j >= 0 && !set.contains(p2)) {
                maxHeap.add(new Triplet(arr1.get(p2.i) + arr2.get(p2.j), p2.i, p2.j));
                set.add(new Pair(p2.i, p2.j));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxSumCombination m = new MaxSumCombination();
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 4, 2, 3));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(2, 5, 1, 6));
        m.solve(arr1, arr2, 3);
    }
}
