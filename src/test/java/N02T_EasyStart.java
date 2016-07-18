// tag::easyTestNG[]
import org.testng.annotations.Test;
// end::easyTestNG[]

import java.util.ArrayList;

// tag::easyTestNG[]
import static org.testng.Assert.assertEquals;
// end::easyTestNG[]

public class N02T_EasyStart {

    // tag::easyTestNG[]

    @Test // <1>
    public void arrayList_length_idm() {
        ArrayList<String> list = new ArrayList<>();
        list.add("we");
        list.add("all");
        list.add("love");
        list.add("testng");
        assertEquals(list.size(), 4); // <2>
    }
    // end::easyTestNG[]
}
