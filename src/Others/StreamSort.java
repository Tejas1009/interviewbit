package Others;

import java.util.*;

public class StreamSort {

    static class Employee {
        int id;
        String name;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(3, 2, 5, 4, 1));
        //list1.stream().sorted().forEach(System.out::print);//asc
        System.out.println();
        //list1.stream().sorted(Collections.reverseOrder()).forEach(System.out::print);//desc
        Employee e1 = new Employee(2, "xyz");
        Employee e2 = new Employee(1, "abc");
        List<Employee> employees = new ArrayList<>(Arrays.asList(e1, e2));
        //employees.stream().sorted(Comparator.comparing(Employee::getName).reversed()).map(x -> x.name).forEach(System.out::println);
        //employees.stream().sorted((x, y) -> x.id - y.id).map(x -> x.name).forEach(System.out::println);
        Collections.sort(employees, (x, y) -> y.id - x.id);
        employees.stream().map(Employee::getName).forEach(System.out::println);
    }
}
