import org.testng.annotations.Test;

import java.util.ArrayList;

public class N35T_Timeout {

    // tag::timeout[]
    @Test(timeOut = 2000)
    public void infiniteLoop() {
        // setup
        ArrayList<String> arrayList = new ArrayList<>();

        // run
        while (true) { arrayList.add("testng forever!"); }
    }
    // end::timeout[]
}
