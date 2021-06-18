package Strings;

/*Remove Consecutive Characters
        Asked in:
        BrowserStack
        Problem Description

        Given a string A and integer B, remove all consecutive same characters that have length exactly B.



        Problem Constraints
        1 <= |A| <= 100000

        1 <= B <= |A|



        Input Format
        First Argument is string A.

        Second argument is integer B.



        Output Format
        Return a string after doing the removals.



        Example Input
        Input 1:

        A = "aabcd"
        B = 2
        Input 2:

        A = "aabbccd"
        B = 2


        Example Output
        Output 1:

        "bcd"
        Output 2:

        "d"


        Example Explanation
        Explanation 1:

        "aa" had length 2.
        Explanation 2:

        "aa", "bb" and "cc" had length of 2.*/

public class RemoveConsecutiveCharacters {
    public String solve(String A, int B) {
        String ans = "";
        String buffer = "";
        buffer += A.charAt(0);
        char prev = A.charAt(0);

        for (int i = 1; i < A.length(); i++) {
            if (prev == A.charAt(i)) {
                buffer += A.charAt(i);
            } else {
                if (buffer.length() != B) {
                    ans += buffer;
                }
                buffer = "" + A.charAt(i);
                prev = A.charAt(i);
            }
        }

        if (buffer.length() != B) {
            ans += buffer;
        }

        return ans;
    }

    public static void main(String[] args) {
        RemoveConsecutiveCharacters r = new RemoveConsecutiveCharacters();
        System.out.println(r.solve("aabbccd", 2));
    }
}