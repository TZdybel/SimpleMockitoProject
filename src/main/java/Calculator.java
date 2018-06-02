import javax.swing.text.InternationalFormatter;
import java.util.Iterator;

public class Calculator {

    private SomeClass someClass;

    public Calculator(SomeClass someClass) {
        this.someClass = someClass;
    }

    public int add() {
        int result = someClass.add();
        if (result > 100) return -result;
        else return result;
    }

    public int sum_all() {
        Iterator<Integer> it = someClass.getIterator();
        int sum = 0;
        while(it.hasNext()) {
            sum += it.next();
        }
        return sum;
    }

    public String isPythagorean(int x) {
        if (someClass.pythagoreadTriangle(x)) return "It is pythagorean triangle";
        else return "It is not pythagorean triangle";
    }

    public String divide() {
        int result;
        try {
            result = someClass.divide();
        } catch(ArithmeticException e) {
            return "Cannot divide by 0";
        }
        return "Result: " + result;
    }
}
