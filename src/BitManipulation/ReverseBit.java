package BitManipulation;

public class ReverseBit {
    /*
        Problem Description

        Reverse the bits of an 32 bit unsigned integer A.



        Problem Constraints
    0 <= A <= 232



        Input Format
        First and only argument of input contains an integer A.



        Output Format
        Return a single unsigned integer denoting the decimal value of reversed bits.



        Example Input
        Input 1:

                0
        Input 2:

                3
    */
    public long reverse(long a) {
        long rev = 0;
        for (int i = 0; i < 32; i++, a >>= 1) {
            rev = (rev << 1) | (a & 1);
            System.out.println(Integer.toBinaryString((int) rev));
            System.out.println(Integer.toBinaryString((int) a));
        }
        return rev;
    }

    public static void main(String[] args) {
        ReverseBit rb = new ReverseBit();
        rb.reverse(3);
    }
}