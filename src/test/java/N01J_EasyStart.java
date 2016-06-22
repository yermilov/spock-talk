// tag::easyJUnit[]
import org.junit.Test;
// end::easyJUnit[]

import java.util.ArrayList;

import static org.hamcrest.Matchers.hasSize;
// tag::easyJUnit[]
import static org.junit.Assert.assertEquals;
// end::easyJUnit[]
import static org.junit.Assert.assertThat;

public class N01J_EasyStart {

    // tag::easyJUnit[]

    @Test // <1>
    public void arrayList_length_ind() {
        ArrayList<String> list = new ArrayList<>();
        list.add("we");
        list.add("all");
        list.add("love");
        list.add("junit");
        assertEquals(list.size(), 4); // <2>
    }
    // end::easyJUnit[]

    // tag::idiomaticJUnit[]
    @Test // <1>
    public void arrayList_length_idm() {
        // setup // <2>
        ArrayList<String> list = new ArrayList<>();

        // run // <2>
        list.add("we");
        list.add("all");
        list.add("love");
        list.add("junit");

        // verify // <2>
        assertThat(list, hasSize(4)); // <3>
    }
    // end::idiomaticJUnit[]
}
