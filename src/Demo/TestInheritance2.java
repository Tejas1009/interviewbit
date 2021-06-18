package Demo;

import Tree.TreeNode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class A {
    void m1() throws FileNotFoundException {
        try {
            FileReader reader = new FileReader("file.txt");
            System.out.println("A's m1");
        } catch (FileNotFoundException e1) {
            System.out.println("A return");
            throw e1;
        } catch (Exception e) {
            throw e;
        }
    }
}

class B extends A {
    void m1() {
        System.out.println("B's m1");
    }
}

class C {
    public void callm1(A a) throws FileNotFoundException {
        try {
            a.m1();
        } catch (Exception e) {
            System.out.println("C return");
            throw e;
        }
    }

    public void callm1(B b) {
        b.m1();
    }
}

public class TestInheritance2 {
    public static void main(String[] args) throws FileNotFoundException {
       /* C c = new C();
        A a = new A();
        c.callm1(a);*/
        List<Integer> al = new ArrayList<>();
        al.add(1);
        m1(al);
        System.out.println(al);
        System.out.println(Objects.hashCode("b"));
    }

    static void m1(List al) {
        al.add("Data");
    }
}