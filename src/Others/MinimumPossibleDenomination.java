package Others;

/*
Given an amount, find the minimum number of notes of different denominations that sum upto the given amount. Starting from the highest denomination note, try to accommodate as many notes possible for given amount.
We may assume that we have infinite supply of notes of values {2000, 500, 200, 100, 50, 20, 10, 5, 1}
 */
public class MinimumPossibleDenomination {

    public static void denomination(int amount, int coins[]) {
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                int note_counter = amount / coins[i];
                System.out.println(coins[i] + " - " + note_counter);
                amount = amount - (coins[i] * note_counter);
            }
        }
    }

    public static void main(String[] args) {
        int coins[] = {2000, 500, 200, 100, 50, 20, 10, 5, 1};
        denomination(800, coins);
        System.out.println("=========================");
        denomination(2456, coins);
        System.out.println("=========================");
        int coins1[] = {2000, 1000, 500, 100, 20, 10, 5, 2, 1};
        denomination(238, coins1);
    }
}
