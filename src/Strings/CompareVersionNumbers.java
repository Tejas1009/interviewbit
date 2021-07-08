package Strings;

public class CompareVersionNumbers {

    //1.3
    //1.3.1
    public int compareVersion(String ver1, String ver2) {
        long num1 = 0, num2 = 0;
        for (int i = 0; i < ver1.length(); i++) {
            char ch = ver1.charAt(i);
            if (ch == '.') continue;
            if (i == ver1.length() - 1 && ch == '0' && ver1.charAt(i - 1) == '.') continue;
            int m = ch - '0';
            num1 = (num1 * 10) + m;
        }
        for (int i = 0; i < ver2.length(); i++) {
            char ch = ver2.charAt(i);
            if (ch == '.') continue;
            if (i == ver2.length() - 1 && ch == '0' && ver2.charAt(i - 1) == '.') continue;

            int m = ch - '0';
            num2 = (num2 * 10) + m;
        }
        return (num1 < num2) ? -1 : ((num1 == num2) ? 0 : 1);
    }

    public static void main(String[] args) {
        CompareVersionNumbers c = new CompareVersionNumbers();
        System.out.println(c.compareVersion("4444444444444444444444444", "444444444444444444444444"));
    }
}
