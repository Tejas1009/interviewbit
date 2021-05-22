package Math;

public class MathLastNumberK {
    int cnt = 0;

    public void getPerms(int arr[], int len, int k, String osf) {
        if (osf.length() == 3) {
            System.out.println(osf);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            getPerms(arr, len, k, osf + arr[i]);
        }
    }

    public static void main(String[] args) {
        MathLastNumberK k = new MathLastNumberK();
        int arr[] = {0, 1, 2};
        k.getPerms(arr, 2, 21, "");
    }
}
