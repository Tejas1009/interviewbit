package Arrays;

import java.util.ArrayList;

public class MinStepsToReachLastGrid {
    class point {
        int x, y;

        point(int a, int b) {
            x = a;
            y = b;

        }
    }

    static int shortestPath(point p1,
                            point p2) {
        int dx = Math.abs(p1.x - p2.x);
        int dy = Math.abs(p1.y - p2.y);
        return Math.max(dx, dy);
    }

    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int stepCount = 0;
        point arr[] = new point[A.size()];
        for (int i = 0; i < A.size(); i++) {
            arr[i] = new point(A.get(i), B.get(i));
        }

        for (int i = 0; i < arr.length - 1; i++) {
            stepCount += shortestPath(arr[i],
                    arr[i + 1]);
        }

        return stepCount;
    }


    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(0);
        A.add(1);
        A.add(1);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(0);
        B.add(1);
        B.add(2);
        System.out.println(new MinStepsToReachLastGrid().coverPoints(A, B));
    }
}
