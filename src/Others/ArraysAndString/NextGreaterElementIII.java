package Others.ArraysAndString;

/*Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

        Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.



        Example 1:

        Input: n = 12
        Output: 21
        Example 2:

        Input: n = 21
        Output: -1


        Constraints:

        1 <= n <= 231 - 1*/
public class NextGreaterElementIII {

    //6537421
    //convert int to string
    //traverse from back until we get greater element than previous one i.e "37" in above example
    //j is pointing to 3
    //again traverse from end of string and find out just greater to 3 i.e 4 in above example
    //i is pointing to 4
    //swap i & j and string becomes
    //6547321
    //still this is not the answer
    //reverse all the characters after i
    //6541237->res
    public int nextGreaterElement(int n) {
        int j = 0, i = 0;
        String temp = String.valueOf(n);
        for (j = temp.length() - 2; j >= 0; j--) {
            if (temp.charAt(j) >= temp.charAt(j + 1)) continue;
            break;
        }
        if (j < 0) return -1;
        for (i = temp.length() - 1; i >= 0; i--) {
            if (temp.charAt(i) <= temp.charAt(j)) continue;
            break;
        }
        temp = swap(i, j, temp);
        char[] res = temp.toCharArray();
        i = temp.length() - 1;
        j++;
        while (j <= i) {
            char c = res[j];
            res[j] = res[i];
            res[i] = c;
            j++;
            i--;
        }
        return Integer.valueOf(String.valueOf(res));
    }

    private String swap(int i, int j, String str) {
        char[] temp = str.toCharArray();
        char c = temp[i];
        temp[i] = temp[j];
        temp[j] = c;
        return String.valueOf(temp);
    }

    public static void main(String[] args) {
        NextGreaterElementIII n = new NextGreaterElementIII();
        System.out.println(n.nextGreaterElement(6537421));
        System.out.println(n.nextGreaterElement(21));
        System.out.println(n.nextGreaterElement(12));
    }
}