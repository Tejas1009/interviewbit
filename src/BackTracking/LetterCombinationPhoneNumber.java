package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/?envType=problem-list-v2&envId=plakya4j
 * 17. Letter Combinations of a Phone Number
 * Medium
 * Topics
 * Companies
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 * <p>
 * Input: digits = ""
 * Output: []
 * Example 3:
 * <p>
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombinationPhoneNumber {
    public static void main(String[] args) {
        List<String> res = letterCombinations("234");
        res.stream().forEach(System.out::println);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return res;
        }

        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");
        backtrack(new StringBuilder(), 0, digits, digitToLetters, res);
        return res;
    }

    private static void backtrack(StringBuilder combination, int idx, String digits, Map<Character, String> digitToLetters, List<String> res) {
        if (idx == digits.length()) {
            res.add(combination.toString());
            return;
        }
        String letters = digitToLetters.get(digits.charAt(idx));
        for (char ch : letters.toCharArray()) {
            combination.append(ch);
            backtrack(combination, idx + 1, digits, digitToLetters, res);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
