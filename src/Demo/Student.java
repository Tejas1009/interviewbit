package Demo;

// Java program to Sort a TreeSet with
// User Defined Objects

import java.io.*;
import java.util.*;

class students implements Comparable<students> {

    private int marks;
    private String name;

    // constructor
    public students(int value, String name) {
        this.marks = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public int compareTo(students o) {
        return o.compareTo(this);
    }
}

// Comparator class will override the compare
// method which will compare the tw objects
// passed in the parameter


class GFG {

    public static void main(String[] args) {

        // Creating the TreeSet with Comparator object passed
        // as the parameter which will sort the user defined
        // objects of TreeSet
        TreeSet<students> set = new TreeSet<students>();

        set.add(new students(450, "Sam"));
        set.add(new students(341, "Ronaldo"));
        set.add(new students(134, "Daniel"));
        set.add(new students(590, "George"));

        System.out.println("increasing Order with the Marks");

        // Printing the TreeSet elements
        for (students ele : set) {
            System.out.print(ele.getName() + " " + ele.getMarks());
            System.out.println();
        }


        TreeSet<students> mrks = new TreeSet<students>();

        mrks.add(new students(450, "Sam"));
        mrks.add(new students(341, "Ronaldo"));
        mrks.add(new students(134, "Daniel"));
        mrks.add(new students(590, "George"));

        System.out.println();

        for (students ele : mrks) {
            System.out.print(ele.getName() + " " + ele.getMarks());
            System.out.println();
        }

    }
}
