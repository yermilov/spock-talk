// tag::easyJUnit5[]
import org.junit.gen5.api.Test;
// end::easyJUnit5[]
import org.junit.gen5.junit4.runner.JUnit5;
import org.junit.runner.RunWith;

import java.util.ArrayList;

// tag::easyJUnit5[]
import static org.junit.gen5.api.Assertions.assertEquals;
// end::easyJUnit5[]

@RunWith(JUnit5.class)
public class N03_J5_EasyStartTest {

    // tag::easyJUnit5[]

    @Test // <1>
    public void arrayList_length_idm() {
        ArrayList<String> list = new ArrayList<>();
        list.add("we");
        list.add("all");
        list.add("love");
        list.add("junit");
        list.add("5");
        assertEquals(5, list.size()); // <2> <3>
    }
    // end::easyJUnit5[]
}
