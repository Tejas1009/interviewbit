package Demo;

public class Patterns {
    public static void main(String[] args) {
        int n = 6;
        leftPattern1ToN(n);
        leftPatternNto1(n);
        rightPattern1ToN(n);
        rightPatternNTo1(n);
        pyramid(n);
        reverseDiamond(n);
    }

    public static void leftPattern1ToN(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void leftPatternNto1(int n) {
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void rightPattern1ToN(int n) {
        int k = n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= k) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            k--;
            System.out.println();
        }
    }

    public static void rightPatternNTo1(int n) {
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= k) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
            k++;
        }
    }

    public static void pyramid(int n) {
        int k = n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= k) {
                    System.out.print("* ");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            k--;
        }
    }

    public static void reverseDiamond(int n) {
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= k) {
                    System.out.print("* ");
                } else {
                    System.out.print(" ");
                }
            }
            k++;
            System.out.println();
        }
    }
}
