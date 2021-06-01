package Greedy;

/*Majority Element
        Asked in:
        Microsoft
        Yahoo
        Google
        Amazon
        Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.

        You may assume that the array is non-empty and the majority element always exist in the array.

        Example :

        Input : [2, 1, 2]
        Return  : 2 which occurs 2 times which is greater than 3/2.*/
public class MajorityElements {

    public int majorityElement(int arr[]) {
        int m_idx = 0, cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[m_idx]) {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                m_idx = i;
                cnt++;
            }
        }
        return arr[m_idx];
    }

    public static void main(String[] args) {
        MajorityElements m = new MajorityElements();
        int arr[] = {100};
        System.out.println(m.majorityElement(arr));
    }
}
