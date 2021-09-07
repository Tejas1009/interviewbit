package Others;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class SingletonExample implements Serializable, Cloneable {
    private static SingletonExample instance;

    private SingletonExample() throws Exception {
        if (instance != null) {
            throw new Exception("Cannot create Instance");
        }
    }

    static SingletonExample getInstance() {
        if (instance == null) {
            synchronized (SingletonExample.class) {
                if (instance == null) {
                    try {
                        instance = new SingletonExample();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return instance;
    }

    @Override
    public Object clone() {
        return new CloneNotSupportedException();
    }

    public Object readResolve() {
        return new Exception("Not supported");
    }

    public static void main(String[] args) {
        System.out.println(SingletonExample.getInstance().hashCode());
        System.out.println(SingletonExample.getInstance().hashCode());

    }
}
