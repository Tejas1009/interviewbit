package Others.Udemy.String;

import java.util.ArrayList;

public class CustomTokenizer {

    /*
        Input: str='Today is a rainy day', deleimter: ' '
        OP: Today
            is
            a
            rainy
            day
     */
    public static ArrayList<String> customSplit(String str, char delimiter) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == delimiter) {
                res.add(token.toString());
                token = new StringBuilder();
            } else {
                token.append(str.charAt(i));
            }
        }
        if (token.length() > 0)
            res.add(token.toString());
        return res;
    }

    public static void main(String[] args) {
        customSplit("Today is a rainy day", ' ').forEach(System.out::println);
        System.out.println("--------------------");
        customSplit("Today", 'a').forEach(System.out::println);
    }
}
