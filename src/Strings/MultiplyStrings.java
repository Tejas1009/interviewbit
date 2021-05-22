package Strings;

/*Given two numbers represented as strings, return multiplication of the numbers as a string.

        Note: The numbers can be arbitrarily large and are non-negative.
        Note2: Your answer should not have leading zeroes. For example, 00 is not a valid answer.
        For example,
        given strings "12", "10", your answer should be “120”.

        NOTE : DO NOT USE BIG INTEGER LIBRARIES ( WHICH ARE AVAILABLE IN JAVA / PYTHON ).
        We will retroactively disqualify such submissions and the submissions will incur penalties.*/
public class MultiplyStrings {
    public String multiply(String A, String B) {
        if (A == "0") {
            return "0";
        }
        if (B.equals("0")) {
            return "0";
        }
        int arr[] = new int[A.length() + B.length()];
        for (int i = A.length() - 1; i >= 0; i--) {
            for (int j = B.length() - 1; j >= 0; j--) {
                arr[i + j + 1] += (A.charAt(i) - '0') * (B.charAt(j) - '0');
                arr[i + j] += arr[i + j + 1] / 10;
                arr[i + j + 1] = arr[i + j + 1] % 10;
            }
        }
        StringBuilder sb = new StringBuilder("0");
        int i = 0;
        for (; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }
            break;
        }
        for (int k = i; k < arr.length; k++) {
            sb = sb.append(arr[k]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings ms = new MultiplyStrings();
        System.out.println(ms.multiply("31243242535342", "0"));
    }
}