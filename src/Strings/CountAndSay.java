package Strings;

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
        System.out.println(cs.countAndSay(0));
    }
}
