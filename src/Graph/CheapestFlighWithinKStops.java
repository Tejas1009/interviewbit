package Graph;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/description/?envType=problem-list-v2&envId=plakya4j
 * <p>
 * 787. Cheapest Flights Within K Stops
 * Medium
 * Topics
 * Companies
 * There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
 * <p>
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
 * Output: 700
 * Explanation:
 * The graph is shown above.
 * The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
 * Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
 * Example 2:
 * <p>
 * <p>
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation:
 * The graph is shown above.
 * The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
 * Example 3:
 * <p>
 * <p>
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation:
 * The graph is shown above.
 * The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 100
 * 0 <= flights.length <= (n * (n - 1) / 2)
 * flights[i].length == 3
 * 0 <= fromi, toi < n
 * fromi != toi
 * 1 <= pricei <= 104
 * There will not be any multiple flights between two cities.
 * 0 <= src, dst, k < n
 * src != dst
 */
public class CheapestFlighWithinKStops {
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0;
        int dst = 3;
        int k = 1;
        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        for (int i = 0; i < k + 1; i++) {
            int[] tmpPrices = Arrays.copyOf(prices, prices.length);
            for (int[] flight : flights) {
                int start = flight[0];
                int end = flight[1];
                int price = flight[2];
                if (prices[start] == Integer.MAX_VALUE) {
                    continue;
                }
                if (prices[start] + price < tmpPrices[end]) {
                    tmpPrices[end] = prices[start] + price;
                }
            }
            prices = Arrays.copyOf(tmpPrices, tmpPrices.length);
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
