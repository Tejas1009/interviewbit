package BackTracking;

import java.util.ArrayList;

/*The set [1,2,3,…,n] contains a total of n! unique permutations.

        By listing and labeling all of the permutations in order,
        We get the following sequence (ie, for n = 3 ) :

        1. "123"
        2. "132"
        3. "213"
        4. "231"
        5. "312"
        6. "321"
        Given n and k, return the kth permutation sequence.

        For example, given n = 3, k = 4, ans = "231"

        Good questions to ask the interviewer :
        What if n is greater than 10. How should multiple digit numbers be represented in string?
        In this case, just concatenate the number to the answer.
        so if n = 11, k = 1, ans = "1234567891011"
        Whats the maximum value of n and k?
        In this case, k will be a positive integer thats less than INT_MAX.
        n is reasonable enough to make sure the answer does not bloat up a lot.
        Seen this question in a real interview before*/
public class KthPermutations {

    public String getPermutation(int n, int k) {
        String ans = "";
        ArrayList<Integer> ds = new ArrayList<>(n);
        int fact = 1;
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            ds.add(i);
        }
        ds.add(n);
        k = k - 1;
        while (fact != 0 && true && k >= 0) {
            System.err.println(n);
            System.err.println(k);
            System.err.println(fact);
            System.err.println(k / fact);
            ans = ans + ds.get((int) (k / fact));
            ds.remove(k / fact);
            if (ds.size() <= 0) {
                break;
            }
            k = k % fact;
            fact = fact / ds.size();
        }
        return ans;
    }

    public static void main(String[] args) {
        KthPermutations k = new KthPermutations();
        System.out.println(k.getPermutation(23, 99999999));
    }
}
