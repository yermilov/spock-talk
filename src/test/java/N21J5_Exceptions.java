import org.junit.gen5.api.Test;
import org.junit.gen5.junit4.runner.JUnit5;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.gen5.api.Assertions.assertEquals;
import static org.junit.gen5.api.Assertions.expectThrows;
import static org.junit.gen5.api.Assertions.fail;

@RunWith(JUnit5.class)
public class N21J5_Exceptions {

    @Test
    public void noException() {
        // setup
        ArrayList<Integer> arrayList = new ArrayList<>();

        // run
        arrayList.size();

        // verify no exception is thrown
    }

    @Test
    public void noException_uglyWay() {
        // setup
        ArrayList<Integer> arrayList = new ArrayList<>();

        // run
        try {
            arrayList.size();
        } catch (Exception exception) {
            // verify no exception is thrown
            fail("Expected no exception to be thrown");
        }
    }

    @Test
    public void exceptionAndMessage() {
        // setup
        ArrayList<Integer> arrayList = new ArrayList<>();

        // run
        try {
            arrayList.get(17);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException exception) {
            // verify
            assertEquals("Index: 17, Size: 0", exception.getMessage());
        }
    }

    // tag::expectException[]

    @Test
    public void exception() {
        // setup
        ArrayList<Integer> arrayList = new ArrayList<>();

        // run & verify
        Throwable thrown = expectThrows(IndexOutOfBoundsException.class, () -> { arrayList.get(17); });
        assertEquals("Index: 17, Size: 0", thrown.getMessage());
    }

    // end::expectException[]
}
