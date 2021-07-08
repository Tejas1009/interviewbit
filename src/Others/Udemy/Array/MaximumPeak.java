package Others.Udemy.Array;

public class MaximumPeak {
    //5,6,1,2,3,4,5,4,3,2,0,1,2,3,-2,4
    //  p          p             p
    public static int highest_mountain(int arr[]) {
        int res = Integer.MIN_VALUE;
        int i = 1;
        while (i < arr.length - 1) {
            if (arr[i - 1] < arr[i] && arr[i + 1] < arr[i]) {
                int j = i, w = 1;
                while (j > 0 && arr[j] > arr[j - 1]) {
                    j--;
                    w++;
                }
                //j = i + 1;
                while (i < arr.length - 1 && arr[i] > arr[i + 1]) {
                    i++;
                    w++;
                }
                res = Math.max(res, w);
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {5, 6, 1, 2, 3, 4, 5, 4, 3, 2, 0, 1, 2, 3, -2, 4};
        System.out.println(highest_mountain(arr));
    }
}
