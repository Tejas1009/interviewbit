package HeadAndMap;

import java.util.ArrayList;

public class MinHeap {

    ArrayList<Integer> data;

    MinHeap() {
        data = new ArrayList<>();
    }

    public void insert(int val) {
        data.add(val);
        upheapify(data.size() - 1);
    }

    public int poll() {
        if (data.size() <= 0) return -1;
        if (data.size() == 1) {
            int val = data.get(0);
            data.remove(data.size() - 1);
            return val;
        }
        int val = data.get(0);
        swap(0, data.size() - 1);
        data.remove(data.size() - 1);
        downheapify(0);
        return val;
    }

    private void downheapify(int pi) {
        //pick smallest among three
        int min_i = pi;
        if ((pi * 2 + 1) < data.size() && data.get(pi * 2 + 1) < data.get(min_i)) {
            min_i = pi * 2 + 1;
        }
        if ((pi * 2 + 2) < data.size() && data.get(pi * 2 + 2) < data.get(min_i)) {
            min_i = pi * 2 + 2;
        }
        if (pi != min_i) {
            swap(pi, min_i);
            downheapify(min_i);
        }
    }

    private void swap(int i, int j) {
        int temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    private void upheapify(int i) {
        if (i == 0) return;
        int p_idx = (i - 1) / 2;
        if (data.get(i) < data.get(p_idx)) {
            swap(i, p_idx);
            upheapify(p_idx);
        }
    }

    public int getSize() {
        return this.data.size();
    }

    public static void main(String[] args) {
        MinHeap mh = new MinHeap();
        mh.insert(11);
        mh.insert(3);
        mh.insert(4);
        mh.insert(2);
        mh.insert(1);

        mh.poll();
        int r = mh.poll();
        System.out.println(r);
    }
}
