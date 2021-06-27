package Others.ArraysAndString;

/*Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

        You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.



        Example 1:

        Input: name = "alex", typed = "aaleex"
        Output: true
        Explanation: 'a' and 'e' in 'alex' were long pressed.
        Example 2:

        Input: name = "saeed", typed = "ssaaedd"
        Output: false
        Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
        Example 3:

        Input: name = "leelee", typed = "lleeelee"
        Output: true
        Example 4:

        Input: name = "laiden", typed = "laiden"
        Output: true
        Explanation: It's not necessary to long press any character.


        Constraints:

        1 <= name.length <= 1000
        1 <= typed.length <= 1000
        name and typed contain only lowercase English letters.*/
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) return false;
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
            } else if (typed.charAt(j) != typed.charAt(j - 1)) {
                return false;
            }
            j++;
        }
        return i == name.length();
    }

    public static void main(String[] args) {
        LongPressedName l = new LongPressedName();
        System.out.println(l.isLongPressedName("alex", "aaleex"));
        System.out.println(l.isLongPressedName("saeed", "ssaaedd"));
        System.out.println(l.isLongPressedName("leelee", "lleeelee"));
        System.out.println(l.isLongPressedName("laiden", "laiden"));
    }
}