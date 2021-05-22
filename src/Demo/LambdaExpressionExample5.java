package Demo;


import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaExpressionExample5 {
    @FunctionalInterface
    interface Addable extends sayable {
        int add(int a, int b);

        int hashCode();

        String toString();

        boolean equals(Object obj);
    }

    interface sayable {
        //void say(String msg);   // abstract method
        int hashCode();
    }

    public static boolean isMoreThanFifty(int n1, int n2) {
        return (n1 + n2) > 50;
    }

    public static void main(String[] args) {
        String s = "";


        // Multiple parameters in lambda expression
/*        Addable ad1 = (a, b) -> (a + b);
        System.out.println(ad1.add(10, 20));
        BiFunction<Integer, Integer, Integer> adder = ad1::add;
        adder.apply(1, 2);
        Consumer<String> c = System.out::println;
        c.accept("a");
        System.out.println(c);*/
//        List<String> messages = Arrays.asList("hello", "baeldung", "readers!");
//        messages.forEach(word -> StringUtils.capitalize(word));
        //
//        messages.forEach(StringUtils::capitalize);
        //List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        //Stream s = arr.stream().filter(x -> x % 2 == 0);

    }
}
