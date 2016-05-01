import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class N20T_Exceptions {

    @Test(expectedExceptions = IndexOutOfBoundsException.class, expectedExceptionsMessageRegExp = "Index: 17, Size: 0")
    public void exception_oldWay() {
        // setup
        ArrayList<Integer> arrayList = new ArrayList<>();

        // run
        arrayList.get(17);
    }

    @Test
    public void noException_oldWay() {
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
    public void exceptionAndMessage_oldWay() {
        // setup
        ArrayList<Integer> arrayList = new ArrayList<>();

        // run
        try {
            arrayList.get(17);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException exception) {
            // verify
            assertEquals(exception.getMessage(), "Index: 17, Size: 0");
        }
    }
}
