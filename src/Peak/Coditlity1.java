package Peak;

/*
1578. Minimum Deletion Cost to Avoid Repeating Letters
Medium

513

25

Add to List

Share
Given a string s and an array of integers cost where cost[i] is the cost of deleting the ith character in s.

Return the minimum cost of deletions such that there are no two identical letters next to each other.

Notice that you will delete the chosen characters at the same time, in other words, after deleting a character, the costs of deleting other characters will not change.



Example 1:

Input: s = "abaac", cost = [1,2,3,4,5]
Output: 3
Explanation: Delete the letter "a" with cost 3 to get "abac" (String without two identical letters next to each other).
Example 2:

Input: s = "abc", cost = [1,2,3]
Output: 0
Explanation: You don't need to delete any character because there are no identical letters next to each other.
Example 3:

Input: s = "aabaa", cost = [1,2,3,4,1]
Output: 2
Explanation: Delete the first and the last character, getting the string ("aba").
 */
public class Coditlity1 {

    public int solution(String s, int cost[]) {
        char prev_char = s.charAt(0);
        int prev_val = cost[0];
        int ans = 0;

        for (int i = 1; i < s.length(); i++) {
            char curr_char = s.charAt(i);
            int curr_val = cost[i];

            if (curr_char == prev_char) {

                if (prev_val <= curr_val) {
                    ans += prev_val;
                    prev_val = curr_val;
                } else {
                    ans += curr_val;
                }
            } else {
                prev_char = curr_char;
                prev_val = curr_val;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Coditlity1 c = new Coditlity1();
        int arr[] = {0, 1, 2, 3, 4, 5};
        System.out.println(c.solution("abccbd", arr));
    }
}