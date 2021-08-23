package Others.Udemy.PriorityQueue;

/*
Merge K-Sorted Array:

As discussed, you need to implement a function that accepts k-sorted arrays of integers and returns the sorted version of the array.
Sample Input:
Input is 2D Vector, each row represents a sorted array. There are K such rows.
{
    {10, 15, 20, 30},
    {2, 5, 8, 14, 24},
    {0, 11, 60, 90}
}
Output:
0, 2, 5, 8, 10, 11, 14, 15, 20, 24, 30, 60, 90
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KWayMerge {

    static class Node implements Comparable<Node> {
        int value;
        int index;
        int arr_index;

        public Node(int value, int index, int arr_index) {
            this.value = value;
            this.index = index;
            this.arr_index = arr_index;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    public static ArrayList<Integer> merge(List<List<Integer>> arr) {
        ArrayList<Integer> res = new ArrayList<>();
        int k = arr.size();
        PriorityQueue<Node> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            minHeap.add(new Node(arr.get(i).get(0), 0, i));
        }
        while (!minHeap.isEmpty()) {
            Node curr_node = minHeap.poll();
            res.add(curr_node.value);
            if (arr.get(curr_node.arr_index).size() > curr_node.index + 1) {
                minHeap.add(new Node(arr.get(curr_node.arr_index).get(curr_node.index + 1), curr_node.index + 1, curr_node.arr_index));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>(Arrays.asList(10, 15, 20, 30)));
        arr.add(new ArrayList<>(Arrays.asList(2, 5, 8, 14, 24)));
        arr.add(new ArrayList<>(Arrays.asList(0, 11, 60, 90)));
        ArrayList<Integer> res = merge(arr);
        res.forEach(x -> System.out.print(x + ", "));
        System.out.println();
    }
}
