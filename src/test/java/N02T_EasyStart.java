import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class N02T_EasyStart {

    @Test
    public void arrayList_length_idm() {
        ArrayList<String> list = new ArrayList<>();
        list.add("we");
        list.add("all");
        list.add("love");
        list.add("junit");
        assertEquals(list.size(), 4);
    }
}
