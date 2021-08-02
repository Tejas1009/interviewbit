package Others.Udemy.Graph;
/*
Astronaut Pairs:
The member states of the UN are planning to send people to the moon. They want them to be from different countries.
You will be given a list of pairs of astronaut ID's. Each pair is made of astronauts from the same country.
Determine how many pairs of astronauts from different countries they can choose from.

Input contains the number N : denoting number of astronauts and and list L denoting the pairs of astronauts from the same country.
N=5
int astronauts: {{0,1}, {2,3}, {0,4}}
Output:
6

There are 6 ways to choose a pair (0,2) (0,3) (1,2) (1,3) (4,2) and (4,3) as astronauts (0,1,4) belong to country 1 and (2,3) belong to another.
*/

import java.util.HashMap;
import java.util.Map;

public class AstronautPair {
    private static int parent[];

    private static void union(int fromP, int toP) {
        parent[toP] = fromP;
    }

    private static int findParent(int source) {
        if (parent[source] == source) return source;
        int p = findParent(parent[source]);
        parent[source] = p;
        return parent[source];
    }

    public static int count_pairs(int astronauts[][], int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int pair[] : astronauts) {
            union(pair[0], pair[1]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = findParent(i);
            map.putIfAbsent(parent, 0);
            map.put(parent, map.get(parent) + 1);
        }
        int res = 1;
        if (map.size() <= 1) return 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res *= entry.getValue();
        }
        return res;
    }

    public static void main(String[] args) {
        int astronauts[][] = {
                {0, 1},
                {2, 3},
                {0, 4}
        };
        System.out.println(count_pairs(astronauts, 5));
        System.out.println("---------------------------");
        int astronauts2[][] = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4}
        };
        System.out.println(count_pairs(astronauts2, 5));
        System.out.println("---------------------------");
        int astronauts3[][] = {
                {0, 1},
                {2, 3}
        };
        System.out.println(count_pairs(astronauts3, 4));
    }
}