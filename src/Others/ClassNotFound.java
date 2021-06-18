package Others;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;

interface i1 {
    int a = 0;
}

class Employee {
    int i;
    String j;

    public Employee(int i, String j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return i == employee.i &&
                j.equals(employee.j);
    }

    @Override
    public int hashCode() {
        return i;
    }
}

public class ClassNotFound implements i1 {

    public static void main(String[] args) {
        int n = 3;
        //011
        int i = 1 << 3;
        //System.out.println((n | i));
        HashMap<Employee, Integer> map = new HashMap<>();
        map.put(new Employee(1, "A"), 1);
        map.put(new Employee(1, "A"), 1);
        System.out.println(map.size());
    }
}
