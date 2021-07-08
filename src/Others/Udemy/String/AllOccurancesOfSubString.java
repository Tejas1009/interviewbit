package Others.Udemy.String;

public class AllOccurancesOfSubString {

    public static void find(String str, String subStr) {
        int index = 0;
        while (index >= 0) {
            index = str.indexOf(subStr, index);
            if (index != -1) System.out.println("" + index++);
        }
    }

    public static void main(String[] args) {
        find("helloslkhellodjladfjhello", "hello");
        System.out.println("-----------------");
        find("I liked the movie, acting in movie was great!", "movie");
    }
}
