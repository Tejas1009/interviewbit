package Demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamReduce {
    public static void main(String[] args) {
        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String c = letters.stream().reduce("", String::concat);
        //System.out.println(c);
    }
}
