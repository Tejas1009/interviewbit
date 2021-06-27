package Others.ArraysAndString;

import java.util.HashSet;
import java.util.Set;

/*Given a string s, reverse only all the vowels in the string and return it.

        The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.



        Example 1:

        Input: s = "hello"
        Output: "holle"
        Example 2:

        Input: s = "leetcode"
        Output: "leotcede"


        Constraints:

        1 <= s.length <= 3 * 105
        s consist of printable ASCII characters.*/
public class ReverseVowelsOfString {
    public String reverseVowels(String s) {
        char ch[] = s.toCharArray();
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int i = 0, j = ch.length - 1;
        while (i < j) {
            while (i < ch.length && !vowels.contains(ch[i])) i++;
            while (j >= 0 && !vowels.contains(ch[j])) j--;
            if (i < j) {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
            }
            i++;
            j--;
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        ReverseVowelsOfString r = new ReverseVowelsOfString();
        System.out.println(r.reverseVowels("hello"));
        System.out.println(r.reverseVowels("leetcode"));
        System.out.println(r.reverseVowels("tejas"));
    }
}
