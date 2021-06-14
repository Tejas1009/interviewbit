package Ninja;

import java.util.*;

public class Mode {

    public ArrayList<Integer> getMode(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        TreeMap<Integer, TreeMap<Integer, Integer>> map2 = new TreeMap<>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i : A) {
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }
        for (Map.Entry m : map.entrySet()) {
            int freq = (int) m.getValue();
            TreeMap<Integer, Integer> x = new TreeMap<>();
            if (map2.containsKey(freq) == true) {
                x = map2.get(freq);
            }
            x.put((int) m.getKey(), 1);
            map2.put(freq, x);
        }
        for (ArrayList<Integer> update : B) {
            int index = update.get(0);
            int num = update.get(1);

            int toUpdate = A.get(index - 1);

            if (map.get(toUpdate) != null) {
                int freq = map.get(toUpdate);
                TreeMap<Integer, Integer> temp = map2.get(freq);
                if (temp.size() == 1) {
                    map2.remove(freq);
                } else {
                    temp.remove(toUpdate);
                    map2.put(freq, temp);
                }
                if (freq == 1) {
                    map.remove(toUpdate);
                } else {
                    map.put(toUpdate, freq - 1);
                    int z = freq - 1;
                    TreeMap<Integer, Integer> tt = new TreeMap<>();
                    if (map2.containsKey(z)) {
                        tt = map2.get(z);
                    }
                    tt.put(toUpdate, 1);
                    map2.put(z, tt);
                }
            }
            A.set(index - 1, num);
            if (map.containsKey(num)) {
                int tt = map.get(num);
                TreeMap<Integer, Integer> w = map2.get(tt);
                if (w.size() == 1) {
                    map2.remove(tt);
                } else {
                    w.remove(num);
                    map2.put(tt, w);
                }
                map.put(num, tt + 1);
                TreeMap<Integer, Integer> q = new TreeMap<>();
                if (map2.containsKey(tt + 1)) {
                    q = map2.get(tt + 1);
                }
                q.put(num, 1);
                map2.put(tt + 1, q);
            } else {
                map.put(num, 1);
                TreeMap<Integer, Integer> qq = new TreeMap<>();
                if (map2.containsKey(1)) {
                    qq = map2.get(1);
                }
                qq.put(num, 1);
                map2.put(1, qq);
            }
            int rr = (int) map2.lastKey();
            TreeMap<Integer, Integer> xyz = map2.get(rr);
            result.add((int) (xyz.firstKey()));
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(2);
        A.add(2);
        A.add(2);
        A.add(3);
        A.add(3);

        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        B.add(new ArrayList<Integer>(list));
        list.clear();

        list.add(5);
        list.add(4);
        B.add(new ArrayList<Integer>(list));
        list.clear();

        list.add(2);
        list.add(4);
        B.add(new ArrayList<Integer>(list));
        list.clear();

        System.out.println("A: " + A);
        System.out.println("B: " + B);
        Mode m = new Mode();
        System.out.println(m.getMode(A, B));
    }
}
