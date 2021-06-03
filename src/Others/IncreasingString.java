package Others;

import java.util.Scanner;

import static java.lang.Math.min;

public class IncreasingString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc > 0) {
            String s = sc.next();
            char[] arr = s.toCharArray();
            int change[][] = new int[26][26];
            for (int x = 0; x < 26; x++) {
                for (int i = 0; i < 26; i++) {
                    change[x][i] = sc.nextInt();
                }
            }
            int len = s.length();
            int dp[][] = new int[2000][28];


            for (int i = 0; i < 26; i++)
                dp[0][i] = change[arr[0] - 'a'][i];//  for  1st position calcuate all possible replacements

            for (int i = 1; i < len; i++) {
                for (int j = 0; j < 26; j++)//try to fix ith position  fix each character and  calculate cost by fixing i-1 th character to any val less than ith
                {
                    dp[i][j] = change[arr[i] - 'a'][j];// cost of fixing it character to j
                    int adn = Integer.MAX_VALUE;
                    for (int k = 0; k <= j; k++) {
                        adn = min(dp[i - 1][k], adn);//  calculating min cost from fixing i-1 character to all value less than j
                    }
                    dp[i][j] += adn;// adding min cost
                }
            }

            int ans = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < 26; i++) {
                if (dp[len - 1][i] < ans) {
                    ans = dp[len - 1][i];
                    index = i;
                }
            }
            System.out.print(ans + " ");
            char str[] = new char[len + 10];
            str[len - 1] = (char) (index + 'a');
            for (int i = len - 2; i >= 0; i--) {
                int an = Integer.MAX_VALUE;
                int pindex = 0;
                for (int k = 0; k <= index; k++)// since last character in index so this character can be up to index  start from a to index so that get lexographical minum
                {
                    if (dp[i][k] < an) {
                        an = dp[i][k];
                        pindex = k;
                    }
                }
                str[i] = (char) (pindex + 'a');
                index = pindex;
            }
            System.out.print(str);
            System.out.println();
            tc--;
        }
    }
}