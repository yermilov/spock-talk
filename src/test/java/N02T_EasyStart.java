import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class N02T_EasyStart {

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
        assertEquals(list.size(), 4);
    }
}
