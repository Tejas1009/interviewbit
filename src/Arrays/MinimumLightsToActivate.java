public class MinimumLightsToActivate {

    public int solve(int[] a, int b) {
        int res = 0, i = b - 1, k = 0;
        while (i < a.length) {
            for (; i >= k; i--) {
                if (a[i] == 0) {
                    continue;
                }
                res++;
                k = i + b - 1;
                i = k + b;
                break;
            }
            if (i < k) return -1;
        }
        return res;
    }

    public int solve2(int[] a, int b) {
        int i = 0, n = a.length;
        int count = 0;
        while (i < n) {
            int j = Math.min(i + b - 1, n - 1);
            boolean found = false;
            while (j >= i - b + 1 && j >= 0 && j < n) {
                if (a[j] == 1) {
                    found = true;
                    i = j + b;
                    count++;
                    break;
                }
                j--;

            }
            if (!found)
                return -1;
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumLightsToActivate m = new MinimumLightsToActivate();
        int a[] = {0, 0, 1, 1, 1, 0, 0, 1};
        System.out.println(m.solve2(a, 3));
    }
}