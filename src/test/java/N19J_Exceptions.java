import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class N19J_Exceptions {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = IndexOutOfBoundsException.class)
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
            assertThat(exception.getMessage(), is("Index: 17, Size: 0"));
        }
    }

    @Test
    public void exception_modernWay() {
        // setup
        ArrayList<Integer> arrayList = new ArrayList<>();

        // expect
        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage(is("Index: 17, Size: 0"));

        // run
        arrayList.get(17);
    }
}
