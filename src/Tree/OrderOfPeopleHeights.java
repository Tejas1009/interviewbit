package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*You are given the following :

        A positive number N
        Heights : A list of heights of N persons standing in a queue
        Infronts : A list of numbers corresponding to each person (P) that gives the number of persons who are taller than P and standing in front of P
        You need to return list of actual order of persons’s height

        Consider that heights will be unique

        Example

        Input :
        Heights: 5 3 2 6 1 4
        InFronts: 0 1 2 0 3 2
        Output :
        actual order is: 5 3 2 1 6 4
        So, you can see that for the person with height 5, there is no one taller than him who is in front of him, and hence Infronts has 0 for him.

        For person with height 3, there is 1 person ( Height : 5 ) in front of him who is taller than him.

        You can do similar inference for other people in the list.*/
public class OrderOfPeopleHeights {
    class PeopleModel {
        int h;
        int i;

        PeopleModel(int h, int i) {
            this.h = h;
            this.i = i;
        }
    }

    public int[] order(int[] h, int[] inf) {
        int res[] = new int[h.length];
        ArrayList<PeopleModel> pm = new ArrayList<>();
        for (int k = 0; k < h.length; k++) {
            pm.add(new PeopleModel(h[k], inf[k]));
        }
        Collections.sort(pm, new Comparator<PeopleModel>() {
            @Override
            public int compare(PeopleModel p1, PeopleModel p2) {
                if (p1.h == p2.h) {
                    return 0;
                } else if (p1.h > p2.h) {
                    return 1;
                } else return -1;
            }
        });
        for (int k = 0; k < pm.size(); k++) {
            PeopleModel p = pm.get(k);
            int cnt = p.i, x = 0;
            while (true) {
                if (cnt == 0 && res[x] == 0) {
                    res[x] = p.h;
                    break;
                }
                if (res[x] == 0 || (res[x] >= p.h && cnt > 0)) {
                    cnt--;
                }
                x++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        OrderOfPeopleHeights o = new OrderOfPeopleHeights();
        ArrayList<Integer> height = new ArrayList<>(Arrays.asList(5, 3, 2, 6, 1, 4));
        ArrayList<Integer> infronts = new ArrayList<>(Arrays.asList(0, 1, 2, 0, 3, 2));
        int h[] = {5, 3, 2, 6, 1, 4};
        int i[] = {0, 1, 2, 0, 3, 2};
        o.order(h, i);
    }
}