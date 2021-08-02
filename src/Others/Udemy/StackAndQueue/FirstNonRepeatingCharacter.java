package Others.Udemy.StackAndQueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
First Non-Repeating Character
Given a stream of characters (lowercase alphabets), find the first non-repeating character from
stream. You need to tell the first non-repeating character in O(1) time at each index. If for a
current index there is no such character returm -1 for that particular index.
Input:
a,a,b,c,c,b,c,d
Output:
a,-1,b,b,b,-1,-1,d
 */
public class FirstNonRepeatingCharacter {
    public static void findFirstNonRepeatingCharacter(String str) {
        //we will be using hashmap and queue
        //hash map will store frequency of character
        //queue will store the order
        //if queue is empty that means all characters are repeating
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        int i = -1;
        while (++i < str.length()) {
            Character curr_ch = str.charAt(i);
            queue.add(curr_ch);
            map.putIfAbsent(curr_ch, 0);
            map.put(curr_ch, map.get(curr_ch) + 1);
            Character ch = queue.peek();
            if (ch == null) {
                if (map.get(curr_ch) == 1) {
                    System.out.print(curr_ch);
                } else {
                    System.out.print(-1);
                }
            } else {
                while (ch != null) {
                    if (map.get(ch) == 1) {
                        System.out.print(ch);
                        break;
                    } else {
                        ch = queue.poll();
                    }
                }
                if (ch == null) {
                    System.out.print(-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        findFirstNonRepeatingCharacter("aabccbcd");
        System.out.println();
    }
}
