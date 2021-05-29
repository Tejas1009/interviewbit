import java.util.*;

public class demo {

    public static String join(Collection<String> s, String delimiter) {
        StringBuffer b = new StringBuffer();
        Iterator<String> i = s.iterator();
        while (i.hasNext()) {
            b.append(i.next());
            if (i.hasNext()) {
                b.append(delimiter);
            }
        }
        return b.toString();
    }

    public static int addition(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        System.out.println(addition(5, 5));
        System.out.println(addition(5, 10));


        /*        int mask = 0x000F;
        int value = 0x222;
        System.out.println(value & mask);*/



      /* double d = 10.0/-0;
       if(d==Double.POSITIVE_INFINITY){
           System.out.println("PI");
       }
       else {
           System.out.println("NI");
       }*/
        /*Map<String, Integer> unique = new LinkedHashMap<>();
        for (String string : "Java, Java, REstful, Angular, Angular, Spring Boot, Angular".split(", ")) {
            if (unique.get(string) == null) {
                unique.put(string, 1);
            } else {
                unique.put(string, unique.get(string) + 1);
            }
            String uniqueString = join(unique.keySet(), ", ");
            List<Integer> value = new ArrayList<Integer>(unique.values());
            System.out.println("Output - " + uniqueString);
            System.out.println("Values - " + value);
        }*/
    }
}
