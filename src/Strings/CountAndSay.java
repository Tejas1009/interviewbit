package Strings;

/*Count And Say
        Asked in:
        Facebook
        Amazon
        The count-and-say sequence is the sequence of integers beginning as follows:

        1, 11, 21, 1211, 111221, ...
        1 is read off as one 1 or 11.
        11 is read off as two 1s or 21.

        21 is read off as one 2, then one 1 or 1211.

        Given an integer n, generate the nth sequence.

        Note: The sequence of integers will be represented as a string.

        Example:

        if n = 2,
        the sequence is 11.*/
public class CountAndSay {
    public String countAndSay(int A) {
        if (A <= 0) {
            return "";
        }
        String osf = "1";
        StringBuilder nextStr = new StringBuilder("");
        while (A > 1) {
            char currChar = osf.charAt(0);
            int currCharCnt = 0;
            for (int i = 0; i < osf.length(); i++) {
                if (currChar == osf.charAt(i)) {
                    currCharCnt++;
                } else {
                    nextStr = nextStr.append(currCharCnt).append(currChar);
                    currChar = osf.charAt(i);
                    currCharCnt = 1;
                }
            }
            osf = nextStr.append(currCharCnt).append(currChar).toString();
            nextStr = new StringBuilder("");
            A--;
        }
        return osf.toString();
    }

    public static void main(String[] args) {
        CountAndSay cs = new CountAndSay();
        System.out.println(cs.countAndSay(4));
    }
}
