package Others;

import java.util.TreeMap;

public class ConvertIntegerToRoman {
    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public static String convert(int number) {
        int l = map.floorKey(number);
        if (l == number) {
            return map.get(l);
        }
        return map.get(l) + convert(number - l);
    }

    public static void main(String[] args) {
        System.out.println(convert(2));
        System.out.println(convert(3));
        System.out.println(convert(7));
        System.out.println(convert(12));
    }
}
