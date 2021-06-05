package Demo;

import java.util.HashMap;

public class HashMapHandling {
    int a;
    String hash;

    HashMapHandling(int a, String hash) {
        this.a = a;
        this.hash = hash;
    }

    @Override
    public boolean equals(Object o) {
        HashMapHandling h = (HashMapHandling) o;
        return h.a == this.a;
    }

    @Override
    public int hashCode() {
        return this.hash.length();
    }

    public static void main(String[] args) {
        HashMap<HashMapHandling, Integer> map = new HashMap<>();
        HashMapHandling m = new HashMapHandling(10, "10");
        map.put(m, 10);
        System.out.println(map.get(m));
        m.a = 20;
        m.hash = "200";
        System.out.println(map.get(m));
    }
}
