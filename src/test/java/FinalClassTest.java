import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

import org.junit.*;

public class FinalClassTest {

    /*Available since Mockito v2
      Necessary:
      - creating file org.mockito.plugins.MockMaker in
      src/test/recources/mockito-extensions/ or src/mockito-extensions/
      - adding "mock-maker-inline" line to created file
      If not working - add Maven dependency:
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-inline</artifactId>
            <version>2.18.3</version>
            <scope>test</scope>
        </dependency>*/


    //Now we can mock final classes
    @Test
    public void test_final_class() {
        FinalClass finalClass = mock(FinalClass.class);
        FinalClass finalClass1 = new FinalClass();
        when(finalClass.foo()).thenReturn("Mocked final class");
        assertNotEquals(finalClass.foo(), finalClass1.foo());
    }
}