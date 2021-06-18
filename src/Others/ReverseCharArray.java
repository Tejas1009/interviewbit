package Others;

public class ReverseCharArray {

    char arr[];

    private void reverse(int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public void reverseKElement(char[] arr, int k) {
        this.arr = arr;
        k = k % arr.length;
        if (k == 0) {
            System.out.println(arr);
            return;
        }
        if (k < 0) {
            k = arr.length + k;
        }
        //part 1:
        reverse(0, arr.length - k - 1);
        //part 2:
        reverse(arr.length - k, arr.length - 1);
        //reverse whole string
        reverse(0, arr.length - 1);
        System.out.println(arr);
    }

    public static void main(String[] args) {
        ReverseCharArray r = new ReverseCharArray();
        char arr[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        r.reverseKElement(arr, -1);
    }
}