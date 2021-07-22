package Others.Udemy.Recusrion;

/*
Oswald and Henry are playing the game of coins. They have a row of 'n' coins [C1,C2,C3...Cn] with values [V1,V2,V3...Vn] where Ci coin has Vi value.
 They take turns alternatively. In one turn the player can pick either the first or the last coin of the row. Given both Oswald and Henry are very smart
  players, you need to find the maximum possible value Oswald can earn if he plays first.

  In the function you are given an integer N i.e. the number of coins and a vector V which represents the values of each coin in the row respectively.
  Return a single integer which is the maximum possible value as asked in the question.
  Sample Testcase:
  4
  1,2,3,4
  Sample Output:
  6

  Explanation:
  Oswald will pick up coin with value 4, Henry will pick coin with value 3, Oswald will pick 2 and Henry will pick 1. Hence 4+2=6.
 */
public class GameOfCoin {

    private static int recur(int arr[], int s, int e, int asf, int i) {
        if (s > e) return asf;
        if (arr[s] >= arr[e]) {
            if (i % 2 == 0) {
                return recur(arr, s + 1, e, asf + arr[s], i + 1);
            } else {
                return recur(arr, s + 1, e, asf, i + 1);
            }
        } else {
            if (i % 2 == 0) {
                return recur(arr, s, e - 1, asf + arr[e], i + 1);
            } else {
                return recur(arr, s, e - 1, asf, i + 1);
            }
        }
    }

    public static int maxValue(int arr[]) {
        return recur(arr, 0, arr.length - 1, 0, 0);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        System.out.println(maxValue(arr));
    }
}
