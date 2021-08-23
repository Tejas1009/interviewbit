package Others.Udemy.PriorityQueue;

import java.util.PriorityQueue;

/*
Merging Ropes:
Given N ropes each having a different size, your task is join the ropes together.
The cost of joining 2 ropes of different sizes X and Y is (X+Y). Find the minimum cost to join all
ropes together.

Input:
N=4;
Ropes[] = {4,3,2,6};

Output:
29

Algorithm:
1) Construct a min heap.
2) Pop first  elements and add them add the same to overall cost
3) Add the new cost to minheap
4) continue step 2 & 3 till the heap size is 1.

example:
{2,3,4,6}
2+3=5
{4,5,6}
4+5=9
{6,9}
6+9=14
{14}

overall cost: 5+9+14=29
*/
public class MergingRopes {

    public static int joinRopes(int n, int ropes[]) {
        if (n <= 1) return n;
        int res = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            priorityQueue.add(ropes[i]);
        }
        while (!(priorityQueue.size() == 1)) {
            int fe = priorityQueue.poll();
            int se = priorityQueue.poll();
            int ne = fe + se;
            res += ne;
            priorityQueue.add(ne);
        }
        return res;
    }

    public static void main(String[] args) {
        int ropes[] = {4, 3, 2, 6};
        System.out.println(joinRopes(4, ropes));
    }
}