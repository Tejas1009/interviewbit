package Strings;

import java.util.ArrayList;
import java.util.Collections;

/*Valid Ip Addresses
        Asked in:
        Amazon
        Given a string containing only digits, restore it by returning all possible valid IP address combinations.

        A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.

        Example:

        Given “25525511135”,

        return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned strings are sorted in order)*/
public class ValidIpAddresses {

    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        dfs(s, "", 0, res);
        Collections.sort(res);
        return res;
    }

    private void dfs(String s, String sub, int index, ArrayList<String> res) {
        if (index == 4 || s.length() == 0) {
            if (index == 4 && s.length() == 0) {
                res.add(sub.substring(0, sub.length() - 1));
            }
            return;
        }
        dfs(s.substring(1), sub + s.substring(0, 1) + ".", index + 1, res);
        if (s.length() > 1 && s.charAt(0) != '0') {
            dfs(s.substring(2), sub + s.substring(0, 2) + ".", index + 1, res);
            if (s.length() > 2 && Integer.valueOf(s.substring(0, 3)) <= 255) {
                dfs(s.substring(3), sub + s.substring(0, 3) + ".", index + 1, res);
            }
        }
    }

    public static void main(String[] args) {
        ValidIpAddresses v = new ValidIpAddresses();
        System.out.println(v.restoreIpAddresses("25525511135"));
    }
}
