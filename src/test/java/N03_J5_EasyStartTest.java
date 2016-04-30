import org.junit.gen5.api.Test;
import org.junit.gen5.junit4.runner.JUnit5;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.gen5.api.Assertions.assertEquals;

@RunWith(JUnit5.class)
public class N03_J5_EasyStartTest {

    @Test
    public void arrayList_length_idm() {
        // setup
        ArrayList<String> list = new ArrayList<>();

        // run
        list.add("we");
        list.add("all");
        list.add("love");
        list.add("junit");

        // verify
        assertEquals(4, list.size());
    }
}
