package Others;

import java.util.*;

class User implements Comparable<User> {
    int id;
    String name;

    public User(int id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        User o = (User) obj;
        return this.name == o.name;
    }

    @Override
    public int compareTo(User o) {
        return this.name.compareTo(o.name);
    }
}

public class TestSet {
    public static void main(String[] args) {
        Set<User> set = new TreeSet<>();
        set.add(new User(1, "abc"));
        set.add(new User(2, "abc"));
        System.out.println(set.size());
    }
}
