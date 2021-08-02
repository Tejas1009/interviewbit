package Others;

public class CountOfSubstringWithKOnes {
    static int countOfSubstringWithKOnes(
            String s, int K) {
        int N = s.length();
        int res = 0;
        int countOfOne = 0;
        int[] freq = new int[N + 1];

        // initialize index having zero
        // sum as 1
        freq[0] = 1;

        // loop over binary characters
        // of string
        for (int i = 0; i < N; i++) {

            // update countOfOne variable
            // with value of ith character
            countOfOne += (s.charAt(i) - '0');

            // if value reaches more than
            // K, then update result
            if (countOfOne >= K) {

                // add frequency of indices,
                // having sum (current sum - K),
                // to the result
                res += freq[countOfOne - K];
            }

            // update freqency of one's count
            freq[countOfOne]++;
        }
        return res;
    }

    // Driver code to test above methods
    static public void main(String[] args) {
        String s = "101101";
        int K = 3;

        System.out.println(
                countOfSubstringWithKOnes(s, K));
    }
}
