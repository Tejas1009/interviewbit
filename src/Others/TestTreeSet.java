package Others;

import java.util.TreeSet;

public class TestTreeSet {
    static class Employee implements Comparable<Employee> {
        int id;
        String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int compareTo(Employee o) {
            return this.id - o.id;
        }
    }

    public static void main(String[] args) {
        TreeSet<Employee> set = new TreeSet<>();
        set.add(new Employee(2, "x"));
        set.add(new Employee(1, "a"));
        set.stream().forEach(x -> System.out.println(x.name));
    }
}
