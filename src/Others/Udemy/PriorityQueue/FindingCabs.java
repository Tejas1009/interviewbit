package Others.Udemy.PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
Finding cabs:
Given N cartesian Points in a 2D plane each represents the location of the cab.
You are standing at origin, you want to know the names of nearest k cars.

Sample Input:
N=5, k=3
C1 1 1
C2 2 1
C3 3 2
C4 0 1
C5 2 3

Output:
C4
C1
C2
 */
public class FindingCabs {

    static class Car implements Comparable<Car> {
        String id;
        int x;
        int y;

        public Car(String id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }

        public int getDistance() {
            return (x * x) + (y * y);
        }

        public void printCarId() {
            System.out.println(id);
        }

        @Override
        public int compareTo(Car o) {
            return this.getDistance() - o.getDistance();
        }
    }

    public static void printNearestCars(List<Car> cars, int k) {
        PriorityQueue<Car> heap = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            heap.add(cars.get(i));
        }
        for (int i = k; i < cars.size(); i++) {
            Car curr_top = heap.peek();
            if (cars.get(i).getDistance() < curr_top.getDistance()) {
                heap.poll();
                heap.add(cars.get(i));
            }
        }
        ArrayList<Car> res = new ArrayList<>();
        while (!heap.isEmpty()) {
            res.add(heap.poll());
        }
        Collections.sort(res, (x, y) -> {
            return x.getDistance() - y.getDistance();//ascending
            //return y.getDistance() - x.getDistance();//descending
        });
        res.stream().forEach(Car::printCarId);
    }

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("C1", 1, 1));
        cars.add(new Car("C2", 2, 1));
        cars.add(new Car("C3", 3, 2));
        cars.add(new Car("C4", 0, 1));
        cars.add(new Car("C5", 2, 3));
        printNearestCars(cars, 3);
    }
}
