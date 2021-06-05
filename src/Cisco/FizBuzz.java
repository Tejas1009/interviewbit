package Cisco;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FizBuzz {

    public static int howManyWorked(String sentence) {
        int count = 0;
        String[] words = sentence.split("\\s+");
        Pattern letter = Pattern.compile("[a-zA-z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile("[~`@#$%^&*()_+={}\\[\\]|;:'/\"'<>/]");
        for (String w : words) {
            Matcher hasLetter = letter.matcher(w);
            Matcher hasDigit = digit.matcher(w);
            Matcher hasSpecial = special.matcher(w);
            if (!hasDigit.find() && hasLetter.find() && !hasSpecial.find()) {
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    public static int howMany(String sentence) {
        // Write your code here
        int count = 0;
        String[] words = sentence.split("\\s+");
        for (String w : words) {
            if (!w.trim().isEmpty() && w.matches("[a-zA-Z,.?\\s-]*")) {
                count++;
                System.out.println(w);
            }
        }
        System.out.println(count);
        return count;
    }

    static int MAX_CHAR = 10;

    static boolean check(int freq[], int k) {
        for (int i = 0; i < MAX_CHAR; i++)
            if (freq[i] != 0 && freq[i] != k)
                return false;
        return true;
    }

    public static int perfectSubstring(String s, int k) {
        // Write your code here
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int freq[] = new int[MAX_CHAR];
            for (int j = i; j < s.length(); j++) {
                int index = s.charAt(j) - '0';
                freq[index]++;
                if (freq[index] > k)
                    break;
                else if (freq[index] == k &&
                        check(freq, k) == true)
                    res++;
            }
        }
        System.out.println(res);
        return res;
    }

    //____________-
    static String integer_to_string(int n) {
        String str = "";
        while (n > 0) {
            int digit = n % 2;
            n /= 2;
            str += (char) (digit + '0');
        }
        return str;
    }

    static int isPalindrome(int i) {
        int temp = i;
        int m = 0;
        while (temp > 0) {
            m = temp % 10 + m * 10;
            temp /= 10;
        }
        if (m == i) {
            String str = integer_to_string(m);
            StringBuilder sb = new StringBuilder(str);
            String str1 = sb.reverse().toString();
            if (str.equals(str1)) {
                return i;
            }
        }
        return 0;
    }

    public static int getSumOfDoubleBasePalindromes(int maximum) {
        int sum = 0;
        for (int i = 1; i <= maximum; i++) {
            sum += isPalindrome(i);
        }
        return sum;
    }

    //_____________

    public static int efficientJanitor2(float[] arr) {
        int limit = 3;
        int n = arr.length;
        Arrays.sort(arr);

        boolean[] check = new boolean[n];
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (check[i]) continue;
            check[i] = true;
            count++;

            float remain = (limit - arr[i]);
            for (int j = i - 1; j >= 0; j--) {
                if (!check[j] && arr[j] <= remain) {
                    remain = (remain - arr[j]);
                    check[j] = true;
                    // break;  // add this if  maximum items = 2
                }
            }
        }
        System.out.println(count);
        return count;
    }

    public static int efficientJanitor(List<Float> weight) {
        // Write your code here
        Collections.sort(weight);
        int left = 0;
        int right = weight.size() - 1;
        int count = 0;
        while (left <= right) {
            if (left == right) {
                count++;
                break;
            }
            if (weight.get(left) + weight.get(right) <= 3.0) {
                left++;
            }
            right--;
            count++;

        }
        //    System.out.println(count);
        return count;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static int countProperFractions(int max_d) {
        int count = 0;
        for (int i = max_d; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (j < i) {
                    if (gcd(j, i) == 1) count++;
                }
            }
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Float> w = new ArrayList<>();
        //1.01. 1.991, 1.32, 1.4
/*        w.add((float) 1);
        w.add((float) 1);
        w.add((float) 1);
        w.add((float) 1);
        w.add((float) 1);*/
        w.add((float) 1.01);
        w.add((float) 1.991);
        w.add((float) 1.32);
        w.add((float) 1.4);

        //efficientJanitor(w);
        float[] ww = {(float) 1, (float) 1, (float) 1, (float) 1, (float) 1};
        //efficientJanitor2(ww);
        //getSumOfDoubleBasePalindromes(5);
        perfectSubstring("1221221121", 3);
        //howMany(" )}OJR 92ww. z )UPl 49e ]S  g. zrZEnQ  D. FoKp ]ow 1EceB 3oK }w ]CA? L 3LPbDN! trqJY 0sBmm. Nwn");
        //countProperFractions(9);
    }
}