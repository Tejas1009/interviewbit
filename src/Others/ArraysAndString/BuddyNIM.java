package Others.ArraysAndString;

/*Alice, Bob and Charlie are playing a new game called Buddy NIM. The game is played at two tables; on the first table, there are N heaps containing A1,A2,…,AN stones and on the second table, there are M heaps containing B1,B2,…,BM stones respectively.

        Initially, Alice is playing at the first table and Bob is playing at the second table. The players take their turns in this order: Charlie, Alice, Bob, Charlie, etc.

        Alice and Bob follow the rules for classical NIM - on Alice's turn, Alice must remove a positive number of stones from one of the piles at her current table and on Bob's turn, Bob must remove a positive number of stones from one of the piles at his current table. Whoever cannot remove any stone from a pile loses.

        Charlie does not play at any table. Instead, on his turn, he decides if Alice and Bob should keep playing at their respective tables or swap places.

        Alice and Charlie are buddies and they cooperate, playing in the optimal way that results in Alice's victory (if possible).

        It is clear that either Alice or Bob wins the game eventually. You must find out who the winner will be.

        Input
        The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
        The first line of each testcase contains two space-separated integers N and M.
        The second line contains N space-separated integers A1,A2,…,AN.
        The third line contains M space-separated integers B1,B2,…,BM.
        Output
        Print a single line containing the string "Alice" if Alice wins or "Bob" if Bob wins.

        Constraints
        1≤T≤102
        1≤N,M≤102
        0≤Ai≤109 for each valid i
        0≤Bi≤109 for each valid i
        Example Input
        3
        3 1
        1 1 1
        3
        3 1
        1 2 4
        7
        1 1
        1
        1
Example Output
Alice
Alice
Bob
        */

import java.util.Arrays;

public class BuddyNIM {

    //      m:3
    //      n:1
    //table 1: 1 1 1
    //table 2: 3
    public void solve(int m, int n, int table1[], int table2[]) {
        Arrays.sort(table1);
        Arrays.sort(table2);
        int i = 0, j = 0;
        while (table1[i] == 0) i++;
        while (table2[j] == 0) j++;
        while (i < m && j < n) {
            if (table1[i] != table2[j]) {
                System.out.println("Alice");
                return;
            }
            i++;
            j++;
        }
        if (i == m && j == n) {
            System.out.println("Bob");
        } else {
            System.out.println("Alice");
        }
    }

    public static void main(String[] args) {
        BuddyNIM b = new BuddyNIM();
        int m = 3;
        int n = 1;
        int table1[] = {1, 1, 1};
        int table2[] = {3};
        b.solve(m, n, table1, table2);

        int m1 = 3;
        int n1 = 1;
        int table11[] = {1, 2, 4};
        int table21[] = {7};
        b.solve(m1, n1, table11, table21);

        int m2 = 1;
        int n2 = 1;
        int table12[] = {1};
        int table22[] = {1};
        b.solve(m2, n2, table12, table22);


        int m3 = 5;
        int n3 = 4;
        int table13[] = {2, 3, 0, 0, 5};
        int table23[] = {5, 3, 2, 0};
        b.solve(m3, n3, table13, table23);
    }
}