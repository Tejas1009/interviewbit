public class MaximumSumTriplet {
    class Triplet {
        int x, y, sum;

        Triplet(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }

    int solve(int arr[]) {
        int ans = 0;
        int n = arr.length;
        for (int i = 1; i < n - 1; ++i) {
            int max1 = 0, max2 = 0;

            for (int j = 0; j < i; ++j)
                if (arr[j] < arr[i])
                    max1 = Math.max(max1, arr[j]);
            for (int j = i + 1; j < n; ++j)
                if (arr[j] > arr[i])
                    max2 = Math.max(max2, arr[j]);
            if (max1 > 0 && max2 > 0)
                ans = Math.max(ans, max1 + arr[i] + max2);
        }

        return ans;
    }

    public static void main(String[] args) {
        MaximumSumTriplet m = new MaximumSumTriplet();
        int arr[] = {2, 5, 3, 1, 4, 9};
        System.out.println(m.solve(arr));
        System.console();
    }
}
