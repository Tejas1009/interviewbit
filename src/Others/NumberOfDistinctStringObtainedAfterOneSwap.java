package Others;

/*
Given a string S containing lowercase English alphabet characters. The task is to calculate the number of distinct strings that can be obtained after performing exactly one swap.
In one swap,Geek can pick two distinct indexes i and j (i.e 1 < i < j < |S| ) of the string, then swap the characters at the position i and j.
Example 1:
Input:
S = "geek"
Output:
6
Explanation:
After one swap, there are only 6 distinct strings possible.
(i.e "egek","eegk","geek","geke","gkee" and "keeg")
 */
public class NumberOfDistinctStringObtainedAfterOneSwap {
    public static int count(String str) {
        int freq[] = new int[25];
        int res = 1;
        freq[str.charAt(0) - 'a']++;
        for (int i = 1; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            res += (i - freq[idx]);
            freq[idx]++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(count("geek"));
    }
}
