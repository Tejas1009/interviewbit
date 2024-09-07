package Others.Udemy.Array;

public class RainWaterTrapped {

    public static int waterTrappedWithSpace(int height[]) {
        int res = 0;
        int maxL[] = new int[height.length];
        maxL[0] = height[0];
        int maxR[] = new int[height.length];
        maxR[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            maxL[i] = Math.max(maxL[i - 1], height[i]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            maxR[i] = Math.max(maxR[i + 1], height[i]);
        }
        for (int i = 0; i < height.length; i++) {
            res += Math.min(maxL[i], maxR[i]) - height[i];
        }
        return res;
    }

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
        int h1[] = {4, 2, 3};
        int height[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int height1[] = {3, 4, 5};
        //System.out.println(waterTrapped(height));
        //System.out.println(waterTrapped(h1));

        //int h1[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(waterTrappedWithSpace(h1));
    }
}