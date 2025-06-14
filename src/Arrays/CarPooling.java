package Arrays;

//https://leetcode.com/problems/car-pooling/description/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1094. Car Pooling
 * Medium
 * Topics
 * Companies
 * Hint
 * There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).
 * <p>
 * You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.
 * <p>
 * Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4
 * Output: false
 * Example 2:
 * <p>
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 5
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= trips.length <= 1000
 * trips[i].length == 3
 * 1 <= numPassengersi <= 100
 * 0 <= fromi < toi <= 1000
 * 1 <= capacity <= 105
 */
public class CarPooling {
    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 5, 7}};
        int capacity = 3;
        System.out.println(carPooling(trips, capacity));
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int currPassengers = 0;
        for (int i = 0; i < trips.length; i++) {
            int trip = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];
            if (currPassengers > capacity) {
                return false;
            }
            while (!minHeap.isEmpty() && minHeap.peek()[1] <= from) {
                int[] p = minHeap.poll();
                currPassengers -= p[0];
            }
            minHeap.add(new int[]{trip, to});
            currPassengers += trip;
        }
        return currPassengers <= capacity;
    }
}
