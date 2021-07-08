package Others.Recursion;

public class TowerOfHanoi {

    void towerOfHanoi(int n, int tower1, int tower2, int tower3) {
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, tower1, tower3, tower2);
        System.out.println(n + "[" + tower1 + " -> " + tower2 + "]");
        towerOfHanoi(n - 1, tower3, tower2, tower1);
    }

    public static void main(String[] args) {
        TowerOfHanoi t = new TowerOfHanoi();
        t.towerOfHanoi(3, 1, 3, 3);
    }
}