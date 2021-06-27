package Others.ArraysAndString;

import java.util.Arrays;

public class MinimumNumberOfPlatforms {

    //int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
    //int dep[] = { 910, 1120, 1130, 1200 1900, 2000 };
    public int findPlatform(int arr[], int dep[]) {
        int res = Integer.MIN_VALUE;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0, platform_needed = 0;
        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                i++;
                platform_needed++;
            } else if (arr[i] > dep[j]) {
                j++;
                platform_needed--;
            }
            res = Math.max(res, platform_needed);
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumNumberOfPlatforms m = new MinimumNumberOfPlatforms();
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(m.findPlatform(arr, dep));
        int arr1[] = {900, 940};
        int dep1[] = {910, 1200};
        System.out.println(m.findPlatform(arr1, dep1));
    }
}
