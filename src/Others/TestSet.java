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
    public int compareTo(User o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object obj) {
        User that = (User) obj;
        return this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}

public class TestSet {
    public static void main(String[] args) {
        Set<User> set = new TreeSet<>();
        set.add(new User(1, "abc"));
        set.add(new User(1, "abca"));
        //System.out.println(set.size());

        Map<User, Integer> map = new HashMap<>();
        User u1 = new User(1, "abc");
        User u2 = new User(1, "abc");
        map.put(u1, 1);
        map.put(u2, 1);
        System.out.println(map.size());
    }
}
