package Hashing;

import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class HashingSortByValueOnObject {
    public static void main(String[] args) {
        Map<Integer, Student> map = new HashMap<>();
        map.put(1, new Student(1, "xyz"));
        map.put(2, new Student(1, "abc"));
        map.put(3, new Student(1, "pqr"));
        List<Map.Entry<Integer, Student>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (x, y) -> x.getValue().name.compareTo(y.getValue().name));
        list.stream().forEach(x -> System.out.println(x.getValue().name));
    }
}
