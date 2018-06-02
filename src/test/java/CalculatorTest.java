import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Iterator;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {

    @Mock
    private SomeClass someClass;

    @Test
    public void test_add() {
        //add < 100
        Calculator calc = new Calculator(someClass);
        when(someClass.add()).thenReturn(30);
        assertEquals(30, calc.add());
    }

    @Test
    public void test_add_2() {
        //add > 100
        Calculator calc = new Calculator(someClass);
        when(someClass.add()).thenReturn(110);
        assertEquals(-110, calc.add());
    }

    @Test
    public void test_sum() {
        //more than one return value test
        Iterator<Integer> it = mock(Iterator.class);
        when(it.hasNext()).thenReturn(true).thenReturn(true).thenReturn(false);
        when(it.next()).thenReturn(10).thenReturn(90);
        Calculator calc = new Calculator(someClass);
        when(someClass.getIterator()).thenReturn(it);
        assertEquals(100, calc.sum_all());
    }

    @Test
    public void test_isPythagorean_1() {
        //return value dependent on method parameter
        Calculator calc = new Calculator(someClass);
        when(someClass.pythagoreadTriangle(anyInt())).thenReturn(true);
        when(someClass.pythagoreadTriangle(4)).thenReturn(false);
        assertEquals("It is pythagorean triangle", calc.isPythagorean(3));
        assertEquals("It is not pythagorean triangle", calc.isPythagorean(4));
    }

    @Test
    public void test_divide() {
        //throwing an exception
        Calculator calc = new Calculator(someClass);
        when(someClass.divide()).thenThrow(new ArithmeticException());
        assertEquals("Cannot divide by 0", calc.divide());
    }

    @Test
    public void test_verify() {
        //verifying what methods were called
        when(someClass.pythagoreadTriangle(1)).thenReturn(true);
        someClass.getIterator();
        someClass.getIterator();
        someClass.pythagoreadTriangle(1);

        verify(someClass).pythagoreadTriangle(ArgumentMatchers.eq(1));
        verify(someClass, times(2)).getIterator();
        verify(someClass, never()).add(); //never called
        verify(someClass, atLeastOnce()).getIterator(); //called at least one time
        verify(someClass, atLeast(2)).getIterator(); //called at least 2 times
        verify(someClass, atMost(1)).pythagoreadTriangle(1); //called at most 1 time
        verify(someClass, times(2)).getIterator(); // called exactly 2 times
    }
}