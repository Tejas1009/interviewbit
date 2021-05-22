package Math;

public class ExcelColumnNumber {
    public static void main(String[] args) {
        String A = "AAA";
        int res = (A.charAt(A.length() - 1) - 'A') + 1;
        int c = 1;
        for (int i = A.length() - 2; i >= 0; i--) {
            res += (Math.pow(26, c)) * (A.charAt(i) - 'A' + 1);
            c++;
        }
        System.out.println(res);
    }
}
