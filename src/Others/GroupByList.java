package Others;

import java.util.*;
import java.util.stream.Collectors;

class Employee12 {
    String firstName;
    String lastName;
    String dept;

    public Employee12(String firstName, String lastName, String dept) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dept = dept;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDept() {
        return dept;
    }
}

public class GroupByList {


    public static void main(String[] args) {
        List<Employee12> list = new ArrayList<>();
        list.add(new Employee12("tejas", "ratnapagol", "it"));
        list.add(new Employee12("pooja", "ratnapagol", "comp"));
        list.add(new Employee12("poonam", "patil", "comp"));

        long n = list.stream().filter(x -> x.dept == "comp").count();

        Collections.sort(list, (x, y) -> {
            if (x.firstName.equals(y.firstName)) {
                return y.lastName.compareTo(x.lastName);
            }
            return y.firstName.compareTo(x.lastName);
        });
        list.stream().map(Employee12::getLastName).forEach(System.out::println);
        System.out.println("-------------------");
        Map<String, List<Employee12>> res = list.stream().collect(Collectors.groupingBy(Employee12::getDept));
        res.forEach((k, v) -> {
            System.out.println(k + "-" + v.size());
        });
        System.out.println("------------------------");
    }
}