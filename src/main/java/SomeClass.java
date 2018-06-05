import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SomeClass {
    private int x;
    private int y;
    private List<Integer> results= new LinkedList<Integer>();

    public SomeClass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int add() {
        results.add(x+y);
        return x+y;
    }

    public Iterator<Integer> getIterator() {
        return results.iterator();
    }

    public boolean pythagoreanTriangle(int z) {
        if ((z*z) == (x*x) + (y*y)) {
            results.add(1);
        } else {
            results.add(0);
        }
        return (z*z) == (x*x) + (y*y);
    }

    public int divide() throws ArithmeticException {
        results.add(x/y);
        return x/y;
    }
}
