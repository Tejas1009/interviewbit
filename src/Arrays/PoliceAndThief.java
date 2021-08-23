package Arrays;

import java.util.ArrayList;
import java.util.List;

public class PoliceAndThief {

    public static void main(String[] args) {
        char arr[] = {'P', 'T', 'P', 'T', 'T', 'P'};
        int k = 3;
        int res = 0;
        List<Integer> police = new ArrayList<>();
        List<Integer> thieves = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P') {
                police.add(i);
            } else {
                thieves.add(i);
            }
        }
        //0,3
        //
        int i = 0, j = 0;
        while (i < police.size() && j < thieves.size()) {
            if (Math.abs(police.get(i) - thieves.get(j)) <= k) {
                i++;
                j++;
                res++;
            } else if (police.get(i) < thieves.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        System.out.println(res);
    }
}
