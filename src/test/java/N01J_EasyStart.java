import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class N01J_EasyStart {

    @Test
    public void arrayList_length_ind() {
        ArrayList<String> list = new ArrayList<>();
        list.add("we");
        list.add("all");
        list.add("love");
        list.add("junit");
        assertEquals(list.size(), 4);
    }

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
        assertThat(list, hasSize(4));
    }
}
