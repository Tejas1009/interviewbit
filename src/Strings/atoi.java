package Strings;

public class atoi {
    public static void main(String[] args) {
        String A = "5121478262  072BT097 0 N818 Q 74571983Q7391995080P1810U 9070955Q90 T04437 545N792730 73";
        int res = 0, i = 0, sign = 1;
        while (A.charAt(i) == ' ') {
            i++;
        }
        if (A.charAt(i) == '-' || A.charAt(i) == '+') {
            sign = A.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        if (!Character.isDigit(A.charAt(i))) {
            System.out.println(0);
            return;
        }
        for (; i < A.length(); i++) {
            if (!Character.isDigit(A.charAt(i))) {
                break;
            }
            //if ((res * 10 + (A.charAt(i) - '0')) > (Integer.MAX_VALUE / 10)) {
            //if ((Integer.MAX_VALUE - (res * 10 + (A.charAt(i) - '0')) < 0)) {
            if (res >= Integer.MAX_VALUE / 10) {
                res = Integer.MAX_VALUE;
                break;
            }
            res = res * 10 + (A.charAt(i) - '0');
        }
        if (sign == -1 && res == Integer.MAX_VALUE) {
            System.out.println(Integer.MIN_VALUE);
        } else if (sign == -1) {
            System.out.println(sign * res);
        } else {
            System.out.println(res);
        }
    }
}
