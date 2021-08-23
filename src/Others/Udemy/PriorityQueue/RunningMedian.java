package Others.Udemy.PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

/*
Running Median:
You are given a running stream of integers.
Write an efficient algorithm to output median of numbers read so far after every input.
Sample Input:
10,5,2,3,0,12,18,20,22

Sample Output:
10,7.5,5,4,3,4,5,7.5,10
 */
public class RunningMedian {

    public static void median(int arr[]) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap.add(arr[0]);
        float curr_median = (float) arr[0];
        System.out.print(curr_median + ", ");
        for (int i = 1; i < arr.length; i++) {
            int curr_element = arr[i];
            if (curr_element > curr_median) {
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }
                minHeap.add(curr_element);
            } else {
                if (maxHeap.size() > minHeap.size()) {
                    minHeap.add(maxHeap.poll());
                }
                maxHeap.add(curr_element);
            }
            if (maxHeap.size() == minHeap.size()) {
                curr_median = (float) (maxHeap.peek() + minHeap.peek()) / 2;
            } else {
                if (maxHeap.size() > minHeap.size()) {
                    curr_median = maxHeap.peek();
                } else {
                    curr_median = minHeap.peek();
                }
            }
            System.out.print(curr_median + ", ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {10, 5, 2, 3, 0, 12, 18, 20, 22};
        median(arr);
        System.out.println();
    }
}
