package Others.Udemy.Array;

public class RainWaterTrapped {

    //0,1,0,2,1,0,1,3,2,1,2,1
    public static int waterTrapped(int height[]) {
        int res = 0, i = 1, j = height.length - 1;
        int maxL = height[0], maxR = height[height.length - 1];
        while (i < j) {
            if (maxL <= maxR) {
                res += Math.max(0, maxL - height[i]);
                maxL = Math.max(maxL, height[i]);
                i++;
            } else {
                res += Math.max(0, maxR - height[j]);
                maxR = Math.max(maxR, height[j]);
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int height[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int height1[] = {3, 4, 5};
        System.out.println(waterTrapped(height));
        System.out.println(waterTrapped(height1));
    }
}