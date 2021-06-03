package Graph;

import java.util.Arrays;

/*Commutable Islands
        Asked in:
        Amazon
        Problem Setter: amitkgupta94 Problem Tester: archit.rai
        There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.

        We need to find bridges with minimal cost such that all islands are connected.

        It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.

        Input Format:

        The first argument contains an integer, A, representing the number of islands.
        The second argument contains an 2-d integer matrix, B, of size M x 3:
        => Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].
        Output Format:

        Return an integer representing the minimal cost required.
        Constraints:

        1 <= A, M <= 6e4
        1 <= B[i][0], B[i][1] <= A
        1 <= B[i][2] <= 1e3
        Examples:

        Input 1:
        A = 4
        B = [   [1, 2, 1]
        [2, 3, 4]
        [1, 4, 3]
        [4, 3, 2]
        [1, 3, 10]  ]

        Output 1:
        6

        Explanation 1:
        We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.

        Input 2:
        A = 4
        B = [   [1, 2, 1]
        [2, 3, 2]
        [3, 4, 4]
        [1, 4, 3]   ]

        Output 2:
        6

        Explanation 2:
        We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will be (1 + 2 + 3) = 6.*/
public class CommutableIslands {

    int[] parent;

    int findParent(int e) {
        if (parent[e] == -1) return e;
        parent[e] = findParent(parent[e]);
        return parent[e];
    }

    void union(int fromP, int toP) {
        parent[fromP] = toP;
    }

    public int solve(int a, int[][] mat) {
        parent = new int[a + 1];
        for (int i = 1; i <= a; i++) {
            parent[i] = -1;
        }
        Arrays.sort(mat, (x, y) -> {
            return x[2] - y[2];
        });
        int cost = 0;
        for (int[] pair : mat) {
            int fromP = findParent(pair[0]);
            int toP = findParent(pair[1]);
            if (fromP != toP) {//if no cycle then add to cost
                cost += pair[2];
                union(fromP, toP);
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        CommutableIslands c = new CommutableIslands();
        int[][] m = {
                {1, 2, 1},
                {2, 3, 4},
                {1, 4, 3},
                {4, 3, 2},
                {1, 3, 10}
        };
        c.solve(4, m);
    }
}
