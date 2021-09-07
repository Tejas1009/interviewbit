package Others;

class StaticBlock {
    static int i;

    static {
        System.out.println("a");
        i = 100;
    }
}

/*class StaticBlock2 {
    static int i;

    static {
        System.out.println("e");
        i = 100;
    }
}*/

public class TestStaticBlocks {
    static {
        System.out.println("b");
    }

    static {
        System.out.println("d");
    }

    public static void main(String[] args) {
        System.out.println("c");
        //System.out.println(StaticBlock.i);

    }
}
