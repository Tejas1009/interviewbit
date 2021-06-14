package ubs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LiftingWeights {
    static int maxWeight = 0;

    private static void findAllSubsets(List<Integer> arr, int startIdx, int wsf, int maxCapacity) {
        if (wsf > maxCapacity) return;
        maxWeight = Math.max(maxWeight, wsf);
        for (int i = startIdx; i < arr.size(); i++) {
            findAllSubsets(arr, i + 1, wsf + arr.get(i), maxCapacity);
        }
    }

    public static int weightCapacity(List<Integer> weights, int maxCapacity) {
        // Write your code here
        maxWeight = 0;
        findAllSubsets(weights, 0, 0, maxCapacity);
        return maxWeight;
    }

    public static int weightCapacityDP(List<Integer> weights, int maxCapacity) {
        int dp[][] = new int[weights.size() + 1][maxCapacity + 1];
        for (int i = 1; i <= weights.size(); i++) {
            for (int j = 1; j <= maxCapacity; j++) {
                if (weights.get(i - 1) > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], weights.get(i - 1) + dp[i - 1][j - weights.get(i - 1)]);
                }
            }
        }
        return dp[weights.size()][maxCapacity];
    }

    public static void main(String[] args) {
        List<Integer> weights = new ArrayList<>(Arrays.asList(1, 3, 5));
        //weightCapacity(weights, 7);
        System.out.println(weightCapacityDP(weights, 7));
    }
}
