package Others.Udemy.StackAndQueue;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpan {
    static class StockIndex {
        public int value;
        public int index;

        public StockIndex(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    //Input: 100,80,60,70,60,75,85
    //Output: 1,1,1,2,1,4,6
    public static ArrayList<Integer> stockSpan(int stocks[]) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<StockIndex> stack = new Stack<>();
        stack.push(new StockIndex(stocks[0], 0));
        res.add(1);
        for (int i = 1; i < stocks.length; i++) {
            int stockValue = stocks[i];
            while (!stack.empty() && stack.peek().value < stockValue) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res.add(i);
            } else {
                res.add(i - stack.peek().index);
            }
            stack.push(new StockIndex(stockValue, i));
        }
        return res;
    }

    public static void main(String[] args) {
        int stock[] = {100, 80, 60, 70, 60, 75, 85};
        stockSpan(stock).forEach(System.out::print);
        System.out.println();
    }
}
