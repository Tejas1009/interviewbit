package HeadAndMap;

import java.util.*;

/*Given two arrays A & B of size N each.
        Find the maximum N elements from the sum combinations (Ai + Bj) formed from elements in array A and B.

        For example if A = [1,2], B = [3,4], then possible pair sums can be 1+3 = 4 , 1+4=5 , 2+3=5 , 2+4=6
        and maximum 2 elements are 6, 5

        Example:

        N = 4
        a[]={1,4,2,3}
        b[]={2,5,1,6}

        Maximum 4 elements of combinations sum are
        10   (4+6),
        9    (3+6),
        9    (4+5),
        8    (2+6)*/
public class MaxPairCombination {

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

    public ArrayList<Integer> solve(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        ArrayList<Integer> res = new ArrayList<>();
        Collections.sort(arr1);
        Collections.sort(arr2);
        PriorityQueue<Triplet> maxHeap = new PriorityQueue<>();
        HashSet<Pair> set = new HashSet<>();
        int i = arr1.size() - 1;
        int j = arr2.size() - 1;
        set.add(new Pair(i, j));
        maxHeap.add(new Triplet(arr1.get(i) + arr2.get(j), i, j));
        for (int k = 0; k < arr1.size() && i >= 0 && j >= 0; k++) {
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
        MaxPairCombination m = new MaxPairCombination();
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 4, 2, 3));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(2, 5, 1, 6));
        m.solve(arr1, arr2);
    }
}
