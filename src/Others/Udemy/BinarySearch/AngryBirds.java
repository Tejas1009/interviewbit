package Others.Udemy.BinarySearch;

import java.util.Arrays;

/*
There is a long wire along a straight line, which contains N bird nests at positions x1, x2...xn
There are B(B<=N) birds, which becomes angry towards each other once put into a nest. To put birds from
hurting each other you want to assign birds to nests such that minimum distance between any two birds is
as large as possible. What is the largest minimum distance.
 */
public class AngryBirds {

    private static boolean canPlaceBirds(int b, int n, int nest[], int sep) {
        int placed_birds = 1;
        int last_location = nest[0];
        for (int i = 1; i <= n; i++) {
            int curr_location = nest[i];
            if ((curr_location - last_location) >= sep) {
                placed_birds++;
                last_location = curr_location;
                if (b == placed_birds) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int possibleToPlaceBirds(int b, int nest[]) {
        int res = -1;
        Arrays.sort(nest);
        int n = nest.length - 1;
        int s = nest[0], e = nest[n];
        while (s <= e) {
            int mid = (s + e) / 2;
            boolean canPlace = canPlaceBirds(b, n, nest, mid);
            if (canPlace) {
                res = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int nest[] = {1, 2, 4, 8, 9};
        System.out.println(possibleToPlaceBirds(3, nest));
    }
}