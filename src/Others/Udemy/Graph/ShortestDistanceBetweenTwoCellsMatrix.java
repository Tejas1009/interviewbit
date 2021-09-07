package Others.Udemy.Graph;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a matrix of N*M order. Find the shortest distance from a source cell to a destination cell, traversing through limited cells only. Also you can move only up, down, left and right. If found output the distance else -1.
s represents ‘source’
d represents ‘destination’
* represents cell you can travel
0 represents cell you can not travel
This problem is meant for single source and destination.
Examples:


Input : {'0', '*', '0', 's'},
        {'*', '0', '*', '*'},
        {'0', '*', '*', '*'},
        {'d', '*', '*', '*'}
Output : 6

Input :  {'0', '*', '0', 's'},
         {'*', '0', '*', '*'},
         {'0', '*', '*', '*'},
         {'d', '0', '0', '0'}
Output :  -1
 */
public class ShortestDistanceBetweenTwoCellsMatrix {

    static class Item {
        int row;
        int col;
        int dist;

        public Item(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public static int getShortestDistance(char[][] matrix) {
        Queue<Item> queue = new LinkedList<>();
        Item item = new Item(0, 0, 0);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 's') {
                    item.row = i;
                    item.col = j;
                    break;
                }
            }
        }
        queue.add(item);
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, -1, 0, 1};
        boolean visited[][] = new boolean[matrix.length][matrix[0].length];
        while (!queue.isEmpty()) {
            Item currItem = queue.poll();
            if (matrix[currItem.row][currItem.col] == 'd') {
                return currItem.dist;
            }
            for (int i = 0; i < 4; i++) {
                int newRow = currItem.row + dx[i];
                int newCol = currItem.col + dy[i];
                if (newRow < matrix.length && newCol < matrix[0].length && newRow >= 0 && newCol >= 0 && !visited[newRow][newCol]
                        && matrix[newRow][newCol] != '0') {
                    visited[newRow][newCol] = true;
                    queue.add(new Item(newRow, newCol, 1 + currItem.dist));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char mat[][] = {
                {'0', '*', '0', 's'},
                {'*', '0', '*', '*'},
                {'0', '*', '*', '*'},
                {'d', '*', '*', '*'}
        };
        System.out.println(getShortestDistance(mat));
    }
}
