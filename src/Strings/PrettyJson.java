package Strings;

/*
Given a string A representating json object. Return an array of string denoting json object with proper indentaion.

        Rules for proper indentaion:

        Every inner brace should increase one indentation to the following lines.
        Every close brace should decrease one indentation to the same line and the following lines.
        The indents can be increased with an additional ‘\t’
        Note:

        [] and {} are only acceptable braces in this case.

        Assume for this problem that space characters can be done away with.



        Input Format

        The only argument given is the integer array A.
        Output Format

        Return a list of strings, where each entry corresponds to a single line. The strings should not have "\n" character in them.
        For Example

        Input 1:
        A = "{A:"B",C:{D:"E",F:{G:"H",I:"J"}}}"
        Output 1:
        {
        A:"B",
        C:
        {
        D:"E",
        F:
        {
        G:"H",
        I:"J"
        }
        }
        }

        Input 2:
        A = ["foo", {"bar":["baz",null,1.0,2]}]
        Output 2:
        [
        "foo",
        {
        "bar":
        [
        "baz",
        null,
        1.0,
        2
        ]
        }
        ]
        Seen this question in a real interview before
*/

import java.util.ArrayList;

public class PrettyJson {
    public ArrayList<String> prettyJSON(String A) {
        int indt = 0;
        ArrayList<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            switch (c) {
                case '[':
                case '{':
                    indt++;
                    sb = sb.append(c);
                    res.add(sb.toString());
                    sb = new StringBuilder();
                    for (int k = 0; k < indt; k++) {
                        sb = sb.append("\t");
                    }
                    break;
                case ',':
                    sb = sb.append(c);
                    res.add(sb.toString());
                    sb = new StringBuilder();
                    for (int k = 0; k < indt; k++) {
                        sb = sb.append("\t");
                    }
                    break;
                case ':':
                    if (A.charAt(i + 1) != '{' && A.charAt(i + 1) != '[') {
                        sb = sb.append(c);
                    } else {
                        sb = sb.append(c);
                        res.add(sb.toString());
                        sb = new StringBuilder();
                        for (int k = 0; k < indt; k++) {
                            sb = sb.append("\t");
                        }
                    }
                    break;
                case '}':
                case ']':
                    if (sb.length() > 0) {
                        res.add(sb.toString());
                        sb = new StringBuilder();
                    }
                    indt--;
                    for (int k = 0; k < indt; k++) {
                        sb = sb.append("\t");
                    }
                    sb = sb.append(c);
                    if (i < A.length() - 1 && A.charAt(i + 1) != ',') {
                        res.add(sb.toString());
                        sb = new StringBuilder();
                    }
                    if (i == A.length() - 1) {
                        res.add(sb.toString());
                    }
                    break;
                default:
                    sb = sb.append(c);
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PrettyJson pj = new PrettyJson();
        System.out.println(pj.prettyJSON("{\"id\":100,\"firstName\":\"Jack\",\"lastName\":\"Jones\",\"age\":12}"));
    }
}