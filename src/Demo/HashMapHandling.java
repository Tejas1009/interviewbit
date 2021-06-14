package Demo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface a1 {
    default void print() {
        System.out.println("i");
        ;
    }
}

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
        HashMap<String, Integer> hm = new HashMap<>();
        HashMap<String, Integer> temp
                = hm.entrySet()
                .stream()
                .sorted((i1, i2)
                        -> i1.getValue().compareTo(
                        i2.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, HashMap::new));

        //System.out.println(map.get(10));
        m.a = 20;
        m.hash = "200";
        //System.out.println(map.get(m));

        List<Integer> list = new ArrayList<>(Arrays.asList(5, 6, 9, 7, 8));
        list = list.stream().filter(x -> x > 6).collect(Collectors.toList());
        //System.out.println(list);


        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }
}
