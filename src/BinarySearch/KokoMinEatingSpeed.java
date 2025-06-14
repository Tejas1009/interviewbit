package BinarySearch;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/koko-eating-bananas/description/
 * 875. Koko Eating Bananas
 * Medium
 * Topics
 * Companies
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 * <p>
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 * <p>
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * <p>
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * Example 2:
 * <p>
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * Example 3:
 * <p>
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 */
public class KokoMinEatingSpeed {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int result = 0;
        Arrays.sort(piles);
        int n = piles.length - 1;
        int low = 0;
        int high = piles[n];
        while (low <= high) {
            int mid = (low + high) / 2;
            int noOfHours = noOfHoursToEatAllBananas(piles, mid);
            if (noOfHours <= h) {
                high = mid - 1;
                result = mid;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private static int noOfHoursToEatAllBananas(int piles[], int hour) {
        int result = 0;
        for (int i = 0; i < piles.length; i++) {
            double timePerPile = (double) piles[i] / hour;
            result += Math.ceil(timePerPile);
        }
        return result;
    }
}
