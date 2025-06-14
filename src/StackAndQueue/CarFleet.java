package StackAndQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/car-fleet/
 * <p>
 * 853. Car Fleet
 * Solved
 * Medium
 * Topics
 * Companies
 * There are n cars at given miles away from the starting mile 0, traveling to reach the mile target.
 * <p>
 * You are given two integer array position and speed, both of length n, where position[i] is the starting mile of the ith car and speed[i] is the speed of the ith car in miles per hour.
 * <p>
 * A car cannot pass another car, but it can catch up and then travel next to it at the speed of the slower car.
 * <p>
 * A car fleet is a car or cars driving next to each other. The speed of the car fleet is the minimum speed of any car in the fleet.
 * <p>
 * If a car catches up to a car fleet at the mile target, it will still be considered as part of the car fleet.
 * <p>
 * Return the number of car fleets that will arrive at the destination.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * <p>
 * Output: 3
 * <p>
 * Explanation:
 * <p>
 * The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12. The fleet forms at target.
 * The car starting at 0 (speed 1) does not catch up to any other car, so it is a fleet by itself.
 * The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
 * Example 2:
 * <p>
 * Input: target = 10, position = [3], speed = [3]
 * <p>
 * Output: 1
 * <p>
 * Explanation:
 * <p>
 * There is only one car, hence there is only one fleet.
 * Example 3:
 * <p>
 * Input: target = 100, position = [0,2,4], speed = [4,2,1]
 * <p>
 * Output: 1
 * <p>
 * Explanation:
 * <p>
 * The cars starting at 0 (speed 4) and 2 (speed 2) become a fleet, meeting each other at 4. The car starting at 4 (speed 1) travels to 5.
 * Then, the fleet at 4 (speed 2) and the car at position 5 (speed 1) become one fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
 */
public class CarFleet {
    public static void main(String[] args) {
        int target = 10;
        int[] position = {6, 8};
        int[] speed = {3, 2};
        System.out.println(carFleet(target, position, speed));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        List<Pair> data = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            data.add(new Pair(position[i], speed[i]));
        }
        data.sort((o1, o2) -> o2.position - o1.position);
        Stack<Double> stack = new Stack<>();
        for (Pair d : data) {
            double timeToReachTarget = ((double) (target - d.position) / d.speed);
            //timeToReachTarget <= stack.peek() condition states that previous car is going to reach target in less than or equal to ahead car time
            if (stack.size() >= 1 && timeToReachTarget <= stack.peek()) {
                continue;
            } else {
                stack.add(timeToReachTarget);
            }
        }
        return stack.size();
    }

    static class Pair {
        int position;
        int speed;

        public Pair(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }
}
