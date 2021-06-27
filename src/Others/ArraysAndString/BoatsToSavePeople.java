package Others.ArraysAndString;

import java.util.Arrays;

/*You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

        Return the minimum number of boats to carry every given person.



        Example 1:

        Input: people = [1,2], limit = 3
        Output: 1
        Explanation: 1 boat (1, 2)
        Example 2:

        Input: people = [3,2,2,1], limit = 3
        Output: 3
        Explanation: 3 boats (1, 2), (2) and (3)
        Example 3:

        Input: people = [3,5,3,4], limit = 5
        Output: 4
        Explanation: 4 boats (3), (3), (4), (5)


        Constraints:

        1 <= people.length <= 5 * 104
        1 <= people[i] <= limit <= 3 * 104*/
public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        int res = 0;
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        while (i <= j) {
            //case 1 if both person's weight is less than limit
            if (people[i] + people[j] <= limit) {
                i++;
            }
            //both person cannot travel in single boat
            //so we send heavy person first so that in next iteration we can accompany light weighted person with less weighted person
            j--;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        BoatsToSavePeople b = new BoatsToSavePeople();
        int people[] = {1, 2};
        System.out.println(b.numRescueBoats(people, 3));
        int people1[] = {3, 2, 2, 1};
        System.out.println(b.numRescueBoats(people1, 3));
        int people2[] = {3, 5, 3, 4};
        System.out.println(b.numRescueBoats(people2, 5));
    }
}