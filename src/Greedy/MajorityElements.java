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

    public static int majorityElement2(int arr[]) {
        int count = 1, element = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (count == 0) {
                element = arr[i];
            }
            if (arr[i] == element) {
                count++;
            } else {
                count--;
            }
        }
        return element;
    }

    public static void main(String[] args) {
        int arr[] = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement2(arr));
        //MajorityElements m = new MajorityElements();

        //System.out.println(m.majorityElement(arr));
    }
}
